<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <title>会员管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
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
        <a href="welcome2.jsp">首页</a>
        <a>
          <cite>会员管理</cite></a>
      </span>
  <a class="layui-btn layui-btn-small" style="text-align: center;margin-top:3px;float:right;"
     href="javascript:location.replace(location.href);" title="刷新">刷新</a>
</div>
<%--条件查询--%>
<div class="x-body">

  <div class="layui-row">
    <form class="layui-form layui-col-md12 x-so">
      <input type="text" name="userName" id="userName" placeholder="请输入会员姓名" autocomplete="off" class="layui-input"
             lay-verify="required">
      <button class="layui-btn" lay-submit="" lay-filter="search-comment"><i class="layui-icon">&#xe615;</i></button>
    </form>
  </div>
  <xblock>
    <button class="layui-btn" onclick="x_admin_show('添加','./user-add.jsp',600,400)"><i
            class="layui-icon"></i>添加
    </button>
    <span class="x-right" style="line-height:40px" id="dataNumSpan"></span>
    <button class="layui-btn layui-btn-danger" id="btn"><i class="layui-icon"></i>批量删除</button>
  </xblock>
  <%--评论表--%>
  <table class="layui-table" lay-filter="comment-table" id="comment-table" style="height:500px">
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
            , url: '<%=request.getContextPath()%>/select/userList/user' //数据接口，查询所有list
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
                {field: 'userId', title: 'ID', sort: true, width: 68}//主键
                , {field: 'userName', title: '姓名',width:80} //对应的实体的字段
                , {field: 'birth', title: '出生年月',minWidth:102,templet: function (data) {
                        return  util.toDateString(data.birth, "yyyy-MM-dd")}
                }
                , {field: 'userPhone', title: '电话',minWidth:117} //对应的实体的字段
                , {field: 'userAddress', title: '地址',minWidth:143} //对应的实体的字段
                , {field: 'memberDengji', title: '会员等级',width:90} //对应的实体的字段
                , {field: 'balance', title: '余额',width:60} //对应的实体的字段
                , {field: 'point', title: '积分',width:60} //对应的实体的字段
                , {field: 'records', title: '消费记录',width:90} //对应的实体的字段
                ,{field: 'recharge', title: '充值时间',minWidth:102,templet: function (data) {
                        return  util.toDateString(data.recharge, "yyyy-MM-dd")}
                }
                , {field: 'userMoney', title: '充值金额'} //对应的实体的字段
                , {fixed: 'right', title: '操作', align: 'center', toolbar: '#user-row-bar',minWidth:120}
            ]]
        });

        //监听行工具事件
        table.on('tool(comment-table)', function (obj) {
            var data = obj.data;
            switch (obj.event) {
                case 'del-comment': {
                    layer.confirm('确定删除吗？', function (index) {
                        $.ajax({
                            url: '<%=request.getContextPath()%>/delete/user/userId',
                            data: "userId=" + data.userId,
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
                    updateMed(data.userId);
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
        function updateMed(userId) {
            var url = 'user-update.jsp?userId='+userId;
            x_admin_show('编辑', url);

        }

        // 批量删除
        function delAll() {
            var checkStatus = table.checkStatus('comment-table'),
                checkData = checkStatus.data; //得到选中的数据
            var arr = [];
            checkData.forEach(function (el, index) {
                arr.push(el.userId);
            });
            console.log(arr);
            if (arr.length != 0) {
                layer.confirm('确认要删除吗？', function (index) {

                    //发异步删除数据
                    $.ajax({
                        url: "<%=request.getContextPath()%>/delete/user/users",
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

