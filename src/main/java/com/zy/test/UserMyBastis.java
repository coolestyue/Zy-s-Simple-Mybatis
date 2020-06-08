package com.zy.test;

import com.zy.io.Resources;
import com.zy.mapper.UserMapper;
import com.zy.mybatis.SqlSession;
import com.zy.mybatis.SqlSessionFactory;
import com.zy.mybatis.SqlSessionFactoryBuilder;
import com.zy.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ZY
 * 18:22
 */
public class UserMyBastis {

   public static void main(String[] args) {
      try {
         // 1. 读取配置文件
         InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
         // 2. 创建 SqlSessionFactory 工厂
         SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
         SqlSessionFactory factory = builder.build(is);
         // 3. 获取 SqlSession 对象
         SqlSession sqlSession = factory.openSession();
         // 4. 使用 SqlSession 创建 Mapper 的代理对象
         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
         // 5. 使用代理对象执行查询
         List<User> users = mapper.selectList();
         users.forEach(System.out::println);
         // 6. 释放资源
         sqlSession.close();
         is.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }


}
