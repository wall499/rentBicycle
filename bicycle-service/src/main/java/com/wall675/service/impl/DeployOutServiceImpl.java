package com.wall675.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wall675.dao.Bicycle_dealMapper;
import com.wall675.dao.Bicycle_deployMapper;
import com.wall675.dao.Bicycle_infoMapper;
import com.wall675.dao.Bicycle_pileMapper;
import com.wall675.dao.CardMapper;
import com.wall675.exception.ServiceException;
import com.wall675.model.Card;
import com.wall675.service.DeployOutService;
import com.wall675.util.DateUtil;

@Service
public class DeployOutServiceImpl implements DeployOutService{

	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private Bicycle_infoMapper bicycle_infoMapper;
	
	@Autowired
	private Bicycle_pileMapper bicycle_pileMapper;
	
	@Autowired
	private Bicycle_deployMapper bicycle_deployMapper;
	
	@Autowired
	private Bicycle_dealMapper bicycle_dealMapper;
	
	@Transactional
	public void deployOut(String card_code, Integer pile_id, Integer bicycle_id) {
			System.out.println("card_code     "+card_code+"   pile_id   "+pile_id+"     bicycle_id  "+bicycle_id);
		//1.判断卡类型是否为员工卡 （card表）
		Card card = cardMapper.selCard(card_code);
		if(card.getCard_type()!=4) {
			throw new ServiceException("请使用员工卡！"); 
		}
		Integer card_id=cardMapper.selCardId(card_code);
		//2.在bicycle_info表中将被选中的车辆的车辆状态改成4，将所在车桩的id清空
		int complete=bicycle_infoMapper.updateOutBicycle(bicycle_id);
		if(complete == 0) {
			throw new ServiceException("车辆状态修改失败！");
		}
		
		//3.bicycle_pile中将所在车桩的状态改成2，将所存车辆id清空
		int complete1 = bicycle_pileMapper.updatePile(bicycle_id);
		if(complete1 == 0) {
			throw new ServiceException("车桩状态修改失败！");
		}
		
		//4.记录车辆调配明细，记录车辆id，调出车桩id，调出卡号等信息，调入原因填写（4：普通调出）。
		String from_time = DateUtil.currentTime();	//获取当前时间作为调出时间
		int addDeploy = bicycle_deployMapper.insertBicycleDeployOut(bicycle_id, pile_id, card_id,from_time);
		if(addDeploy != 1) {
			throw new ServiceException("车辆调配明细新增失败！");
		}
		int deploy_id=bicycle_deployMapper.selDeployId(bicycle_id, from_time);	//查询调配明细id
		
		//5.记录车辆业务流水，业务类型为（4：普通调出），关联的业务记录id填写车辆调配明细id，业务名称填写(普通调出)，是否发生费用为（0：未发生），费用金额填0。
		int n=bicycle_dealMapper.addDeal(from_time, deploy_id, card_id, pile_id, bicycle_id);
		if(n != 1) {
			throw new ServiceException("车辆业务流水新增失败！");
		}
	}

}
