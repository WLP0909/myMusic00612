<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <link rel="stylesheet" href="/myMusic/static/css/regist.css" type="text/css">
    <script type="text/javascript" src="/myMusic/static/js/jquery-3.2.1.js"></script>
    <script src="/myMusic/static/js/all.js" type="text/javascript"></script>
    <script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
    <script src="/myMusic/static/js/supersized.3.2.7.min.js" type="text/javascript"></script>
    <script src="/myMusic/static/js/supersized-init.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/myMusic/static/css/supersized.css">
    <link rel="stylesheet" href="/myMusic/static/css/style.css">
    <script type="text/javascript">
        function reloadCode() {
            document.getElementById("imagecode").src = "<%=request.getContextPath()%>/selectImage?" + Math.random();
        }
    </script>
</head>
<body id="b1">
<div id="ldiv2">
    <form>
        <table>
            <tr>
                <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <img src="/myMusic/static/img/Logo.jpg" class="Limage2"/></td>
            </tr>
            <tr>
                <td colspan="3">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择您的身份：
                    <input type="radio" name="login" value="普通用户" id="pUser" style="width: 10px"/>普通用户
                    <input type="radio" name="login" value="管理员" id="Manage" style="width: 10px"/>管理员
                </td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：<input type="text" name="name" id="name" placeholder="请输入用户名"/>
                </td>
                <td width="200px" id="errorUser"></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：&nbsp;&nbsp;&nbsp;<input type="password" name="pwd" id="pwd"
                                                                              placeholder="请输入密码"></td>
                <td width="200px" id="errorPwd"></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;验证码：<input type="text" id="sign" placeholder="请输入验证码"/><br>&nbsp;&nbsp;&nbsp;
                    <img alt="验证码" id="imagecode" src="<%=request.getContextPath()%>/selectImage"/>&nbsp;&nbsp;&nbsp;
                    <a href="javascript:reloadCode();" style="color:darkgreen; font-size:17px; text-decoration:none;">看不清楚</a>
                </td>
                <td width="200px" id="errorSign"></td>
            </tr>
            <tr>
                <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" value="登录" width="40px" id="login1"/>
                    登录</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" value="忘记密码" with="40px" id="lost"/>
                    忘记密码</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button type="button" value="注册" with="40px" id="login2"/>
                    注册</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
