package com.wall675.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wall675.model.Bicycle_station;

public interface Bicycle_stationMapper {
	/**
	 * 查询所有车点
	 * @return
	 */
	public List<Bicycle_station> selStationInfo();
}
