package com.wall675.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wall675.exception.ServiceException;
import com.wall675.service.DeployInService;

@RestController
public class DeployInController {
	private Logger logger = Logger.getLogger(DeployInController.class);
	
	@Autowired
	private DeployInService deployInServiceImpl;
	


	/**
	 * 普通调入操作
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/deployIn",produces = "text/plain;charset=utf-8")
	public String repairIn(@RequestParam Map<String, String> map) {
		Integer bicycle_id = Integer.valueOf(map.get("bicycle_id"));
		Integer pile_id = Integer.valueOf(map.get("pile_id"));
		try {
		   deployInServiceImpl.deployIn(pile_id, bicycle_id);
			return "success";
		} catch (ServiceException e) {
			return e.getMessage();
		}catch (Exception e) {
			logger.error("服务端异常", e);
			return "服务端异常";
		}
	}
	
}
