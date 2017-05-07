package com.wjs.schedule.vo.auth;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CuckooAuthUserVo {

	private Long id;

    private String userName;

    private String userPwd;
    
    private String userPwd2;

    private String userAuthType;

    private String phone;

    private String email;

    private String orgName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }
    
    public String getUserPwd2() {
        return userPwd2;
    }

    public void setUserPwd2(String userPwd2) {
        this.userPwd2 = userPwd2 == null ? null : userPwd2.trim();
    }

    public String getUserAuthType() {
        return userAuthType;
    }

    public void setUserAuthType(String userAuthType) {
        this.userAuthType = userAuthType == null ? null : userAuthType.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOrgName() {
        return orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
