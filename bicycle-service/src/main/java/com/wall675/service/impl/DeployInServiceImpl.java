package com.wall675.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wall675.constants.PageConfig;
import com.wall675.dao.Bicycle_dealMapper;
import com.wall675.dao.Bicycle_deployMapper;
import com.wall675.dao.Bicycle_infoMapper;
import com.wall675.dao.Bicycle_pileMapper;
import com.wall675.dao.Bicycle_stationMapper;
import com.wall675.exception.ServiceException;
import com.wall675.model.Bicycle_pile;
import com.wall675.model.Bicycle_station;
import com.wall675.model.Card;
import com.wall675.service.DeployInService;
import com.wall675.util.DateUtil;

@Service
public class DeployInServiceImpl implements DeployInService{
	
	@Autowired
	private Bicycle_infoMapper bicycle_infoMapper; 
	
	@Autowired
	private Bicycle_pileMapper bicycle_pileMapper;
	
	@Autowired
	private Bicycle_deployMapper bicycle_deployMapper;
	
	@Autowired
	private Bicycle_dealMapper bicycle_dealMapper;
	
	@Autowired
	private Bicycle_stationMapper bicycle_stationMapper;
	
	//所有的车点信息
	public List<Bicycle_station> selStationInfo() {
		List<Bicycle_station> stations = bicycle_stationMapper.selStationInfo();
		return stations;
	}
	
	
	
	//查询指定车点所有车桩的信息
		public List<Bicycle_pile> selPile(Integer station_id){
			List<Bicycle_pile> piles= bicycle_pileMapper.selPileInfo(null,station_id);			
			return piles;
		}
	
	
	

	@Transactional
	public void deployIn(Integer pile_id, Integer bicycle_id) {
		//校验车桩是否有车 
//		List<Bicycle_pile> pile = bicycle_pileMapper.selPileInfo(pile_id, null);
//		if(pile.size()!=0) {
//			throw new ServiceException("调入车桩失败！");
//		}
		// TODO Auto-generated method stub
		// 1.	修改车辆状态从普通调出(4)变为在桩(3)
				int i = bicycle_infoMapper.updateInBicycle(bicycle_id, pile_id);
				if(i != 1) {
					throw new ServiceException("车辆状态修改失败！");
				}
				
				//2.车桩表中状态改为有车，并填入车辆id
				int j = bicycle_pileMapper.updateDeployedPile(bicycle_id, pile_id);
				if(j != 1) {
					throw new ServiceException("车桩状态修改失败！");
				}
				
				//3.该车辆的车辆调配明细，填写车辆调入信息。填写调入车桩，调入车点，调入日期，调入人，调入原因为（5：普通调入）
				String to_time = DateUtil.currentTime();	//获取当前时间作为调入时间
				Integer deploy_id = bicycle_deployMapper.selDeployedId(bicycle_id);	//查询普通调出时的明细记录id
					//明细表中填入调入信息
				int m = bicycle_deployMapper.setDeploy(deploy_id, pile_id, to_time);
//				if(m != 1) {
//					throw new ServiceException("调入明细填入失败！");
//				}
				
				//4.写车辆业务流水
				int n = bicycle_dealMapper.addDeployIn(deploy_id, bicycle_id, pile_id, to_time);
//				if(n != 1) {
//					throw new ServiceException("车辆业务流水填入失败！");
//				}
	
	}

}
