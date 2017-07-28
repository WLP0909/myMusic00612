<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/14
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>好友中心</title>
    <link type="text/css" rel="stylesheet" href="static/css/personal.css" >
</head>
<body>
<div class="header"  id="bigdiv">
    <div class="myInfo" id="myInfo">
        <div class="photo">
            <img class="img1" width="100px" height="100px"  src="static/img/${user.userPhoto}"/>
        </div>
        <div class="interest" id="interestNum">
            <a href="interest.jsp">关注</a> <e name="interestNum">${interest}&nbsp;&nbsp;|&nbsp;</e> <a href="toInterest.jsp">粉丝</a> <e>${toInterest}</e>
        </div>
        <div class="info">
            昵 称： <e>${user.userName}</e><br />
            性 别: <e>${user.userSex}</e><br>
            年 龄： <e>${user.userAge}</e><br>
            个人签名：<input class="inputControl" type="text" name="userSign" value="${user.userSign}" />
        </div>
        <div class="rightInfo">
            <a>编辑资料</a> <e>|</e>
            <a>退出</a>
        </div>
    </div>
    <!--中间部分我的音乐-->
    <div class="suggest1"></div>
    <div class="myMusic">
        <div class="button">
            <span>好友作品</span>
        </div>
        <%---------------------搜索部分-----------------------%>
        <div class="search_div">
            <form >
                <input class="searchWork" type="text" id="key" name="key" placeholder="请输入您的作品名"/>
                <input id="search" class="search_button" type="submit" value="搜索"/>
            </form>
        </div>
        <%----------------------作品列表----------------------%>
        <div class="table_div">
            <table border="1px" cellspacing="0">
                <tr>
                    <th>序号</th>
                    <th>歌曲</th>
                    <th>时长</th>
                    <th>上传时间</th>
                    <th>操作</th>
                </tr>
                <c:if test="${works!=null && fn:length(works) > 0}">
                    <c:forEach items="${works}" var="list" varStatus="status">
                        <tr>
                            <td>${status.count} </td>     <!--遍历计数-->
                            <td>${list.workName}</td>
                            <td>${list.time}</td>
                            <td>${list.worksDate}</td>
                            <td align="center">
                                <a href="error/index.html"><img  style="height: 30px;width: 30px" class="imgRadio" src="error/index.html" /></a>
                                &nbsp;&nbsp;&nbsp;<a id="deleteWork" href="deleteWork">删除</a>
                                &nbsp;&nbsp;&nbsp;<a id="shareWork" href="shareWork">分享</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </div>
</div>
</body>
</html>
