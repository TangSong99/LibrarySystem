<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>集美大学图书管理系统</title>

    <style>
        .demo-carousel {
            height: 200px;
            line-height: 200px;
            text-align: center;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="readerheader.jsp" flush="true"/>

    <!-- 搜索条件表单 -->
    <div class="demoTable layui-form">
        <div class="layui-inline">
            <input class="layui-input" name="bname" id="bname" autocomplete="off" placeholder="请输入书名">
        </div>
        <%--<div class="layui-inline">
            <input class="layui-input" name="author" id="author" autocomplete="off" placeholder="请输入作者">
        </div>--%>
        <div class="layui-inline">
            <div class="layui-input-block">
                <select name="ccnum" id="ccnum">
                    <option value="">请选择书本类别</option>
                    <c:forEach items="${ChineseClass}" var="cc">
                        <option value="${cc.ccnum}">${cc.ccexplain}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
</div>


<table class="layui-hide" id="demo" lay-filter="test"></table>

<div class="layui-tab-item layui-show">
    <div id="pageDemo"></div>
</div>
<script type="text/html" id="barDemo">
    <%-- 必须使用 button--%>
    <button class="layui-btn layui-btn-normal layui-btn-sm detail" lay-event="detail">详情</button>
    <button class="layui-btn layui-btn-normal layui-btn-sm lend" lay-event="lend">借阅</button>
    <%--	<button class="layui-btn layui-btn-sm lend layui-btn-disabled" lay-event="lend" disabled="disabled">已借阅</button>--%>


</script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });
</script>

<script src="<%=basePath%>js/layui.js"></script>
<script>
    layui.config({
        version: '1554901098009' //为了更新 js 缓存，可忽略
    });

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider //滑块


        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , height: 630
            , url: '<%=basePath%>listBook.do' //数据接口
            , title: '图书表'
            , page: true
            , limit: 6
            , limits: [5, 10, 15, 20]
            , cols: [[ //表头
                {type: 'numbers', fixed: 'left'}
                , {field: 'iSBN', title: 'ISBN', width: 130, sort: true}
                , {field: 'bname', title: '书名', width: 200}
                , {field: 'aname', title: '作者', width: 200, sort: true}
                , {field: 'ccexplain', title: '类别', width: 200, sort: true}
                , {field: 'pname', title: '出版社', width: 200, sort: true}
                , {field: 'wordnum', title: '字数', width: 120, sort: true}
                , {field: 'price', title: '价格', width: 80, sort: true}
                , {field: 'blname', title: '图书馆', width: 120, sort: true}
                , {field: 'instocknum', title: '库存', width: 80}
                , {fixed: 'right', width: 155, align: 'center', toolbar: '#barDemo'}
            ]]
            //用于搜索结果重载
            , id: 'testReload'
        });
        var $ = layui.$, active = {
            reload: function () {
                var bname = $('#bname');
                //alert("bname" + bname.val());
                var ccnum = $('#ccnum');
                //alert("ccnum" + ccnum.val());
                //执行重载
                table.reload('testReload', {
                    //一定要加不然乱码
                    method: 'post'
                    , page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        //bname表示传到后台的参数,bname.val()表示具体数据
                        bname: bname.val(),
                        ccnum: ccnum.val(),
                    }
                });
            }
        };
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


        //监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            console.log(data);
            console.log(layEvent);
            console.log(obj);
            if (layEvent === 'lend') {
                layer.confirm('确认借阅此书吗?', function (index) {
                    lend(obj, index, data);
                });
            }else if(layEvent === 'detail'){
                detail(obj,data)
            }
        });

//后边两个参数仅仅是因为要执行动态删除dom
        function lend(obj, index, data1) {
            $.ajax({
                url: '<%=basePath%>borrowBook.do?'
                     + 'iSBN=' + data1.iSBN
                    // // + '&bname=' + data1.bname
                    // + '&bstate=' + data1.bstate
                     + '&blnum=' + data1.blnum
                    // + '&pnum=' + data1.pnum
                    // + '&ccnum=' + data1.ccnum
                     + '&btnum=' + data1.btnum
                    // //+ '&btname=' + data1.btname
                    // + '&padress=' + data1.padress
                    // //+ '&aname=' + data1.aname
                    // + '&ccexplain=' + data1.ccexplain
                    // //+ '&pname=' + data1.pname
                    // + '&wordnum=' + data1.wordnum
                    // + '&price=' + data1.price
                    // + '&anum' + data1.anum
                    // + '&rolename' + data1.rolename
                    // //+ '&blname' + data1.blname
                     + '&collectionnum=' + data1.collectionnum
                    ,
                dataType: 'text',
                type: 'post',
                success: function (data) {
                    if (data == 'ok') {

                        //当前行数
                        var i = $("tr").index(obj.tr) - 1;
                        //获取当前dom
                        var dom = $('.lend').eq(i);
                        if (dom.hasClass('layui-btn-normal')) {
                            dom.removeClass('layui-btn-normal');
                            //变为禁用
                            dom.addClass('layui-btn-disabled');
                            //去除点击事件
                            dom.attr("disabled", "disabled");
                            dom.html('已借阅');
                        }
                        //更新库存
                        obj.update({
                            instocknum: data1.instocknum - 1
                        });
                        layer.close(index);

                    } else if (data == '0') {
                        layer.msg('您有超期图书未还!', {icon: 5});
                    }else if (data == '1') {
                        layer.msg('该图书库存不足!', {icon: 5});
                    }else{
                        layer.msg('您已超过最大借阅数量!', {icon: 5});
                    }
                }
            })


        }
        notice: function detail(obj,data2) {
            //示范一个公告层
            layer.open({
                type: 1
                ,title: false //不显示标题栏
                ,closeBtn: false
                ,area: '300px;'
                ,shade: 0.8
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btn: ['确认']
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
                    '<center>书名：' + data2.bname + '</center>' +
                    '<br>类别：' + data2.ccexplain + '(' + data2.btname + ')' +
                    '<br>作者：' + data2.aname + '(' + data2.rolename + ')' +
                    '<br>出版信息：' + data2.pname + '(' + data2.padress + ')' +
                    '<br>ISBN号：' + data2.iSBN +
                    '<br>字数：' + data2.wordnum +
                    '<br>价格：' + data2.price +
                    '</div>'
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        target: '_blank'
                    });
                }
            });
        }
    });


</script>
</body>
</html>        
        