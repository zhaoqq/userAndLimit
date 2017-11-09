<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>编辑角色信息</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../../bower_components/jquery.tree-multiselect.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="../../bower_components/select2/dist/css/select2.min.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="../../bower_components/iCheck/flat/blue.css" >
    <link rel="stylesheet" href="../../bower_components/iCheck/all.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/theme-css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../dist/theme-css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="../../dist/my-css/style.css">
    <link rel="stylesheet" href="../../dist/my-css/limit.css">

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
                        <li><a href="../algo/algoList.html">查看算法</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>数据管理</span>
                        <span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../dataset/dataManage.html">数据集管理</a></li>
                        <li><a href="../dataset/datasetList.html">查看数据集</a></li>
                    </ul>
                </li>



                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>影响分析</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="../influence/people_influence.html">影响力人物分析</a></li>
                        <li><a href="../influence/trend_influence.html">影响过程分析</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>事件分析</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
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
                编辑角色信息
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>系统管理</a></li>
                <li class="active">编辑角色信息</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">基本角色信息</h3>
                </div>
                <!-- /.box-header -->
                <form role="form" action="doAddRole.action" method="post">
                    <div class="box-body" style="height:400px;">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>角色名</label>
                                    <s:textfield class="form-control" name="role.name" placeholder="%{ROLENAME}"></s:textfield>
                                </div>
                                <div class="form-group">
                                    <label>角色描述</label>
                                    <s:textfield class="form-control" rows="5" name="role.comment"  placeholder="添加描述"></s:textfield>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="form-group">
                            <div class="pull-right">
                                <button type="submit" class="btn btn-primary" onclick="editConfirm()">确定</button>
                                <a href="roleManage.jsp" type="button" class="btn btn-default">返回</a>
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
<script src="../../bower_components/jquery-ui.min.js"></script>
<!--Tree-Multiselect.js-->
<script src="../../bower_components/jquery.tree-multiselect.js"></script>
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
<!-- iCheck 1.0.1 -->
<script src="../../bower_components/iCheck/icheck.min.js"></script>

<!-- Page script -->

<script>
    function editConfirm(){
        var x;
        var r = confirm("确定提交吗？")
        if(r==true){
            x = 1;
            return true;
            alert("角色添加成功！");
        }
        else{
            x = 0;
            return false;
        }
    }
    var tree1 = $("#test-select").treeMultiselect(
        { sortable: true }
    );

</script>




</body>
</html>