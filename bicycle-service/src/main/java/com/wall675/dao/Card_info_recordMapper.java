package com.wall675.dao;

import org.apache.ibatis.annotations.Param;

public interface Card_info_recordMapper {
	/**
	 * 存入到卡信息记录表
	 * @param card_id,info_type,create_time,user_id
	 * @return
	 */
	public int insertCardInfoRecord(@Param("card_id")Integer card_id, @Param("info_type")double info_type, @Param("create_time") String create_time, @Param("user_id") Integer user_id, @Param("remark") String remakr);
}
