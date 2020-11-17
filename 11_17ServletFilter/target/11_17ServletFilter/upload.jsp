<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/17
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="/upload">
    <label for="file">上传文件</label><input type="file" id="file" name="file"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
