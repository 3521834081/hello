package com.hisedu.project.jiaofei.domain;

import java.util.Date;

/**
 * 交费实体类
 * @author Mr.J
 *
 */
public class TabJiaofei {

	/** id */
    private Long id;

    /** 挂号id */
    private Long registerid;

    /** 姓名 */
    private String name;

    /** 身份证号 */
    private String idcard;

    /** 检查项目id */
    private String jcxmids;

    /** 检查项目名称 */
    private String jcxmname;

    /** 检查项目数量 */
    private int jcxmnum;

    /** 总价格 */
    private Double price;

    /** 添加时间 */
    private Date addtime;

    /** 状态 */
    private String status;
    
    private Long[] jcxmIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegisterid() {
		return registerid;
	}

	public void setRegisterid(Long registerid) {
		this.registerid = registerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getJcxmids() {
		return jcxmids;
	}

	public void setJcxmids(String jcxmids) {
		this.jcxmids = jcxmids;
	}

	public String getJcxmname() {
		return jcxmname;
	}

	public void setJcxmname(String jcxmname) {
		this.jcxmname = jcxmname;
	}

	public int getJcxmnum() {
		return jcxmnum;
	}

	public void setJcxmnum(int jcxmnum) {
		this.jcxmnum = jcxmnum;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long[] getJcxmIds() {
		return jcxmIds;
	}

	public void setJcxmIds(Long[] jcxmIds) {
		this.jcxmIds = jcxmIds;
	}
    
    
}
