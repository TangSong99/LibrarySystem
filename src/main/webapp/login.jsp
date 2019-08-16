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
<title>图书管理系统登录</title>
<link rel="stylesheet" href="<%=basePath%>css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
    <link rel="stylesheet" href="<%=basePath%>css/modules/layer/default/layer.css">
 	<script src="<%=basePath%>js/layui.js"></script>
</head>
<body>
<div class="login-main">
    <header class="layui-elip">图书管理系统登录</header>
    <form class="layui-form" action="<%=basePath%>login.do" method="post">
        <div class="layui-input-inline">
            <input type="text" id="usernum" name="usernum" required lay-verify="required" placeholder="用户名" autocomplete="on"
                   class="layui-input">
        </div>
        <div class="layui-input-inline">
            <input type="password" id="userpwd" name="userpwd" required lay-verify="required" placeholder="密码" autocomplete="on"
                   class="layui-input">
        </div>
         <div class="layui-input-inline">
			   	<select name="rolenum" id="rolenum" lay-verify="required">
				  <option value="">请选择身份</option>
				  	<option value="1" >管理员</option>
				  	<option value="0" >读者</option>
				</select> 
    	</div>
        
        <div class="layui-input-inline login-btn">
            <button lay-submit lay-filter="login" class="layui-btn">登录</button>
        </div>
        <hr/>
        <p><a href="register1.jsp" class="fl">立即注册</a><a href="javascript:;" onclick="forgetpsw();" class="fr">忘记密码？</a></p>
    </form>
</div>
 
 

<script type="text/javascript">
    layui.use(['form','layer','jquery'], function () {
 
        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;
       
        form.on('submit(login)',function (data) {
            $.ajax({
                url:'<%=basePath%>login.do',
                data:{
                    usernum:$("#usernum").val(),
                    userpwd:$("#userpwd").val(),
                    rolenum:$("#rolenum").val()
                },
                dataType:'text',
                type:'post',
                success:function (data) {
                   // alert(data);
                    if (data == '1'){
                        location.href = "<%=basePath%>index.do";
                    }else if (data == '0') {
                    	 location.href = "<%=basePath%>frontIndex.do";
                    }else{
                        layer.msg('登录名或密码错误');
                    }
                }
            })
            return false;
        })
    });
	 	function forgetpsw(){
       	 layer.msg('请到图书馆进行重置');
      	}
</script>
</body>
</html>