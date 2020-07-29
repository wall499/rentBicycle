package com.wall675.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.wall675.model.Bicycle_pile;

public interface Bicycle_pileMapper {
	
	/**
	 * 修改维修调出的车桩状态（2：无车）
	 * @param bicycle_id
	 * @return
	 */
	public int updatePile(Integer bicycle_id);
	
	
	/**
	 * 维修调入的车桩状态改为1：有车，并设置车辆id
	 * @param bicycle_id
	 * @param pile_id
	 * @return
	 */
	public int updateDeployedPile(@Param("bicycle_id") Integer bicycle_id,@Param("pile_id") Integer pile_id);
	
	/**
	 * 查询有车的车桩
	 * @return
	 */
	public List<Bicycle_pile> selPileInfo(@Param("pile_id") Integer pile_id,@Param("station_id") Integer station_id);
	
	
}
