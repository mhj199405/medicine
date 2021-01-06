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
                  <span class="x-red">*</span>姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="stName" name="stName" required="" lay-verify="stname"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">只能是中文或者英文。中文名不允许有空格;英文名可以有空格英文，但是不能出现非连续的空格。</div>
          </div>

		<div class="layui-form-item">
		    <label class="layui-form-label"><span class="x-red">*</span>性别</label>
		    <div class="layui-input-block">
		      <input type="radio" name="sex" value="男" title="男" checked="">
		      <input type="radio" name="sex" value="女" title="女">
		    </div>
		  </div>
		  

		<div class="layui-form-item">
		    <div class="layui-inline">
		      <label class="layui-form-label"><span class="x-red">*</span>出生年月</label>
		      <div class="layui-input-inline">
		        <input type="text" class="layui-input" id="stBirth" placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required">
		      </div>
		    </div>
		  </div>

		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>手机号码1
				  </label>
				  <div class="layui-input-inline">
					  <input type="text" id="stPhone1" name="stPhone1" required="" lay-verify="phone" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
				  <div class="layui-form-mid layui-word-aux">请填写11位手机号</div>
		   </div>
		   
		   	<div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					 手机号码2
				  </label>
				  <div class="layui-input-inline">
					  <input type="text" id="stPhone2" name="stPhone2"  oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
				  <div class="layui-form-mid layui-word-aux">请填写11位手机号(选填)</div>
		   </div>
		   
		   
		   <div class="layui-form-item">
				  <label for="L_username" class="layui-form-label">
					  <span class="x-red">*</span>身份证号码
				  </label>
				  <div class="layui-input-inline">
					  <input type="text" id="stIds" name="stIds" required="" lay-verify="stIds" oninput="value=value.replace(/[^\d]/g,'')"
					  autocomplete="off" class="layui-input">
				  </div>
				  <div class="layui-form-mid layui-word-aux">请填写18位身份证号</div>
		   </div>



          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>新密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="stPassword" name="stPassword" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">新密码</div>
          </div>
          
                    <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="stPassword2" name="stPassword2" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">请再一次输入新密码</div>
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
	     var stId = v['stId'] ;//就是你要的结果	     
	     $.ajax({
				url:"<%=basePath%>/select/staff/staffId",
				data: {'stId':stId},
				dataType:"json",
				type:"get",
				success:function(result){
					if(result.code == 1){
						var staff = result.data;

						// 获取值
						var stId = staff.stId; // ID    
						var stName = staff.stName; // 姓名
						var stSex = staff.stSex; // 性别
						var stBirth = staff.stBirth; // 出生年月
			            var stPhone1 = staff.stPhone1; // 手机号码1
			            var stPhone2 = staff.stPhone2; // 手机号码2
			            var stIds = staff.stIds; // 身份证号码
			            var stPassword = staff.stPassword; // 密码
			           
						

						// 设置值
						$("#stName").val(stName);
						$("#stBirth").val(dateFormatter(stBirth));
						$("#stPhone1").val(stPhone1);
						$("#stPhone2").val(stPhone2);
						$("#stIds").val(stIds);
						$("#stPassword").val(stPassword);
						$("#stPassword2").val(stPassword);
						
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
		     if(value.length != 18){
		      return '身份证号必须为18位数字';
		     }
		    }, passwordCheck: function(value){
		     if(value != stPassword2){
		      return '两次密码不一致，请检查';
		     }
		    }, contact: function(value){
		     if(value.length < 4){
		      return '内容请输入至少4个字符';
		     }
		    }
		    ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']
		    ,stname: [/^([\u4e00-\u9fa5]+|([a-zA-Z]+\s?)+)$/, '姓名格式不对']
		 });

		
    	form.on('submit(update)', function(data){
	    var v = parseUrl();//解析所有参数
	    var stId = v['stId'] ;//就是你要的结果
	    
		var stName = $("#stName").val();
		var stSex = $("input[name='sex']:checked").val();
		var stBirth = $("#stBirth").val();
		var stPhone1  = $("#stPhone1").val();
		var stPhone2  = $("#stPhone2").val();
		var stIds  = $("#stIds").val();
		var stPassword  = $("#stPassword").val();
		var stPassword2  = $("#stPassword2").val();

		if(stPassword == stPassword2){
			$.ajax({
				url:"<%=basePath%>/update/staff/staff",
				data: {"stId":stId,
					"stName":stName,
					"stSex":stSex,
					"stBirth":stBirth,
					"stPhone1":stPhone1,
					"stPhone2":stPhone2,
					"stIds":stIds,
					"stPassword":stPassword
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
		} else {
				alert("两次输入的密码不一致，请重新输入");
		}

    	return false;
    });
});
    </script>

	<script>
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //日期时间选择器
		  laydate.render({
		    elem: '#stBirth'
		    ,type: 'datetime'
		  });
		});
	</script>


  </body>

</html>