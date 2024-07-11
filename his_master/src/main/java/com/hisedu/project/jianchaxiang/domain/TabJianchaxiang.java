package com.hisedu.project.jianchaxiang.domain;
/**
 * 检查项目实体类
 * @author Mr.J
 *
 */
public class TabJianchaxiang {

	private Long id;
	
	private String jcname;
	
	private Double price;
	
	private int orders;
	
	private String jianjie;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJcname() {
		return jcname;
	}

	public void setJcname(String jcname) {
		this.jcname = jcname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
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
	
	
}
