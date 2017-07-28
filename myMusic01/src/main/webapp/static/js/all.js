$(document).ready(function () {
    $("#luser").blur(function () {
        var username = $("#luser").val();
        if(username == ""){
            $("#errorusername").html("用户名不能为空");
            $("#errorusername").css({"color":"red"})
        }else  if(username.length > 8){
            $("#errorusername").html("用户名长度不能大于8位");
            $("#errorusername").css({"color":"red"})
        } else if(0<username.length && username.length<8){
            $.ajax({
                url:"LSelectN?userName="+username,
                type:"post",
                success:function(data){
                    if(data > 0){
                        $("#errorusername").html("用户名已存在");
                        $("#errorusername").css({"color":"red"});
                    }else {
                        $("#errorusername").hide();
                    }
                }
            })
        } else {
            $("#errorusername").hide();
        }

    });

    $("#lpwd").blur(function () {
        var pattenpwd = /^[a-zA-Z0-9][\w]{5,17}$/;
        var pwd = $("#lpwd").val();
        if(pwd == ""){
            $("#errorpassword").html("密码不能为空");
            $("#errorpassword").css({"color":"red"})
        }else if(pwd.length < 6){
            $("#errorpassword").html("密码长度要大于6位");
            $("#errorpassword").css({"color":"red"})
        }else if(pwd.length > 16){
            $("#errorpassword").html("密码不能超过16位");
            $("#errorpassword").css({"color":"red"})
        }else if(!pattenpwd.test(pwd)){
            $("#errorpassword").html("密码应由字母数字组成");
            $("#errorpassword").css({"color":"red"})
        }else{
            $("#errorpassword").hide();
        }
    });
    $("#login2").click(function () {
        window.location.href="regist.jsp"
    })

    $("#First").click(function () {
        window.location.href="First"
    })

    $("#lrepwd").blur(function () {
        var repwd = $("#lrepwd").val();
        var pwd = $("#lpwd").val();
        if(repwd == ""){
            $("#errorrepwd").html("密码不能为空");
            $("#errorrepwd").css({"color":"red"})
        }else if(repwd != pwd){
            $("#errorrepwd").html("两次密码不一致");
            $("#errorrepwd").css({"color":"red"})
        }else {
            $("#errorrepwd").hide();
        }
    });


  $("#lphone").blur(function () {
      var phone = $("#lphone").val();
      var phone1 = /^1[0-9]{10}$/;
      $("#errorphone").show();
      if (phone.length == 0) {
          $("#errorphone").html("手机号不能为空");
          $("#errorphone").css({"color":"red"})
      }else if(!phone1.test(phone)) {
          $("#errorphone").html("手机号格式不正确");
          $("#errorphone").css({"color": "red"})
      }else if(phone1.test(phone) && phone.length != 0 ) {
          $.ajax({
              url:"LSelectP?phone="+phone,
              type:"post",
              success:function(data){
                  if(data > 0){
                      $("#errorphone").html("该手机号已经被注册");
                      $("#errorphone").css({"color":"red"});
                  }else {
                      $("#errorphone").hide();
                  }
              }
          })
      }else{
          $("#errorphone").hide();
      }
  });

  $("#sbumit1").click(function () {
      var luser = $("#luser").val();
      var lpwd  = $("#lpwd").val();
      var phone  = $("#lphone").val();
      var rpwd = $("#lrepwd").val();
      alert(luser+" " +lpwd+"  "+phone+" " +rpwd)
      if(luser != "" && lpwd != "" && phone != "" && rpwd != ""&&$("#errorphone").is(":hidden") &&$("#errorrepwd").is(":hidden")&&$("#errorpassword").is(":hidden") &&$("#errorusername").is(":hidden") ){
          $("#form1").submit();
      }else{
          alert("请完善您的信息");
      }
  });

  $("#login").click(function () {
      window.location.href="/myMusic/login.jsp"
  });

  $("#regist").click(function () {
       window.location.href="/myMusic/regist.jsp"
  });

  //登录验证
  $("#name").blur(function () {
       var pUser = $("input[type='radio']:checked").val();
       var name = $("#name").val();
       if(typeof(pUser) == "undefined"){
           alert("请选择您的身份");
       }else if(name == ""){
           $("#errorUser").html("用户名不能为空");
           $("#errorUser").css("color","red");
       }else if(name != "") {
           $.ajax({
               url: "LSelect?userName=" + name+"&pUser="+pUser+"",
               type: "post",
               success: function (data) {
                   if (data == "0") {
                       $("#errorUser").html("该用户不存在");
                       $("#errorUser").css("color", "red");
                   }else{
                       $("#errorUser").html("");
                       //更改头像
                   }
               }
           })
       }else {
           $("#errorUser").html("");
       }
    });


  $("#sign").blur(function () {
      var signWriter = $("#sign").val();
      $.ajax({
          url:"Vai?sign="+signWriter,
          type:"post",
          success:function (data) {
              if(data == "0"){
                  $("#errorSign").html("不能为空");
                  $("#errorSign").css("color", "red");
              } else if(data == "1"){
                  $("#errorSign").html("输入有误");
                  $("#errorSign").css("color", "red");
              }else{
                  $("#errorSign").html("");
              }
          }
      });

  });

  
  $("#login1").click(function () {
      var pUser = $("input[type='radio']:checked").val();
      var name = $("#name").val();
      var pwd = $("#pwd").val();
      var signv=$("#sign").val();
      if(pUser != "" && name != "" && pwd != "" && signv !="" && $("#errorSign").html()=="" ){
          $.ajax({
              url:"loginP?name=" + name+"&pUser="+pUser+"&pwd="+pwd,
              type:"post",
              success:function (data) {
                  if(data == "-1"){
                      alert("密码错误！");
                  }else{
                      alert("登录成功！");
                      //路径跳转！！！
                      window.location.href="/myMusic/First";
                  }
              }
          });
      }else{
          alert("请按要求填写！");
      }
  });


  //忘记密码
    $("#lost").click(function () {
       window.location.href="/myMusic/findPwd.jsp"
    });

    $("#writePwd").blur(function () {
        var pwd = $("#writePwd").val();
        if(pwd == "" && pwd.length > 16 && pwd.length <6){
            alert("密码不能为空，且长度在6-16位之间")
            return false;
        }
    });


    $("#getSign").click(function(){
        var phone =$("#lostPhone").val();
        if(phone != ""){
            $.ajax({
                url:"getMessage?phone="+phone,
                success:function(data){
                    alert("验证码已发送");
                    return false;
                }
            });
        }
    });

    $("#writeUser").blur(function () {
        var name = $("#writeUser").val();
        if(name != ""){
            $.ajax({
                url: "LSelect?userName=" + name+"&pUser="+"普通用户",
                type: "post",
                success: function (data) {
                    if (data == "0") {
                       alert("该用户不存在");
                       $("#writeUser").val("");
                    }
                }
            })
        } else {
            alert("请输入用户名");
            return false;
        }
    });

//验证修改密码时
    $("#lostPhone").blur(function () {
        var phone = $("#lostPhone").val();
        var name = $("#writeUser").val();
            if (phone != "") {
                $.ajax({
                    url: "LSelectPN?phone=" + phone + "&userName=" + name,
                    type: "post",
                    success: function (data) {
                        if (data == "-1") {
                            alert("手机号错误");
                            $("#lostPhone").val("");
                            //$("#getSign").disabled();
                        }else{
                            $("#getSign").removeAttr("disabled");
                        }
                    }
                })
            } else {
                alert("请输入手机号");
                return false;
            }
    });

//验证码
    $("#newSign").blur(function () {
        var newsing = $("#newSign").val();
        if(newsing != ""){
            $.ajax({
                url:"testSign?newSign="+newsing,
                type:"post",
                success:function (data) {
                    if(data == "1")
                        alert("验证码输入有误");
                        return false;
                    $("newSign").val("");
                }
            })
        } else {
            alert("验证码不能为空");
            return false;
        }

    });

     //保存按钮事件
    $("#save").click(function () {
        var phone = $("#lostPhone").val();
        var userName = $("#writeUser").val();
        var newSign=$("#newSign").val();
        var password=$("#writePwd").val();
        if(phone != "" && userName !="" && newSign!="" && password !=""){
            $.ajax({
                url:"alterPwd?password="+password+"&userName="+userName,
                type:"post",
                success:function (data) {
                    alert(data);
                    if(data == "1"){
                        alert("密码修改成功");
                        return false;
                    }else{
                        alert("稍等一下 正忙");
                        return false;
                    }
                }
            });
            window.location.href="/myMusic/login.jsp";
            //提交后台，只需要验证验证码即可，通过后更新数据库，通不过的话，给出提示
        }else{
            alert("请按要求输入");
            return false;
        }
    });

});