package com.wall675.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wall675.constants.PageConfig;
import com.wall675.dao.MsPhaseMapper;
import com.wall675.model.MsPhase;

@Service
public class MsPhaseServiceImpl {
	
	@Autowired
	private MsPhaseMapper msPhaseMapper;
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param msPhase
	 * @return
	 */
	public PageInfo<MsPhase> select(int pageNum,MsPhase msPhase){
		PageHelper.startPage(pageNum, PageConfig.PAGE_SIZE);
		List<MsPhase> phases = msPhaseMapper.select(msPhase);
		
		return new PageInfo<MsPhase>(phases);
	}
	
	/**
	 * 新增权限
	 * @param msPhone
	 * @return
	 */
	public int insert(MsPhase msPhase) {
		return msPhaseMapper.insert(msPhase);
	}
	/**
	 * 修改权限
	 * @param msPhase
	 * @return
	 */
	public int update(MsPhase msPhase) {
		return msPhaseMapper.update(msPhase);
	}

	/**
	 * 删除权限
	 * @param phaseId
	 * @return
	 */
	public int delete(int phaseId) {
		return msPhaseMapper.delete(phaseId);
	}
	/**
	 * 根据id查询权限
	 * @param phaseId
	 * @return
	 */
	public MsPhase selectById(int phaseId) {
		return msPhaseMapper.selectById(phaseId);
	}
}
