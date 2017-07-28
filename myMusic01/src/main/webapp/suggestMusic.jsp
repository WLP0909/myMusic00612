<%--
  Created by IntelliJ IDEA.
  User: WLP
  Date: 2017/7/10
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页推荐歌曲</title>
    <link rel="stylesheet" href="static/css/W_css.css">
    <script type="text/javascript" src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src='static/js/style.js'></script>
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="static/css/hexagons.css" type="text/css">
    <script type="text/javascript" href="static/js/jquery.validate.js"></script>
    <script type="text/javascript" href="static/js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" type="text/css" href="static/css/css.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/ZoomPic.js"></script>
    <link rel="stylesheet" href="static/css/sech.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script type="text/javascript" src="static/js/audio.min.js"></script>
    <link type="text/css" rel="stylesheet" href="static/css/demo.css">
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script src="https://api.map.baidu.com/geocoder/v2/?ak=W5ydDYtL0ZTnxZSn2ZxqA4BhneNCQclo&callback=renderReverse&location=39.983424,116.322987&output=xml&pois=1" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            new ZoomPic("jswbox");
        });

        $(document).ready(function () {
            $(".sechs").keyup(function () {
                var sech1 = $("#text").val();
                $("#table1 tr:gt(0)").remove(); //除了第一个之外的都清除
                $.getJSON('sechMu',{"sech":sech1},function (data) {
                    for(var i = 0; i<data.length; i++) {
                        $("#table1").append("<tr><td class='td'>"+data[i]+"</td></tr>")
                        addClickEvent();
                    }
                })
            });
            $("#submit1").click(function(){
                var str = $(".sechs").val();
                str= str.replace(/\s/g,"");
                if(str != null && str != ""){
                    window.location.href="/myMusic/sechShow?str="+str;
                }
            });
        });
        function addClickEvent() {
            $(".td").click(function () {
                var valueS=($(this).parents("tr").find("td").text());
                $(".sechs").val(valueS);
                $("#table1 tr:gt(0)").remove();
            });
        }
    </script>
</head>
<%-------------------------首页头部------------------------------------%>
<body>

<div class="nav">
    <div class="nav_li">
        <div id="logoImg">
            <img src="static/img/Logo.jpg">
        </div>
        <ul>
            <li><a href="UserCenter" id="showUser">个人动态</a></li>
            <li><a href="Near" id="showNear">附近的人</a></li>
            <li><a href="First" id="showSuggest">网站首页</a></li>
        </ul>
    </div>
    <div class="log">
        <c:if test="${not empty userName}"><e class="word">${userName}</e></c:if>
        <a href="login.jsp"><c:if test="${empty userName}">登录|注册</c:if></a>&nbsp;&nbsp;
        <a href="personal">个人中心</a>
    </div>
</div>
<%-------------------------------推荐歌曲---------------------------------%>
<div>
    <div class="search d1">
        <form>
            <table id="table1">
                <tr>
                    <td>
                        <input type="text" placeholder="好歌从这里开始..." class="sechs" id="text">
                        <button type="button" id="submit1"></button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="div1">
    </div>
