package com.wall675.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wall675.model.Bicycle_record;
import com.wall675.model.SingleSpendTime;

public interface Bicycle_recordMapper {

	/**
	 *  记录车辆业务流水，业务类型为（4：普通调出），关联的业务记录id填写车辆调配明细id
	 *  业务名称填写(普通调出)，是否发生费用为（0：未发生），费用金额填0
	 * @param Bicycle_record
	 * @return
	 */
	public int insertBicycleRecord(Bicycle_record Bicycle_record);
	
	/**
	 * 总租车小时数 
	 * @param return_time,card_id
	 * @return
	 */
	public int sumRentHour(@Param("date")String date,@Param("card_id")Integer card_id);
	
	/**
	 * 平均租车小时数 
	 * @param return_time,card_id
	 * @return
	 */
	public double avgRentHour(@Param("date")String date,@Param("card_id")Integer card_id);
	
	

	/**
	 * 单次租车时间
	 * @param card_id
	 * @return List<SingleSpendTime>
	 */
	public List<SingleSpendTime> singleSpendTime(@Param("card_id")Integer card_id);
	
}
