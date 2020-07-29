package com.wall675.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wall675.model.Bicycle_deal;

public interface Bicycle_dealMapper {
	
	/**
	 * 车辆的费用流水
	 * @param Bicycle_deal
	 * @return
	 */
	public List<Bicycle_deal> listSpendDetail(Bicycle_deal Bicycle_deal);
	
	/**
	 * 新增普通调出的业务流水
	 * @param creat_time
	 * @param record_id
	 * @param card_id
	 * @param pile_id
	 * @param bicycle_id
	 * @return
	 */
	public int addDeal(@Param("create_time")String create_time,@Param("record_id") int record_id,@Param("card_id") Integer card_id,@Param("pile_id") Integer pile_id,@Param("bicycle_id") Integer bicycle_id);

	/**
	 * 新增车辆普通调入的业务流水
	 * @param record_id
	 * @param bicycle_id
	 * @param pile_id
	 * @return
	 */
	public int addDeployIn(@Param("record_id") Integer record_id,@Param("bicycle_id") Integer bicycle_id,@Param("pile_id") Integer pile_id,@Param("create_time") String create_time);
	
	
}
