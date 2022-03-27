<%--
  Created by IntelliJ IDEA.
  User: yaozeyu
  Date: 2022/3/27
  Time: 8:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
 request.setAttribute("name","monkey1024");
%>
<jsp:forward page="first.jsp"></jsp:forward>
</body>
</html>