</div>
<div id="body2">
    <c:if test="${not empty workMusics}">
        <div id="jswbox" style="position:relative;left:60px;border-top: 40px;margin-top: -30px">
            <pre class="prev">prev</pre>
            <pre class="next">next</pre>
            <ul style="padding-top: -30px">
                <li class="lunbo"><a href="aboutUs.jsp" target="_blank"><img src="static/img/L8.jpg" id="img1"/></a></li>
                <li class="lunbo"><img src="static/img/L12.jpg" id="img2"/></li>
                <li class="lunbo"><img src="static/img/L18.jpg" id="img3"/></li>
                <li class="lunbo"><img src="static/img/L10.jpg" id="img4"/></li>
                <li class="lunbo"><img src="static/img/L14.jpg" id="img5"/></li>
            </ul>
        </div>
        <div id="suggestAll" style="display: block" >
            <div class="suggest1">
                <e class="word">好歌推送</e>
                <span class="more"><a href="userMore">更多>></a></span>
            </div>
            <div id="user">
                <div id="userSuggest">
                    <ul>
                        <c:set var="id" value="3"></c:set>
                        <c:forEach items="${workMusics}" var="works" end="7">
                            <li class="photo1">
                                <div class="box">
                                    <div class="box1">
                                        <img src="static/img/${works.photo}">
                                    </div>
                                    <div class="box2"><a href="userMusic.jsp?id=${id}"><img src="static/img/W12.png" alt="点我播放"></a></div>
                                </div>
                                <a href="LookPersonal?userName=${works.userName}">歌手：${works.userName}</a><br>
                                <a href="userMusic.jsp?id=${id}">歌曲：${works.workName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div id="bestList">
                    <e class="word">本月高分榜</e>
                    <ol type="1" class="list">
                        <c:forEach items="${bestMusic}" var="b" end="6" varStatus="status">
                            <c:set var="id" value="4"></c:set>
                            <li>
                                <a href="userMusic.jsp?id=${id}">${b.workName}</a>
                            </li>
                        </c:forEach>
                    </ol>
                    <span class="clickMore"><a href="List.jsp">查看更多>></a></span><br>
                    <e class="word">历史高分榜</e>
                    <ol type="1" class="list1">
                        <c:forEach items="${historyMusic}" var="h" end="6" varStatus="status">
                            <c:set var="id" value="5"></c:set>
                            <li>
                                <a href="userMusic.jsp?id=${id}">${h.workName}</a>
                            </li>
                        </c:forEach>
                    </ol>
                    <span class="clickMore"><a href="List.jsp">查看更多>></a></span>
                </div>
            </div>

            <div class="suggest2">
                <e class="word">新歌推送</e>
                <span class="more"><a href="starMore">更多>></a></span>
            </div>
            <div id="star">
                <div id="starSuggest">
                    <ul>
                        <c:forEach items="${starMusics}" var="m" end="3" varStatus="status">
                        <c:set var="id" value="1">
                        </c:set>
                            <li class="photo1">
                                <div class="box">
                                    <div class="box1">
                                        <img src="static/img/${m.starPhoto}">
                                    </div>
                                    <div class="box2"><a href="music.jsp?id=${id}"><img src="static/img/W12.png" alt="点我播放"></a></div>
                                </div>
                                <e style="color: white;font-size: 10px">歌手：${m.starName}</e><br>
                                <a href="music.jsp?id=${id}">歌曲：${m.starMusicName}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div id="listMusic">
                    <e class="word">高分榜</e>
                    <ol class="list" type="1">
                        <c:forEach items="${listStarMusic}" var="listStar" end="5" varStatus="status">
                        <c:set var="id" value="2">
                        </c:set>
                            <li>
                                <a href="music.jsp?id=${id}">${listStar.starMusicName}</a>
                            </li>
                        </c:forEach>
                    </ol>
                    <span class="clickMore"><a href="List.jsp">查看更多>></a></span>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${not empty users}">
        <div id="nearUser" style="display: block">
            <div style="text-align:center;clear:both;"> </div>
                <ul id="hexGrid">
                    <c:forEach items="${users}" var="user">
                        <li class="hex">
                            <a href="LookPersonal?userName=${user.userName}" class="hexIn"><img src="static/img/${user.userPhoto}">
                                <h1>歌手：${user.userName}</h1>
                                <p>地区：${user.address}</p></a>
                        </li>
                    </c:forEach>
                </ul>
        </div>
    </c:if>
    <c:if test="${not empty generals}">
        <div id="showMusic">
            <c:forEach items="${generals}" var="general" end="0">
                <div class="W_gener" >
                    <a href="LookPersonal?userName=${general.userName}"><img src="static/img/${general.userPhoto}"></a>
                    <e class="word">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${general.userSign}</e>
                </div>
                <c:forEach items="${worksMusic}" var="works" end="0">
                    <div class="gen_music">
                        <img src="static/img/${works.photo}">
                        &nbsp;&nbsp;&nbsp;&nbsp;<e style="color: orangered">${works.workName}</e>&nbsp;&nbsp;
                    <c:forEach items="${goodNum}" var="num" end="0">
                        <div class="praise">
                            <span id="praise1"><img  src="static/img/yizan.png" id="praise-img1" /></span>
                            <span id="praise-txt1" style="float: left">${num}</span>
                            <span id="add-num1"><em>+1</em></span>
                        </div>
                    </c:forEach>
                        <audio  src="${works.workAddress}" preload="none"></audio>
                    </div><br>
                </c:forEach>

                <c:forEach items="${worksMusic}" var="works" begin="1" end="1">
                    <div class="gen_music">
                        <img src="static/img/${works.photo}">
                        &nbsp;&nbsp;&nbsp;&nbsp;<e style="color: orangered">${works.workName}</e>&nbsp;&nbsp;
                        <c:forEach items="${goodNum}" var="num" begin="1">
                            <div class="praise">
                                <span id="praise"><img src="static/img/yizan.png" id="praise-img" /></span>
                                <span id="praise-txt" style="float: left">${num}</span>
                                <span id="add-num"><em>+1</em></span>
                            </div>
                        </c:forEach>
                        <audio  src="${works.workAddress}" preload="none"></audio>
                    </div><br>
                </c:forEach>
            </c:forEach>
        </div>
    </c:if>
</div>
<script>
    audiojs.events.ready(function() {
        audiojs.createAll();
    });
    /* @author:Romey
     * 动态点赞
     * 此效果包含css3，部分浏览器不兼容（如：IE10以下的版本）
     */
    $(function(){
        $("#praise").click(function(){
            var praise_img = $("#praise-img");
            var text_box = $("#add-num");
            var praise_txt = $("#praise-txt");
            var num=parseInt(praise_txt.text());
            if(praise_img.attr("src").isEqual("static/img/yizan.png")){
                $(this).html("<img src='static/img/zan.png' id='praise-img' class='animation' />");
                praise_txt.removeClass("hover");
                text_box.show().html("<em class='add-animation'>-1</em>");
                $(".add-animation").removeClass("hover");
                num -=1;
                praise_txt.text(num)
            }else{
                $(this).html("<img src='static/img/yizan.png' id='praise-img' class='animation' />");
                praise_txt.addClass("hover");
                text_box.show().html("<em class='add-animation'>+1</em>");
                $(".add-animation").addClass("hover");
                num +=1;
                praise_txt.text(num)
            }
        });
    })
    $(function(){
        $("#praise1").click(function(){
            var praise_img = $("#praise-img1");
            var text_box = $("#add-num1");
            var praise_txt = $("#praise-txt1");
            var num=parseInt(praise_txt.text());
            if(praise_img.attr("src").isEqual("static/img/yizan.png")){
                $(this).html("<img src='static/img/zan.png' id='praise-img' class='animation' />");
                praise_txt.removeClass("hover");
                text_box.show().html("<em class='add-animation'>-1</em>");
                $(".add-animation").removeClass("hover");
                num -=1;
                praise_txt.text(num)
            }else{
                $(this).html("<img src='static/img/yizan.png' id='praise-img' class='animation' />");
                praise_txt.addClass("hover");
                text_box.show().html("<em class='add-animation'>+1</em>");
                $(".add-animation").addClass("hover");
                num +=1;
                praise_txt.text(num)
            }
        });
    })
</script>
</body>
</html>
