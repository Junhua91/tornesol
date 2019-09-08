package com.junhua.mybatis.db;

import com.junhua.mybatis.mapper.MomentMapper;
import com.junhua.mybatis.model.Moment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MomentDao {


    /**
     * @return
     * @throws IOException
     */
    public Moment getMoment() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in, "development");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Moment moment = sqlSession.selectOne("momentMapper.selectMoment", 1);
        MomentMapper mapper = sqlSession.getMapper(MomentMapper.class);
        Moment moment1 = mapper.selectMoment(2);

        return moment1;
    }
}
