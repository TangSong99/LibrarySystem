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
<title>注册界面</title><link rel="stylesheet" href="<%=basePath%>css/layui.css">
<link rel="stylesheet" href="<%=basePath%>css/style.css">
<link rel="stylesheet" href="<%=basePath%>css/modules/layer/default/layer.css">
<script src="<%=basePath%>js/laydate.js"></script>
<script src="<%=basePath%>js/layui.js" ></script>
</head>
<body>
<div class="login-main">
    <header class="layui-elip" style="width: 82%;;margin-top:40px">注册页</header>
    <!-- 表单选项 -->
    <form class="layui-form"  method="post">
        <div class="layui-input-inline">
            <div class="layui-inline" style="width: 85%">
                <input type="text" id="usernum" name="usernum" required  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-inline">
                <i class="layui-icon" id="ri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <div class="layui-inline">
                <i class="layui-icon" id="wr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>
            <!-- 密码 -->
        <div class="layui-input-inline">
            <div class="layui-inline" style="width: 85%">
                <input type="password" id="userpwd" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="pri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="pwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>
            <!-- 确认密码 -->
        <div class="layui-input-inline">
            <div class="layui-inline" style="width: 85%">
                <input type="password" id="rpwd"  required  lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="rpri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="rpwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>
        <div class="layui-input-inline" style="width: 85%">
			   	<select name="rcnum" id="rcnum" lay-verify="required">
				  <option value="">请选择身份</option>
				  	<option value="1" selected="selected">学生</option>
				  	<option value="2" >研究生</option>
				  	<option value="3" >教师</option>
				</select> 
    	</div>
    	<div class="layui-input-block">
        	 <div class="layui-inline" style="width: 85%">
	      		<input type="radio" name="rsex" value="true" title="男">
	      		<input type="radio" name="rsex" value="false" title="女" checked>
	      	</div>
	    </div>
 		 <div class="layui-input-inline">
 		  <div class="layui-inline" style="width: 85%">
            <input type="text" id="remail" name="remail" required lay-verify="required" placeholder="邮箱" autocomplete="off"
                   class="layui-input">
          </div>
        </div>
        <div class="layui-input-inline">
          <div class="layui-inline" style="width: 85%">
            <input type="text" id="rname" name="rname" required lay-verify="required" placeholder="姓名" autocomplete="off"
                   class="layui-input">
            </div>
        </div>
         <div class="layui-input-inline">
          <div class="layui-inline" style="width: 85%">
            <input type="text" id="cname" name="cname" required lay-verify="required" placeholder="地址" autocomplete="off"
                   class="layui-input">
            </div>
        </div>
        <div class="layui-input-inline">
 		  <div class="layui-inline" style="width: 85%">
            <input type="text" id="ctel" name="ctel" required lay-verify="phone" placeholder="电话" autocomplete="off"
                   class="layui-input">
          </div>
        </div>
        <div class="layui-input-inline login-btn" style="width: 85%">
            <button type="submit" lay-submit lay-filter="sub" class="layui-btn">注册</button>
        </div>
        <hr style="width: 85%" />
        <p style="width: 85%"><a href="login.jsp" class="fl">已有账号？立即登录</a></p>
    </form>
</div>

<script type="text/javascript">
    layui.use(['form','jquery','layer'], function () {
        var form   = layui.form;
        var $      = layui.jquery;
        var layer  = layui.layer;
        
        layer.tips('学号就是借阅号哦!', '#usernum');
        //添加表单失焦事件
        //验证表单
        $('#usernum').blur(function() {
            var usernum = $(this).val();
            //alert(user);
            $.ajax({
                url:"<%=basePath%>checkReader.do",
                type:'post',
                dataType:'text',
                data:{usernum:usernum},
                //验证用户名是否可用
                success:function(data){
                	//alert(data);
                    if (data == "1") {
                        $('#ri').removeAttr('hidden');
                        $('#wr').attr('hidden','hidden');
                    } else {
                        $('#wr').removeAttr('hidden');
                        $('#ri').attr('hidden','hidden');
                        layer.msg('当前学号已被注册! ')
                    }
                }
            })
        });
        $('#userpwd').blur(function() {
                var reg = /^[\w]{6,12}$/;
                if(!($('#userpwd').val().match(reg))){
                    $('#pwr').removeAttr('hidden');
                    $('#pri').attr('hidden','hidden');
                    layer.msg('密码必须6-12位');
                }else {
                    $('#pri').removeAttr('hidden');
                    $('#pwr').attr('hidden','hidden');
                }
        });
 
        //验证两次密码是否一致
        $('#rpwd').blur(function() {
                if($('#userpwd').val() != $('#rpwd').val()){
                    $('#rpwr').removeAttr('hidden');
                    $('#rpri').attr('hidden','hidden');
                    layer.msg('两次输入密码不一致!');
                }else {
                    $('#rpri').removeAttr('hidden');
                    $('#rpwr').attr('hidden','hidden');
                };
        });
        
      //添加表单监听事件,提交注册信息
        form.on('submit(sub)', function(data) {
            if(!new RegExp("^[0-9]*$").test(data.field.usernum)){
                layer.msg("学号为数字哦!");
                return false;
            }
            $.ajax({
            	url:'<%=basePath%>addReader.do',
                data:{
                	usernum:$("#usernum").val(),
                	userpwd:$("#userpwd").val(),
                	rcnum:$("#rcnum").val(),
                	cnum:$("#usernum").val(),
                	cname:$("#cname").val(),
                	ctel:$("#ctel").val(),
                	rsex:$("input[name='rsex']:checked").val(),
                	remail:$("#remail").val(),
                	rnum:$("#usernum").val(),
                	rname:$("#rname").val(),
                },
                dataType:'text',
                type:'post',
                success:function(data){
                    if (data == '1') {
                        layer.msg('注册成功');
                        location.href = "login.jsp";
                    }else {
                        layer.msg('注册失败');
                    }
                }
            })
            //防止页面跳转
            return false;
        });
    });
    
    
</script>
</body>
</html>