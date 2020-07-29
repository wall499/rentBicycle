package com.wall675.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wall675.dao.Bicycle_recordMapper;
import com.wall675.dao.CardMapper;
import com.wall675.dao.Card_recordMapper;
import com.wall675.model.Card_record;
import com.wall675.model.SingleSpendTime;
import com.wall675.model.StatisticData;
import com.wall675.service.StatisticService;

@Service
public class StatisticServiceImpl implements StatisticService{
	
	@Autowired
	private CardMapper cardMapper;
	
	@Autowired
	private Card_recordMapper card_recordMapper;
	
	@Autowired
	private Bicycle_recordMapper bicycle_recordMapper;
	
	/**
	    * 租车卡的总张数，有租车记录的卡张数，总充值金额，总消费金额，现冻结金额，现可用余额，总租车小时数，总租车次数。平均租车次数。
	 * @param 
	 * @return
	 */
	public StatisticData totalStatistic() {
		//注册卡的数量
		int countCard=cardMapper.countCard();
		//有租车记录的卡数量
		int countCardRecord=card_recordMapper.countCardRecord();
		//总充值金额
		double sumChgMoney=card_recordMapper.sumChgMoney(null,0);
		//总消费金额
		double sumSpendMoney=card_recordMapper.sumSpendMoney(null,0);
		//现冻结金额
		double sumFrozenMoney=cardMapper.sumFrozenMoney(0);
		//现可用余额
		double sumMoney=cardMapper.sumMoney(0);
		//总租车小时数，总租车次数。平均租车次数。
		int sumRentHour=bicycle_recordMapper.sumRentHour(null,0);
		int sumRentTimes=card_recordMapper.sumRentTimes(null,0);
		double avgRentTimes=card_recordMapper.avgRentTimes(null,0);
		
		return new StatisticData(countCard,countCardRecord,sumChgMoney,sumSpendMoney,sumFrozenMoney,sumMoney,sumRentHour,sumRentTimes,avgRentTimes,null);
	}
	
	/**
	    * 单张卡的总充值金额，总充值次数，总消费金额，现冻结金额，现可用余额，总租车小时数，总租车次数，单次租车时间等信息
	 * @param card_id
	 * @return
	 */
	public StatisticData singleStatistic(Integer card_id) {
		//单张卡总充值金额
		double singleChgMoney=card_recordMapper.sumChgMoney(null,card_id);
		//单张卡总充值次数
		int singleChargeTimes=card_recordMapper.sumChargeTimes(card_id);
		//单张卡总消费金额
		double singleSpendMoney=card_recordMapper.sumSpendMoney(null,card_id);
		//单张卡冻结金额
		double singleFrozenMoney=cardMapper.sumFrozenMoney(card_id);
		//单张卡可用余额
		double singleMoney=cardMapper.sumMoney(card_id);
		//单张卡总租车小时数
		int singleRentHour=bicycle_recordMapper.sumRentHour(null,card_id);
		//单张卡租车次数
		int singleRentTimes=card_recordMapper.sumRentTimes(null,card_id);
		
		//单次租车时间
		List<SingleSpendTime> bicycle_records=bicycle_recordMapper.singleSpendTime(card_id);
		
		for(int i = 0;i <bicycle_records.size();i++){
		    System.out.println(bicycle_records.get(i));
		}
		
		return new StatisticData(null,singleChargeTimes,singleChgMoney,singleSpendMoney,singleFrozenMoney,singleMoney,singleRentHour,singleRentTimes,null,bicycle_records);	
	}
	
	
	//分页查询单卡对应的所有的card_record 
	public List<Card_record> cardRecordList(Integer card_id){
		
		return  card_recordMapper.listCardRecord(card_id);
	}
	
	
}
