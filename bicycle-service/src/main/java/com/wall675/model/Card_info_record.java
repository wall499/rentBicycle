package com.wall675.model;

public class Card_info_record {
		private Integer record_id;
		private Integer card_id;
		private Double info_type;
		private String createtime;
		private Integer user_id;
		private String remark;
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
		public Double getInfo_type() {
			return info_type;
		}
		public void setInfo_type(Double info_type) {
			this.info_type = info_type;
		}
		public String getCreatetime() {
			return createtime;
		}
		public void setCreatetime(String createtime) {
			this.createtime = createtime;
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
		@Override
		public String toString() {
			return "Card_info_record [record_id=" + record_id + ", card_id=" + card_id + ", info_type=" + info_type
					+ ", createtime=" + createtime + ", user_id=" + user_id + ", remark=" + remark + "]";
		}
		
}
