<%@ page import="domain.StarMusic" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  user.User: chengzhi
  Date: 2017/7/11
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="keywords" content="html5,css3,javascript,音乐,音乐播放器,audio">
    <meta name="description" content="一款基于HTML5、Css3的列表式音乐播放器，包含列表，音量，进度，时间以及模式等功能，不依赖任何库">
    <meta name="viewport" content="width=device-width, initial-scale=1, user.User-scalable=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, user.User-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="version" content="1.0.0">

    <link rel="stylesheet" href="static/css/smusic.css"/>
    <title>音乐播放MyMusic</title>
</head>
<body>
<div>
    <input type="text" id="id" value="<%=request.getParameter("id")%>" style="display: none"><br>
    <a href="First" style="text-decoration: none;color: #2e8ded">返回首页</a>
</div>
<div class="grid-music-container f-usn">
    <div class="m-music-play-wrap">
        <div class="u-cover"></div>
        <div class="m-now-info">
            <h1 class="u-music-title"><strong>标题</strong>
                <small>歌手</small>
            </h1>
            <div class="m-now-controls">
                <div class="u-control u-process">
                    <span class="buffer-process"></span>
                    <span class="current-process"></span>
                </div>
                <div class="u-control u-time">00:00/00:00</div>
                <div class="u-control u-volume">
                    <div class="volume-process" data-volume="0.50">
                        <span class="volume-current"></span>
                        <span class="volume-bar"></span>
                        <span class="volume-event"></span>
                    </div>
                    <a class="volume-control"></a>
                </div>
            </div>
            <div class="m-play-controls">
                <a class="u-play-btn prev" title="上一曲"></a>
                <a class="u-play-btn ctrl-play play" title="暂停"></a>
                <a class="u-play-btn next" title="下一曲"></a>
                <a class="u-play-btn mode mode-list current" title="列表循环"></a>
                <a class="u-play-btn mode mode-random" title="随机播放"></a>
                <a class="u-play-btn mode mode-single" title="单曲循环"></a>
            </div>
        </div>
    </div>
    <div class="f-cb">&nbsp;</div>
    <div class="m-music-list-wrap"></div>
    <div class="m-music-lyric-wrap">
        <div class="inner">
            <ul class="js-music-lyric-content">
                <li class="eof">暂无歌词...</li>
            </ul>
        </div>
    </div>
</div>

<script type="text/javascript" src="static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="static/js/jquery.validate.js"></script>
<script type="text/javascript" src="static/js/layer/layer.js"></script>
<%--<script>--%>
<%--var musicList = [--%>
<%--{--%>
<%--<c:forEach items="${list}" var="list">--%>
<%--&lt;%&ndash;<%--%>
<%--List<StarMusic> starMusic = (List<StarMusic>) request.getAttribute("musicList");--%>
<%--for (StarMusic music:starMusic){--%>
<%--System.out.println(music.getStarName());--%>
<%--}--%>
<%--%>&ndash;%&gt;--%>
<%--<c:out value="${list.starName}" />--%>
<%--<c:out value="${list.starMusicName}" />--%>
<%--title  : ${list.starMusicName},--%>
<%--singer : console.log(${list.starName}),--%>
<%--cover  :"static/image/${list.starPhoto}",--%>
<%--src    : console.log("static/music/${list.starMusicAddress}"),--%>
<%--lyric  : console.log("static/lrc/${list.starLyrics}")--%>
<%--</c:forEach>--%>
<%--}--%>
<%--];--%>
<%--</script>--%>
<script src="static/js/smusic.js"></script>
<script>
    $().ready(function () {
        var id = $("#id").val();
        $.ajax(
            {
                data: {
                    id: 'id',
                }
            }
        )
        $.getJSON('/myMusic/selectMusic', {"id": id}, function (data) {
            var musicList = [];
            var str = eval(data);
            for (var i = 0; i < str.length; i++) {
                musicList.push(
                {
                    title: str[i].starMusicName,
                    singer: str[i].starName,
                    cover: str[i].starPhoto,
                    src: str[i].starMusicAddress,
                    lyric: str[i].starLyrics,
                })
            }
            new SMusic({
                musicList: musicList,
                autoPlay: true,  //是否自动播放
                defaultMode: 1,   //默认播放模式，随机
                callback: function (obj) {  //返回当前播放歌曲信息
                    console.log(obj);
                    /*{title: "赤血长殷", singer: "王凯", cover: "http://data.smohan.net/upload/other/cxcy/cover.jpg", src: "http://data.smohan.net/upload/other/cxcy/music.mp3", index: 4}*/
                }
            });
        });
    });
</script>

</body>
</html>
