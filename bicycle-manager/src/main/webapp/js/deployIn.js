//@ sourceURL=js/repair.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#deployIn",
		data: {
			pageInfo:{},
			list: [],	//车辆信息
			deployInData: {}, // 保存调出信息的数据对象
			stationData: {}, // 车点信息
			pileData: {}, // 车点信息
			type: 1, //1不显示 2成功 3失败
			valid: [true],//记录表单数据校验结果 默认都是通过的
			
		},
		
		methods:{
			goPage: function(pageNum){
				var data= {
						pageNum:pageNum
				};
				var params = {
						params:data
				};
				this.$http.get("deploy/selectBicycle",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			

			//点击车辆调出按钮，显示所有车点信息
			deployInDiv: function(index){				
				this.valid = [true];
				//this.deployInData = {};//清空表单数据	
				this.deployInData.bicycle_id=this.list[index].bicycle_id;
				
				this.$http.get("deploy/selectStation").then(
						(resp) => {
							this.stationData = resp.body;
							console.log(resp.body);
						},
						(resp) => {
							
						}
				);
			},
			
			
			//点击选择车桩按钮，显示所有车桩信息
			showPile: function(index){
				$("#optStationDiv").modal('hide');
				this.valid = [true];
				this.deployInData.station_id=this.stationData[index].station_id;
				this.deployInData.station_code=this.stationData[index].station_code;
				
				
	
				var data= {
						data:this.deployInData.station_id
				};
				var params = {
						params:data
				};
				this.$http.get("deploy/selectAppointedPile",params).then(
						(resp) => {
							this.pileData = resp.body;
						},
						(resp) => {
							
						}
				);
			},
			
	 
			//普通调出操作
			commit: function(index){				
			this.deployInData.pile_id=this.pileData[index].pile_id;			
				var data= {
						pile_id:this.deployInData.pile_id,
						bicycle_id:this.deployInData.bicycle_id,
				};
				var params = {
						params:data
				};				
				this.$http.get("deploy/deployIn",params).then(
						(resp) => {
							var r = resp.bodyText;
							if(r == "success"){
								//关闭窗口
								$("#optPileDiv").modal('hide');
								
								this.type = 2;
								this.goPage(this.pageInfo.pageNum);	//刷新页面
							}else if(r == "wrongPileID"){
								this.valid = [false];
								this.type = 3;
							}else{
								//关闭窗口
								$("#optPileDiv").modal('hide');
								
								this.type = 3;
							}
							setTimeout('vm.type = 1',3000);
						},
						(resp) => {
							
						}
				);
				
			}
			
	
			
		
			
		}
	});
	
	vm.goPage(1); // 显示第1页数据