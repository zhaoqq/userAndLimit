<%--
  Created by IntelliJ IDEA.
  User: zqq
  Date: 2017/11/2
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>编辑权限信息</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="../../bower_components/select2/dist/css/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/theme-css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../dist/theme-css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="../../dist/my-css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- 顶部导航条 -->
    <header class="main-header">
        <!-- Logo -->
        <a href="#" class="logo">
            <span class="logo-lg">网络舆情影响传播算法测评与分析平台</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation" id="myheaer">
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">

                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span>${CurrentUser.getUsername()}</span>
                            <i class="fa fa-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <p>管理员</p>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">个人信息</a>
                                </div>
                                <div class="pull-right">
                                    <a href="doLogout.action" class="btn btn-default btn-flat">退出登录</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!--左侧SideBar -->
    <aside class="main-sidebar">

        <section class="sidebar">
            <!-- 菜单 -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">HEADER</li>
                <!-- Optionally, you can add icons to the links -->
                <li class="active treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>用户管理</span>
                        <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="doShowAll.action">用户管理</a></li>
                        <li><a href="doShowAllRole.action">角色管理</a></li>
                        <li><a href="doShowAllLimit.action">权限管理</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>算法管理</span>
                        <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../algo/algoManage.html">算法信息管理</a></li>
                        <li><a href="#">查看算法</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>数据管理</span>
                        <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../dataset/dataManage.html">数据集管理</a></li>
                        <li><a href="#">查看数据集</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>影响分析</span>
                        <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../influence/people_influence.html">影响力人物分析</a></li>
                        <li><a href="../influence/trend_influence.html">影响过程分析</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>事件分析</span>
                        <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../analysis/case_analysis.html">案例分析</a></li>
                        <li><a href="../analysis/new_case_analysis.html">新事件分析</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                添加权限信息
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>系统管理</a></li>
                <li class="active">编辑权限信息</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">基本权限信息</h3>
                </div>
                <!-- /.box-header -->
                <form role="form" action="doAddLimit.action" method="post">
                    <div class="box-body" style="height: 400px;">
                        <div class="row">
                            <div class="col-md-6">
                                <%--<input type="hidden" name="id" value="<s:property value="#request.id" />">--%>
                                <%--<input type="hidden" name="role.id" value="${Role_Access.id}" />--%>
                                <div class="form-group">
                                    <label>权限名</label>
                                    <%--<input type="text" class="form-control" placeholder="输入权限名">--%>
                                    <s:textfield cssClass="form-control" name="limit.name"
                                                 placeholder="%{LIMITNAME}"></s:textfield>
                                </div>


                                <div class="form-group">
                                    <label>权限描述</label>
                                    <%--<textarea class="form-control" rows="3" placeholder="添加描述"></textarea>--%>
                                    <s:textfield cssClass="form-control" rows="5" name="limit.comment"
                                                 placeholder="添加描述"></s:textfield>
                                </div>

                                    <div class="form-group">
                                        <label>权限类型（a 或 d）</label>
                                        <%--<textarea class="form-control" rows="3" placeholder="添加描述"></textarea>--%>
                                        <s:textfield cssClass="form-control" name="limit.type"
                                                     placeholder="a/d"></s:textfield>
                                    </div>
                                <div class="form-group">
                                    <label>可选算法</label>
                                    <s:select list="#request.Algos" listKey="id" listValue="appName"
                                               cssClass="form-control" name="limit.algo.id"
                                              cssStyle="width: 100%;" id="select_algo"/>

                                </div>
                                <div class="form-group">
                                    <label>可选数据</label>
                                    <s:select list="#request.Datas" listKey="id" listValue="name"
                                              cssClass="form-control select2" name="limit.data.id"
                                              cssStyle="width: 100%;" id="select_data"/>

                                </div>

                                <div class="form-group">
                                    <label>可执行权限行为</label>
                                    <select class="form-control select2" style="width: 100%;" multiple = "multiple" name="limit.limits" id = "behavior">
                                        <option>C</option>
                                        <option>R</option>
                                        <option>U</option>
                                        <option>D</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="form-group">
                            <div class="pull-right">
                                <button type="submit" class="btn btn-primary" onclick="return editConfirm()">增加</button>
                                <a href="doShowAllLimit.action" type="button" class="btn btn-default">返回</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>

    <!--页脚 -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            网络舆情影响传播算法测评与分析平台
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2017 <a href="http://cs.bit.edu.cn/">北京理工大学计算机学院</a>.</strong> 版权所有.
    </footer>

</div>


<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!-- Select2 -->
<script src="../../bower_components/select2/dist/js/select2.full.min.js"></script>

<script>
    function editConfirm() {
        var x;
        var r = confirm("确定添加吗？")
        if (r == true) {
            x = 1;
            return true;
            alert("已成功添加！");
        }
        else {
            x = 0;
            return false;
        }
    }

    $(function () {
        //Initialize Select2 Elements
        $('.select2').select2();
        $("#select_algo").val("").select2();
        $("#select_data").val("").select2();
        $("#behavior").val("").select2();
    })
</script>

</body>
</html>

