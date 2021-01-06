<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%	
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>添加药品信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />

    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
       <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="./layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body layui-anim layui-anim-up">



<form class="layui-form">


          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>会员姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="userName" name="userName" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>

	  <div class="layui-form-item">
	    <div class="layui-inline">
	      <label class="layui-form-label"><span class="x-red">*</span>出生年月</label>
	      <div class="layui-input-inline">
	        <input type="text" class="layui-input" id="birth" placeholder="yyyy-MM-dd">
	      </div>
	    </div>



		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>电话
				  </label>
				  <div class="layui-input-inline">
					  <input type="text" id="userPhone" name="userPhone" required="" lay-verify="phone" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
		   </div>

		  <div class="layui-form-item layui-form-text">
			<label class="layui-form-label"><span class="x-red">*</span>地址</label>
			<div class="layui-input-block">
			  <textarea placeholder="请输入地址" id="userAddress" class="layui-textarea" lay-verify="required"></textarea>
			</div>
		  </div>

          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red" >*</span>会员等级
              </label>
              <div class="layui-input-inline">
                  <select name="contrller" id="memberDengji"> 
	          		<option value="1">1</option>
	          		<option value="2">2</option>
	          		<option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                  </select>
              </div>
          </div>

		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>余额
				  </label>
				  <div class="layui-input-inline" style="width: 100px;">
					  <input type="text" id="balance" placeholder="￥" name="balance" required="" lay-verify="number" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
		   </div>

		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label" >
					  <span class="x-red">*</span>积分
				  </label>
				  <div class="layui-input-inline" style="width: 100px;">
					  <input type="text" id="point" name="point" required="" lay-verify="number" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
		   </div>


		  <div class="layui-form-item layui-form-text">
			<label class="layui-form-label"><span class="x-red">*</span>消费记录</label>
			<div class="layui-input-block">
			  <textarea placeholder="请输入消费记录" id="records" class="layui-textarea" lay-verify="required"></textarea>
			</div>
		  </div>

		  <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label"><span class="x-red">*</span>充值时间</label>
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="recharge" placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required">
		      </div>
		    </div>
		  </div>

		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>充值金额
				  </label>
				  <div class="layui-input-inline" style="width: 100px;">
					  <input type="text" id="userMoney" placeholder="￥" name="userMoney" required="" lay-verify="number" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
		   </div>


          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-submit="" lay-filter="update" >
                修改
              </button>
          </div>
  </form> 
    </div>
    <script>


		function dateFormatter(value) {
		    date = new Date(value);
		    var yy = date.getFullYear();
		    var MM = date.getMonth() + 1;
		    var dd = date.getDate();
		    var hh = date.getHours();
		    var mm = date.getMinutes();
		    var ss = date.getSeconds();
		    if (MM < 10)
		        MM = "0" + MM;
		    if (dd < 10)
		        dd = "0" + dd;
		    if (hh < 10)
		        hh = "0" + hh;
		    if (mm < 10)
		        mm = "0" + mm;
		    if (ss < 10)
		        ss = "0" + ss;					 
		    return "" + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss;
		}
    
	$(function(){
	     var v = parseUrl();//解析所有参数
	     var userId = v['userId'] ;//就是你要的结果	     
	     $.ajax({
				url:"<%=basePath%>/select/user/userId",
				data: {'userId':userId},
				dataType:"json",
				type:"get",
				success:function(result){
					if(result.code == 1){
						var user = result.data;

						// 获取值
						var userId = user.userId;
						var userName = user.userName;
						var memberDengji = user.memberDengji;
						var birth = dateFormatter(user.birth);
						var userPhone = user.userPhone;
						var userAddress = user.userAddress;
						var balance = user.balance;
						var point = user.point;
						var records = user.records;
						var recharge = dateFormatter(user.recharge);
						var userMoney = user.userMoney;

						// 设置值
						$("#userName").val(userName);
						$("#memberDengji").val(memberDengji);
						$("#birth").val(birth);
						$("#userPhone").val(userPhone);
						$("#userAddress").val(userAddress);
						$("#balance").val(balance);
						$("#point").val(point);
						$("#records").val(records);
						$("#recharge").val(recharge);
						$("#userMoney").val(userMoney);
						
					}
				}
			});
	});

    function parseUrl(){
                    var url=location.href;
                    var i=url.indexOf('?');
                    if(i==-1)return;
                    var querystr=url.substr(i+1);
                    var arr1=querystr.split('&');
                    var arr2=new Object();
                    for  (i in arr1){
                        var ta=arr1[i].split('=');
                        arr2[ta[0]]=ta[1];
                    }
                    return arr2;
                }



    layui.use('form', function(){
		var form = layui.form;

		 //自定义验证规则
		 form.verify({
			 stIds: function(value){
		     if(value.length != 15){
		      return '身份证号必须为15位数字';
		     }
		    },  contact: function(value){
		     if(value.length < 4){
		      return '内容请输入至少4个字符';
		     }
		    }
		    ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']
		    ,stname: [/^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/, '姓名格式不对']
		 });

		
    	form.on('submit(update)', function(data){
	    var v = parseUrl();//解析所有参数
	    var userId = v['userId'] ;//就是你要的结果
	    
		var userName = $("#userName").val();
		var birth = $("#birth").val();
		var userPhone = $("#userPhone").val();
		var userAddress  = $("#userAddress").val();
		var memberDengji = $("#memberDengji").find("option:selected").text();
		var balance  = $("#balance").val();
		var point  = $("#point").val();
		var records  = $("#records").val();
		var recharge  = $("#recharge").val();
		var userMoney  = $("#userMoney").val();
		
		$.ajax({
			url:"<%=basePath%>/update/user/user",
			data:{"userId":userId,
				"userName":userName,
				"memberDengji":memberDengji,
				"birth":birth,
				"userPhone":userPhone,
				"userAddress":userAddress,
				"balance":balance,
				"point":point,
				"records":records,
				"recharge":recharge,
				"userMoney":userMoney},
			dataType:"json",
			type:"post",
			success:function(result){
				if(result.code == 1){					
					// 修改成功后关闭窗口
					layer.close(layer.index);
					// 刷新父页面
                    window.parent.location.reload();
				} else if (result.code == 2){
					alert("修改失败，请重新输入");
				} else if (result.code == 3){
					alert("对不起，服务器出现异常");
				}
			}
		});
    	return false;
    });
});
    </script>

	<script>
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //日期时间选择器
		  laydate.render({
		    elem: '#recharge'
		    ,type: 'datetime'
		  });

			//出生年月选择器
		  laydate.render({
		    elem: '#birth'
		    ,type: 'datetime'
		  });
	 });
	</script>


  </body>

</html>