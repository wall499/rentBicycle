package com.wall675.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wall675.exception.ServiceException;
import com.wall675.service.DeployOutService;

@RestController
public class DeployOutController {
	
	private Logger logger = Logger.getLogger(DeployOutController.class);
	
	@Autowired
	private DeployOutService deployOutServiceImpl;
	
	       //普通调出
			@RequestMapping(value="/deployOut",produces = "text/plain;charset=utf-8")
			public String deployOut(@RequestParam Map<String, String> map) {
				String card_code = map.get("card_code");
				String pi = map.get("pile_id");
				String bi = map.get("bicycle_id");
				Integer pile_id = Integer.valueOf(pi);
				Integer bicycle_id = Integer.valueOf(bi);
				try {
					deployOutServiceImpl.deployOut(card_code, pile_id, bicycle_id);
					return "操作成功";
				} catch (ServiceException e) {
					return e.getMessage();
				}catch (Exception e) {
					logger.error("服务端异常", e);
					return "服务端 异常";
				}
			}
	
}
