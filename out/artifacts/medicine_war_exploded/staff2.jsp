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
    <title>退单管理</title>
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
      <script src="https://cdn.staticfile.org/jsp5shiv/r29/jsp5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body class="layui-anim layui-anim-up">
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="text-align: center;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        刷新</a>
    </div>
    <div class="x-body">

 
<div style="overflow:auto;width:100%">
	<table class="layui-table" width="auto" style="white-space:nowrap">
        <thead>

          <tr>
            <th>ID</th>            
            <th>姓名</th>
            <th>编号</th>
            <th>性别</th>
            <th>身份(等级)</th>
            <th>出生年月</th>
            <th>年龄</th>
            <th>手机号码1</th>
            <th>手机号码2</th>
            <th>身份证号码</th>
            <th>所属部门</th>

            <th>创建时间</th>
            <th>修改时间</th>
            <th>操作</th></tr>
        </thead>
        <tbody id="tbody">
				
				<!--  利用Ajax技术循环生成页面	-->
				
		</tbody>
      </table>
</div>
      <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <span class="current">1</span>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });


    /*用户-修改*/
	function updateMed(stId){
		var url = 'staff-update.jsp?stId='+stId;
		x_admin_show('编辑',url);

	}
     




    </script>
    <script>
 // 当页面加载完毕 执行函数 
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


 					function dateFormatterYMD(value) {
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
					    return "" + yy + "-" + MM + "-" + dd ;
					}

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

 $(function(){
	    var v = parseUrl();//解析所有参数
 	    var stId = v['stId'] ;//就是你要的结果
	
			$.ajax({
				url:"<%=basePath%>/select/staff/staffGrade",
				data:{"stId":stId},
				dataType:"json",
				type:"get",
				success:function(result){
					if(result.code == 1){
						var staffList = result.data;
						// 置空
						$("#tbody").empty();
						// 创建空字符串
						var str = '';
						// 循环medicine集合
						for(var i=0;i<staffList.length;i++){
	
							var stId = staffList[i].stId; // ID    
							var stName = staffList[i].stName; // 姓名
							var stOrdernum = staffList[i].stOrdernum; // 编号
							var stSex = staffList[i].stSex; // 性别
							var stGrade = staffList[i].stGrade; // 身份(等级)
							var stBirth = dateFormatterYMD(staffList[i].stBirth); // 出生年月
				            var stAge = staffList[i].stAge; // 年龄
				            var stPhone1 = staffList[i].stPhone1; // 手机号码1
				            var stPhone2 = staffList[i].stPhone2; // 手机号码2
				            var stIds = staffList[i].stIds; // 身份证号码
				            var stDepartment = staffList[i].stDepartment; // 所属部门

				//          var stPassword = staffList[i].stPassword; // 密码
				            var stCreatTime = dateFormatter(staffList[i].stCreatTime); // 创建时间
				            var stUpdateTime = dateFormatter(staffList[i].stUpdateTime); // 修改时间
							
							
							var dataNum = 0;
							
							str += '  <tr>';
							str += '	<td>'+stId+'</td>';
							str += '    <td>'+stName+'</td>';
							str += '    <td>'+stOrdernum+'</td>';
							str += '    <td>'+stSex+'</td>';
							str += '	<td>'+stGrade+'</td>';
							str += '	<td>'+stBirth+'</td>';
							str += '	<td>'+stAge+'</td>';
							str += '	<td>'+stPhone1+'</td>';
							str += '	<td>'+stPhone2+'</td>';
							str += '	<td>'+stIds+'</td>';
							str += '	<td>'+stDepartment+'</td>';
							
				//			str += '	<td>'+stPassword+'</td>';
							str += '	<td>'+stCreatTime+'</td>';
							str += '	<td>'+stUpdateTime+'</td>';
							str += '	<td class="td-manage">';
							str += '     <button class="layui-btn layui-btn layui-btn-xs"  onclick="updateMed('+stId+')" >';
							str += '		<i class="layui-icon">&#xe642;</i>修改';
							str += '	  </button>';
							str += '  	</td>';
							str += '  </tr>';
							dataNum = i+1;
						}
						$("#dataNumSpan").text('共有数据：'+dataNum+' 条');
						$("#tbody").append(str);
					}
				}
			});
		
});
    </script>
  </body>

</html>