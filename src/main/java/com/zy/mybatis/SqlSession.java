package com.zy.mybatis;

/**
 * ZY
 * 19:21
 * mybatis核心类,通过来创建mapper实现类的代理对象
 */
public interface SqlSession {

    /**
     * 根据mapper接口的类的字节码对象创建mapper代理
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T>T getMapper(Class<T> daoInterfaceClass);

    void close();

}
