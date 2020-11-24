<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>Hello World!</h2>
<table border="1" id="tab">
  <tr><th>姓名</th><th>年龄</th><th>籍贯</th><th>性别</th></tr>
    <tr><th>${data.name}</th><th>${data.age}</th></tr>
    <tr><th>${data1.name}</th><th>${data1.age}</th></tr>
</table>
${date?datetime}<br>
${date?date}<br>
${date?time}<br>
${date?string("yyyy-MM-dd HH:mm:ss")?starts_with("2020")?c}<br>
<h2>函数</h2>
<#import "freemark/function.ftl" as fun>
<#assign list=["qw","as","po"]>
<@fun.get "name"></@fun.get>
<@fun.forEach list></@fun.forEach>
<@fun.chose 7></@fun.chose>
</body>
</html>
