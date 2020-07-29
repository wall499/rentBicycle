package com.wall675.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wall675.constants.PageConfig;
import com.wall675.dao.Bicycle_infoMapper;
import com.wall675.dao.Bicycle_pileMapper;
import com.wall675.model.Bicycle_info;
import com.wall675.model.Bicycle_pile;
import com.wall675.service.BicycleService;
@Service
public class BicycleServiceImpl implements BicycleService{
	@Autowired
	private Bicycle_infoMapper bicycle_infoMapper;
	
	@Autowired
	private Bicycle_pileMapper bicycle_pileMapper;
	
	/**
	 * 分页查询所有状态为普通调出的车辆
	 * @param pageNum
	 * @return
	 */
	public PageInfo<Bicycle_info> select(int pageNum){
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);

		List<Bicycle_info> bic = bicycle_infoMapper.selInfo();
		
		return new PageInfo<Bicycle_info>(bic);
	}
	
	

	/**
	 * 分页查询所有状态为查询车桩
	 * @param pageNum
	 * @return
	 */
	public PageInfo<Bicycle_pile> selectPile(int pageNum){
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);

		List<Bicycle_pile> bpi = bicycle_pileMapper.selPileInfo(null,null);
		
		return new PageInfo<Bicycle_pile>(bpi);
	}

}
