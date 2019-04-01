package kgc.com.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PersonImpl {
    private SqlSession session = null;

    @Before
    public void init() throws IOException {
        //SqlSession(核心类)--->SqlSessionFactory---->SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder ssb = new SqlSessionFactoryBuilder();
        //将mybatis.xml主配置文件以流的形式进行读取
        InputStream ins = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = ssb.build(ins);
        //通过SqlSessionFactory得到SqlSession对象
         session=sqlSessionFactory.openSession();
    }
  @Test
    public void  getPersonById() {

        Map<String,Object> Map = new HashMap<String,Object>();
        Map.put("name","李明");
        Map.put("phone","2147483647");
        Map<String,Object> resultMap = session.selectOne("kgc.com.mybatis.PersonImpl.getPersonById",Map);
        resultMap.forEach((k,v)-> System.out.print(k+"="+v+"\t"));
    }
}
