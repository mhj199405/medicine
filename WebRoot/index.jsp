<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>药店管理系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script src="./layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="./index.jsp">药店管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"><span id="stName"></span></a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="tuichu()">退出</a></dd>
            </dl>
        </li>

    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">

            <!-- 一级菜单(1) -->
            <li id="li1">
                <a _href="medicine.jsp">
                    <i class="iconfont">&#xe723;</i>
                    <cite>药品管理</cite>

                </a>
            </li>
            <!-- 一级菜单(2) -->
            <li id="li2">
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>销售管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="provid.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>供应商信息管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="soldnote.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>销售记录管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="refund.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>退单管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <!-- 一级菜单(3) -->
            <li id="li3">
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>会员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="user.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>基本信息管理</cite>
                        </a>
                    </li>
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="member.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>积分兑换管理</cite>
                        </a>
                    </li>
                </ul>
            </li>

            <!-- 一级菜单(4) -->

            <li id="li4">
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>财务管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="incomeman.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>收入管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="intoman.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>进货管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="salaryman.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>薪资管理</cite>
                        </a>
                    </li>

                </ul>
            </li>

            <!-- 一级菜单(5) -->


            <li id="div5">

            </li>

            <li id="li5">
                <a _href="statistics.jsp">
                    <i class="iconfont">&#xe723;</i>
                    <cite>实时统计</cite>


                </a>
            </li>


        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show" id="divWel">

            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->

<!-- 底部结束 -->
<script>


    function tuichu() {

        //	$.cookie('stId', null);
        //	$.cookie('stName', null);
        //	$.cookie('stDepartment', null);
        //	$.cookie('stGrade', null);

        window.location.href = "login.jsp";
    }

    $(function () {
        var stId = $.cookie('stId');
        var stName = $.cookie('stName');
        var stDepartment = $.cookie('stDepartment');
        var stGrade = $.cookie('stGrade');

        if (stId == null) {
            window.location.href = "login.jsp";
        } else {
            $("#stName").text(stName);
            $("#div5").empty();
            $("#divWel").empty();
            var str = '';
            var str2 = '';
            if (stGrade == 3) {
                str += '	 <a _href="staff2.jsp?stId=' + stId + '">';
                str += '      <i class="iconfont">&#xe723;</i>';
                str += '       <cite>个人信息</cite>';
                str += '   </a>';

                str2 += '<iframe src="./welcome.jsp" frameborder="0" scrolling="yes" class="x-iframe"></iframe>';
            } else {
                str += '	 <a _href="staff.jsp?stId=' + stId + '">';
                str += '      <i class="iconfont">&#xe723;</i>';
                str += '       <cite>员工管理</cite>';
                str += '   </a>';

                str2 += '<iframe src="./welcome2.jsp" frameborder="0" scrolling="yes" class="x-iframe"></iframe>';
            }
            $("#div5").append(str);
            $("#divWel").append(str2);

            if (stDepartment == "药品部") {
                $("#li2").css("display", "none");
                $("#li3").css("display", "none");
                $("#li4").css("display", "none");
                $("#li5").css("display", "none");
            } else if (stDepartment == "销售部") {
                $("#li1").css("display", "none");
                $("#li3").css("display", "none");
                $("#li4").css("display", "none");
                $("#li5").css("display", "none");
            } else if (stDepartment == "财务部") {
                $("#li1").css("display", "none");
                $("#li2").css("display", "none");
                $("#li3").css("display", "none");
                $("#li5").css("display", "none");
            }


        }


    });


</script>
</body>
</html>