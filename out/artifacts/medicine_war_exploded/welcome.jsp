<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
</head>
<style type="text/css">
    * {
        margin: 0;
        padding: 0;
        list-style-type: none;
    }

    a, img {
        border: 0;
        text-decoration: none;
    }

    /*今日签到*/
    .singer {
        border: 1px solid #DCDBDB;
        padding: 10px;
        height: 45px;
        line-height: 45px;
        width: 290px;
        margin: 20px auto;
    }

    .singer_l_cont, .singer_r_img {
        float: left;
    }

    .singer_l_cont {
        width: 145px;
        background: url(images/sing_per.gif) no-repeat left 12px;
        text-indent: 23px;
        font-size: 12px;
    }

    .singer_r_img {
        display: block;
        width: 114px;
        height: 52px;
        background: url(images/sing_week.gif) right 2px no-repeat;
        vertical-align: middle;
        float: right;
        *margin-bottom: -10px;
    }

    .singer_r_img:hover {
        background-position: right -53px;
        text-decoration: none;
    }

    .singer_r_img span {
        margin-left: 14px;
        font-size: 16px;
        font-family: 'Hiragino Sans GB', 'Microsoft YaHei', sans-serif !important;
        font-weight: 700;
        color: #165379;
    }

    .singer_r_img.current {
        background: url(images/sing_sing.gif) no-repeat 0 2px;
    }

    .singer2 {
        border: 1px solid #DCDBDB;
        padding: 10px;
        height: 45px;
        line-height: 45px;
        width: 290px;
        margin: 20px auto;
    }

    .singer_l_cont2, .singer_r_img2 {
        float: left;
    }

    .singer_l_cont2 {
        width: 145px;
        background: url(images/sing_per.gif) no-repeat left 12px;
        text-indent: 23px;
        font-size: 12px;
    }

    .singer_r_img2 {
        display: block;
        width: 114px;
        height: 52px;
        background: url(images/sing_week2.gif) right 2px no-repeat;
        vertical-align: middle;
        float: right;
        *margin-bottom: -10px;
    }

    .singer_r_img2:hover {
        background-position: right -53px;
        text-decoration: none;
    }

    .singer_r_img2 span {
        margin-left: 14px;
        font-size: 16px;
        font-family: 'Hiragino Sans GB', 'Microsoft YaHei', sans-serif !important;
        font-weight: 700;
        color: #165379;
    }

    .singer_r_img2.current2 {
        background: url(images/sing_sing.gif) no-repeat 0 2px;
    }
