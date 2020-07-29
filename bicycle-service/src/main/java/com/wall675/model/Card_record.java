package com.wall675.model;

public class Card_record {
		private Integer record_id;
		private Integer card_id;
		private Integer fee_type;
		private Double chg_monthly_money;
		private Double chg_wallet_money;
		private Double chg_frozen_money;
		private String create_time;
		private Integer user_id;
		private String remark;
		private Integer ZXBJ;
		public Integer getRecord_id() {
			return record_id;
		}
		public void setRecord_id(Integer record_id) {
			this.record_id = record_id;
		}
		public Integer getCard_id() {
			return card_id;
		}
		public void setCard_id(Integer card_id) {
			this.card_id = card_id;
		}
		public Integer getFee_type() {
			return fee_type;
		}
		public void setFee_type(Integer fee_type) {
			this.fee_type = fee_type;
		}
		public Double getChg_monthly_money() {
			return chg_monthly_money;
		}
		public void setChg_monthly_money(Double chg_monthly_money) {
			this.chg_monthly_money = chg_monthly_money;
		}
		public Double getChg_wallet_money() {
			return chg_wallet_money;
		}
		public void setChg_wallet_money(Double chg_wallet_money) {
			this.chg_wallet_money = chg_wallet_money;
		}
		public Double getChg_frozen_money() {
			return chg_frozen_money;
		}
		public void setChg_frozen_money(Double chg_frozen_money) {
			this.chg_frozen_money = chg_frozen_money;
		}
		public String getCreate_time() {
			return create_time;
		}
		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public Integer getZXBJ() {
			return ZXBJ;
		}
		public void setZXBJ(Integer zXBJ) {
			ZXBJ = zXBJ;
		}
		@Override
		public String toString() {
			return "Card_record [record_id=" + record_id + ", card_id=" + card_id + ", fee_type=" + fee_type
					+ ", chg_monthly_money=" + chg_monthly_money + ", chg_wallet_money=" + chg_wallet_money
					+ ", chg_frozen_money=" + chg_frozen_money + ", create_time=" + create_time + ", user_id=" + user_id
					+ ", remark=" + remark + ", ZXBJ=" + ZXBJ + "]";
		}
		
}
