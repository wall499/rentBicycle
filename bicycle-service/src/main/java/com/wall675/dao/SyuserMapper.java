package com.wall675.dao;

import com.wall675.model.Syuser;

public interface SyuserMapper {
	/**
	 * 用户名登录
	 * @param syuser
	 * @return
	 */
	public Syuser login(Syuser syuser);
	
	
	/**
	 * 校验手机用户是否存在
	 * @param mobilePhone
	 * @return
	 */
	public Syuser phoneLogin(String mobilePhone);

}
