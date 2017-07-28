<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/12
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>我的粉丝</title>
    <link href="static/css/toInterest.css" type="text/css"  rel="stylesheet"/>
    <script type="text/javascript" src="static/js/jquery-latest.js"></script>
</head>
<body>
<div class="slider" >
    <%--标题--%>
    <div class="top_div">
        <h2>我的粉丝</h2>
    </div>
    <div class="return">
        <a href="personal">返回个人中心</a>
    </div>
    <%--内容--%>
    <div class="suggest1"></div>
        <div class="container">
            <ul class="display">
                <c:if test="${toInterest != null && fn:length(toInterest)> 0}">
                    <c:forEach items="${toInterest}" var="toInterest">
                        <li>
                            <div class="content_block">
                                <a href="LookPersonal?userName=${toInterest.userName}"><img style="width: 150px; height: 150px; border-radius: 50%" src="static/img/${toInterest.userPhoto}" alt="" /></a>
                                <div class="info">
                                    <a>昵称:</a> <e>${toInterest.userName}</e> <br />
                                    <a>年龄：</a> <e>${toInterest.userAge}</e> <br />
                                    <a>性别：</a> <e>${toInterest.userSex}</e><br>
                                    <a>地区：</a> <e>${toInterest.address}</e><br>
                                    <a>个性签名：</a><e>${toInterest.userSign}</e>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
</div>
</body>
</html>