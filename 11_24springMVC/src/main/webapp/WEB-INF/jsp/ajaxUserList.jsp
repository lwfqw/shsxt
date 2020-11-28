<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/26
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="test"></table>


<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'/user/json'
            ,height:315
            ,cols: [[
                {field:'email', width:120, title: '邮箱', sort: true}
                ,{field:'name', width:120, title: '用户名'}
                ,{field:'tel', width:120, title: '电话', sort: true}
                ,{field:'banlence', width:120, title: '余额'}
            ]]
            ,page: true
        });
    });
</script>

</body>
</html>
