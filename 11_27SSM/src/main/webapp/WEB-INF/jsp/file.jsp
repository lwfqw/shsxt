<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/26
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件传输</title>
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
    <script src="/layui/layui.js" type="text/javascript"></script>
</head>
<body>
<h1 class="">单文件</h1>
<form class="layui-form" method="post" action="/file/one" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">选择文件</label>
        <div class="layui-input-block">
            <input type="file" name="file" required  lay-verify="required" placeholder="请选择文件" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">${oneFileCode}</div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit">立即提交</button>
        </div>
    </div>
</form>
<h1 class="">单文件</h1>
<form class="layui-form" method="post" action="/file/some" enctype="multipart/form-data">
    <div class="layui-form-item">
        <label class="layui-form-label">选择文件</label>
        <div class="layui-input-block">
            <input type="file" name="files" required  lay-verify="required" placeholder="请选择文件" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择文件</label>
        <div class="layui-input-block">
            <input type="file" name="files" required  lay-verify="required" placeholder="请选择文件" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择文件</label>
        <div class="layui-input-block">
            <input type="file" name="files" required  lay-verify="required" placeholder="请选择文件" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" type="submit">立即提交</button>
        </div>
        <div class="layui-form-mid layui-word-aux">${someFileCode}</div>
    </div>
</form>
</body>
</html>
