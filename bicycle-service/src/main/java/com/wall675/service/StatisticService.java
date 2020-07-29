package com.wall675.service;


import java.util.List;

import com.wall675.model.Card_record;

import com.wall675.model.StatisticData;

public interface StatisticService {
	//租车卡的总张数，有租车记录的卡张数，总充值金额，总消费金额，现冻结金额，现可用余额，总租车小时数，总租车次数。平均租车次数。
	public StatisticData totalStatistic();
	
	//单张卡信息
	public StatisticData singleStatistic(Integer card_id); 
	
	
	//单张卡费用流水，按时间降序排列
	public List<Card_record> cardRecordList(Integer card_id);
}
