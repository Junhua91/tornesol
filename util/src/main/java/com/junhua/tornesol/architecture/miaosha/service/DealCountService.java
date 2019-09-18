package com.junhua.tornesol.architecture.miaosha.service;


import com.junhua.tornesol.architecture.miaosha.db.mapper.DealCountMapper;
import com.junhua.tornesol.architecture.miaosha.db.mapper.UserDealMapper;
import com.junhua.tornesol.architecture.miaosha.db.model.UserDealDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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

    /**
     * transaction + for update => 107/sec
     *
     * @param userDealDO
     * @throws Exception
     */
    public void buy(UserDealDO userDealDO) throws Exception {

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
     * 无事务+乐观锁 =>1221/sec, 没有死锁异常（性能最好）
     *
     * @param userDealDO
     */
    public void buy3(UserDealDO userDealDO) {
        int restCount = dealCountMapper.getRestDealCount(userDealDO.getDealId());
        if (restCount >= userDealDO.getBuyCount()) {
            int res = dealCountMapper.updateDealCount(userDealDO.getDealId(), (restCount - userDealDO.getBuyCount()), restCount);
        }
    }
}
