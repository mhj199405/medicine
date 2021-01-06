<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%	
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
       request.getSchema()可以返回当前页面使用的协议，http 或是 https;

       request.getServerName()可以返回当前页面所在的服务器的名字;

       request.getServerPort()可以返回当前页面所在的服务器使用的端口,就是80;

       request.getContextPath()可以返回当前页面所在的应用的名字;
--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
	<link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script src="./layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up" >
        <div class="message">药店管理登录</div>
        <div id="darkbannerwrap"></div>
        <form method="post" class="layui-form" >
            <input name="username" placeholder="请输入账号" id="stName"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" id="stPassword"  placeholder="请输入密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>
    <script>
    layui.use('form', function(){
		var form = layui.form;
    	form.on('submit(login)', function(data){
    	var stName = $("#stName").val();
    	var stPassword = $("#stPassword").val();
		$.ajax({
			url:"<%=basePath%>/staff/login",
			data: {"stName":stName,"stPassword":stPassword},
			dataType:"json",
			type:"post",
			success:function(result){
				if (result.code == 1) {
					//登录成功
					var mapList = result.data;
					var stDepartment = mapList.stDepartment;	
					var stGrade = mapList.stGrade;	
					var stId = mapList.stId;
					var stName = mapList.stName;
					$.cookie('stDepartment', stDepartment, { expires: 1, path: '/' });
					$.cookie('stGrade', stGrade, { expires: 1, path: '/' });
					$.cookie('stId', stId, { expires: 1, path: '/' });
					$.cookie('stName', stName, { expires: 1, path: '/' });
					window.location.href="<%=basePath%>index.jsp";
				} else if (result.code == 2) {
					alert("账号或密码错误,请重新登录 ");
					window.location.href="login.jsp";
				} else if (result.code == 3) {
					alert("对不起,服务器发生异常,请重新登录");
					window.location.href="login.jsp";
				}
			}
		});
		return false;
	});
});
    </script>
</body>
</html>