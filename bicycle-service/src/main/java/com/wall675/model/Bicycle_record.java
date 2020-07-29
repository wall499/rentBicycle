package com.wall675.model;

public class Bicycle_record {
	private Integer record_id;
	private Integer bicycle_id;
	private Integer card_id;
	private String rent_time;
	private Integer rent_pile_id;
	private String return_pile_id;
	private Double money;
	private String remark;
	
	
	public Integer getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Integer record_id) {
		this.record_id = record_id;
	}
	public Integer getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Integer bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public Integer getCard_id() {
		return card_id;
	}
	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}
	public String getRent_time() {
		return rent_time;
	}
	public void setRent_time(String rent_time) {
		this.rent_time = rent_time;
	}
	public Integer getRent_pile_id() {
		return rent_pile_id;
	}
	public void setRent_pile_id(Integer rent_pile_id) {
		this.rent_pile_id = rent_pile_id;
	}
	public String getReturn_pile_id() {
		return return_pile_id;
	}
	public void setReturn_pile_id(String return_pile_id) {
		this.return_pile_id = return_pile_id;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "bicycle_record [record_id=" + record_id + ", bicycle_id=" + bicycle_id + ", card_id=" + card_id
				+ ", rent_time=" + rent_time + ", rent_pile_id=" + rent_pile_id + ", return_pile_id="
				+ return_pile_id + ", money=" + money + ", remark=" + remark + "]";
	}
}
