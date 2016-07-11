package com.jzc.Util;

import java.util.HashMap;

public class Method {
    
    //该方法的作者
    private String author;
    
    //该方法的url
    private String url;
    
    //该方法的请求方式
    private String requestMethod;
    
    //该方法的名字
    private String name;
    
    //该方法的请求参数
    private HashMap<String,String> param;
    
    //该方法的成功返回值
    private HashMap<String,String> result;
    
    //该方法的异常返回值
    private HashMap<String,String> excep;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getParam() {
        return param;
    }

    public void setParam(HashMap<String, String> param) {
        this.param = param;
    }

    public HashMap<String, String> getResult() {
        return result;
    }

    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    public HashMap<String, String> getExcep() {
        return excep;
    }

    public void setExcep(HashMap<String, String> excep) {
        this.excep = excep;
    }
    
    
}
