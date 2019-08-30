package com.ximalaya.webgroup.tdkservice.core.db.mybatis.mapper;


import com.ximalaya.webgroup.tdkservice.core.db.mybatis.TDKModel;
import com.ximalaya.webgroup.tdkservice.model.Employee;
import com.ximalaya.webgroup.tdkservice.model.Salary;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;


@Mapper
public interface TestMapper {

    TDKModel select(@Param("uniqueCode") String uniqueCode);

    List<TDKModel> selectAll(RowBounds rowBounds);


    void insertList(@Param("list") List<TDKModel> list);

    void insertOne(@Param("element") TDKModel element);

    Employee selectEmployee(@Param("emp_no") int enm_no);

    Employee selectCurrentEmployee(int enm_no);

    Salary selectSalary(int emp_no);

}
