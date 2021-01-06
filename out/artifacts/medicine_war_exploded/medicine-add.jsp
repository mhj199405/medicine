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
                  <span class="x-red">*</span>药品名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="medName" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>

          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>价格
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="price" name="email" required="" lay-verify="number"
                  autocomplete="off" class="layui-input" placeholder="￥">
              </div>
          </div>
          
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>药品编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="medNum" name="username" required="" lay-verify="number"
                  autocomplete="off" class="layui-input">
              </div>
          </div>



		  <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label"><span class="x-red">*</span>生产日期</label>
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="prouductDate" placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required">
		      </div>
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label"><span class="x-red">*</span>保质期</label>
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="saveDate" placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required">
		      </div>
		    </div>
		  </div>


        <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>生产商
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="producter" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>

        <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>生产地区
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="prouductArea" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>


		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>电话
				  </label>
				  <div class="layui-input-inline">
					  <input type="text" id="phone" name="username" required="" lay-verify="required" 
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
		    ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']
		    ,stname: [/^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/, '姓名格式不对']
		 });

		
    	form.on('submit(add)', function(data){
        	
		var medName = $("#medName").val();
		var price = $("#price").val();
		var medNum = $("#medNum").val();
		var prouductDate = $("#prouductDate").val();
		var saveDate = $("#saveDate").val();
		var producter  = $("#producter").val();
		var prouductArea  = $("#prouductArea").val();
		var phone  = $("#phone").val();


		$.ajax({
			url:"<%=basePath%>/insert/medicine/medicine",
			data: {'medName':medName,
					'price':price,
					'medNum':medNum,
					'prouductDate':prouductDate,
					'saveDate':saveDate,
					'producter':producter,
					'prouductArea':prouductArea,
					'phone':phone
				  },
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
		return false;
	});
});
    </script>

	<script>
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
	
		  //生产日期
		  laydate.render({
		    elem: '#prouductDate'
		    ,type: 'datetime'
		  });
		  
		  //保质期
		  laydate.render({
		    elem: '#saveDate'
		    ,type: 'datetime'
		  });
	});
	</script>


  </body>

</html>