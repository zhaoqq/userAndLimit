<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/16
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>注册--网络舆情影响传播算法测评与分析平台</title>
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
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="#"><b>注册</b></a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">填写用户信息</p>

        <form action="../doRegister.action" method="post">
            <div>${requestScope.USERNAME}</div>
            <div class="form-group has-feedback">
                <input type="hidden" name="user.level" value="10" />
                <input type="text" class="form-control" placeholder="${requestScope.USERNAME}" name="user.username" placeholder="用户名" id="userName" onkeyup="validateUN()">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                <div>
                    <p id = "msgUN" style="font-size: 10px;"></p>
                </div>
            </div>
            <div class="form-group has-feedback">
                <input type="email" class="form-control" name="user.email" placeholder="邮箱">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="user.password" placeholder="密码" id="pwd1" onkeyup="validatePwd()">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <div>
                    <p id = "msgPwd1" style="font-size: 10px;"></p>
                </div>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" name="password" placeholder="确认密码" id="pwd2" onkeyup="validatePwd()">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                <div>
                    <p id = "msgPwd2" style="font-size: 10px;"></p>
                </div>
            </div>
            <div class="form-group has-feedback">
                <textarea class="form-control" rows="3" name="user.comment" placeholder="输入描述"></textarea>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <a href="${pageContext.request.contextPath}/JSP/login.jsp" class="text-center">已有账号跳转登录</a>
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat" id="regBtn">注册</button>
                </div>
            </div>
        </form>

    </div>

</div>


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

    function validatePwd() {
        var pwd1 = document.getElementById("pwd1").value;
        var pwd2 = document.getElementById("pwd2").value;

        <!-- 对比两次输入的密码 -->
        if(pwd1 == pwd2) {
            if(pwd1 == ""){
                document.getElementById("msgPwd1").innerHTML="<font color='red'>密码不能为空！</font>";
                document.getElementById("msgPwd2").innerHTML="<font color='red'>密码不能为空！</font>";
                document.getElementById("regBtn").disabled = true;
                pwd1.value = '';
                pwd1.focus();
                pwd2.value = '';
                pwd2.focus();
            }
            else{
                document.getElementById("msgPwd1").innerHTML="<font color='red'></font>";
                document.getElementById("msgPwd2").innerHTML="<font color='green'>两次输入密码相同</font>";
                document.getElementById("regBtn").disabled = false;
            }
        }
        else {
            document.getElementById("msgPwd2").innerHTML="<font color='red'>两次密码不相同</font>";
            document.getElementById("regBtn").disabled = true;
            pwd1.value = '';
            pwd1.focus();
            pwd2.value = '';
            pwd2.focus();
        }
    }
    function validateUN(){
        var userName = document.getElementById("userName").value;
        var usern = /^[a-zA-Z0-9_]{1,}$/;

        if (userName == ""){
            document.getElementById("msgUN").innerHTML="<font color='red'>用户名不能为空！</font>";
            document.getElementById("regBtn").disabled = true;
            userName.value = '';
            userName.focus();
        }
        if (!userName.match(usern)) {
            document.getElementById("msgUN").innerHTML="<font color='red'>用户名只能输入字母、数字、下划线</font>";
            document.getElementById("regBtn").disabled = true;
            userName.value = '';
            userName.focus();
        }
        else{
            document.getElementById("msgUN").innerHTML="<font color='green'>用户名输入正确！</font>";
            document.getElementById("regBtn").disabled = false;
        }
    }
</script>
</body>
</html>

