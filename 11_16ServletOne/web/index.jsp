<%--
  Created by IntelliJ IDEA.
  User: lwf
  Date: 2020/11/16
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title >login</title>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<form method="post " action="${pageContext.request.contextPath}/login">
  <label for="name">用户名</label><input type="text" name="name" id="name" required="输入用户名"><br>
  <label for="password">密码</label><input type="password" onblur="btnClick1()" name="password" id="password" required="输入密码"><br>
  <input type="submit" value="提交" onclick="return btnClick1()">
  <%
    String msg= (String) request.getAttribute("msg");
    String res=(msg==null?"请登录":msg);
  %>
  服务器返回<%=res%>
  <script type="text/javascript">
    function btnClick1() {
      var name=$("#name").val();
      var password=$("#password").val();
      if (name==null){
        $("#name").attr("required","密码不能为空");
        return false;
      }
      if (password==null){
        $("#password").attr("required","密码不能为空");
        return false;
      }
      return true;
    }
  </script>
</form>
</body>
</html>
