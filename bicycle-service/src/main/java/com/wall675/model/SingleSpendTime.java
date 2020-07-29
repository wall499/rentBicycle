package com.wall675.model;

public class SingleSpendTime {
	private String rent_time;
	private String return_time;
	private long spendTime;
	public SingleSpendTime(String rent_time, String return_time, long spendTime) {
		super();
		this.rent_time = rent_time;
		this.return_time = return_time;
		this.spendTime = spendTime;
	}
	public String getRent_time() {
		return rent_time;
	}
	public void setRent_time(String rent_time) {
		this.rent_time = rent_time;
	}
	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
	public long getSpendTime() {
		return spendTime;
	}
	public void setSpendTime(long spendTime) {
		this.spendTime = spendTime;
	}
	@Override
	public String toString() {
		return "SingleSpendTime [rent_time=" + rent_time + ", return_time=" + return_time + ", spendTime=" + spendTime
				+ "]";
	}
	
}