</style>
<body>
<div class="x-body layui-anim layui-anim-up">
    <div id="div1">


    </div>

    <div class="singer">
        <div class="singer_l_cont">
            <span>签到</span>
        </div>
        <div class="singer_r_r ">
            <a class="singer_r_img" href="#">
                <span id="sing_for_number"></span>
            </a>
        </div>
    </div><!--singer end-->


    <div class="singer2">
        <div class="singer_l_cont2">
            <span>签退</span>
        </div>
        <div class="singer_r_r2">
            <a class="singer_r_img2" href="#">
                <span id="sing_for_number2"></span>
            </a>
        </div>
    </div><!--singer end-->

    <fieldset class="layui-elem-field">
        <legend>数据统计</legend>
        <div class="layui-field-box">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="layui-carousel x-admin-carousel x-admin-backlog" lay-anim="" lay-indicator="inside"
                             lay-arrow="none" style="width: 100%; height: 90px;">
                            <div carousel-item="">
                                <ul class="layui-row layui-col-space10 layui-this">
                                    <li class="layui-col-xs2">
                                        <a href="javascript:;" class="x-admin-backlog-body">
                                            <h3>当月工资</h3>
                                            <p>
                                                <cite id="gongzi"></cite></p>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>

    <fieldset class="layui-elem-field">
        <legend>开发团队</legend>
        <div class="layui-field-box">
            <table class="layui-table">
                <tbody>
                <tr>
                    <th>版权所有</th>
                    <td>兰州城市学院</td>

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
    $(function () {
        var stId = $.cookie('stId');
        var qiandao = $.cookie('qiandao' + stId);
        var qiantui = $.cookie('qiantui' + stId);
        var stName = $.cookie('stName');
        var stDepartment = $.cookie('stDepartment');
        var stGrade = $.cookie('stGrade');

        // 获取本机时间
        var localhostTime = dateFormatter(new Date().getTime())

        $("#div1").empty();
        var str = '';
        if (stGrade == 0) {
            str += '<blockquote class="layui-elem-quote">欢迎董事长：';
            str += '   <span class="x-red">' + stName + '</span>&nbsp;&nbsp; &nbsp;  当前时间:' + localhostTime + ' &nbsp;';
            str += '</blockquote>';
        } else if (stGrade == 1) {
            str += '<blockquote class="layui-elem-quote">欢迎店长：';
            str += '   <span class="x-red">' + stName + '</span>&nbsp; &nbsp; &nbsp;  当前时间:' + localhostTime + ' &nbsp;';
            str += '</blockquote>';
        } else if (stGrade == 2) {
            str += '<blockquote class="layui-elem-quote">欢迎管理员：';
            str += '   <span class="x-red">' + stName + '</span> &nbsp; &nbsp; &nbsp; 当前时间:' + localhostTime + ' &nbsp;';
            str += '</blockquote>';
        } else if (stGrade == 3) {
            str += '<blockquote class="layui-elem-quote">欢迎员工：';
            str += '   <span class="x-red">' + stName + '</span> &nbsp; &nbsp; &nbsp; 当前时间:' + localhostTime + ' &nbsp;&nbsp;&nbsp;&nbsp;上班时间&nbsp;09:00&nbsp;&nbsp;&nbsp;&nbsp;下班时间&nbsp;17:00';
            str += '</blockquote>';
            if (qiandao != null) {

                $(".singer_r_img").addClass("current");

            }
            if (qiantui != null) {

                $(".singer_r_img2").addClass("current2");

            }

            $.ajax({
                url: "<%=basePath%>/select/salaryMan/stId",
                data: {'stId': stId},
                dataType: "json",
                type: "get",
                success: function (result) {
                    if (result.code == 1) {
                        var salaryman = result.data;

                        // 获取值
                        var saId = salaryman.saId;
                        var saNumber = salaryman.saNumber;
                        var saOvertime = salaryman.saOvertime;
                        var saChidao = salaryman.saChidao;
                        var saZaotui = salaryman.saZaotui;
                        var saLastsalary = salaryman.saLastsalary;

                        // 设置值
                        $("#gongzi").html(saLastsalary);
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
<script type="text/javascript">


    function week2() {
        var objDate = new Date();
        var week = objDate.getDay();
        switch (week) {
            case 0:
                week = "周日";
                break;
            case 1:
                week = "周一";
                break;
            case 2:
                week = "周二";
                break;
            case 3:
                week = "周三";
                break;
            case 4:
                week = "周四";
                break;
            case 5:
                week = "周五";
                break;
            case 6:
                week = "周六";
                break;
        }
        $("#sing_for_number2").html(week);
    }

    $(document).ready(function () {
        week2();
        $(".singer_r_img2").click(function () {

            var stId = $.cookie('stId');
            var stName = $.cookie('stName');
            var stDepartment = $.cookie('stDepartment');
            var stGrade = $.cookie('stGrade');
            $.ajax({
                url: "<%=basePath%>/update/salaryMan/qiantui",
                data: {'stId': stId},
                dataType: "json",
                type: "post",
                success: function (result) {
                    if (result.code == 1) {


                    }
                }
            });
            $.cookie('qiantui' + stId, stId, {expires: 1, path: '/'});
            $(this).addClass("current2");
        })


    })


    /*签到模块日期捕捉：*/
    function week() {
        var objDate = new Date();
        var week = objDate.getDay();
        switch (week) {
            case 0:
                week = "周日";
                break;
            case 1:
                week = "周一";
                break;
            case 2:
                week = "周二";
                break;
            case 3:
                week = "周三";
                break;
            case 4:
                week = "周四";
                break;
            case 5:
                week = "周五";
                break;
            case 6:
                week = "周六";
                break;
        }
        $("#sing_for_number").html(week);
    }

    $(document).ready(function () {
        week();
        $(".singer_r_img").click(function () {
            var stId = $.cookie('stId');
            var stName = $.cookie('stName');
            var stDepartment = $.cookie('stDepartment');
            var stGrade = $.cookie('stGrade');
            $.ajax({
                url: "<%=basePath%>/update/salaryMan/qiandao",
                data: {'stId': stId},
                dataType: "json",
                type: "post",
                success: function (result) {
                    if (result.code == 1) {


                    }
                }
            });
            $.cookie('qiandao' + stId, stId, {expires: 1, path: '/'});
            $(this).addClass("current");
        })
    })
</script>
</body>
</html>