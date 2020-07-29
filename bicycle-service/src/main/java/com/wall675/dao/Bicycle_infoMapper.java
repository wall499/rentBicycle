package com.wall675.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wall675.model.Bicycle_info;

public interface Bicycle_infoMapper {

	
	/**
	 * 修改维修调出的车辆状态
	 * @param bicycle_id
	 * @return
	 */
	public int updateOutBicycle(Integer bicycle_id);
	
	/**
	 * 修改维修调入的车辆状态
	 * @param bicycle_id,pile_id
	 * @return
	 */
	public int updateInBicycle(Integer bicycle_id,Integer pile_id);
	
	/**
	 * 查询所有状态为4：普通调出的车辆
	 * @return
	 */
	public List<Bicycle_info> selInfo();
	
	
	
}
