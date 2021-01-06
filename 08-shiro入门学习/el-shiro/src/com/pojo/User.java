package com.pojo;

/**
 * 用户类，存放账号和密码
 */
public class User {

    /**
     * name 用户名
     */
    private String name;

    /**
     * password 密码
     */
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
