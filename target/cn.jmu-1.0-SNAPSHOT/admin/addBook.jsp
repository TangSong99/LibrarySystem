<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>添加图书页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
  <link rel="stylesheet" href="<%=basePath%>css/layui.css"  media="all">
  <link rel="<%=basePath%>css/modules/laydate/default/laydate.css" >
  <link rel="stylesheet" href="<%=basePath%>css/style.css">
  <link rel="stylesheet" href="<%=basePath%>css/modules/layer/default/layer.css">
  <script src="<%=basePath%>js/laydate.js"></script> <!-- 要在layui 的前边不然时间插件失效 -->
  <script src="<%=basePath%>js/layui.js" ></script>
 <style>
  body{padding: 20px;}
  .demo-input{padding-left: 10px; height: 38px; min-width: 262px; line-height: 38px; border: 1px solid #e6e6e6;  background-color: #fff;  border-radius: 2px;}
  .demo-footer{padding: 50px 0; color: #999; font-size: 14px;}
  .demo-footer a{padding: 0 5px; color: #01AAED;}
  </style>
</head>
<body>
<form class="layui-form" action="<%=basePath%>submitAddBook.do" method="post" id="addbook" lay-filter="example">
 <div class="layui-form-item">
     <div class="layui-inline">
         <label class="layui-form-label">图书编号：</label>
         <div class="layui-input-inline">
             <input type="text" name="bnum" lay-verify="required" value="${bookinfo.bnum}" <c:if test="${bookinfo.bnum!=null}">disabled="disabled"</c:if>>
         </div>
     </div>
     <div class="layui-inline">
         <label class="layui-form-label">ISBN号：</label>
         <div class="layui-input-inline">
             <input type="text" name="ISBN" lay-verify="required" value="${bookinfo.ISBN}" <c:if test="${bookinfo.bnum!=null}">disabled="disabled"</c:if>>
         </div>
     </div>
    <div class="layui-inline">
      <label class="layui-form-label">书名：</label>
      <div class="layui-input-inline">
      <!--  隐藏域-->
<%--      <input type="hidden" name="book_id"  value="${bookinfo.book_id}" >--%>
        <input type="text" name="bname" lay-verify="required" value="${bookinfo.bname}" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">作者：</label>
      <div class="layui-input-inline">
        <input type="text" name="aname" lay-verify="required" value="${bookinfo.aname}" autocomplete="off" class="layui-input">
      </div>
    </div>
     <div class="layui-inline">
         <label class="layui-form-label">该书角色：</label>
         <div class="layui-input-inline">
             <input type="text" name="rolename" lay-verify="required" value="${bookinfo.rolename}" autocomplete="off" class="layui-input">
         </div>
     </div>
  </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">字数：</label>
            <div class="layui-input-inline">
                <input type="text" name="wordnum" lay-verify="required" value="${bookinfo.wordnum}" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
          <label class="layui-form-label">价格：</label>
          <div class="layui-input-inline">
            <input type="text" name="price" lay-verify="required" value="${bookinfo.price}" autocomplete="off" class="layui-input">
          </div>
        </div>
  </div>
   <div class="layui-form-item">
       <div class="layui-inline">
           <c:set  var="pnum" value="${bookinfo.pnum}" />
           <label class="layui-form-label">出版社：</label>
           <div class="layui-input-block" >
               <select name="pnum" id="pnum" lay-verify="required">
                   <option value="">请选择出版社</option>
                   <c:forEach items="${Press}" var="press">
                       <option value="${press.pnum}" <c:if test="${press.pnum==pnum}">selected</c:if>>${press.pname}</option>
                   </c:forEach>
               </select>
           </div>
       </div>
       <div class="layui-inline">
           <c:set  var="blnum" value="${bookinfo.blnum}" />
           <label class="layui-form-label" >图书馆：</label>
           <div class="layui-input-block" >
               <select name="blnum" id="blnum" lay-verify="required" <c:if test="${bookinfo.blnum!=null}">disabled="disabled"</c:if>>
                   <option value="">请选择出版社</option>
                   <c:forEach items="${BranchLibraries}" var="branchlibraries">
                       <option value="${branchlibraries.blnum}" <c:if test="${branchlibraries.blnum==blnum}">selected</c:if>>${branchlibraries.blname}</option>
                   </c:forEach>
               </select>
           </div>
       </div>
   </div>
   <div class="layui-form-item">
    <div class="layui-inline">
        <c:set  var="btnum" value="${bookinfo.btnum}" />
     <label class="layui-form-label">书本类别：</label>
			<div class="layui-input-block" >
			   	<select name="btnum" id="btnum" lay-verify="required">
				  <option value="">请选择书本类别</option>
				  <c:forEach items="${BorrowType}" var="borrowtype">
				  	<option value="${borrowtype.btnum}"<c:if test="${borrowtype.btnum==btnum}">selected</c:if>>${borrowtype.btname}</option>
				  </c:forEach>
				</select> 
			</div>
    </div>
  </div>
  
  </div>
  <div class="layui-form-item">
      <div class="layui-inline">
          <c:set  var="ccnum" value="${bookinfo.ccnum}" />
          <label class="layui-form-label">中图分类：</label>
          <div class="layui-input-block">
              <select name="ccnum" id="ccnum">
                  <option value="">请选择书本类别</option>
                  <c:forEach items="${ChineseClass}" var="cc">
                      <option value="${cc.ccnum}"<c:if test="${cc.ccnum==ccnum}">selected</c:if>>${cc.ccexplain}</option>
                  </c:forEach>
              </select>
          </div>
      </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
    <c:if test="${bookinfo==null}"><!-- 查看是没有添加按钮的 -->
      <button class="layui-btn" lay-submit="" lay-filter="addbook">立即添加</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
     </c:if>
     <!-- 修改需要修改按钮是没有添加按钮的 -->
     <c:if test="${code==1}">
	     <button class="layui-btn" lay-submit="" lay-filter="updatebook">立即修改</button>
	     <button type="reset" class="layui-btn layui-btn-primary">重置</button>
     </c:if>
    </div>
  </div>
</form>

<script>
lay('#version').html('-v'+ laydate.v);

//执行一个laydate实例
laydate.render({
  elem: '#test1' //指定元素
});
</script>

<script type="text/javascript">
    layui.use(['form','layer','jquery'], function () {
        // 操作对象
        var form = layui.form;
        var $ = layui.jquery;
        //添加ajax表单提交
        form.on('submit(addbook)',function (data) {
            $.ajax({
                url:'<%=basePath%>submitAddBook.do',
               	data:data.field,
                dataType:'text',
                type:'post',
                success:function (data) {
                    if (data == '1'){
                    	 layer.msg("添加成功！");
                         layer.alert("添加成功！",function(){
                             window.parent.location.reload();//刷新父页面
                             parent.layer.close(index);//关闭弹出层
                         });
                    }else{
                        layer.msg('添加失败');
                    }
                }
            })
            return false;
        }),

      //修改ajax表单提交
        form.on('submit(updatebook)',function (data) {
            $.ajax({
                url:'<%=basePath%>updateBook.do',
               	data:data.field,
                dataType:'text',
                type:'post',
                success:function (data) {
                    if (data == '1'){
                         layer.alert("修改成功！",function(){
                             window.parent.location.reload();//刷新父页面
                             parent.layer.close(index);//关闭弹出层
                         });
                    }else{
                        layer.msg('修改失败');
                    }
                }
            })
            return false;
        })
 
        
    });
</script>


</body>
</html>