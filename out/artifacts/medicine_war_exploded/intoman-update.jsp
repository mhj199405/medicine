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
	     var intoId = v['intoId'] ;//就是你要的结果	     
	     $.ajax({
				url:"<%=basePath%>/select/intoMan/intoManId",
				data: {'intoId':intoId},
				dataType:"json",
				type:"get",
				success:function(result){
					if(result.code == 1){
						var intoman = result.data;

						// 获取值
						var intoId = intoman.intoId;
						var intoName = intoman.intoName;
						var intoType = intoman.intoType;
						var intoNumber = intoman.intoNumber;

						var intoPrice = intoman.intoPrice;
						var intoCreateTime = dateFormatter(intoman.intoCreateTime);
						// 设置值

						$("#intoName").val(intoName);
						$("#intoType").val(intoType);
						$("#intoNumber").val(intoNumber);
						$("#intoPrice").val(intoPrice);
						$("#intoCreateTime").val(intoCreateTime);
						
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




		
    	form.on('submit(update)', function(data){
	    var v = parseUrl();//解析所有参数
	    var intoId = v['intoId'] ;//就是你要的结果
	    
		var intoName = $("#intoName").val();
	//	var intoType = $("#intoType").val();
		var intoType = $("input[name='intoType']:checked").val();
		var intoNumber = $("#intoNumber").val();
		var intoPrice = $("#intoPrice").val();
		var intoCreateTime = $("#intoCreateTime").val();


		$.ajax({
			url:"<%=basePath%>/update/intoMan/intoMan",
			data: {'intoId':intoId,
					"intoName":intoName,
					"intoType":intoType,
					"intoNumber":intoNumber,
					"intoPrice":intoPrice,
					"intoCreateTime":intoCreateTime
				  },
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
	
		  //生产日期
		  laydate.render({
		    elem: '#intoCreateTime'
		    ,type: 'datetime'
		  });

	});
</script>
    
  </body>

</html>