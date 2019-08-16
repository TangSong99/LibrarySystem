<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>集美大学图书管理系统</title>

  <style>
    .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
  </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<jsp:include   page="header.jsp" flush="true"/>  

	<!-- 搜索条件表单 -->
	<div class="demoTable layui-form">
	  	<div class="layui-inline">
<%--	    	<input class="layui-input" name="rnum" id="rnum" autocomplete="off"  placeholder="请输入读者编号">--%>
	    </div>
<%-- 		<button class="layui-btn" data-type="reload">搜索</button>--%>
 		<a  style="margin-left: 70px"  class="layui-btn layui-btn-normal" onclick="addReader();">添加读者</a>
  	</div>
</div>
 
	
	


<table class="layui-hide" id="demo" lay-filter="test"></table>
 
    <div class="layui-tab-item layui-show">
      <div id="pageDemo"></div>
    </div>
<script type="text/html" id="barDemo">
<%--  <a class="layui-btn layui-btn-primary layui-btn-sm" lay-event="detail">详情</a>--%>
  <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
</script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
var url = "<%=basePath%>"
</script>

<script src="<%=basePath%>js/layui.js"></script>
<script src="<%=basePath%>js/reader/CRUDreader.js"></script>
<script>


layui.config({
  version: '1554901098009' //为了更新 js 缓存，可忽略
});


layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
  var laydate = layui.laydate //日期
  ,laypage = layui.laypage //分页
  ,layer = layui.layer //弹层
  ,table = layui.table //表格
  ,carousel = layui.carousel //轮播
  ,upload = layui.upload //上传
  ,element = layui.element //元素操作
  ,slider = layui.slider //滑块
  
  
  //执行一个 table 实例
  table.render({
    elem: '#demo'
    ,height: 630
    ,url: '<%=basePath%>listReader.do' //数据接口
    ,title: '图书表'
    ,page: true
    ,limit: 6
    ,limits: [5,10,15,20]
    ,cols: [[ //表头
      {type: 'numbers', fixed: 'left'}
      ,{field: 'rnum', title: '读者编号', width:150, sort: true}
      ,{field: 'rname', title: '姓名', width:150}
      ,{field: 'rsex', title: '性别', width: 150}
      ,{field: 'remail', title: '邮箱', width:200, sort: true}
      ,{field: 'cname', title: '地址', width: 150}
      ,{field: 'ctel', title: '电话', width: 120}
      ,{field: 'rcname', title: '角色', width: 100, sort: true}
      ,{field: 'maxnum', title: '可借图书数', width: 100}
      ,{fixed: 'right', width: 200, align:'center', toolbar: '#barDemo'}
    ]]
      //用于搜索结果重载
      ,id: 'testReload'
  });
  var $ = layui.$, active = {
		   reload: function(){
		      var rnum = $('#rnum');
		      //执行重载
		      table.reload('testReload', {
		    	  //一定要加不然乱码
		    	method: 'post'
		        ,page: {
		          curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
		        	//bname表示传到后台的参数,bname.val()表示具体数据
		        	  rnum: rnum.val(),
		        }
		      });
		    }
  };
  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
  
  
  //监听行工具事件
  table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
    var data = obj.data //获得当前行数据
    ,layEvent = obj.event; //获得 lay-event 对应的值
    if(layEvent === 'detail'){
        detail(obj,data);
    } else if(layEvent === 'del'){
      layer.confirm('真的删除行么', function(index){
       del(data,obj,index);
      });
    } else if(layEvent === 'edit'){
    	edit(data);
    }
  });
//后边两个参数仅仅是因为要执行动态删除dom
function del(data,obj,index){
	
	$.ajax({
        url:'<%=basePath%>deleteReader.do?'
        +'rnum='+data.rnum,
        dataType:'text',
        type:'post',
        success:function (data) {
            if (data == '1'){
            	 obj.del(); //删除对应行（tr）的DOM结构
                 layer.close(index);
            }else{
                layer.msg('删除失败');
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
    function edit(data){
        layer.open({
            type: 2,
            title: '修改读者',
            skin: 'layui-layer-demo', //加上边框
            area: ['800px', '600px'], //宽高
            content: '<%=basePath%>editReader.do?'
                + 'rnum=' + data.rnum
                + '&rname=' + data.rname
                + '&rsex=' + data.rsex
                + '&remail=' + data.remail
                + '&cname=' + data.cname
                + '&ctel=' + data.ctel
                + '&maxnum=' + data.maxnum
                + '&rcnum=' + data.rcnum
        });
    }
});
function addReader(){//添加
    layer.open({
        type: 2,
        title: '添加读者',
        skin: 'layui-layer-demo', //加上边框
        area: ['800px', '600px'], //宽高
        content: '<%=basePath%>addReaders.do'
    });
}


</script>
</body>
</html>        
        