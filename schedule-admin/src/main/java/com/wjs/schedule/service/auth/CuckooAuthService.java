package com.wjs.schedule.service.auth;

import com.wjs.schedule.domain.auth.CuckooAuthUser;
import com.wjs.schedule.qry.auth.AuthUserQry;
import com.wjs.schedule.qry.job.GroupAuthQry;
import com.wjs.schedule.vo.auth.CuckooGroupAuthVo;
import com.wjs.schedule.vo.auth.CuckooLogonInfo;
import com.wjs.util.dao.PageDataList;

public interface CuckooAuthService {
	
	/**
	 * 获得登录用户信息 -- 内部通过ThreadLocal获取
	 * @return
	 */
	public CuckooLogonInfo getLogonInfo();
	
	
	/**
	 * 
	 * @param cuckooLogonInfo
	 */
	public void setLogonInfo(CuckooLogonInfo cuckooLogonInfo);
	

	/**
	 * 清空logon信息 - ThreadLocal
	 */
	public void clearLogon();
	
	
	/**
	 * 通过用户名和密码获得登录信息
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public CuckooLogonInfo getLogonInfo(String userName, String userPwd);


	/**
	 * 用户名是否存在 
	 * @param userName
	 */
	public void isUsernameExist(String userName);


	/**
	 * 新增用户
	 * @param user
	 */
	public void addUser(CuckooAuthUser user);


	/**
	 * 刷新权限
	 * @param cuckooLogonInfo
	 * @param user
	 */
	void refreshAuth(CuckooLogonInfo cuckooLogonInfo);


	/**
	 * 新增权限关系
	 * @param userId
	 * @param groupId
	 */
	public void addAuthJobgrp(Long userId, Long groupId);

	/**
	 * 分页查询分组级别各个用户权限
	 * @param qry
	 * @return
	 */
	public PageDataList<CuckooGroupAuthVo> pageGroupAuth(GroupAuthQry qry);


	/**
	 * 
	 * @param type
	 * @param authId
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public void changeAuth(String type, Long authId, Long userId, Long groupId);

	/**
	 * 查询登录用户信息
	 * @param id
	 * @return
	 */
	public CuckooAuthUser getUserInfoById(Long id);


	/**
	 * 修改用户
	 * @param cuckooAuthUser
	 */
	public void update(CuckooAuthUser cuckooAuthUser);


	/**
	 * 查询条件
	 * @param qry
	 * @return
	 */
	public PageDataList<CuckooAuthUser> pageAuthUser(AuthUserQry qry);


}
