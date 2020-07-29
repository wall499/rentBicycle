package com.wall675.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wall675.model.Syuser;
import com.wall675.service.impl.CardServiceImpl;

@RestController
@RequestMapping("/main/charge")
public class ChargeController {
	private Logger logger = Logger.getLogger(ChargeController.class);
	
	@Autowired
	private CardServiceImpl cardServiceImpl;
	

	
	/**
	  * 充值
	 * @param card_code
	 * @param judge 充值方式
	 * @param chg_money 充值金额
	 * @return
	 */
	@RequestMapping(value="/card",produces = {"application/json;charset=utf-8"})

	public String  chargeCard(String card_code,Double chg_money,String judge,HttpSession session)  {
		try {
		Syuser user=(Syuser)session.getAttribute("syuser");
		cardServiceImpl.chargeCard(card_code,chg_money,judge,user.getUserId());
	}catch (Exception e) {
		
	e.printStackTrace();
	String msg=e.getMessage();
	if(msg=="首月充值金额小于50！") {
		return "monthError";
	}
		logger.error("服务端异常", e);
		return "error";
	}
	return "success";
	
}
}
