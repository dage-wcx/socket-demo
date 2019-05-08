package com.socket.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Userinfo
 * @Description
 * @Author wcx
 * @Date 2019/05/08 10:05
 * @Version
 **/
public class Userinfo implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账号
     */
    private Integer account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String headPhoto;

    /**
     * 性别
     */
    private String sex;

    /**
     * 签名
     */
    private String signature;

    /**
     * 注册时间
     */
    private String registerTime;

    /**
     * 修改时间
     */
    private String modifyTime;

    /**
     * 用户状态
     */
    private Integer userType;

    /**
     * 用户有效性
     */
    private Integer userValidity;

    public Userinfo() { }

    public Userinfo(Integer userId, Integer account, String username, String password, String headPhoto, String sex, String signature, String registerTime, String modifyTime, Integer userType, Integer userValidity) {
        this.userId = userId;
        this.account = account;
        this.username = username;
        this.password = password;
        this.headPhoto = headPhoto;
        this.sex = sex;
        this.signature = signature;
        this.registerTime = registerTime;
        this.modifyTime = modifyTime;
        this.userType = userType;
        this.userValidity = userValidity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
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

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.registerTime = sdf.format(registerTime);
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.modifyTime = sdf.format(modifyTime);
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserValidity() {
        return userValidity;
    }

    public void setUserValidity(Integer userValidity) {
        this.userValidity = userValidity;
    }
}
