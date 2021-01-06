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
	        <input type="text" class="layui-input" id="birth" placeholder="yyyy-MM-dd" lay-verify="required">
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
              <button  class="layui-btn" lay-submit="" lay-filter="add" >
                  增加
              </button>
          </div>
  </form> 
    </div>
    <script>
    
    layui.use('form', function(){
		var form = layui.form;


		 //自定义验证规则
		 form.verify({
			 stIds: function(value){
		     if(value.length != 15){
		      return '身份证号必须为15位数字';
		     }
		    }, contact: function(value){
		     if(value.length < 4){
		      return '内容请输入至少4个字符';
		     }
		    }
		   /* ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']*/
		    ,stname: [/^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/, '姓名格式不对']
		 });



		
    	form.on('submit(add)', function(data){


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

//		var response_data = {
//			"userName":userName,
//			"memberDengji":memberDengji,
//			"birth":birth,
//			"userPhone":userPhone,
//			"userAddress":userAddress,
//			"balance":balance,
//			"point":point,
//			"records":records,
//			"state":state,
//			"recharge":recharge,
//			"userMoney":userMoney
//		};

		$.ajax({
			url:"<%=basePath%>/insert/user/user",
			data:{"userName":userName,
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
					// 成功后关闭窗口
					layer.close(layer.index);
					// 刷新父页面
	                window.parent.location.reload();
				}
			}
		});
//	};
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