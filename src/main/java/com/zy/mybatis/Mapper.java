package com.zy.mybatis;

/**
 * ZY
 * 20:01
 */
public class Mapper{
    /**
     * sql语句
     */
    private String queryString;
    /**
     * 结果类型的全限定类名
     */
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

}
