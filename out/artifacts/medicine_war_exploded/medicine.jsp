<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>药品管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="./layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <style>

    </style>
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>药品管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="text-align: center;margin-top:3px;float:right;"
       href="javascript:location.replace(location.href);" title="刷新">刷新</a>
</div>
<%--条件查询--%>
<div class="x-body">

    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input type="text" name="medName" id="medName" placeholder="请输入药品名称" autocomplete="off" class="layui-input"
                   lay-verify="required">
            <button class="layui-btn" lay-submit="" lay-filter="search-comment"><i class="layui-icon">&#xe615;</i>
            </button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加','./medicine-add.jsp',600,400)"><i
                class="layui-icon"></i>添加
        </button>
        <span class="x-right" style="line-height:40px" id="dataNumSpan"></span>
        <button class="layui-btn layui-btn-danger" id="btn"><i class="layui-icon"></i>批量删除</button>
        <a href="/药品信息录入模板.xls"><button class="layui-btn layui-btn-warm" style="float: right">模板下载</button></a>
        <form action="/medicine/upload" method="post" enctype="multipart/form-data" style="float: right" id="form1">
            <input type="file" name="filename" id="up"/>
            <button type="button" class="layui-btn layui-btn-normal" id="btn1"><i class="layui-icon"></i>批量上传</button>
        </form>
    </xblock>
    <%--评论表--%>
    <table class="layui-table" lay-filter="comment-table" id="comment-table">
    </table>
</div>
</body>
</html>

<%--行操作--%>
<script type="text/html" id="user-row-bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit-comment">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del-comment">删除</a>
</script>

<script>
    layui.use(['table', 'form', 'layer', 'jquery', 'util', 'upload'], function () {
        var form = layui.form;
        var layer = layui.layer;
        var table = layui.table;
        var util = layui.util;
        var upload = layui.upload;
        $ = layui.jquery;
        $(document).on('click', '#btn', function () {
            delAll();
        });
        $(document).on('click', '#btn1', function () {
            var file = $("#up").val();
            var flag=false;
            if (file == null || file == "") {
                layer.msg("请选择文件!")
            } else {
                var s = file.substr(file.lastIndexOf("."));
                if (s == ".xls" || s == ".xlsx") {
                    $("#form1").submit();
                } else {
                    layer.msg("文件格式不正确!")
                }

            }

        });

        table.render({
            id: "comment-table"
            , elem: '#comment-table'
            , cellMinWidth: 40
            , url: '<%=request.getContextPath()%>/select/medicineList/medicine' //数据接口，查询所有list
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'count', 'skip', 'limit'] //自定义分页布局
                , groups: 5 //只显示 1 个连续页码
                , first: false //不显示首页
                , last: false //不显示尾页,
                , limits: [5, 10, 15, 20, 25, 30]
                , limit: 10
            }
            , cols: [[ //表头
                {type: 'checkbox'},
                {field: 'mId', title: 'ID', sort: true, width: 60}//主键
                , {field: 'medName', title: '药品名称'} //对应的实体的字段
                , {field: 'price', title: '价格', width: 60} //对应的实体的字段
                , {field: 'medNum', title: '编号', width: 70} //对应的实体的字段
                , {
                    field: 'prouductDate', title: '生产日期', templet: function (data) {
                        return util.toDateString(data.prouductDate, "yyyy-MM-dd")
                    }
                }
                , {
                    field: 'saveDate', title: '保质期', templet: function (data) {
                        return util.toDateString(data.saveDate, "yyyy-MM-dd")
                    }
                } //对应的实体的字段
                , {field: 'producter', title: '生产商'} //对应的实体的字段
                , {field: 'phone', title: '电话'} //对应的实体的字段
                , {
                    field: 'careatTime', title: '录入时间', templet: function (data) {
                        return util.toDateString(data.careatTime, "yyyy-MM-dd")
                    }
                } //对应的实体的字段
                , {
                    field: 'updateTime', title: '更新时间', templet: function (data) {
                        return util.toDateString(data.updateTime, "yyyy-MM-dd")
                    }
                } //对应的实体的字段
                , {fixed: 'right', title: '操作', align: 'center', toolbar: '#user-row-bar'}
            ]]
        });

        //监听行工具事件
        table.on('tool(comment-table)', function (obj) {
            var data = obj.data;
            console.log(data);
            switch (obj.event) {
                case 'del-comment': {
                    layer.confirm('确定删除吗？', function (index) {
                        $.ajax({
                            url: '<%=request.getContextPath()%>/delete/medicine/medicineId',
                            data: "mId=" + data.mId,
                            method: 'post',
                            success: function (result) {
                                layer.msg(result.msg, {icon: 1, time: 1000});
                                location.replace(location.href);
                            }
                        })
                    });
                    break;
                }

                case 'edit-comment': {
                    updateMed(data.mId);
                    break;
                }
                /*case 'goDelete':
                    delAll();
                    break;*/
            }
        });
        form.render();
        form.on('submit(search-comment)', function (data) {
            table.reload('comment-table', {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: data.field
            });
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });

        function updateMed(mId) {
            var url = 'medicine-update.jsp?mId=' + mId;
            x_admin_show('编辑', url);

        }

        // 批量删除
        function delAll() {
            var checkStatus = table.checkStatus('comment-table'),
                checkData = checkStatus.data; //得到选中的数据
            console.log(checkData);
            var arr = [];
            checkData.forEach(function (el, index) {
                arr.push(el.mId);
            });
            console.log(arr);
            if (arr.length != 0) {
                layer.confirm('确认要删除吗？', function (index) {

                    //发异步删除数据
                    $.ajax({
                        url: "<%=request.getContextPath()%>/delete/medicine/medicines",
                        data: {'datas': arr},
                        dataType: "json",
                        async: false,
                        type: "post",
                        success: function (result) {
                            if (result == 1) {
                            }
                        }
                    });

                    //捉到所有被选中的，发异步进行删除
                    layer.msg('删除成功', {icon: 1});
                    $(".layui-form-checked").not('.header').parents('tr').remove();
                });
            } else {
                layer.msg('请勾选要删除的选项!');
            }
        }
    })


</script>

