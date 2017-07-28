
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>搜索歌曲展示</title>
    <link rel="stylesheet" type="text/css" href="static/css/musicshow.css">
</head>
<body style="background-image: url(static/img/L4.jpg);background-size: 100% 100%;background-repeat: no-repeat">
    <div>
        <div id="ldiv4">
            <table cellspacing="5px" cellpadding="10px">
                <c:forEach items="${works}" var="work">
                    <tr>
                        <td>${work.workName}</td>
                        <td>${work.userName}</td>
                        <td>${work.worksDate}</td>
                        <td>${work.good}</td>
                        <td><audio controls>
                            <source src="${work.workAddress}" type="audio/mp3">
                        </audio></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
