package com.junhua.tornesol.architecture.miaosha.db.mapper;

import com.junhua.tornesol.architecture.miaosha.db.model.UserDealDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDealMapper {

    int selectCount(@Param("userId") int userId, @Param("dealId") int dealId);

    void insert(@Param("userDeal") UserDealDO userDealDO);

    int getCountSum(@Param("dealId") int dealId);

}
