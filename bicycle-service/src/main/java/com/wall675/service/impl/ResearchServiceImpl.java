package com.wall675.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.wall675.dao.Bicycle_recordMapper;
import com.wall675.dao.CardMapper;
import com.wall675.dao.Card_recordMapper;
import com.wall675.model.StatisticData;
import com.wall675.service.ResearchService;

@Service
public class ResearchServiceImpl implements ResearchService{
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private Card_recordMapper card_recordMapper;
	
	@Autowired
	private Bicycle_recordMapper bicycle_recordMapper;
	
	/**
	 * 年度内所有的租车卡的总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数
	 * @param date 
	 * @return
	 */
	public StatisticData totalYearStat(@RequestParam String date,@RequestParam(required=false)Integer card_id) {
		//总充值金额
		double sumChgMoney=card_recordMapper.sumChgMoney(date,0);
		//总消费金额
		double sumSpendMoney=card_recordMapper.sumSpendMoney(date,0);
		//总租车次数
		int sumRentTimes=card_recordMapper.sumRentTimes(date,0);
		//平均租车次数
		double avgRentTimes=card_recordMapper.avgRentTimes(date,0);
		//总租车时间数
		int sumRentHour=bicycle_recordMapper.sumRentHour(date,0);
		//平均租车时间数
		double avgRentHour=bicycle_recordMapper.avgRentHour(date,0);

		return new StatisticData(sumChgMoney,sumSpendMoney,sumRentHour,sumRentTimes,avgRentTimes,avgRentHour);	
	}
	
	
	/**
	 * 单张卡月度内，年度内，租车卡的充值金额，消费金额，租车次数，租车时间数，平均租车时间
	 * @param date,card_id
	 * @return
	 */
	public StatisticData SingleYearStat(@RequestParam String date,@RequestParam(required=false)Integer card_id) {
				//总充值金额
				double sumChgMoney=card_recordMapper.sumChgMoney(date,card_id);
				//总消费金额
				double sumSpendMoney=card_recordMapper.sumSpendMoney(date,card_id);
				//总租车次数
				int sumRentTimes=card_recordMapper.sumRentTimes(date,card_id);
				
				//总租车时间数
				int sumRentHour=bicycle_recordMapper.sumRentHour(date,card_id);
				//平均租车时间数
				double avgRentHour=bicycle_recordMapper.avgRentHour(date,card_id);
				
				return new StatisticData(sumChgMoney,sumSpendMoney,sumRentHour,sumRentTimes,null,avgRentHour);	
	}
}
