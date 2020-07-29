package com.wall675.model;

import java.util.List;

public class StatisticData {
  //实时卡费用统计——所有卡部分
	private Integer countCard;
	private Integer countCardRecord;
	private Double sumChgMoney;
	private Double sumSpendMoney;
	private Double sumFrozenMoney;
	private Double sumMoney;
	private Integer sumRentHour;
	private Integer sumRentTimes;
	private Double avgRentTimes;
	
	private List<SingleSpendTime> singleSpendTimes;
	
	//月度/年度卡费用统计
	private Double avgRentHour;

	public Double getAvgRentHour() {
		return avgRentHour;
	}
	public void setAvgRentHour(Double avgRentHour) {
		this.avgRentHour = avgRentHour;
	}
	public List<SingleSpendTime> getSingleSpendTimes() {
		return singleSpendTimes;
	}
	public void setSingleSpendTimes(List<SingleSpendTime> singleSpendTimes) {
		this.singleSpendTimes = singleSpendTimes;
	}
	public Integer getCountCard() {
		return countCard;
	}
	public void setCountCard(Integer countCard) {
		this.countCard = countCard;
	}
	public Integer getCountCardRecord() {
		return countCardRecord;
	}
	public void setCountCardRecord(Integer countCardRecord) {
		this.countCardRecord = countCardRecord;
	}
	public Double getSumChgMoney() {
		return sumChgMoney;
	}
	public void setSumChgMoney(Double sumChgMoney) {
		this.sumChgMoney = sumChgMoney;
	}
	public Double getSumSpendMoney() {
		return sumSpendMoney;
	}
	public void setSumSpendMoney(Double sumSpendMoney) {
		this.sumSpendMoney = sumSpendMoney;
	}
	public Double getSumFrozenMoney() {
		return sumFrozenMoney;
	}
	public void setSumFrozenMoney(Double sumFrozenMoney) {
		this.sumFrozenMoney = sumFrozenMoney;
	}
	public Double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(Double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public Integer getSumRentHour() {
		return sumRentHour;
	}
	public void setSumRentHour(Integer sumRentHour) {
		this.sumRentHour = sumRentHour;
	}
	public Integer getSumRentTimes() {
		return sumRentTimes;
	}
	public void setSumRentTimes(Integer sumRentTimes) {
		this.sumRentTimes = sumRentTimes;
	}
	public Double getAvgRentTimes() {
		return avgRentTimes;
	}
	public void setAvgRentTimes(Double avgRentTimes) {
		this.avgRentTimes = avgRentTimes;
	}
	
	
	public StatisticData(Integer countCard, Integer countCardRecord, Double sumChgMoney, Double sumSpendMoney,
			Double sumFrozenMoney, Double sumMoney, Integer sumRentHour, Integer sumRentTimes, Double avgRentTimes,
			List<SingleSpendTime> singleSpendTimes) {
		super();
		this.countCard = countCard;
		this.countCardRecord = countCardRecord;
		this.sumChgMoney = sumChgMoney;
		this.sumSpendMoney = sumSpendMoney;
		this.sumFrozenMoney = sumFrozenMoney;
		this.sumMoney = sumMoney;
		this.sumRentHour = sumRentHour;
		this.sumRentTimes = sumRentTimes;
		this.avgRentTimes = avgRentTimes;
		this.singleSpendTimes = singleSpendTimes;
	}
	
	public StatisticData(Double sumChgMoney, Double sumSpendMoney, Integer sumRentHour, Integer sumRentTimes,
			Double avgRentTimes, Double avgRentHour) {
		super();
		this.sumChgMoney = sumChgMoney;
		this.sumSpendMoney = sumSpendMoney;
		this.sumRentHour = sumRentHour;
		this.sumRentTimes = sumRentTimes;
		this.avgRentTimes = avgRentTimes;
		this.avgRentHour = avgRentHour;
	}
	@Override
	public String toString() {
		return "StatisticData [countCard=" + countCard + ", countCardRecord=" + countCardRecord + ", sumChgMoney="
				+ sumChgMoney + ", sumSpendMoney=" + sumSpendMoney + ", sumFrozenMoney=" + sumFrozenMoney
				+ ", sumMoney=" + sumMoney + ", sumRentHour=" + sumRentHour + ", sumRentTimes=" + sumRentTimes
				+ ", avgRentTimes=" + avgRentTimes + ", singleSpendTimes=" + singleSpendTimes + "]";
	}
	
	
	
	
	
	
}
