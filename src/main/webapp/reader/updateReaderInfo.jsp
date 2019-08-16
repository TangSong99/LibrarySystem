<%--
  Created by IntelliJ IDEA.
  User: MECHREV
  Date: 2019/7/5
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>修改信息</title>
    <script src="<%=basePath%>js/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include   page="readerheader.jsp" flush="true"/>
</div>
<div class="login-main">
    <form class="layui-form"  method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">新邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="remail" id="remail" required  lay-verify="required" placeholder="${user.remail}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新地址</label>
            <div class="layui-input-block">
                <input type="text" name="cname" id="cname" required  lay-verify="required" placeholder="eg：集美大学五社区五号楼" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新电话</label>
            <div class="layui-input-block">
                <input type="text" name="ctel" id="ctel" required  lay-verify="required" placeholder="eg：13285970367" autocomplete="off" class="layui-input">
            </div>
        </div>
        <center>
        <div class="layui-input-inline login-btn">
            <button lay-submit lay-filter="update" class="layui-btn">修改</button>
        </div>
        </center>
        <hr/>
    </form>
</div>
<script type="text/javascript">

    layui.use(['form','layer','jquery'], function () {

        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;

        form.on('submit(update)',function (data) {
            $.ajax({
                url:'<%=basePath%>updateReader.do',
                data:{
                    remail:$("#remail").val(),
                    cname:$("#cname").val(),
                    ctel:$("#ctel").val(),
                    rnum:${user.rnum}
                },
                dataType:'text',
                type:'post',
                success:function (data) {
                    //alert(data);
                    if (data == '1'){
                        layer.msg('修改成功');
                    }
                }
            })
            return false;
        })
    });
</script>
</body>
</html>

