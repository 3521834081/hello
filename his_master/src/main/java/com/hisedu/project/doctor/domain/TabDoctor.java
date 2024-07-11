package com.hisedu.project.doctor.domain;

/**
 * 医生管理实体类
 * @author Mr.J
 *
 */
public class TabDoctor {

	//id主键
	private Long id;
	//医生编号
	private String idcode;
	//医生姓名
	private String name;
	//排序
	private String orders;
	//医生简介
	private String jianjie;
	//状态
	private String status;
	//科室id
	private Long ksid;
	//科室名称
	private String ksname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdcode() {
		return idcode;
	}
	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrders() {
		return orders;
	}
	public void setOrders(String orders) {
		this.orders = orders;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getKsid() {
		return ksid;
	}
	public void setKsid(Long ksid) {
		this.ksid = ksid;
	}
	public String getKsname() {
		return ksname;
	}
	public void setKsname(String ksname) {
		this.ksname = ksname;
	}
	
	
}
