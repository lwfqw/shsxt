<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/26
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
    <link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
    <script src="/layui/layui.js" type="text/javascript"></script>
</head>
<body>
<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="/user/all">所有用户</a></li>
    <li class="layui-nav-item layui-this"><a href="/user/tojson">LayUi样式（ajax）显示用户</a></li>
    <li class="layui-nav-item"><a href="/file/go">文件上传</a></li>
    <li class="layui-nav-item">welcome:${user.name}</li>
</ul>
<form class="layui-form" method="post" action="/user/transfor">
    <div class="layui-form-item">
        <label class="layui-form-label">转账到：</label>
        <div class="layui-input-block">
            <input type="email" id="email" name="email" required  lay-verify="required" placeholder="请输入对方账号（邮箱)" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">金额：</label>
        <div class="layui-input-block">
            <input type="number" id="money" name="money" required  lay-verify="required" placeholder="请输入金额" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框</label>
        <div class="layui-input-inline">
            <input type="password" name="password" id="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">${transfor}</div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="return x();" type="submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script type="text/javascript">
    //Demo
    layui.use('form', function(){
        var form = layui.form;

    //     //监听提交
    //     form.on('submit(formDemo)', function(data){
    //         layer.msg(JSON.stringify(data.field));
    //         return false;
    //     });
     });
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
    function x() {
        var a=document.getElementById("money").value;
        if (a<0){
            return false;
        }
        if (document.getElementById("email")==null){
            return false;
        }
        if (document.getElementById("password")==null){
            return false;
        }
        return true;
    }
</script>
</body>
</html>
