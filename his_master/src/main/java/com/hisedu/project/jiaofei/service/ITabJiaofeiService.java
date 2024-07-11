package com.hisedu.project.jiaofei.service;

import java.util.List;

import com.hisedu.project.jiaofei.domain.TabJiaofei;

public interface ITabJiaofeiService {

	public List<TabJiaofei> selectTabJiaofeiList(TabJiaofei tabJiaofei);
	
	public int insertTabJiaofei(TabJiaofei tabJiaofei);
	
	public int deleteTabJiaofeiById(Long id);
	
	public int updateTabJiaofei(TabJiaofei tabJiaofei);
	
}
