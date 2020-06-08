package com.zy.io;

import java.io.InputStream;

/**
 * ZY
 * 18:21
 * 使用类加载器读取配置文件
 */
public class Resources {
    /**
     * 根据参数获取字节输入流
     *
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}