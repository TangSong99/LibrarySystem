<%--
  Created by IntelliJ IDEA.
  User: MECHREV
  Date: 2019/7/5
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>借阅记录</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include   page="readerheader.jsp" flush="true"/>

    <!-- 搜索条件表单 -->
    <div class="demoTable layui-form">
<%--        <div class="layui-inline">--%>
<%--            <input class="layui-input" name="bname" id="bname" autocomplete="off"  placeholder="请输入书名">--%>
<%--        </div>--%>
        <div class="layui-inline">
            <div class="layui-input-block">
                <select name="brstate" id="brstate">
                    <option value="2">请选择归还状态</option>
                    <option value="1">未还</option>
                    <option value="0">已还</option>
                </select>
            </div>
        </div>
        <button class="layui-btn" data-type="reload"   lay-filter="reset" >搜索</button>
    </div>


</div>


<table class="layui-hide" id="demo" lay-filter="test"></table>

<div class="layui-tab-item layui-show">
    <div id="pageDemo"></div>
</div>

<script type="text/html" id="barDemo">
    {{#  if(d.brstate =="1"){ }}
    <p style="color:red;font-size:1.3em;">未还</p>
    {{#  } }}
    {{#  if(d.brstate =="0"){ }}
    <p style="color:limegreen;font-size:1.3em;" >已还</p>
    {{#  } }}
</script>
<script type="text/html" id="barDemo2">
    <%-- 必须使用 button--%>
    {{#  if(d.brstate =="1"){ }}
    <button class="layui-btn layui-btn-normal layui-btn-sm lend" lay-event="back">归还</button>
    <button class="layui-btn layui-btn-normal layui-btn-sm detail" lay-event="last">续借</button>
    <%--	<button class="layui-btn layui-btn-sm lend layui-btn-disabled" lay-event="lend" disabled="disabled">已借阅</button>--%>
    {{#  } }}
</script>
<div id="testDiv"></div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    var url = "<%=basePath%>"
</script>

<script src="<%=basePath%>js/layui.js"></script>
<script>


    layui.config({
        version: '1554901098009' //为了更新 js 缓存，可忽略
    });


    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider','laytpl'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,carousel = layui.carousel //轮播
            ,upload = layui.upload //上传
            ,element = layui.element //元素操作
            ,slider = layui.slider //滑块
            ,laytpl = layui.laytpl




        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 630
            ,url: '<%=basePath%>listDisBackBook.do' //数据接口
            ,title: '图书表'
            ,page: true
            ,limit: 6
            ,limits: [5,10,15,20]
            ,cols: [[ //表头
                {type: 'numbers', fixed: 'left'}
                ,{field: 'bnum', title: '图书号', width: 200}
                ,{field: 'bname', title: '书名', width: 200}
                ,{field: 'bdate', title: '借阅时间', width:200, sort: true}
                ,{field: 'edate', title: '应还时间', width: 200}
                ,{field: 'blname', title: '图书馆', width: 200}
                ,{field: 'rfmoney', title: '罚款', width: 100
                     ,templet: function(d){
                         return d.rfmoney==null?'':'<a style="font-size:1.5em;color: red;font-weight: bold">'+d.rfmoney+'元</a>';
                     }
                    }
                ,{fixed: 'right', width: 150, align:'center', toolbar: '#barDemo'}
                ,{fixed: 'right', width: 200, align:'center', toolbar: '#barDemo2'}
            ]]
            //用于搜索结果重载
            ,id: 'testReload'
        });
        var $ = layui.$, active = {
            reload: function(){
                //var bname = $('#bname');
                var brstate = $('#brstate');
                alert(brstate.val());
                //执行重载
                table.reload('testReload', {
                    //一定要加不然乱码
                    method: 'post'
                    ,page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        //bname表示传到后台的参数,bname.val()表示具体数据
                        //bname: bname.val(),
                        brstate: brstate.val()
                    }
                });
            }
        };
        $('.demoTable .layui-btn').on('click', function(){
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
            if (layEvent === 'back') {
               // / layer.confirm('确认借阅此书吗?', function (index) {
                    back(obj, data);
                // });
            }else if(layEvent === 'last'){
                last(obj,data);
            }
        });

//后边两个参数仅仅是因为要执行动态删除dom
        function back(obj, data1) {
            $.ajax({
                url: '<%=basePath%>backBook.do?'
                    + 'bnum=' + data1.bnum
                    + '&rnum=' + data1.rnum
                    + '&collectionnum=' + data1.collectionnum
                ,
                dataType: 'text',
                type: 'post',
                async:false,
                success: function (data) {
                    if (data == 'ok') {
                        layer.msg('归还成功!', {icon: 6});
                        //response.setHeader("refresh","1;URL=listDisBack.jsp");
                        //更新库存
                        obj.update({
                            brstate: 0
                        });
                        window.parent.location.reload();//刷新父页面
                    }else{
                        layer.msg('归还失败!', {icon: 5});
                    }
                }
            })
        }

        function last(obj, data2) {
            $.ajax({
                url: '<%=basePath%>lastBook.do?'
                    + 'bnum=' + data2.bnum
                    + '&rnum=' + data2.rnum
                    + '&snum=' + data2.snum
                    + '&collectionnum=' + data2.collectionnum
                ,
                dataType: 'text',
                type: 'post',
                success: function (data) {
                    if (data == '0') {
                        layer.msg('续借成功!', {icon: 6});
                    }else if(data == '1') {
                        layer.msg('您已续借过!', {icon: 5});
                    }else {
                        layer.msg("您有超期图书未还!", {icon: 5})
                    }
                }
            })
        }
    });

</script>
</body>
</html>
