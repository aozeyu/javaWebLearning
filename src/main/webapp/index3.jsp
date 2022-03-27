<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo4.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yaozeyu
  Date: 2022/3/27
  Time: 9:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Student> student = new ArrayList<>();
    student.add(new Student("马云",22));
    student.add(new Student("马化腾",26));
    student.add(new Student("李彦宏",21));
    student.add(new Student("周鸿祎",20));
    student.add(new Student("雷军",28));
    student.add(new Student("陈一舟",25));
    student.add(new Student("柳传志",30));
    pageContext.setAttribute("student", student);
%>
<table border="1">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <c:forEach items="${student}" var="s" varStatus="obj">
        <tr style="background-color: ${obj.index % 2 == 0 ? 'orange': 'red'}">
            <td>${obj.count}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
