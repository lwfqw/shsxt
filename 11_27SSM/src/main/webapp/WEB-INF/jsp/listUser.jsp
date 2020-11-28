<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/25
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table border="1" align="center" style="border-collapse: collapse">
    <tr><th>email</th><th>name</th><th>tel</th><th>banlence</th></tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.email}</td>
            <td>${user.name}</td>
            <td>${user.tel}</td>
            <td>${user.banlence}</td>
        </tr>
    </c:forEach>
</table>

</table>
</body>
</html>
