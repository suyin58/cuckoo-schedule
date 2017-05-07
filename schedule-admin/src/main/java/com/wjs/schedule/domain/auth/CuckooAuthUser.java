package com.wjs.schedule.domain.auth;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooAuthUser implements Serializable {
    /**
     * 标准ID -- cuckoo_auth_user.id
     * 
     */
    private Long id;

    /**
     * 用户姓名 -- cuckoo_auth_user.user_name
     * 
     */
    private String userName;

    /**
     * 用户密码 -- cuckoo_auth_user.user_pwd
     * 
     */
    private String userPwd;

    /**
     * 用户权限类型 -- cuckoo_auth_user.user_auth_type
     * 
     */
    private String userAuthType;

    /**
     * 电话 -- cuckoo_auth_user.phone
     * 
     */
    private String phone;

    /**
     * 邮件 -- cuckoo_auth_user.email
     * 
     */
    private String email;

    /**
     * 机构名称 -- cuckoo_auth_user.org_name
     * 
     */
    private String orgName;

    /**
     * cuckoo_auth_user表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cuckoo_auth_user.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cuckoo_auth_user.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cuckoo_auth_user.user_name的get方法 
     * 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 数据字段 cuckoo_auth_user.user_name的set方法
     * 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 数据字段 cuckoo_auth_user.user_pwd的get方法 
     * 
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 数据字段 cuckoo_auth_user.user_pwd的set方法
     * 
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * 数据字段 cuckoo_auth_user.user_auth_type的get方法 
     * 
     */
    public String getUserAuthType() {
        return userAuthType;
    }

    /**
     * 数据字段 cuckoo_auth_user.user_auth_type的set方法
     * 
     */
    public void setUserAuthType(String userAuthType) {
        this.userAuthType = userAuthType == null ? null : userAuthType.trim();
    }

    /**
     * 数据字段 cuckoo_auth_user.phone的get方法 
     * 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 数据字段 cuckoo_auth_user.phone的set方法
     * 
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 数据字段 cuckoo_auth_user.email的get方法 
     * 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 数据字段 cuckoo_auth_user.email的set方法
     * 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 数据字段 cuckoo_auth_user.org_name的get方法 
     * 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 数据字段 cuckoo_auth_user.org_name的set方法
     * 
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}