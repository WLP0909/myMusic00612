<%--
  Created by IntelliJ IDEA.
  User: WLP
  Date: 2017/7/13
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>歌曲列表</title>
    <link rel="stylesheet" href="static/css/W_list.css">
    <script type="text/javascript" src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/style.js"></script>
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
<div class="nav">
    <div class="nav_li">
        <div id="logoImg">
            <img src="static/img/Logo.jpg">
        </div>
        <ul>
            <li><a href="personal" id="showUser">个人动态</a></li>
            <li><a href="Near" id="showNear">附近的人</a></li>
            <li><a href="First" id="showSuggest">网站首页</a></li>
        </ul>
    </div>
    <div class="log">
        <a href="login.jsp">登录</a>&nbsp;&nbsp;<a href="regist.jsp">注册</a>
    </div>
</div>
<c:if test="${not empty bestMusic}">
    <div id="listAll">
        <div id="month">
            <table cellspacing="0">
                <tr>
                    <td align="center">本月好歌榜</td>
                </tr>
                <tr>
                    <th>序号</th>
                    <th>歌曲</th>
                    <th>歌手</th>
                    <th>时长</th>
                </tr>
                <c:forEach items="${bestMusic}" var="listUserMusic" varStatus="status">
                    <c:set var="id" value="4"></c:set>
                    <tr>
                        <td>${status.count}</td>
                        <td><a href="userMusic.jsp?id=${id}">${listUserMusic.workName}</a></td>
                        <td>${listUserMusic.userName}</td>
                        <td>${listUserMusic.time}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="history">
            <table cellspacing="0">
                <tr>
                    <td align="center">历史好歌榜</td>
                </tr>
                <tr>
                    <th>序号</th>
                    <th>歌曲</th>
                    <th>歌手</th>
                    <th>时长</th>
                </tr>
                <c:forEach items="${historyMusic}" var="listHistory" varStatus="status">
                    <c:set var="id" value="5"></c:set>
                    <tr>
                        <td>${status.count}</td>
                        <td><a href="userMusic.jsp?id=${id}">${listHistory.workName}</a></td>
                        <td>${listHistory.userName}</td>
                        <td>${listHistory.time}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="starBest">
            <table cellspacing="0">
                <tr>
                    <td align="center">明星好歌榜</td>
                </tr>
                <tr>
                    <th>序号</th>
                    <th>歌曲</th>
                    <th>歌手</th>
                </tr>
                <c:forEach items="${listStarMusic}" var="listStar" varStatus="status">
                    <c:set var="id" value="2"></c:set>
                    <tr>
                        <td>${status.count}</td>
                        <td><a href="music.jsp?id=${id}">${listStar.starMusicName}</a></td>
                        <td>${listStar.starName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <br>
</c:if>

<c:if test="${not empty workMusics}">
    <div id="userSuggest">
        <ul>
            <c:forEach items="${workMusics}" var="works">
                <c:set var="id" value="3"></c:set>
                <li class="photo1">
                    <div class="box">
                        <div class="box1">
                            <img src="static/img/${works.photo}">
                        </div>
                        <div class="box2"><a href="userMusic.jsp?id=${id}"><img src="static/img/W12.png" alt="点我播放"></a>
                        </div>
                    </div>
                    <a href="LookPersonal?userName=${works.userName}">歌手：${works.userName}</a><br>
                    <a href="userMusic.jsp?id=${id}">歌曲：${works.workName}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</c:if>
<c:if test="${not empty starMusics}">
    <div id="starSuggest">
        <ul>
            <c:forEach items="${starMusics}" var="m" varStatus="status">
                <c:set var="id" value="1">
                </c:set>
                <li class="photo1">
                    <div class="box">
                        <div class="box1">
                            <img src="static/img/${m.starPhoto}">
                        </div>
                        <div class="box2"><a href="music.jsp?id=${id}"><img src="static/img/W12.png" alt="点我播放"></a>
                        </div>
                    </div>
                    <e style="color: white;font-size: 10px">歌手：${m.starName}</e>
                    <br>
                    <a href="music.jsp?id=${id}">歌曲：${m.starMusicName}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</c:if>

</body>
</html>
