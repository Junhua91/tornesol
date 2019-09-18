package com.junhua.tornesol.controller;


import com.junhua.tornesol.architecture.miaosha.db.mapper.UserDealMapper;
import com.junhua.tornesol.architecture.miaosha.db.model.UserDealDO;
import com.junhua.tornesol.architecture.miaosha.service.DealCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiaoshaController {

    @Autowired
    private UserDealMapper userDealMapper = null;
    @Autowired
    private DealCountService dealCountService;

    @RequestMapping(path = "miaosha/getCount", method = RequestMethod.GET)
    public int getBuyCount(int userId, int dealId) {
        int count = userDealMapper.selectCount(userId, dealId);
        return count;
    }

    @RequestMapping(path = "miaosha/start", method = RequestMethod.GET)
    public void buy() {
        UserDealDO userDealDO = new UserDealDO();
        int userId = (int) (Math.random() * 10000);
        int dealId = 1001;
        int buyCount = (int) (Math.random() * 10) + 1;
        userDealDO.setBuyCount(buyCount);
        userDealDO.setDealId(dealId);
        userDealDO.setUserId(userId);
        try {
            dealCountService.buy3(userDealDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
