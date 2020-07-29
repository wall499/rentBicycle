package com.wall675.dao;

import org.apache.ibatis.annotations.Param;

public interface Bicycle_deployMapper {
	/**
	 * 记录车辆调配明细，调入的内容可以不填写，调入原因填写（4：普通调出）
	 * @param bicycle_id,pile_id,card_id,from_time
	 * @return int
	 */
	public int insertBicycleDeployOut(@Param("bicycle_id") Integer bicycle_id,@Param("pile_id") Integer pile_id,@Param("card_id") Integer card_id,@Param("from_time") String from_time);
	
	/**
	 * 车辆调入时，调配明细表中填入调入时间，调入车桩，调入原因等
	 * @param deploy_id
	 * @param pile_id
	 * @param to_time
	 * @return
	 */
	public int setBicycleDeployIn(@Param("deploy_id") Integer deploy_id,@Param("pile_id") Integer pile_id,@Param("to_time") String to_time);
	
	
	/**
	 * 根据车辆id和调度时间查询明细id
	 * @param bicycle_id
	 * @param from_time
	 * @return
	 */
	public int selDeployId(@Param("bicycle_id") Integer bicycle_id,@Param("from_time") String from_time);
	
	
	/**
	 * 根据车辆id查询调配明细记录id（准备进行普通调入）
	 * @param bicycle_id
	 *  @param bicycle_id
	 * @return
	 */
	public Integer selDeployedId( Integer bicycle_id);
	
	
	/**
	 * 车辆普通调入时，调配明细表中填入调入时间，调入车桩，调入原因等
	 * @param pile_id
	 * @param to_time
	 * @return
	 */
	public int setDeploy(@Param("deploy_id") Integer deploy_id,@Param("pile_id") Integer pile_id,@Param("to_time") String to_time);

}
