<%@page contentType="text/html;utf-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <link rel="stylesheet"  type="text/css" href="layui/css/layui.css"/>
    <script src="./layui/layui.js" type="text/javascript"></script>
    <script type="text/javascript">
        function check() {
            var email=document.getElementById("id").value;
            var passward=document.getElementById("password").value;
            if (email==null||email=="".trim()){
                alert("email不为空");
                return false;
            }
            if (passward==null||passward=="".trim()){
                alert("password不为空");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>登录${msg}</legend>
</fieldset>

<form class="layui-form" action="/user/login" method="post" lay-filter="example">
    <div class="layui-form-item">
        <label class="layui-form-label">id</label>
        <div class="layui-input-block">
            <input type="email" name="id" lay-verify="title" autocomplete="off" placeholder="请输入id" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" onclick="return check();" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">设置</label>
        <div class="layui-input-block">
            <input type="checkbox"  title="记住">
            <input type="checkbox"  title="不记住">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="reset" class="layui-btn layui-btn-normal" id="LAY-component-form-getval">取值</button>
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>
</body>
</html>