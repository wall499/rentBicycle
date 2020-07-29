package com.wall675.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wall675.dao.SyuserMapper;
import com.wall675.model.Syuser;
import com.wall675.service.SyuserService;

@Service
public class SyuserServiceImpl implements SyuserService{
	
	@Autowired
	private SyuserMapper syuserMapper;
	public Syuser login(Syuser syuser) {
		return syuserMapper.login(syuser);
	}

}
