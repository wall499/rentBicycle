package com.wall675.service;

import com.wall675.model.Card;

public interface CardService {
	         //充值
			public void chargeCard(String card_code,Double chgMoney,String flag,Integer userid);
			
			 //办理新卡
			public void applyNewCard(Card card,Integer userid);
			
			//挂失卡
			public void reportLossCard(Card card,Integer userid);
			
			//注销卡
			public void cancelCard(Card card,Integer userid);
			
			//修改卡信息
			public void updateCardInfo(Card card);
}
