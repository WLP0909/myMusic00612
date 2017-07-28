
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>div</title>
    <link rel="stylesheet" href="static/css/sech.css">
    <script type="text/javascript" src="static/js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script type="text/javascript">
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
<body>
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
</body>
</html>
