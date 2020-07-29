package com.wall675.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wall675.model.Bicycle_info;
import com.wall675.model.Bicycle_pile;
import com.wall675.model.Bicycle_station;
import com.wall675.service.impl.BicycleServiceImpl;
import com.wall675.service.impl.DeployInServiceImpl;
import com.wall675.service.impl.DeployOutServiceImpl;

@RestController
@RequestMapping("/main/deploy")
public class DeployController {
private Logger logger = Logger.getLogger(DeployController.class);
	
	@Autowired
	private DeployInServiceImpl deployInServiceImpl;
	
	@Autowired
	private DeployOutServiceImpl deployOutServiceImpl;
	
	@Autowired
	private BicycleServiceImpl bicycleServiceImpl;
	
	
	/**
	 * 查询所有状态为普通调出的车辆返回到界面
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/selectBicycle")
	public PageInfo<Bicycle_info> selectBicycle(@RequestParam(defaultValue = "1") int pageNum){
		return bicycleServiceImpl.select(pageNum);
				
	}
	

	/**
	 * 查询所有上面有车的车桩
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/selectPile")
	public PageInfo<Bicycle_pile> select(@RequestParam(defaultValue = "1") int pageNum){
		return bicycleServiceImpl.selectPile(pageNum);
				
	}
	
	/**
	 * 查询所有车点信息
	 * @param 
	 * @return
	 */
	@RequestMapping("/selectStation")
	public List<Bicycle_station> selectStation(){
		return deployInServiceImpl.selStationInfo();			
	}
	
	/**
	 * 查询指定车点所有车桩的信息
	 * @param station_id
	 * @return
	 */
	@RequestMapping("/selectAppointedPile")
	public List<Bicycle_pile> selPile(Integer station_id){
		return deployInServiceImpl.selPile(station_id);			
	}
	
	
	
	/**
	 * 调出
	 * @param card_code
	 * @param bicycle_info
	 * @param br
	 * @return
	 */
	@RequestMapping(value = "/deployOut",produces = "text/plain;charset=utf-8")
	public String deployOut(String card_code,Bicycle_info bicycle_info,BindingResult br) {
		if(br.hasErrors()) {
			return "fail";
		}
		try {
			deployOutServiceImpl.deployOut(card_code,bicycle_info.getPile_id(),bicycle_info.getBicycle_id());
		} catch (Exception e) {
			e.printStackTrace();
			String msg=e.getMessage();
			if(msg=="请使用员工卡！") {
				return "wrongCard";
			}
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
	}
	
	/**
	 * 调入
	 * @param pile_id
	 * @param br
	 * @return
	 */
	@RequestMapping(value = "/deployIn",produces = "text/plain;charset=utf-8")
	public String deployIn(Integer pile_id,Integer bicycle_id) {
		System.out.println("2222222222222");
		
		try {
			deployInServiceImpl.deployIn(pile_id,bicycle_id);
		} catch (Exception e) {
			e.printStackTrace();
			String msg=e.getMessage();
			if(msg=="调入车桩失败！") {
				return "wrongPileID";
			}
			logger.error("服务端异常", e);
			return "error";
		}
		return "success";
	}
}
