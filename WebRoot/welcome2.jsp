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
        <title>欢迎页面-X-admin2.0</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.cookie.js"></script>
    </head>

    <body>
    
        <div class="x-body layui-anim layui-anim-up">
		<div id="div1">
		
		
		
		</div>
	
        <fieldset class="layui-elem-field">
            <legend>开发团队</legend>
            <div class="layui-field-box">
                <table class="layui-table">
                    <tbody>
                        <tr>
                            <th>版权所有</th>
                            <td>兰州城市学院
                               
                        </tr>
						<tr>
                            <th>指导老师</th>
                            <td>张天云教授

                        </tr>
                        <tr>
                            <th>开发者</th>
                            <td>米海军</td>
                        </tr>
                        <tr>
                            <th>开发时间</th>
                            <td>2019年2月25日</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </fieldset>
    </div>
        <script>
        $(function(){
    			var stId = $.cookie('stId');
    			var stName = $.cookie('stName');
    			var stDepartment = $.cookie('stDepartment');
    			var stGrade = $.cookie('stGrade');


				// 获取本机时间
    			var localhostTime = dateFormatter(new Date().getTime())
    			
    			$("#div1").empty();
    			
				var str = '';
				if (stGrade == 0){
		    		str+='<blockquote class="layui-elem-quote">欢迎董事长：';
		    		str+='   <span class="x-red">'+stName+'</span>&nbsp;&nbsp; &nbsp;  当前时间:'+localhostTime+' &nbsp;';
		    		str+='</blockquote>';
				} else if (stGrade == 1){
		    		str+='<blockquote class="layui-elem-quote">欢迎店长：';
		    		str+='   <span class="x-red">'+stName+'</span>&nbsp; &nbsp; &nbsp;  当前时间:'+localhostTime+' &nbsp;';
		    		str+='</blockquote>';
				} else if (stGrade == 2){
		    		str+='<blockquote class="layui-elem-quote">欢迎管理员：';
		    		str+='   <span class="x-red">'+stName+'</span> &nbsp; &nbsp; &nbsp; 当前时间:'+localhostTime+' &nbsp;';
		    		str+='</blockquote>';
				} else if (stGrade == 3){
		    		str+='<blockquote class="layui-elem-quote">欢迎员工：';
		    		str+='   <span class="x-red">'+stName+'</span> &nbsp; &nbsp; &nbsp; 当前时间:'+localhostTime+' &nbsp;';
		    		str+='</blockquote>';
					
					 $.ajax({
							url:"<%=basePath%>/select/salaryMan/stId",
							data: {'stId':stId},
							dataType:"json",
							type:"get",
							success:function(result){
								if(result.code == 1){
									var salaryman = result.data;

									// 获取值
									var saId = salaryman.saId;
									var saNumber = salaryman.saNumber;
									var saOvertime = salaryman.saOvertime;
									var saChidao = salaryman.saChidao;
									var saZaotui = salaryman.saZaotui;
									var saLastsalary = salaryman.saLastsalary;
					
									// 设置值
									$("#gongzi").html(saNumber);
								}
							}
						});

				}

				$("#div1").append(str);

         });


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

        
        </script>

    </body>
</html>