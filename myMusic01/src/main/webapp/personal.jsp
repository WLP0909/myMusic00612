<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/11
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <link rel="stylesheet" href="static/css/personal.css">
    <script type="text/javascript" src="static/js/jquery-3.2.1.js"></script>
    <title>个人中心页面</title>
    <style type="text/css">
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="header"  id="bigdiv">
        <div class="myInfo" id="myInfo">
            <div class="photo">
                <img class="img1" width="100px" height="100px"  src="static/img/${user.userPhoto}"/>
            </div>
            <div class="interest" id="interestNum">
                <a href="selectInterestInfo">关注</a> <e name="interestNum">${interest}&nbsp;&nbsp;|&nbsp;</e> <a href="selectToInterestInfo">粉丝</a> <e>${toInterest}</e>
            </div>
            <div class="info">
                昵 称： <e>${user.userName}</e><br />
                性 别: <e>${user.userSex}</e><br>
                年 龄： <e>${user.userAge}</e><br>
                个人签名：<input class="inputControl" type="text" name="userSign" value="${user.userSign}" />
            </div>
            <div class="rightInfo">
                <a href="per?id=${user.userId}">编辑资料</a> <e>|</e>
                <a href="First">返回首页</a>
            </div>
        </div>
        <!--中间部分我的音乐-->
        <div class="suggest1"></div>
        <div class="myMusic">
            <div class="button">
                <span>我的作品</span>
            </div>
            <%---------------------搜索部分-----------------------%>
            <div class="search_div">
                <form action="searchMyWork">
                    <input class="searchWork" type="text" id="key" name="key" placeholder="请输入您的作品名"/>
                    <input id="search" class="search_button" type="submit" value="搜索"/>
                </form>
            </div>
            <%----------------------作品列表----------------------%>
            <div class ="table_div">
                <table border="1px" cellspacing="0">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>歌曲</th>
                        <th>上传时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="data_body">
                    <c:if test="${works!=null && fn:length(works) > 0}">
                        <c:forEach items="${works}" var="list" varStatus="status">
                        <tr>
                            <td>${status.count} </td>
                            <td id="td1">${list.workName}</td>
                            <td>${list.worksDate}</td>
                            <td align="center">
                                <audio controls>
                                    <source src="${list.workAddress}" type="audio/mp3">
                                </audio><br>
                                <a id="deleteWorkById" href="deleteWorkById?workId=${list.workId}">删除</a>
                                &nbsp;&nbsp;&nbsp;<a id="shareWork" href="error/index.html">分享</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="suggest1"></div>
        <%-------------------------创作歌曲------------------------%>
        <div class="myCreate">
            <div class="button">
                <span>创作歌曲</span>
            </div>
            <div class="search_div">
                <form action="searchMyWork">
                    <input class="searchWork" type="text" id="key1" name="key" placeholder="请输入伴奏名"/>
                    <input id="search1" class="search_button" type="submit" value="搜索"/>
                </form>
            </div>
            <div class="works_div">
                <a href="recordMp3/index.html" target="_blank">录歌曲</a>
            </div>
        </div>
    </div>
</body>
</html>