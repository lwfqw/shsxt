<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/26
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>循环打开CSDN</title>
</head>
<body>
<br/>
<h1 id="text"> </h1>
<iframe id="iframe" src="https://www.baidu.com" width="600" height="600">

</iframe>

</body>
</html>
<script type="text/javascript">
    var url=["https://blog.csdn.net/lwf0615/article/details/110138345",
        "https://blog.csdn.net/lwf0615/article/details/109553367",
        "https://blog.csdn.net/lwf0615/article/details/110096870",
        "https://blog.csdn.net/lwf0615/article/details/110006351",
        "https://blog.csdn.net/lwf0615/article/details/109908317",
    "https://blog.csdn.net/lwf0615/article/details/109696172",
    "https://blog.csdn.net/lwf0615/article/details/109729341",
    "https://blog.csdn.net/lwf0615/article/details/109630131",
    "https://blog.csdn.net/lwf0615/article/details/109656654",
    "https://blog.csdn.net/lwf0615/article/details/109627559",
    "https://blog.csdn.net/lwf0615/article/details/109551091",
     "https://blog.csdn.net/lwf0615/article/details/109548078",
    "https://blog.csdn.net/lwf0615/article/details/109540232",
    "https://blog.csdn.net/lwf0615/article/details/109520801",
    "https://blog.csdn.net/lwf0615/article/details/109491838",
    "https://blog.csdn.net/lwf0615/article/details/109393892",
    "https://blog.csdn.net/lwf0615/article/details/109275745",
    "https://blog.csdn.net/lwf0615/article/details/109249835",
    "https://blog.csdn.net/lwf0615/article/details/109231016",
    "https://blog.csdn.net/lwf0615/article/details/109207714",
    "https://blog.csdn.net/lwf0615/article/details/109190371",
    "https://blog.csdn.net/lwf0615/article/details/109185928",
    "https://blog.csdn.net/lwf0615/article/details/109170678"];
    var i=1;
    setInterval(list,5000);
    function list() {
        var iframe = document.getElementById("iframe");
        iframe.setAttribute("src",url[i%url.length]);
        i++;
        document.getElementById("text").innerText=i;
    }
</script>
