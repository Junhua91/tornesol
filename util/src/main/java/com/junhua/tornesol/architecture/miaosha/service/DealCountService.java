package com.junhua.tornesol.architecture.miaosha.service;


import com.junhua.tornesol.architecture.miaosha.db.mapper.DealCountMapper;
import com.junhua.tornesol.architecture.miaosha.db.mapper.UserDealMapper;
import com.junhua.tornesol.architecture.miaosha.db.model.UserDealDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 扣库存
 */
@Service
//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DealCountService {

    @Autowired
    private UserDealMapper userDealMapper = null;
    @Autowired
    private DealCountMapper dealCountMapper = null;
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate = null;

    /**
     *
     * @param userDealDO
     * @throws Exception
     */
    public void buy(UserDealDO userDealDO){

        int restCount = dealCountMapper.getRestDealCount(userDealDO.getDealId());
        if (restCount >= userDealDO.getBuyCount()) {
            dealCountMapper.addDealCount(userDealDO.getDealId(), (restCount - userDealDO.getBuyCount()));
        }
    }

    /**
     * 无事务，没有乐观锁=> 850/sec
     *
     * @param userDealDO
     */
    public void buy2(UserDealDO userDealDO) {
        int restCount = dealCountMapper.getRestDealCount(userDealDO.getDealId());
        if (restCount >= userDealDO.getBuyCount()) {
            dealCountMapper.addDealCount(userDealDO.getDealId(), (restCount - userDealDO.getBuyCount()));
        }
    }

    /**
     * 1. 无事务+乐观锁 =>1221/sec, 没有死锁异常（性能最好）
     * 2. 当并发量起来的时候，会出现大量死锁问题
     *
     * @param userDealDO
     */
    public void buy3(UserDealDO userDealDO) {
        int restCount = dealCountMapper.getRestDealCount(userDealDO.getDealId());
        if (restCount >= userDealDO.getBuyCount()) {
            dealCountMapper.updateDealCount(userDealDO.getDealId(), (restCount - userDealDO.getBuyCount()), restCount);
        }
    }

    /**
     * redis 的方式来实现扣减库存的功能：
     * 1. 多个线程同时过来校验，可以都可以通过校验，于是都进行了减库存操作会导致超卖情况发生
     * 2. 两个操作不是原子性的
     *
     * @param userDealDO
     */
    public void buy4(UserDealDO userDealDO) {
        String key = "goods_" + userDealDO.getDealId();
        int restCount = Integer.valueOf(redisTemplate.opsForValue().get(key));
        if (restCount > userDealDO.getBuyCount()) {
            redisTemplate.opsForValue().decrement(key, userDealDO.getBuyCount());
        }
    }

    /**
     * 1. 使用lua脚本来保证原子性，避免超卖
     * 2. 1600/sec
     *
     * @param userDealDo
     */
    public void buy5(UserDealDO userDealDo) {
        String key = "goods_" + userDealDo.getDealId();
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText("local restCount = tonumber(redis.call('get', KEYS[1]));" +
                "local num = tonumber(ARGV[1]);" +
                "if restCount >= num " +
                "then redis.call('incrby',KEYS[1],0-num);" +
                "end;");
        List<String> keyList = Arrays.asList(key);
        String restCount = redisTemplate.execute(redisScript, keyList,String.valueOf(userDealDo.getBuyCount()));
        return;
    }
}

