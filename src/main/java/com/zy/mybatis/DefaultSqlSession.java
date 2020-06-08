package com.zy.mybatis;

import com.zy.mybatis.cfg.Configuration;
import com.zy.mybatis.proxy.MapperProxy;
import com.zy.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ZY
 * 20:03
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection conn;
    public DefaultSqlSession(Configuration configuration) {
        this.cfg = configuration;
        this.conn = DataSourceUtil.getConnection(cfg);
    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {


        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                                        new Class[]{daoInterfaceClass},
                                        new MapperProxy(cfg.getMappers(),conn)
                );
    }

    @Override
    public void close() {
        //可以先判断非空
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
