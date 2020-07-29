//@ sourceURL=js/repair.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#deploy",
		data: {
			pageInfo:{},
			list: [],	//车点信息
			deployOutData: {}, // 保存调出信息的数据对象
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
				this.$http.get("deploy/selectPile",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
							//console.log(this.pageInfo);
						},
						(resp) => {
							
						}
				);
			},
			

			//点击车辆调出按钮
			deployOutDiv: function(index){
				this.valid = [true];
				this.deployOutData = {};//清空表单数据
				this.deployOutData.pile_id=this.list[index].pile_id;
				this.deployOutData.bicycle_id=this.list[index].bicycle_id;
				
			},
			
	 
			//普通调出操作
			commit: function(){
				this.valid = [true];
				this.$http.post("deploy/deployOut",this.deployOutData,{emulateJSON: true}).then(
						(resp) => {
							var r = resp.bodyText;
							
							if(r == "success"){
								//关闭窗口
								$("#optDiv").modal('hide');
								this.type = 2;
								this.goPage(this.pageInfo.pageNum);	//刷新页面
							}else if(r == "wrongCard"){
								this.valid = [false];
								this.type = 3;
							}else{
								//关闭窗口
								$("#optDiv").modal('hide');
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