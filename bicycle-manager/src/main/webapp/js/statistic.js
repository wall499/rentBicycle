//@ sourceURL=js/statistic.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#statistics",
		data: {
			pageInfo:{},
			list: [],	//车卡信息
			queryCondition: {}, // 保存查询条件
			pageRecordInfo:{},
			listRecord: [],	//车卡费用流水信息
			queryRecordCondition: {}, // 保存查询条件
			card_code:"",	//车卡
			name:"",	//名字
			totalStatistic:{},	//返回总统计信息
			singleStatistic:{},	//返回单张卡统计信息
			record:{},
			
		},
		
		methods:{
			goPage: function(pageNum){
				this.pageInfo = {};
				this.list = [];
				this.queryCondition={},
				// 查询条件中携带要查询的页码
				this.queryCondition.pageNum = pageNum;
				var params = {
						params:this.queryCondition
				};
				this.$http.get("card/list",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},

			//显示该卡的费用流水
			showRecordData: function(index){	
				this.record = {};
				this.queryRecordCondition.card_id=this.list[index].card_id;
				// 查询条件中携带要查询的页码
				//this.queryCondition.pageNum = 1;
				var params = {
						params:this.queryRecordCondition
				};
				this.$http.get("statistic/list",params).then(
						(resp) => {
							this.record = resp.body;
						},
						(resp) => {
							
						}
				);
			},
			
			//显示单张卡统计数据页面的方法
			showSingleData: function(index){
				this.singleStatistic = {};
				this.card_code = this.list[index].card_code;
				this.name = this.list[index].name;
				var card_id = this.list[index].card_id;
				var data={
						card_id:card_id
				};
				var params = {
						params:data
				};
				this.$http.get("statistic/single",params).then(
						(resp) => {
							this.singleStatistic = resp.body;
							console.log(resp.body);
						},
						(resp) => {
							
						}
				);
			},
			

			//显示统计数据页面的方法
			showTotalData: function(index){
				this.totalStatistic = {};
				this.$http.get("statistic/total").then(
						(resp) => {
							this.totalStatistic = resp.body;
						},
						(resp) => {
							
						}
				);
			}

			
		}
	});
	
	vm.goPage(1); // 显示第1页数据