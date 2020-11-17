<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/17
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台下载</title>
</head>
<body>
<form action="/download" method="post">
   <label for="file">文件</label> <input id="file" name="fileName" type="text"><br>
    <input type="submit">
</form>
</body>
</html>
