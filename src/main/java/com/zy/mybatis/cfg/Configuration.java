package com.zy.mybatis.cfg;

import com.zy.mybatis.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * ZY
 * 20:00
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    // 必须new一个集合出来，不然下面调用putAll会空指针异常
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        // 这里应该使用put的方式，直接赋值的话会覆盖原本Map集合中的内容
        this.mappers.putAll(mappers);
    }

}

