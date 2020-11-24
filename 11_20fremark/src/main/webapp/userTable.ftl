<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
</head>
<body>
<h1>用户</h1>
<div>
    <#if list??>
        <table>
            <tr><th>编号</th><th>姓名</th><th>年龄</th></tr>
        <#list list as user>
          <tr><td>${user.id}</td><td>${user.name}</td><td>${user.age}</td></tr>
        </#list>
        </table>
    </#if>
</div>
</body>
</html>