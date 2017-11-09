<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/17
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录--网络舆情影响传播算法测评与分析平台</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../dist/theme-css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="../bower_components/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#"><b>网络舆情影响传播算法测评与分析平台</b></a>
    </div>
    <!-- 登录框 -->
    <div class="login-box-body">
        <form action="../doLogin.action" method="post">
            <div>${INFO}</div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" name="user.username" placeholder="账号" id="userName" onkeyup="validate()">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                <div>
                    <p id = "msgUN" style="font-size: 10px;"></p>
                </div>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="user.password" placeholder="Password" id="userPwd" onkeyup="validate()">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <div>
                    <p id = "msgPwd" style="font-size: 10px;"></p>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> 记住密码
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat" id="loginBtn">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>
        <div class="row">
            <div class="col-xs-8">
                <a href="#">忘记密码</a><br>
            </div>
            <div class="col-xs-4">
                <a type="button" href="/JSP/register.jsp" class="btn btn-primary btn-block btn-flat">注册</a>
            </div>
        </div>



    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../bower_components/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
    function validate(){
        var userName = document.getElementById("userName").value;
        var userPwd = document.getElementById("userPwd").value;

        var usern = /^[a-zA-Z0-9_]{1,}$/;

        //用户名为空时
        if (userName == "" ){
            document.getElementById("msgUN").innerHTML="<font color='red'>用户名不能为空！</font>";
            document.getElementById("loginBtn").disabled = true;
            userName.value = '';
            userName.focus();
        }//用户名不为空但用户名格式错误时
        else if (!userName.match(usern)) {
            document.getElementById("msgUN").innerHTML="<font color='red'>用户名只能输入字母、数字、下划线</font>";
            document.getElementById("loginBtn").disabled = true;
            userName.value = '';
            userName.focus();
        }//用户名不为空且格式正确时
        else{
            document.getElementById("msgUN").innerHTML="<font color='green'></font>";
            document.getElementById("loginBtn").disabled = false;
        }
        //密码为空时
        if(userPwd == ""){
            document.getElementById("msgPwd").innerHTML="<font color='red'>密码不能为空！</font>";
            document.getElementById("loginBtn").disabled = true;
            userPwd.value = '';
            userPwd.focus();
        }//密码不为空时
        else{
            document.getElementById("msgPwd").innerHTML="<font color='green'></font>";
            document.getElementById("loginBtn").disabled = false;
        }
    }
</script>
</body>
</html>