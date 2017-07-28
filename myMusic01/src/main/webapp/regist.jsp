<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: God汐Like彡
  Date: 2017/7/9
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="/myMusic/static/css/regist.css" type="text/css">
    <script type="text/javascript" src="/myMusic/static/js/jquery-3.2.1.js"></script>
    <script src="/myMusic/static/js/all.js" type="text/javascript"></script>
    <script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
    <script src="/myMusic/static/js/supersized.3.2.7.min.js" type="text/javascript"></script>
    <script src="/myMusic/static/js/supersized-init.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/myMusic/static/css/supersized.css">
    <link rel="stylesheet" href="/myMusic/static/css/style.css">
</head>
<body>
    <div id="ldiv1">
        <form  id="form1" action="Linsert" method="post">
            <table>
                <tr><td style="text-align: center"><img src="/myMusic/static/img/Logo.jpg" class="Limage1"></td></tr>
                <tr>
                    <td>用户名：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="请输入用户名" id="luser" name="userName"></td>
                    <td width="200px" id="errorusername"></td>
                </tr>
                <tr>
                    <td>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" placeholder="请输入密码" id="lpwd" name="password"/></td>
                    <td id="errorpassword"></td>
                </tr>
                <tr>
                    <td>确认密码：<input type="password" placeholder="请再次输入密码" id="lrepwd"/></td>
                    <td  width="200px" id="errorrepwd"></td>
                </tr>
                <tr>
                    <td>
                        性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="男" name="userSex" style="width: 10px" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" value="女" name="userSex" style="width: 10px" />女
                    </td>
                    <td id="sex" width="200px"></td>
                </tr>
                <tr>
                    <td>手机号：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="lphone" name="userPhone"/></td>
                    <td id="errorphone" width="200px"></td>
                </tr>
                <tr>
                    <td>地区：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address"/></td>
                    <td id="local" width="200px"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        &nbsp;&nbsp;&nbsp;&nbsp;<button type="button" value="提交" id="sbumit1">提交</button>&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="reset" value="重置"/>重置</button>&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="button" id="First" value="返回"/>返回</button>
                    </td>
                </tr>
            </table>
        </form>
        <div class="connect">
            <p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>&nbsp;&nbsp;&nbsp;&nbsp;
            <p style="margin-top:10px;">如果只是遇见，不能停留，不如不遇见。</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </div>
</div>
<script>
    window.onload = function(){
        $(".connect p").eq(0).animate({"left":"0%"}, 800);
        $(".connect p").eq(1).animate({"left":"0%"}, 500);
    }
</script>
</body>
</html>
