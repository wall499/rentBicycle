//@ sourceURL=js/statistic.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#charge",
		data: {
			pageInfo:{},
			list: [],	//车点信息
			queryCondition: {}, // 保存查询条件
			judge:"wallet",	//充值钱包或者月卡，默认钱包
			chgMoney:0.0,
			card_code:"",
			flag: true, //标记是否可以提交数据 默认可以
			type: 1, //1不显示 2成功 3失败
			valid: [true,true],//记录表单数据校验结果 默认都是通过的
			chargeData:{}	//充值信息
		},
		
		methods:{
			search: function(pageNum){
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
			
			//点击显示钱包充值界面
			showChargeData: function(index){				
				this.chargeData = {};//清空表单数据
				this.judge = 'wallet';
					this.chargeData.card_code=this.list[index].card_code;
					this.chargeData.card_type=this.list[index].card_type;
					this.valid = [true,true];
					this.flag = true;
			},
			
			//点击显示月票充值界面
			showMonthChargeData: function(index){
				this.chargeData = {};//清空表单数据
				this.judge = 'month';
					this.chargeData.card_code=this.list[index].card_code;
					this.chargeData.card_type=this.list[index].card_type;
					this.valid = [true,true];
					this.flag = true;
			},
			
			//充值
			charge: function(index){
				var chg_money =this.chargeData.chg_money;
				var card_code = this.chargeData.card_code;
				
				if("wallet"==this.judge){
					if(chg_money%50==0&&chg_money<=500){
						var chg_wallet_moneyOk = true;
						var chg_monthly_moneyOk= true;
					}else{
						var chg_wallet_moneyOk = false;
						var chg_monthly_moneyOk= true;
					}	
				}else  {
					//判断是否当月首次充值月卡
					var chg_wallet_moneyOk = true;
					var chg_monthly_moneyOk = /^([1-9][0-9]*)?[05]$/.test(this.chargeData.chg_money);	
				}
		
				if(chg_wallet_moneyOk && chg_monthly_moneyOk){
					this.flag = true;
				}else{
					this.flag = false;
				}
				this.valid = [chg_wallet_moneyOk,chg_monthly_moneyOk];
				
			
				var data={
						card_code:card_code,
						judge:this.judge,
						chg_money:chg_money
				};
				
				var params={
						params:data
				};
				
				
				if(this.flag){// 可以提交
					this.$http.get("charge/card",params).then(
							(resp) => {
								var r = resp.bodyText
								console.log("返回"+resp.bodyText);
								
								if(r == "success"){	
									//关闭窗口
									$("#optDiv").modal('hide');
									this.type = 2;
									//月票当月首次充值金额低于50元
									this.search(this.pageInfo.pageNum);
									this.params = {};
									this.data = {};
									this.chargeData= {};
								}else if(r == "monthError"){
									this.valid = [chg_wallet_moneyOk,false];
									this.type = 3;
								}else{
									//关闭窗口
									$("#optDiv").modal('hide');
									this.type = 3;
									this.params = {};
									this.data = {};
									this.chargeData= {};
								}
								setTimeout('vm.type = 1',3000);
								
							},
							(resp) => {
								
							}
					);
				}
				
			},
			
		
			

		}
	});
	
//vm.search(1); // 显示第1页数据