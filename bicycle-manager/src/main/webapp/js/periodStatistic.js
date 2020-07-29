//@ sourceURL=js/statistic.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#statistics",
		data: {
			pageInfo:{},
			list: [],	//车点信息
			queryCondition: {}, // 保存查询条件
			card_code:"",	//车卡
			month:{},
			date:"",
			card_id:0,	//名字
			Statistic:{},	//返回统计信息
			singleStatistic:{},	//返回单张卡统计信息
			flag: true, //标记是否可以提交数据 默认可以
			type: 1, //1不显示 2成功 3失败
			valid: [true],//记录表单数据校验结果 默认都是通过的
		},
		
		methods:{
			goPage: function(pageNum){
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
			
			
			//显示所有卡年度内数据
			totalYearData: function(){
				this.Statistic = {};
				var card_id=0;
				var date = this.date;
				var dateOk = /^((19|20)\d{2}-([1-9]|1[0-2]))$|^((19|20)\d{2})$/.test(this.date);
				if(dateOk){
					this.flag = true;
				}else{
					this.flag = false;
				}
				this.valid = [dateOk];
				if(this.flag){// 可以提交
					var data={
							date:date,
							card_id:card_id
					};
					var params = {
							params:data
					};
					this.$http.get("research/totalYear",params).then(
							(resp) => {
								this.Statistic = resp.body;
							},
							(resp) => {
								
							}
					);
				}
				setTimeout('vm.type = 1',3000);
			},
			
			//显示单张卡年度内数据
			showSingleYearData: function(index){
				this.singleStatistic = {};
				var date = this.date;
				var dateOk = /^((19|20)\d{2}-([1-9]|1[0-2]))$|^((19|20)\d{2})$/.test(this.date);
				var card_id = this.list[index].card_id;
				
				if(dateOk){
					this.flag = true;
				}else{
					this.flag = false;
				}
				this.valid = [dateOk];
				if(this.flag){// 可以提交
					var data={
							date:date,
							card_id:card_id
						};
						var params = {
								params:data
						};
						this.$http.get("research/singleYear",params).then(
								(resp) => {
									this.singleStatistic= resp.body;
									
								},
								(resp) => {
									
								}
						);
				}
				setTimeout('vm.type = 1',3000);
			},
			
			
/**
			//显示所有卡月度内数据
			showTotalMonthData: function(index){
				this.$http.get("research/totalMonth").then(
						(resp) => {
							this.Statistic = resp.body;
						},
						(resp) => {
							
						}
				);
			},
			
			
			//显示单张卡年度内数据
			showSingleYearData: function(index){
				this.$http.get("research/singleYear").then(
						(resp) => {
							this.Statistic = resp.body;
						},
						(resp) => {
							
						}
				);
			},
			
			
			//显示单张卡月度内数据
			showSingleMonthData: function(index){
				this.$http.get("research/singleMonth").then(
						(resp) => {
							this.Statistic = resp.body;
						},
						(resp) => {
							
						}
				);
			}
*/
		
			
		}
	});
	
	vm.goPage(1); // 显示第1页数据