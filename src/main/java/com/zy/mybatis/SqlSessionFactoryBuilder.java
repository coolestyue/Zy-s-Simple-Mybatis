package com.zy.mybatis;

import com.zy.mybatis.cfg.Configuration;
import com.zy.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * ZY
 * 19:19
 */
public class SqlSessionFactoryBuilder{

    public SqlSessionFactory build(InputStream io){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(io);
        return new DefaultSqlSessionFactory(configuration);
    }
}
