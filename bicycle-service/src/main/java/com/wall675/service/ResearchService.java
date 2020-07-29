package com.wall675.service;

import com.wall675.model.StatisticData;

public interface ResearchService {
	//年度内所有的租车卡的总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数
		public StatisticData totalYearStat(String date,Integer card_id);
		
		//年度内所有的租车卡的总充值金额，总消费金额，总租车次数，平均租车次数，总租车时间数，平均租车时间数
		public StatisticData SingleYearStat(String date,Integer card_id);
}
