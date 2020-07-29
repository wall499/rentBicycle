//@ sourceURL=js/repair.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#bicycleFix",
		data: {
			pageInfo:{},
			list: [],	//车点信息
			pile: [],	//车桩_车辆信息
			queryCondition: {}, // 保存查询条件
			bicycles: [],	//存放维修成功的车辆信息
			checkbi: "",	//选中调入的车辆索引
			pile_id: "",	//选择维修调入的车桩id
			fixDiv: ""		//维修调入弹出层id
		},
		
		methods:{
			goPage: function(pageNum){
				// 查询条件中携带要查询的页码
				this.queryCondition.pageNum = pageNum;
				var params = {
						params:this.queryCondition
				}
				this.$http.get("showStation",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			
			//显示车桩的方法
			showPile: function(index){
				var station_id = this.list[index].station_id;
				var data = {
						station_id:station_id
					};
				var params = {
					params : data
				};
				this.$http.get("showPile",params).then(
						(resp) => {
							this.pile = resp.body;
							for(var i=0;i<this.pile.length;i++){
								if(this.pile[i].status == 1){
									this.pile[i].status="有车";
									this.pile[i].op="维修调出";
								}else{
									this.pile[i].status="无车";
									this.pile[i].op="维修调入";
								}
							}
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			
			//维修调出与调入
			inorOut: function(index){
				//维修调出
				if(this.pile[index].status=="有车"){
					this.fixDiv="#optDiv";
					 var card_code = prompt("请输入卡号", ""); 
					 if(card_code){
						 var data={
								 card_code:card_code,
								 pile_id:this.pile[index].pile_id,
								 bicycle_id:this.pile[index].bicycle_id
						 }
						 var params={
								 params:data
						 }
						this.$http.get("fixOut",params).then(
								(resp) => {
									alert(resp.bodyText);
									//location.reload();
								},
								(resp) => {
									
								}
						
						) 
					 }
				}else{	//维修调入
					this.fixDiv="#fixInDiv";
					this.pile_id=this.pile[index].pile_id;
					this.$http.get("success").then(
							(resp) => {
								console.log(resp);
								this.bicycles = resp.body;
							},
							(resp) => {
								console.error("请求失败，"+resp);
							}
					);
				}
			},
			
			//维修调入操作
			fixIn: function(){
				var Bindex=this.checkbi;
				var bicycle_id="";
				var pile_id = this.pile_id;
				if(Bindex.length==0){
					alert("请选择要进行维修调入的车辆！");
				}else{
					bicycle_id = this.bicycles[Bindex].bicycle_id;
					
					var data={
							bicycle_id:bicycle_id,
							pile_id:pile_id
					};
					var params={
							params:data
					};
					this.$http.get("repairIn",params).then(
							(resp) => {
								var r = resp.bodyText;
								$("#fixInDiv").modal('hide');
								$("#optDiv").modal('hide');
								if(r == "success"){
									alert("调入成功！")
									this.goPage(this.pageInfo.pageNum);	//刷新页面
								}else{
									alert(r);
									this.goPage(this.pageInfo.pageNum);
								}
							},
							(resp) => {
								console.error("请求失败，"+resp);
							}
						);
				}
			}
			
		}
	});
	
	vm.goPage(1); // 显示第1页数据