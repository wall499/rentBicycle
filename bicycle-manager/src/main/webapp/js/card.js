//@ sourceURL=js/bicycle.js
// 上面的代码 后面路径写js文件的路径 保证浏览器在调试时 可以加载到该js页面
var vm = new Vue({
		el: "#card",
		data: {
			pageInfo:{},
			list: [],	//车卡信息
			isUpdate: false, // 标记是否是修改操作
			cardData: {}, // 保存新增和修改的数据对象
			queryCondition: {}, // 保存查询条件
			type: 1, //1不显示 2成功 3失败
			valid: [true,true,true,true,true,true,true,true,true,true],//记录表单数据校验结果 默认都是通过的
			flag: true, //标记是否可以提交数据 默认可以
			
		},
		
		methods:{
			
			goPage: function(pageNum){
				// 查询条件中携带要查询的页码
				this.queryCondition.pageNum = pageNum;
				var params = {
						params:this.queryCondition
				}
				this.$http.get("card/list",params).then(
						(resp) => {
							this.pageInfo = resp.body;
							this.list = resp.body.list;
//							console.log(this.pageInfo);
//							console.log(this.list);
						},
						(resp) => {
							
						}
				);
			},
			
			// 点击新增车卡
			addDiv: function(){
				this.isUpdate = false;
				this.cardData = {};//清空表单数据
				this.valid = [true,true,true,true,true,true,true,true,true,true];
				this.flag = true;
			},
			
			// 点击挂失按钮
			reportLoss: function(index){	
				this.cardData=this.list[index];
				this.cardData.ZXBJ=this.list[index].zxbj;
			
					url = "../main/card/reportLoss";
					this.$http.post(url,this.cardData,{emulateJSON: true}).then(
							(resp) => {
								var r = resp.bodyText;
								if(r == "success"){
									//刷新当前页
									if(this.isUpdate){
										this.goPage(this.pageInfo.pageNum);
									}
									this.type = 2;
								}else{
									this.type = 3;
								}
								setTimeout('vm.type = 1',3000);
								this.cardData = {};
							},
							(resp) => {
								
							}
					);	
					this.goPage(1);	
			},
			
			// 点击注销按钮
			cancel: function(index){
				this.cardData=this.list[index];
				this.cardData.ZXBJ=this.list[index].zxbj;
					url = "../main/card/cancel";
					this.$http.post(url,this.cardData,{emulateJSON: true}).then(
							(resp) => {
								var r = resp.bodyText;
								if(r == "success"){
									//刷新当前 页
									if(this.isUpdate){
										this.goPage(this.pageInfo.pageNum);
									}
									this.type = 2;
								}else{
									this.type = 3;
								}
								setTimeout('vm.type = 1',3000);
								this.cardData = {};
							},
							(resp) => {
								
							}
					);	
					this.goPage(1);	
			},
			
			//点击修改按钮
			updateDiv: function(index){

					this.isUpdate = true;
					this.cardData.card_id=this.list[index].card_id;
					
					this.cardData.card_code=this.list[index].card_code;
					this.cardData.card_type=this.list[index].card_type;
					this.cardData.name=this.list[index].name;
					
					this.cardData.idcard=this.list[index].idcard;
					this.cardData.sex=this.list[index].sex;
					this.cardData.telphone=this.list[index].telphone;
					
					this.cardData.mobile=this.list[index].mobile;
					this.cardData.email=this.list[index].email;
					this.cardData.address=this.list[index].address;
					
					this.cardData.work=this.list[index].work;
					this.cardData.ZXBJ=this.list[index].zxbj;
					this.cardData.monthly_money=this.list[index].monthly_money;
					
					this.cardData.frozen_money=this.list[index].frozen_money;
					this.cardData.wallet_money=this.list[index].wallet_money;
					this.cardData.status=this.list[index].status;
					this.valid = [true,true,true,true,true,true,true,true,true,true];
					this.flag = true;
			
				
			},
			
			// 点击保存按钮操作
			save: function(){
				// 数据校验 
				//卡号有7位数的数字组成，每张卡卡号不能重复。
				if(3==this.cardData.card_type){
					var card_codeOk=this.cardData.card_code==this.cardData.idcard?true:false;		
				}else{
					var card_codeOk = /^[1-9][0-9]{6}$/.test(this.cardData.card_code);
				}
				var card_typeOk =/^[1-5]$/.test(this.cardData.card_type);
				var nameOk =/^[\u4e00-\u9fa5]{1,50}$/.test(this.cardData.name);
			
				var idcardOk=/^(\d{15}|(\d{17}[\dXx]))$/.test(this.cardData.idcard);
				var sexOk =/[/^男$|^女&/]/.test(this.cardData.sex);
				var telphoneOk=/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/.test(this.cardData.telphone);
				var mobileOk=/^(1[34578]\d{9})$/.test(this.cardData.mobile);
				var emailOk = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/.test(this.cardData.email);
				var addressOk =/^[\u4e00-\u9fa5]{1,100}$/.test(this.cardData.address);
				var workOk =/^[\u4e00-\u9fa5]{1,100}$/.test(this.cardData.work);
				

				if(card_codeOk && card_typeOk && nameOk && idcardOk && sexOk && telphoneOk && mobileOk && emailOk && addressOk && workOk){
					this.flag = true;
				}else{
					this.flag = false;
				}
				this.valid = [card_codeOk,card_typeOk,nameOk,idcardOk,sexOk,telphoneOk,mobileOk,emailOk,addressOk,workOk];
				
				if(this.flag){// 可以提交
					if(this.isUpdate){
						url = "../main/card/update";
					}else{
						url = "../main/card/insert";
					}				
					this.$http.post(url,this.cardData,{emulateJSON: true}).then(
							(resp) => {
								var r = resp.bodyText;
								if(r == "success"){	
									//关闭窗口
									$("#optDiv").modal('hide');
									//刷新当前 页
									if(this.isUpdate){
										this.goPage(this.pageInfo.pageNum);
									}
									this.type = 2;
									this.cardData = {};
								}else if(r == "repeatError"){
									this.valid = [false,true,true,true,true,true,true,true,true,true];
									this.type = 3;
								}else{
									//关闭窗口
									$("#optDiv").modal('hide');
									this.type = 3;
									this.cardData = {};
								}						
								setTimeout('vm.type = 1',3000);
								
							},
							(resp) => {
								
							}
					);
					
				}
				this.goPage(1);	
			},
		},
	});
	
	vm.goPage(1); // 显示第1页数据