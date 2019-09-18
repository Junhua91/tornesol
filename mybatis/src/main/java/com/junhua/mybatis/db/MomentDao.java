package com.junhua.mybatis.db;

import com.junhua.mybatis.db.model.MomentDO;
import com.junhua.mybatis.mapper.MomentMapper;
import com.junhua.mybatis.model.Moment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;


@Repository
public class MomentDao {

    public SqlSession getSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in, "development");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


    /**
     * @return
     * @throws IOException
     */
    public Moment getMoment() throws IOException {
        SqlSession sqlSession = getSession();
        MomentMapper mapper = sqlSession.getMapper(MomentMapper.class);
        Moment moment1 = mapper.selectMoment(2);
        return moment1;
    }

    public void insert(int authorId, String content, String image) throws IOException {
        SqlSession sqlSession = getSession();
        MomentMapper mapper = sqlSession.getMapper(MomentMapper.class);
        MomentDO momentDO = new MomentDO();
        momentDO.setAuthorId(authorId);
        momentDO.setContent(content);
        momentDO.setImage(image);
        mapper.insert(momentDO);
        sqlSession.commit();
        sqlSession.close();
    }
}
