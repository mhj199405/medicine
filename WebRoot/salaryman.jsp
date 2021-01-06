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
    <title>薪资管理</title>
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

      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
          <input type="text" name="medName" id="sousuokuang" placeholder="请输入员工姓名" autocomplete="off" class="layui-input" lay-verify="required">
          <button class="layui-btn"  lay-submit="" lay-filter="selectName"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <table class="layui-table">
        <thead>

          <tr>
            <th>ID</th>
            <th>员工姓名</th>
            <th>基本工资</th>
            <th>加班情况</th>
            <th>迟到情况</th>
            <th>早退情况</th>
            <th>实际工资</th>
            <th>操作</th></tr>
        </thead>
        <tbody id="tbody">
				
				<!--  利用Ajax技术循环生成页面	-->
				
		</tbody>
      </table>

    </div>
    <script>
layui.use('form', function(){
	var form = layui.form;	
	form.on('submit(selectName)', function(data){   	
		var sousuokuang = $("#sousuokuang").val();
		$.ajax({
			url:"<%=basePath%>/select/salaryMan/LikeStName",
			data: {'stName':sousuokuang},
			dataType:"json",
			type:"post",
			success:function(result){
				if(result.code == 1){
					var salarymanList = result.data;
					// 置空
					$("#tbody").empty();
					// 创建空字符串
					var str = '';
					// 循环medicine集合
					for(var i=0;i<salarymanList.length;i++){
						  
						var saId = salarymanList[i].saId;
						var saNumber = salarymanList[i].saNumber;
						var saOvertime = salarymanList[i].saOvertime;
						var saChidao = salarymanList[i].saChidao;
						var saZaotui = salarymanList[i].saZaotui;
						var saLastsalary = salarymanList[i].saLastsalary;
						var stName = salarymanList[i].staff.stName;
	
	
						var dataNum = 0;
						str += '  <tr>';
						str += '	<td>'+saId+'</td>';
						str += '    <td>'+stName+'</td>';
						str += '    <td>'+saNumber+'</td>';
						str += '    <td>'+saOvertime+'</td>';
						str += '	<td>'+saChidao+'</td>';
						str += '	<td>'+saZaotui+'</td>';
						str += '	<td>'+saLastsalary+'</td>';
						str += '	<td class="td-manage">';
						str += '     <button class="layui-btn layui-btn layui-btn-xs"  onclick="updateMed('+saId+')" >';
						str += '		<i class="layui-icon">&#xe642;</i>修改';
						str += '	  </button>';
						str += '  </td>';
						str += '  </tr>';
						dataNum = i+1;
					}
					$("#dataNumSpan").text('共有数据：'+dataNum+' 条');
					$("#tbody").append(str);
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
	function updateMed(saId){
		var url = 'salaryman-update.jsp?saId='+saId;
		x_admin_show('编辑',url);

	}
     



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>


 $(function(){
		
		$.ajax({
			url:"<%=basePath%>/select/salaryManList/salaryMan",
			dataType:"json",
			type:"get",
			success:function(result){
				if(result.code == 1){
					var salarymanList = result.data;
					// 置空
					$("#tbody").empty();
					// 创建空字符串
					var str = '';
					// 循环medicine集合
					for(var i=0;i<salarymanList.length;i++){
						  
						var saId = salarymanList[i].saId;
						var saNumber = salarymanList[i].saNumber;
						var saOvertime = salarymanList[i].saOvertime;
						var saChidao = salarymanList[i].saChidao;
						var saZaotui = salarymanList[i].saZaotui;
						var saLastsalary = salarymanList[i].saLastsalary;
						var stName = salarymanList[i].staff.stName;
	
	
						var dataNum = 0;
						str += '  <tr>';
						str += '	<td>'+saId+'</td>';
						str += '    <td>'+stName+'</td>';
						str += '    <td>'+saNumber+'</td>';
						str += '    <td>'+saOvertime+'</td>';
						str += '	<td>'+saChidao+'</td>';
						str += '	<td>'+saZaotui+'</td>';
						str += '	<td>'+saLastsalary+'</td>';
						str += '	<td class="td-manage">';
						str += '     <button class="layui-btn layui-btn layui-btn-xs"  onclick="updateMed('+saId+')" >';
						str += '		<i class="layui-icon">&#xe642;</i>修改';
						str += '	  </button>';
						str += '  </td>';
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