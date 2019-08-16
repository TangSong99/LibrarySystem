<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="<%=basePath%>css/layui.css">
  <link rel="stylesheet" href="<%=basePath%>css/modules/code.css">
   <link rel="stylesheet" href="<%=basePath%>css/modules/laydate/default/laydate.css">
   <link rel="stylesheet" href="<%=basePath%>css/modules/layer/default/layer.css">
<style type="text/css">
.layui-table-cell{
    height:36px;
    line-height: 36px;
}
</style>
</head>
<body>
	<div class="layui-header">
    <div class="layui-logo">集美大学图书借阅系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="<%=basePath%>frontIndex.do">图书列表</a></li>
        <li class="layui-nav-item"><a href="<%=basePath%>listDisBack.do">借阅记录</a></li>
        <li class="layui-nav-item"><a href="<%=basePath%>updateReaderInfo.do">修改信息</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
        ${user.rname}
        </a>
      </li>
        <li class="layui-nav-item"><a href="<%=basePath%>loginout.do">注销</a></li>
    </ul>
  </div>

</body>
</html>