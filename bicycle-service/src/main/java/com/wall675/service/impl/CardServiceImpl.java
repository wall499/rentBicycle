package com.wall675.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wall675.constants.PageConfig;
import com.wall675.dao.CardMapper;
import com.wall675.dao.Card_info_recordMapper;
import com.wall675.dao.Card_recordMapper;
import com.wall675.exception.ServiceException;
import com.wall675.model.Card;
import com.wall675.model.Card_record;
import com.wall675.service.CardService;
import com.wall675.util.DateUtil;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardMapper cardMapper; 
	
	@Autowired
	private Card_recordMapper card_recordMapper; 
	
	@Autowired
	private Card_info_recordMapper card_info_recordMapper; 
	
	//分页查询所有的card
	public PageInfo<Card> cardList(int pageNum,Card card){
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		
		List<Card> cards= cardMapper.listByCard(card);
		
		return new PageInfo<Card>(cards);
	}
	
	
	
	
	//办理新卡
	@Transactional
	public void applyNewCard(Card card,Integer user_id) {
		String create_time = DateUtil.currentTime();
		Card selCard=cardMapper.selCard(card.getCard_code());
		if(selCard != null) {
			throw new ServiceException("卡号不能重复！");
		}
		// TODO Auto-generated method stub
		int card_id=cardMapper.save(card);
		int i=card_info_recordMapper.insertCardInfoRecord(card_id,1.0,create_time,user_id,null);
		if(i != 1) {
			throw new ServiceException("创建新卡失败！");
		}
		
	}
	
	//卡信息修改
		public void updateCardInfo(Card card) {
			// TODO Auto-generated method stub
			int i=cardMapper.edit(card);
			if(i != 1) {
				throw new ServiceException("修改卡信息失败！");
			}
		}

	//挂失卡
	@Transactional
	public void reportLossCard(Card card,Integer user_id) {
		// TODO Auto-generated method stub
		cardMapper.reportLossCard(card.getCard_code());
		String create_time = DateUtil.currentTime();
		card_info_recordMapper.insertCardInfoRecord(card.getCard_id(),2.0,create_time,user_id,null);
		
	}
	
	//注销卡
		@Transactional
		public void cancelCard(Card card,Integer user_id) {
			// TODO Auto-generated method stub
			cardMapper.cancelAccount(card.getCard_code());
			String create_time = DateUtil.currentTime();
			card_info_recordMapper.insertCardInfoRecord(card.getCard_id(),3.0,create_time,user_id,"注销");
			if(card.getMonthly_money()!=0||card.getMonthly_money()!=0||card.getFrozen_money()!=0) {
			card_recordMapper.insertCardRecord(card.getCard_id(),5, card.getMonthly_money(), card.getWallet_money(), card.getFrozen_money(),create_time,user_id,"注销",1);
			}
		}
	

	//充值
	@Transactional
	public  void  chargeCard(String card_code,Double chg_money,String judge,Integer userid) {
		   Double walletMoney=0.0;
		   Double monthMoney=0.0;
		   String create_time = DateUtil.currentTime();	//获取当前时间
		   String curMonth = DateUtil.curMonth();	//获取当前月份
		   int j=0;
		   int z=0;
		
		// TODO Auto-generated method stub
		//输入卡号，查询卡信息，并且显示卡信息，若支持月票的卡，则需分别提示充值钱包和月票
				Card card = cardMapper.selCard(card_code);			
					//如果judge=month表示充值月卡，如果是wallet表示充值钱包
				    if("month".equals(judge)) {
				    	int cardnum=card_recordMapper.judgeCharge(card.getCard_id(), curMonth);
				    	//该月首次充值金额大于50，或者该月已经充值过
				    	if((cardnum==0&&chg_money>=50)||(cardnum!=0)) {
				    		//卡内余额变更
					    	monthMoney=card.getMonthly_money()+chg_money;
					    	 j=cardMapper.chargeMonthlyMoney(card_code,monthMoney);
					    	  if(j != 1) {
									throw new ServiceException("充值失败！");
								}	
					    	  z=card_recordMapper.insertCardRecord(card.getCard_id(),1,chg_money,0.0,0.0,create_time,userid,"充值",0);
				    	}else  {
				    		throw new ServiceException("首月充值金额小于50！");
				    	}
				    		
				    }else {
				    	//卡内余额变更
						walletMoney=card.getWallet_money()+chg_money;
				    	j=cardMapper.chargeWalletMoney(card_code,walletMoney);
				    	  if(j != 1) {
								throw new ServiceException("充值失败！");
							}	
				    	
				    	z=card_recordMapper.insertCardRecord(card.getCard_id(),1, 0.0,chg_money,0.0,create_time,userid,"充值",0);
				    }
				    if(z != 1) {
						throw new ServiceException("信息写入到卡费用流水失败！");
					}	
				}				
	}



	


	


	

