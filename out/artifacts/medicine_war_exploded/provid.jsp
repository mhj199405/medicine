<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>供应商管理</title>
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
</head>

<body class="layui-anim layui-anim-up">
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>供应商管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="text-align: center;margin-top:3px;float:right;"
       href="javascript:location.replace(location.href);" title="刷新">刷新</a>
</div>
<%--条件查询--%>
<div class="x-body">

    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input type="text" name="proName" id="proName" placeholder="请输入供应商名称" autocomplete="off" class="layui-input"
                   lay-verify="required">
            <button class="layui-btn" lay-submit="" lay-filter="search-comment"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加','./provide-add.jsp',600,400)"><i
                class="layui-icon"></i>添加
        </button>
        <span class="x-right" style="line-height:40px" id="dataNumSpan"></span>
        <button class="layui-btn layui-btn-danger" id="btn"><i class="layui-icon"></i>批量删除</button>
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
    layui.use(['table', 'form', 'layer','jquery','util'], function () {
        var form = layui.form;
        var layer = layui.layer;
        var table = layui.table;
        var util=layui.util;
        $=layui.jquery;
        $(document).on('click','#btn',function(){
            delAll();
        });
        table.render({
            id: "comment-table"
            , elem: '#comment-table'
            , cellMinWidth: 40
            , url: '<%=request.getContextPath()%>/select/provideList/provide' //数据接口，查询所有list
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'count', 'skip', 'limit'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                , groups: 5 //只显示 1 个连续页码
                , first: false //不显示首页
                , last: false //不显示尾页,
                , limits: [5, 10, 15, 20, 25, 30]
                , limit: 10
            }
            , cols: [[ //表头
                {type: 'checkbox'},
                {field: 'proId', title: 'ID', sort: true,width:60}//主键
                , {field: 'proName', title: '供应商名称'} //对应的实体的字段
                , {field: 'proNum', title: '编号'} //对应的实体的字段
                , {field: 'medType', title: '药品总类',width:280} //对应的实体的字段
                , {field: 'orders', title: '来往订单'}
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
                            url: '<%=request.getContextPath()%>/delete/provide/provideId',
                            data: "proId=" + data.proId,
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
                    updateMed(data.proId);
                    break;
                }
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
        function updateMed(proId) {
            var url = 'provide-update.jsp?proId=' + proId;
            x_admin_show('编辑', url);

        }

        // 批量删除
        function delAll() {
            var checkStatus = table.checkStatus('comment-table'),
                checkData = checkStatus.data; //得到选中的数据
            console.log(checkData);
            var arr = [];
            checkData.forEach(function (el, index) {
                arr.push(el.proId);
            });
            console.log(arr);
            if (arr.length != 0) {
                layer.confirm('确认要删除吗？', function (index) {

                    //发异步删除数据
                    $.ajax({
                        url: "<%=request.getContextPath()%>/delete/provide/provides",
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

