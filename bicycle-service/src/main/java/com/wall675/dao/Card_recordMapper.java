package com.wall675.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wall675.model.Card;
import com.wall675.model.Card_record;

public interface Card_recordMapper {
	
	/**
	 * 判读当月月卡是否已经充值过
	 * @param card_code
	 * @param curMonth
	 * @return 
	 */
	public int judgeCharge(@Param("card_id")Integer card_id,@Param("curMonth")String curMonth);
	
	/**
	 * 5)	卡费用流水填写，将本次充值流水信息写入到卡费用流水中，费用类型为（1：充值）。
	 * @param card_id,chg_monthly_money,chg_wallet_money,chg_frozen_money,user_id
	 * @return
	 */
	public int insertCardRecord(@Param("card_id")Integer card_id,@Param("fee_type")Integer fee_type,@Param("chg_monthly_money")Double chg_monthly_money,@Param("chg_wallet_money")Double chg_wallet_money,@Param("chg_frozen_money")Double chg_frozen_money,@Param("create_time")String create_time,@Param("user_id")Integer user_id,@Param("remark")String remark,@Param("ZXBJ")Integer ZXBJ);
	
	//统计有充值记录的卡张数
	public int countCardRecord();
	
	//总充值金额
	public double sumChgMoney(@Param("date")String date,@Param("card_id")Integer card_id);
	
	//总消费金额
   public double sumSpendMoney(@Param("date")String date,@Param("card_id")Integer card_id);
   
   //总租车次数
   public int sumRentTimes(@Param("date")String date,@Param("card_id")Integer card_id);
   
   //平均租车次数
   public double avgRentTimes(@Param("date")String date,@Param("card_id")Integer card_id);
   
  //单卡的充值次数
   public int sumChargeTimes(Integer card_id);
   
   //单卡的费用流水
   public List<Card_record> listCardRecord(Integer card_id);
   

 
}
