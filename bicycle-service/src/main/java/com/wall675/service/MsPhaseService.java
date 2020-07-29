package com.wall675.service;

import com.github.pagehelper.PageInfo;
import com.wall675.model.MsPhase;

public interface MsPhaseService {
	public PageInfo<MsPhase> select(int pageNum,MsPhase msPhase);
	/**
	 * 新增权限
	 * @param msPhone
	 * @return
	 */
	public int insert(MsPhase msPhase);
	/**
	 * 修改权限
	 * @param msPhase
	 * @return
	 */
	public int update(MsPhase msPhase);

	/**
	 * 删除权限
	 * @param phaseId
	 * @return
	 */
	public int delete(int phaseId) ;
	/**
	 * 根据id查询权限
	 * @param phaseId
	 * @return
	 */
	public MsPhase selectById(int phaseId);
}
