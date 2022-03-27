<%@ taglib prefix="c" uri="" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yaozeyu
  Date: 2022/3/27
  Time: 8:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first jsp</title>
</head>
<body>
<%
    Date d = new Date();
    out.write(d.toLocaleString());
    Object[] city = {"北京","上海","广州","天津"};
    pageContext.setAttribute("city",city);
%>
<c:forEach items="${city}" var="c">${c}</c:forEach>
<%@ include file="left.jsp"%>
<br>
<%= sum%>
<br>
<%=request.getAttribute("name")%>
</body>
</html>
