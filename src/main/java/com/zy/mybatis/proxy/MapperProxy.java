package com.zy.mybatis.proxy;

import com.zy.mybatis.Mapper;
import com.zy.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * ZY
 * 21:13
 */
public class MapperProxy implements InvocationHandler{

    // map的key为全限定类名 + 方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取方法名
        String methodName = method.getName();
        // 获取方法所在的类的名称
        String className = method.getDeclaringClass().getName();
        // 组合key
        String key = className + "." + methodName;
        // 获取Mapper
        Mapper mapper = mappers.get(key);
        // 判断是否有mapper
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        // 调用工具类进行查询
        return new Executor().selectList(mapper, conn);

    }
}
