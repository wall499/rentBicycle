package com.wall675.service;

import java.util.List;

import com.wall675.model.Bicycle_pile;
import com.wall675.model.Bicycle_station;

public interface DeployInService {
	   //普通调入
		public void deployIn(Integer pile_id,Integer bicycle_id);
		
		//所有车点的信息
		public List<Bicycle_station> selStationInfo();
		
		
		//查询指定车点所有车桩的信息
	public List<Bicycle_pile> selPile(Integer station_id);
}
