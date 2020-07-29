package com.wall675.service;

import com.github.pagehelper.PageInfo;
import com.wall675.model.Bicycle_info;

public interface BicycleService {
	//分页查询所有状态为普通调出的车辆
	public PageInfo<Bicycle_info> select(int pageNum);
	
	
	
}
