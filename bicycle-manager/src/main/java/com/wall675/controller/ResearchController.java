package com.wall675.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wall675.model.StatisticData;
import com.wall675.service.impl.ResearchServiceImpl;

@RestController
@RequestMapping("/main/research")
public class ResearchController {
	private Logger logger = Logger.getLogger(ResearchController.class);
	
	@Autowired
	private ResearchServiceImpl researchServiceImpl;
	
	
	/**
	 * 统计年度内所有的租车卡的总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数。
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/totalYear",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public StatisticData totalYearStat(String date,Integer card_id) {
		
		return researchServiceImpl.totalYearStat(date,card_id);
	}
	
	
	/**
	 * 统计月度内所有的租车卡的总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数。
	 * @param 
	 * @return
	 */
//	@RequestMapping(value="/totalMonth",produces = {"application/json;charset=utf-8"})
//	@ResponseBody
//	public StatisticData totalMonthStat() {
//		
//		return researchServiceImpl.totalMonthStat();
//	}
	
	/**
	 * 统计年度内单张租车卡的总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数。
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/singleYear",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public StatisticData singleYearStat(String date,Integer card_id) {
		
		return researchServiceImpl.SingleYearStat(date,card_id);
	}
	
	
	/**
	 * 统计月度内单张租车卡的总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数。
	 * @param 
	 * @return
	 */
//	@RequestMapping(value="/singleMonth",produces = {"application/json;charset=utf-8"})
//	@ResponseBody
//	public StatisticData singleMonthStat() {
//		
//		return researchServiceImpl.singleMonthStat();
//	}
//	
}
