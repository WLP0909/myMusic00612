<%--
  Created by IntelliJ IDEA.
  User: God汐Like彡
  Date: 2017/7/11
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
    <link rel="stylesheet" href="/myMusic/static/css/regist.css" type="text/css">
    <script type="text/javascript" src="/myMusic/static/js/jquery-3.2.1.js"></script>
    <script src="/myMusic/static/js/all.js" type="text/javascript"></script>
</head>
<body style="background-image: url(static/img/L4.jpg);background-size: 100% 100%;background-repeat: no-repeat">
<div id="ldiv3" style="position: absolute;top: 3cm; left: 20cm">
    <table>
        <tr>
            <td><input type="text" placeholder="请输入用户名" id="writeUser"></td>
            <td width="200px" id="errorWU"></td>
        </tr>
        <tr>
            <td>
                <input type="text" placeholder="请输入手机号" id="lostPhone" style="width: 115px">
                <input type="button" value="获取验证码" id="getSign" style="width: 90px">
            <td width="200px" id="errorGS"></td>
            </td>
        </tr>
        <tr>
            <td><input type="text" placeholder="请输入验证码" id="newSign"></td>
            <td width="200px" id="errorNS"></td>
        </tr>
        <tr>
            <td><input type="password" placeholder="请输入新密码" id="writePwd"></td>
            <td width="200px" id="errorNP"></td>
        </tr>
        <tr>
            <td><input type="button" value="保存" id="save"></td>
            <td  width="200px"></td>
        </tr>
    </table>
</div>
</body>
</html>
