package com.hisedu.project.doctor.service;

import java.util.List;

import com.hisedu.project.doctor.domain.TabDoctor;

public interface ITabDoctorService {
	

	/**
	 * 查询医生列表
	 */
	public List<TabDoctor> selectTabDoctorList(TabDoctor tabDoctor); 
	
	
	/**
	 * 新增医生
	 */
	
	public int insertTabDoctor(TabDoctor tabDoctor);
	
	
	/**
	 * 查询医生信息
	 */
	public TabDoctor selectTabDoctorById(Long id); 
	
	
	/**
	 * 修改医生
	 */
	
	public int updateTabDoctor(TabDoctor tabDoctor);
	
	
	
	/**
	 * 删除医生
	 */

	public int deleteTabDoctorById(Long id);
	
}
