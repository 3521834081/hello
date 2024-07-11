package com.hisedu.project.jiaofei.mapper;

import java.util.List;

import com.hisedu.project.jiaofei.domain.TabJiaofei;

public interface TabJiaofeiMapper {

	public List<TabJiaofei> selectTabJiaofeiList(TabJiaofei tabJiaofei);
	
	public int insertTabJiaofei(TabJiaofei tabJiaofei);
	
	public int updateTabJiaofei(TabJiaofei tabJiaofei);
	
	public int deleteTabJiaofeiById(Long id);
}
