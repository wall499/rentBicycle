package com.wall675.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wall675.model.Card_record;

import com.wall675.model.StatisticData;
import com.wall675.service.impl.StatisticServiceImpl;

@RestController
@RequestMapping("/main/statistic")
public class StatisticsController {
	private Logger logger = Logger.getLogger(StatisticsController.class);
		
	@Autowired
	private StatisticServiceImpl statisticServiceImpl;


	
	/**
	 * 统计所有卡实时的所有租车卡的总张数，有租车记录的卡张数，总充值金额，总消费金额，现冻结金额，现可用余额，总租车小时数，总租车次数。平均租车次数。
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/total",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public StatisticData totalStatistic() {
		
		return statisticServiceImpl.totalStatistic();
	}
	
	/**
	  * 单张卡信息，统计总充值金额，总充值次数，总消费金额，现冻结金额，现可用余额，总租车小时数，总租车次数，单次租车时间等信息。
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/single",produces = {"application/json;charset=utf-8"})
	@ResponseBody
	public StatisticData singleStatistic(Integer card_id) {
		System.out.println("aaaaaaaaaaa");
		StatisticData dd=	statisticServiceImpl.singleStatistic(card_id);
		System.out.println("GGG   "+ dd);
		return statisticServiceImpl.singleStatistic(card_id);
	}
	
	
	/**
	  * 单张卡的费用流水，按时间降序排列
	 * @param 
	 * @return
	 */
	@RequestMapping("/list")
	public List<Card_record> cardRecordList(Integer card_id){
		List<Card_record> cc=statisticServiceImpl.cardRecordList(card_id);
		for(int i = 0;i < cc.size();i++){
		    System.out.println(cc.get(i));
		}
		return statisticServiceImpl.cardRecordList(card_id);
	}
	
	
}
