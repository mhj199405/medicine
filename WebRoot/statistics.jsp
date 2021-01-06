<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售统计</title>
    <script src="js/jquery.js"></script>
    <script src="js/echarts.min.js"></script>
</head>
<body>
<div style="margin: 50px 50px">
    <div id="chart" style="width: 50%;height: 70%;float: left;"></div>
    <div id="chartmain1" style="width: 50%;height: 70%;float: right;"></div>
</div>
</body>
<script>
    $(function () {
        //页面加载成功后 加载数据
        getData();
        getpayData();
        setInterval(function () {
            location.reload()
        },5000)
    })
    /******************************过期占比*************************************/
        //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chart'), 'light');

    myChart.setOption({
        title: {
            text: '',
            subtext: [],
            textStyle: {
                color: '#4DCEF8',
                fontSize: 30
            },
            subtextStyle: {
                fontSize: 18,
                color: ['#ff9d19']
            },
            x: 'center',
            y: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: ['未过期', '已过期']
        },
        series: [
            {
                name: '',
                type: 'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'outside'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: [] //ajax获取数据
            }
        ]
    });
    //异步加载数据

    function getData() {
        $.get("<%=request.getContextPath()%>/medicine/statistics").done(function (data) {
            myChart.setOption({
                title: {
                    subtext: '药品总数 ' + data['总数'],
                    text: '药品过期占比',
                },
                series: [{
                    name: '是否过期',
                    data: [
                        {value: data['未过期'], name: "未过期"},
                        {value: data['已过期'], name: "已过期"}]
                }]
            });
        })
    }


    /******************************支付方式占比*************************************/
        //初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('chartmain1'), 'light');

    myChart1.setOption({
        title: {
            text: '',
            subtext: [],
            textStyle: {
                color: '#4DCEF8',
                fontSize: 30
            },
            subtextStyle: {
                fontSize: 18,
                color: ['#ff9d19']
            },
            x: 'center',
            y: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: ['支付宝', '微信','银行卡','货到付款']
        },
        series: [
            {
                name: '',
                type: 'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'outside'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: [] //ajax获取数据
            }
        ]
    });
    function getpayData() {
        //异步加载数据
        $.get("<%=request.getContextPath()%>/pay/statistics").done(function (data) {
            myChart1.setOption({
                title: {
                    text: '支付方式占比'
                },
                series: [{
                    name: '支付方式',
                    data: [
                        {value: data['支付宝'], name: "支付宝"},
                        {value: data['微信'], name: "微信"},
                        {value: data['银行卡'], name: "银行卡"},
                        {value: data['货到付款'], name: "货到付款"}]
                }]
            });
        })
    }
</script>
<script>

</script>

</html>

