package com.wall675.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Card {
	private Integer card_id;
	private String card_code;
	private Integer card_type;
	private String name;
	
	
	private String idcard;
	

	private String sex;
	
	
	private String telphone;
	
	
	private String mobile;
	private String email;
	private String address;
	private String work;
	private String ZXBJ;
	private double monthly_money;
	private double frozen_money;
	private double wallet_money;
	private Integer status;
	
	//分页相关属性
	private Integer pageNum;
	private Integer size;
	private Integer startIndex;
	
	public Card(Integer card_id, String name) {
		// TODO Auto-generated constructor stub
		System.out.println("有参构造器");
		this.card_id = card_id;
		this.name = name;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public Card() {
		super();
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getCard_id() {
		return card_id;
	}
	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}
	public String getCard_code() {
		return card_code;
	}
	public void setCard_code(String card_code) {
		this.card_code = card_code;
	}
	public Integer getCard_type() {
		return card_type;
	}
	public void setCard_type(Integer card_type) {
		this.card_type = card_type;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getZXBJ() {
		return ZXBJ;
	}
	public void setZXBJ(String ZXBJ) {
		this.ZXBJ = ZXBJ;
	}
	public double getMonthly_money() {
		return monthly_money;
	}
	public void setMonthly_money(double monthly_money) {
		this.monthly_money = monthly_money;
	}
	public double getFrozen_money() {
		return frozen_money;
	}
	public void setFrozen_money(double frozen_money) {
		this.frozen_money = frozen_money;
	}
	public double getWallet_money() {
		return wallet_money;
	}
	public void setWallet_money(double wallet_money) {
		this.wallet_money = wallet_money;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "card [card_id=" + card_id + ", card_code=" + card_code + ", card_type=" + card_type + ", name="
				+ name + ", idcard=" + idcard + ", sex=" + sex + ", telphone=" + telphone + ", mobile=" + mobile
				+ ", email=" + email + ", address=" + address + ", work=" + work + ", ZXBJ=" + ZXBJ
				+ ", monthly_money=" + monthly_money + ", frozen_money=" + frozen_money + ", wallet_money="
				+ wallet_money + ", status=" + status + "]";
	}
}
