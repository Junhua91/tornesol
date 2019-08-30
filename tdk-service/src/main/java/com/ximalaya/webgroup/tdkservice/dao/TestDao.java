package com.ximalaya.webgroup.tdkservice.dao;


import com.ximalaya.webgroup.tdkservice.core.db.mybatis.DataSourceContextHolder;
import com.ximalaya.webgroup.tdkservice.core.db.mybatis.TDKModel;
import com.ximalaya.webgroup.tdkservice.core.db.mybatis.mapper.TestMapper;
import com.ximalaya.webgroup.tdkservice.model.ConfigConstant;
import com.ximalaya.webgroup.tdkservice.model.Employee;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TestDao {

    @Autowired
    TestMapper mapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public TDKModel selectTitle(String uniqueCode) {
        DataSourceContextHolder.setDataSourceKey(ConfigConstant.OPS_DS_KEY);
        TDKModel title = mapper.select(uniqueCode);
        DataSourceContextHolder.clearDataSourceKey();
        return title;
    }


    public List<TDKModel> selectAll(RowBounds rowBounds) {
        Map<String, Object> map = new HashMap<String, Object>();
        DataSourceContextHolder.setDataSourceKey(ConfigConstant.OPS_DS_KEY);
        List<TDKModel> models = mapper.selectAll(new RowBounds(0, 5));
        DataSourceContextHolder.clearDataSourceKey();
        return models;
    }


    public void insertList() {
        List<TDKModel> list = new ArrayList<>();
        TDKModel model1 = new TDKModel("title1", "desc1", "keywords1", "uniqueCode1");
        TDKModel model2 = new TDKModel("title2", "desc2", "keywords2", "uniqueCode2");
        TDKModel model3 = new TDKModel("title3", "desc3", "keywords3", "uniqueCode3");
        TDKModel model4 = new TDKModel("title4", "desc4", "keywords4", "uniqueCode4");

        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        DataSourceContextHolder.setDataSourceKey(ConfigConstant.OPS_DS_KEY);
        mapper.insertList(list);
        DataSourceContextHolder.clearDataSourceKey();
    }


    public void insertOne() {
        TDKModel model1 = new TDKModel("title1", "desc1", "keywords1", "uniqueCode88",null);

        DataSourceContextHolder.setDataSourceKey(ConfigConstant.OPS_DS_KEY);
        mapper.insertOne(model1);

        logger.error("+++++" + String.valueOf(model1.getId()));

        DataSourceContextHolder.clearDataSourceKey();
    }

    public void selectEmployee() {

        DataSourceContextHolder.setDataSourceKey(ConfigConstant.LOCAL_DS_KEY);

        Employee emp = mapper.selectEmployee(499999);
        Employee emp2 = mapper.selectCurrentEmployee(499999);

        DataSourceContextHolder.clearDataSourceKey();
    }
}
