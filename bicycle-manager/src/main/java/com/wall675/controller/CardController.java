package com.wall675.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wall675.model.Bicycle_info;
import com.wall675.model.Card;
import com.wall675.model.MsPhase;
import com.wall675.model.Syuser;
import com.wall675.service.impl.CardServiceImpl;

@RestController
@RequestMapping("/main/card")
public class CardController {

	private Logger logger = Logger.getLogger(CardController.class);
	
	@Autowired
	private CardServiceImpl cardServiceImpl;
	
	
	/**
	 * 查询所有cards
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/list")
	public PageInfo<Card> cardList(@RequestParam(defaultValue = "1") int pageNum,Card card){
		return cardServiceImpl.cardList(pageNum,card);
	}
	
	/**
	 * 数据校验 在需要被校验的对象上 添加@Validated 跟在这个参数后面添加一个BindingResult的对象
	 * 
	 * BindingResult 对象用来保存验证的结果的
	 * @param card
	 * @param br
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(@Validated Card card,BindingResult br, HttpSession session) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			Syuser user =(Syuser) session.getAttribute("syuser");
			cardServiceImpl.applyNewCard(card, user.getUserId());
		}catch (Exception e) {
			e.printStackTrace();
			String msg=e.getMessage();
			if(msg=="卡号不能重复！") {
				return "repeatError";
			}
				logger.error("服务端异常", e);
				return "error";
			}
			return "success";
	}
	
	
	/**
	 * 数据校验 在需要被校验的对象上 添加@Validated 跟在这个参数后面添加一个BindingResult的对象
	 * 
	 * BindingResult 对象用来保存验证的结果的
	 * @param card
	 * @param br
	 * @return
	 */
	@RequestMapping("/update")
	public String updateCardInfo(@Validated Card card,BindingResult br) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			cardServiceImpl.updateCardInfo(card);
		}catch (Exception e) {
			e.printStackTrace();
			String msg=e.getMessage();
			if(msg=="卡号不能重复！") {
				return "repeatError";
			}
				logger.error("服务端异常", e);
				return "error";
			}
			return "success";
	}

	
	/**
	 * 挂失卡
	 * 数据校验 在需要被校验的对象上 添加@Validated 跟在这个参数后面添加一个BindingResult的对象
	 * 
	 * BindingResult 对象用来保存验证的结果的
	 * @param card
	 * @param br
	 * @return
	 */
	@RequestMapping("/reportLoss")
	public String reportLossCard(@Validated Card card,BindingResult br,HttpSession session) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			Syuser user =(Syuser) session.getAttribute("syuser");
			cardServiceImpl.reportLossCard(card, user.getUserId());
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
	}
	
	
	/**
	 * 注销卡
	 * 数据校验 在需要被校验的对象上 添加@Validated 跟在这个参数后面添加一个BindingResult的对象
	 * 
	 * BindingResult 对象用来保存验证的结果的
	 * @param card
	 * @param br
	 * @return
	 */
	@RequestMapping("/cancel")
	public String cancelCard(@Validated Card card,BindingResult br,HttpSession session) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			Syuser user =(Syuser) session.getAttribute("syuser");
			cardServiceImpl.cancelCard(card, user.getUserId());
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
	}
}
