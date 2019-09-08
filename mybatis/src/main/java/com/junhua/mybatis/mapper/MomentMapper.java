package com.junhua.mybatis.mapper;

import com.junhua.mybatis.model.Moment;
import org.apache.ibatis.annotations.Param;

public interface MomentMapper {

    Moment selectMoment(@Param("id") int id);
}
