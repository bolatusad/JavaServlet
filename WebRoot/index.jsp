<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h1>用户登录</h1>
    <hr>
    <form action="servlet/LoginServlet" method="post">
         <label>用户名：</label>
         <input type="text" name="username" value="" /><br>
         <label>密 &nbsp;&nbsp;&nbsp;码：</label>
         <input type="password" name="password" value=""/><br>
         <input type="submit" name="login" value="登录"/>
         <input type="reset" name="clear" value="重置"/>
    </form>
  </body>
</html>
