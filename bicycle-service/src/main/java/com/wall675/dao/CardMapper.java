package com.wall675.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wall675.model.Card;

public interface CardMapper {

//	   //获取卡的数量
//		public int getTotal(Card card);
		
		//全部卡的信息
		public List<Card> listByCard(Card card);
		
		//挂失卡
		public void reportLossCard(String  card_code);
		
		//注销卡
		public void cancelAccount(String  card_code);
		
		//卡信息修改
		public int edit(Card card);
		
		//办理新卡
		public int save(Card card);
		
		//根据卡号查询此卡信息,查重
		public Card selCard(String card_code);
		
		//根据输入的card_code，查card_id 
		public Integer selCardId(String card_code);
		
		//根据card_code充值到wallet_money
		public int chargeWalletMoney(@Param("card_code")String card_code,@Param("wallet_money")Double wallet_money);
		
		//根据card_code充值到monthly_money
		public int chargeMonthlyMoney(@Param("card_code")String card_code,@Param("monthly_money")Double monthly_money);
		
		//统计卡的张数
		public int countCard();
		
		  //现冻结金额
		public double sumFrozenMoney(@Param("card_id")Integer card_id);
		
		//现可用余额
		public double sumMoney(@Param("card_id")Integer card_id);
	
				
		
		
		
	
}
