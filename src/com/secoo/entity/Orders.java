package com.secoo.entity;

import java.util.Date;
import java.util.List;

public class Orders {
	
    private Integer id;

    private Integer userId;

    private String number;

    private Date createTime;

    private String note;
    
    private User user;
    
    private List<Orderdetail> orderdetailList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderdetail> getOrderdetailList() {
		return orderdetailList;
	}

	public void setOrderdetailList(List<Orderdetail> orderdetailList) {
		this.orderdetailList = orderdetailList;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number + ", createTime=" + createTime
				+ ", note=" + note + ", user=" + user + ", orderdetailList=" + orderdetailList + "]";
	}

}