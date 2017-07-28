<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/16
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑资料</title>
</head>
<body>
<div>
    <form action="searchMyWork" enctype="multipart/form-data" method="post">
        <input type="hidden" name="id" value="${user.userId}"><br>
        头像：<input type="file" name="file"  /><br>
        昵称：<input type="text" name="userName" value="${user.userName}"/><br>
        密码：<input type="text" name="password" value="${user.password}"><br>
        性别：<input type="text" name="userSex" value="${user.userSex}"/><br>
        年龄：<input type="text" name="userAge" value="${user.userAge}"/><br>
        手机：<input type="text" name="userPhone" value="${user.userPhone}"><br>
        地址：<input type="text" name="address" value="${user.address}"><br>
        个人签名：<input type="text" name="userSign" value="${user.userSign}" /><br>
        <input type="submit" value="确认">
    </form>
</div>

</body>
</html>
