<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title></title>
    

	<link type="text/css" rel="stylesheet" href="/css/style.css" />
  </head>
  
  <body>
	register success!<br/>
	<span>
		loginCode:${user.loginCode} 
		userName:${user.userName} 
		password:${user.password} 
	</span>
	<a href="login.html">登录</a>
  <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
 
  </script>
    
  </body>
</html>