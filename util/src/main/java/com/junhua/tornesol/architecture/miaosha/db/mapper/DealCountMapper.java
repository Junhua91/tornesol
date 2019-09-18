package com.junhua.tornesol.architecture.miaosha.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DealCountMapper {


    int getRestDealCount(@Param("dealId") int dealId);

    //无乐观锁
    void addDealCount(@Param("dealId") int dealId, @Param("newCount") int newCount);

    //加乐观锁
    int updateDealCount(@Param("dealId") int dealId, @Param("newCount") int newCount, @Param("oldCount") int oldCount);

}
