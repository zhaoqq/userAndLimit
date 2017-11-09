<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>事件分析</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Morris charts -->
    <link rel="stylesheet" href="../../bower_components/morris.js/morris.css">
    <!-- cloud -->
    <link rel="stylesheet" href="../../dist/my-css/cloud.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/theme-css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../dist/theme-css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../../dist/my-css/style.css">
    <link rel="stylesheet" href="../../dist/my-css/analysisStyle.css">

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
<body class="skin-blue" data-spy="scroll" data-target="#scrollspy">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->

        <a href="#" class="logo">
            <span class="logo-lg">网络舆情影响传播算法测评与分析平台</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation" id="myheaer">
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
                                    <a href="#" class="btn btn-default btn-flat">退出登录</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <div class="sidebar" id="scrollspy">

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="nav sidebar-menu">
                <li class="header">快速链接</li>
                <li class="active"><a href="#introduction"><i class="fa fa-circle-o"></i> 事件简介</a></li>
                <li><a href="#trend"><i class="fa fa-circle-o"></i> 事件趋势</a></li>
                <li><a href="#hotwords"><i class="fa fa-circle-o"></i> 热点词</a></li>
                <li><a href="#hotInformation"><i class="fa fa-circle-o"></i> 热门信息</a></li>
                <li><a href="#spreadRoute"><i class="fa fa-circle-o"></i> 传播途径</a></li>
                <li><a href="#emotions"><i class="fa fa-circle-o"></i> 情绪分析</a></li>
                <li><a href="#bloggerAnalysis"><i class="fa fa-circle-o"></i> 传播主体分析</a></li>
                <li><a href="#dataAnalysis"><i class="fa fa-circle-o"></i> 数据分析</a></li>
                <li><a href="#commentAnalysis"><i class="fa fa-circle-o"></i> 评论分析</a></li>
                <li><a href="../managerIndex.html"><i class="fa fa-circle-o"></i> 返回</a></li>
            </ul>
        </div>
        <!-- /.sidebar -->
    </aside>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <h1>
                共享单车何处安放事件分析报告
                <small>Version 2.3</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 事件分析</a></li>
                <li class="active">分析报告</li>
            </ol>
        </div>

        <!-- Main content -->
        <div class="content body">

            <!--事件简介-->
            <section id="introduction">
                <h2 class="page-header"><a href="#introduction">事件简介</a></h2>
                <p class="lead">
                    <b>共享单车何处安放事件报告</b> 围绕关键词“(共享单车)+(环境|资源|投放)+(责任|回收)”，对2017/06/26 16:47~2017/06/27日 16:47期间，从微博上采集到的145条信息进行了深入地分析。微博声量最高峰出现在2017/06/27 12，共有26篇相关微博言论；疑似源头的微博讯息于2017/06/26 16:49发布在新浪微博标题为：『   &n...』。总体来说，整个微博事件的发展趋势较为突出，详细报告如下。
                </p>
            </section>

            <!-- ============================================================= -->

            <!--事件趋势-->
            <section id="content">
                <h2 class="page-header"><a href="#trend">事件趋势</a></h2>
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-info">
                            <div class="box-header">
                                <h3 class="box-title">事件趋势图</h3>
                            </div>

                            <div class="box-body chart-responsive">
                                <div class="chart" id="trend-chart" style="height: 400px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <p class="lead">
                    从上图可以看出，整个事件的爆发点是2017年06月27日 15点，原创类型的数据较为突出，加上媒体和转发的关注，将事态发展推向高点。
                </p>
            </section>

            <!-- ============================================================= -->

            <!--热点词-->
             <section id="hotwords">
                <h2 class="page-header"><a href="#hotwords">热点词</a></h2>
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-info">
                            <!--<div class="box-header with-border">
                                <h3 class="box-title">热点词图</h3>
                            </div>-->

                            <div class="box-body chart-responsive">
                                <div id="cloud" style="height: 450px; position:relative;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <p class="lead">
                    从上图可以看出，整个事件的爆发点是2017年06月27日 15点，原创类型的数据较为突出，加上媒体和转发的关注，将事态发展推向高点。
                </p>
            </section>

            <!-- ============================================================= -->

            <!--意见领袖-->
            <!--<section id="adviceLeaders">
                <h2 class="page-header"><a href="#adviceLeaders">意见领袖</a></h2>
                <div class="row" >
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header0"></div>
                            </div>
                            <div class="box-body" id="leader_body0" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header1"></div>
                            </div>
                            <div class="box-body" id="leader_body1" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header2"></div>
                            </div>
                            <div class="box-body" id="leader_body2" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header3"></div>
                            </div>
                            <div class="box-body" id="leader_body3" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header4"></div>
                            </div>
                            <div class="box-body" id="leader_body4" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header5"></div>
                            </div>
                            <div class="box-body" id="leader_body5" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header6"></div>
                            </div>
                            <div class="box-body" id="leader_body6" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header7"></div>
                            </div>
                            <div class="box-body" id="leader_body7" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header8"></div>
                            </div>
                            <div class="box-body" id="leader_body8" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                </div>&lt;!&ndash; /.row &ndash;&gt;

            </section>-->

            <!-- ============================================================= -->

            <!--核心传播人-->
           <!-- <section id="corePeople">
                <h2 class="page-header"><a href="#corePeople">核心传播人</a></h2>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body panel-responsive" id="core_ins"></div>
                        </div>
                    </div>
                </div>

               &lt;!&ndash; <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                &lt;!&ndash; 选项卡 &ndash;&gt;
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#core_institution" data-toggle="tab">核心传播机构</a></li>
                                    <li><a href="#core_media" data-toggle="tab">核心传播媒体</a></li>
                                    <li><a href="#core_medium" data-toggle="tab">核心传播媒体人</a></li>
                                    <li><a href="#core_netizen" data-toggle="tab">核心传播网民</a></li>
                                </ul>

                                &lt;!&ndash;选项卡展示的内容&ndash;&gt;
                                <div class="tab-content">
                                    <div class="tab-pane fade in active" id="core_institution">
                                        <div class="row" id="core_ins"></div>
                                    </div>
                                    <div class="tab-pane fade" id="core_media">
                                        <div class="row" id="core_med"></div>
                                    </div>
                                    <div class="tab-pane fade" id="core_medium">
                                        <div class="row" id="core_mum"></div>
                                    </div>
                                    <div class="tab-pane fade" id="core_netizen">
                                        <div class="row" id="core_net"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>&ndash;&gt;
            </section>-->

            <!-- ============================================================= -->

            <!--热门信息-->
            <section id="hotInformation">
                <h2 class="page-header"><a href="#hotInformation">热门信息</a></h2>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <!-- 选项卡 -->
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#hot_weibo" data-toggle="tab">热门微博</a></li>
                                    <li><a href="#hot_resend" data-toggle="tab">热门转发</a></li>
                                </ul>

                                <!--选项卡展示的内容-->
                                <div class="tab-content">
                                    <div class="tab-pane fade in active" id="hot_weibo">
                                        <h4>Home Tab</h4>
                                        <p>1</p>
                                    </div>
                                    <div class="tab-pane fade" id="hot_resend">
                                        <h4>Profile Tab</h4>
                                        <p>2</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </section>

            <!-- ============================================================= -->

            <!--传播途径-->
            <section id="spreadRoute">
                <h2 class="page-header"><a href="#spreadRoute">传播途径</a></h2>
                <div class="row">
                    <div class="col-md-12">
                        <ul class="timeline">
                            <li class="time-label">
                                <span class="bg-red">2016年6月26日</span>
                            </li>
                            <li>
                                <i class="fa fa-clock-o bg-blue"></i>
                                <div class="timeline-item">
                                    <h3 class="timeline-header">6月26日 <a href="#">12:00</a></h3>
                                    <div class="timeline-body">
                                        共享单车事件爆发
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-clock-o bg-blue"></i>
                                <div class="timeline-item">
                                    <h3 class="timeline-header">6月26日 <a href="#">14:00</a></h3>
                                    <div class="timeline-body">
                                        共享单车事件全面爆发
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-clock-o bg-blue"></i>
                                <div class="timeline-item">
                                    <h3 class="timeline-header">6月26日 <a href="#">16:00</a></h3>
                                    <div class="timeline-body">
                                        共享单车事件全面全面全面爆发
                                    </div>
                                </div>
                            </li>
                            <li class="time-label">
                                <span class="bg-red">2016年6月27日</span>
                            </li>
                            <li>
                                <i class="fa fa-clock-o bg-blue"></i>
                                <div class="timeline-item">
                                    <h3 class="timeline-header">6月27日 <a href="#">12:00</a></h3>
                                    <div class="timeline-body">
                                        共享单车事件爆发
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-clock-o bg-blue"></i>
                                <div class="timeline-item">
                                    <h3 class="timeline-header">6月27日 <a href="#">14:00</a></h3>
                                    <div class="timeline-body">
                                        共享单车事件全面爆发
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-clock-o bg-blue"></i>
                                <div class="timeline-item">
                                    <h3 class="timeline-header">6月27日 <a href="#">16:00</a></h3>
                                    <div class="timeline-body">
                                        共享单车事件全面全面全面爆发
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa bg-blue">续</i>
                            </li>
                        </ul>
                    </div>
                </div>
            </section>

            <!-- ============================================================= -->

            <!--情绪分析-->
            <section id="emotions">
                <h2 class="page-header"><a href="#emotions">情绪分析</a></h2>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <!-- 选项卡 -->
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#resend_emotions" data-toggle="tab">转发表情分析</a></li>
                                    <li><a href="#comment_emotions" data-toggle="tab">评论表情分析</a></li>
                                </ul>

                                <!--选项卡展示的内容-->
                                <div class="tab-content">
                                    <div class="tab-pane fade in active" id="resend_emotions">
                                        <h4>Home Tab</h4>
                                        <p>1</p>
                                    </div>
                                    <div class="tab-pane fade" id="comment_emotions">
                                        <h4>Profile Tab</h4>
                                        <p>2</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- ============================================================= -->

            <!--传播主体分析-->
            <section id="bloggerAnalysis">
                <h2 class="page-header"><a href="#bloggerAnalysis">传播主体分析</a></h2>
                <div class="row">
                    <div class="col-md-9">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">博主地域分析</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="sales-chart" style="height: 450px; position: relative;"></div>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-3">

                        <div class="box">
                            <div class="box-body no-padding" style="height: 500px; position: relative;">
                                <table class="table table-condensed table-bordered table-hover">
                                    <tr>
                                        <th>地域</th>
                                        <th>信息数</th>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                    </tr>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="box-header">
                        <h3 class="box-title">意见领袖</h3>
                    </div>
                </div>
                <div class="row" >
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header0"></div>
                            </div>
                            <div class="box-body" id="leader_body0" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header1"></div>
                            </div>
                            <div class="box-body" id="leader_body1" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header2"></div>
                            </div>
                            <div class="box-body" id="leader_body2" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header3"></div>
                            </div>
                            <div class="box-body" id="leader_body3" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header4"></div>
                            </div>
                            <div class="box-body" id="leader_body4" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header5"></div>
                            </div>
                            <div class="box-body" id="leader_body5" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header6"></div>
                            </div>
                            <div class="box-body" id="leader_body6" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header7"></div>
                            </div>
                            <div class="box-body" id="leader_body7" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="box box-widget">
                            <div class="box-header with-border">
                                <div class="user-block" id="leader_header8"></div>
                            </div>
                            <div class="box-body" id="leader_body8" style="height:180px; overflow-y:auto"></div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">核心传播人</h3>
                            </div>

                            <div class="box-body chart-responsive">
                                <div id="core_ins" style="height: 250px; position:relative;"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="box">
                            <div class="box-header with-border">
                                <h3 class="box-title">＊本次事件中转发数量最多的前10微博博主</h3>
                            </div>
                            <div class="box-body">
                                <table class="table table-bordered">
                                    <tr>
                                        <th style="width:25%">昵称</th>
                                        <th style="width:20%">地域</th>
                                        <th>粉丝数</th>
                                        <th>微博数</th>
                                        <th style="width:25%">参与微博个数（转发）</th>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>
                                    <tr>
                                        <td>金融八卦女</td>
                                        <td>北京 西城区</td>
                                        <td>988515</td>
                                        <td>12149</td>
                                        <td>231</td>
                                    </tr>

                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">男女比例</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="men_women" style="height: 300px; position: relative;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">

                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">用户认证</h3>
                            </div>
                            <div class="box-body">
                                <div class="col-md-9" style="height:300px;position: relative; padding-top: 40px; padding-bottom: 40px">
                                    <canvas id="user_identify"></canvas>
                                </div>
                                <div class="col-md-3" style="height: 300px; position: relative; padding-top: 20px; padding-bottom: 20px">
                                    <ul class="chart-legend clearfix">
                                        <li><i class="fa fa-circle-o text-red"></i> 普通用户</li>
                                        <li><i class="fa fa-circle-o text-green"></i> 达人</li>
                                        <li><i class="fa fa-circle-o text-yellow"></i> 橙V</li>
                                        <li><i class="fa fa-circle-o text-light-blue"></i> 蓝V</li>
                                    </ul>
                                </div>

                            </div>
                            <!-- /.box-body -->
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">海内外统计</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="sales-chart4" style="height: 300px; position: relative;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">水军分析</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="sales-chart5" style="height: 300px; position: relative;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- ============================================================= -->

            <!--数据类型-->
            <section id="dataAnalysis">
                <h2 class="page-header"><a href="#dataAnalysis">数据类型</a></h2>
                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-success">
                            <div class="box-header with-border">
                                <h3 class="box-title">粉丝分布</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="bar-chart" style="height: 300px;"></div>
                            </div>
                            <!-- /.box-body -->
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">敏感占比</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="sales-chart6" style="height: 300px; position: relative;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">原微博转发微博占比</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="sales-chart7" style="height: 300px; position: relative;"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">转发层级占比</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="sales-chart9" style="height: 300px; position: relative;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-success">
                            <div class="box-header with-border">
                                <h3 class="box-title">转发地域分布</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="bar-chart2" style="height: 300px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">发布设备分布</h3>
                            </div>
                            <div class="box-body chart-responsive">
                                <div class="chart" id="sales-chart10" style="height: 400px; position: relative;"></div>
                            </div>
                        </div>
                    </div>
                </div>
           </section>

            <!-- ============================================================= -->

            <!--评论分析-->
            <section id="commentAnalysis">
                <h2 class="page-header"><a href="#commentAnalysis">评论分析</a></h2>
                <div class="row">
                    <div class="col-md-12">
                        <div class="box box-danger">
                            <div class="box-header with-border">
                                <h3 class="box-title">微博评论分析</h3>
                            </div>
                            <div class="box-body">
                                <canvas id="pieChart" style="height:250px"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    </div>

    <!--页脚 -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            网络舆情影响传播算法测评与分析平台
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2017 <a href="#">北京理工大学计算机学院</a>.</strong> 版权所有.
    </footer>

</div><!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="../../bower_components/raphael/raphael.min.js"></script>
<script src="../../bower_components/morris.js/morris.min.js"></script>
<!-- FastClick -->
<script src="../../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>
<!--事件趋势js -->
<script src="../../dist/js/trend.js"></script>
<!--博主分析--男女分析 -->
<script src="../../dist/js/blogger.js"></script>
<!--D3.js -->
<script src="../../bower_components/d3/d3.min.js"></script>
<!--博主分析--用户认证 -->
<script src="../../bower_components/chart.js/Chart.js"></script>
<script src="../../dist/js/pieChart.js"></script>
<!--热点云.js -->
<script src="../../bower_components/wordcloud2.js"></script>
<script src="../../dist/js/cloud.js"></script>

<!-- SlimScroll -->
<script src="../../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js"></script>

<script src="../../dist/js/adviceleader.js"></script>
<script src="../../dist/js/corePeople.js"></script>


</body>
</html>
