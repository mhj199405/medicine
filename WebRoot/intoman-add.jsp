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
                  <input type="text" id="intoName" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>


		<div class="layui-form-item">
		    <label class="layui-form-label"><span class="x-red">*</span>种类</label>
		    <div class="layui-input-block">
		      <input type="radio" name="intoType" value="处方药" title="处方药" checked="">
		      <input type="radio" name="intoType" value="非处方药" title="非处方药">
		    </div>
		  </div>
		  


		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>数量
				  </label>
				  <div class="layui-input-inline">
					  <input type="text" id="intoNumber" name="username" required="" lay-verify="number" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
		   </div>


		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>进货单价
				  </label>
				  <div class="layui-input-inline">
					  <input type="text" id="intoPrice" name="username" required="" lay-verify="number" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
		   </div>
		   
		   
		   <div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label"><span class="x-red">*</span>进货时间</label>
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="intoCreateTime" placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required">
		      </div>
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


		
    	form.on('submit(add)', function(data){
        	    

		var intoName = $("#intoName").val();
	//	var intoType = $("#intoType").val();
		var intoType = $("input[name='intoType']:checked").val();
		var intoNumber = $("#intoNumber").val();
		var intoPrice = $("#intoPrice").val();
		var intoCreateTime = $("#intoCreateTime").val();

		

		$.ajax({
			url:"<%=basePath%>/insert/intoMan/intoMan",
			data:{"intoName":intoName,
					"intoType":intoType,
					"intoNumber":intoNumber,
					"intoPrice":intoPrice,
					"intoCreateTime":intoCreateTime
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
//	};
    	return false;
	});
});
    </script>

	<script>
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
	
		  //生产日期
		  laydate.render({
		    elem: '#intoCreateTime'
		    ,type: 'datetime'
		  });

	});
	</script>

  </body>

</html>