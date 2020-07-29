package com.wall675.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wall675.model.MsPhase;
import com.wall675.service.impl.MsPhaseServiceImpl;

@RestController
@RequestMapping("/main/msphase")
public class MsPhaseController {
	
	private Logger logger = Logger.getLogger(MsPhaseController.class);
	
	@Autowired
	private MsPhaseServiceImpl msPhaseServiceImpl;
	
	@RequestMapping("/select")
	public PageInfo<MsPhase> select(@RequestParam(defaultValue = "1") int pageNum,MsPhase msPhase){
		return msPhaseServiceImpl.select(pageNum, msPhase);
	}
	
	/**
	 * 数据校验 在需要被校验的对象上 添加@Validated 跟在这个参数后面添加一个BindingResult的对象
	 * 
	 * BindingResult 对象用来保存验证的结果的
	 * @param msPhase
	 * @param br
	 * @return
	 */
	@RequestMapping("/insert")
	public String insert(@Validated MsPhase msPhase,BindingResult br) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			
			msPhaseServiceImpl.insert(msPhase);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
		
	}
	
	/**
	 * 数据校验 在需要被校验的对象上 添加@Validated 跟在这个参数后面添加一个BindingResult的对象
	 * 
	 * BindingResult 对象用来保存验证的结果的
	 * @param msPhase
	 * @param br
	 * @return
	 */
	@RequestMapping("/update")
	public String update(@Validated MsPhase msPhase,BindingResult br) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			
			msPhaseServiceImpl.update(msPhase);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
		
	}
	
	/**
	 * 数据校验 在需要被校验的对象上 添加@Validated 跟在这个参数后面添加一个BindingResult的对象
	 * 
	 * BindingResult 对象用来保存验证的结果的
	 * @param msPhase
	 * @param br
	 * @return
	 */
	@RequestMapping("/del")
	public String del(@Validated MsPhase msPhase,BindingResult br) {
		
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			msPhaseServiceImpl.delete(msPhase.getPhaseId());
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
		
	}

}
