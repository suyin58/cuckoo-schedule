<#macro commonStyle>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> -->
    <link rel="stylesheet" href="${request.contextPath}/static/plugins/font-awesome-4.3.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <!-- <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
    <link rel="stylesheet" href="${request.contextPath}/static/plugins/ionicons-2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/dist/css/AdminLTE-local.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/dist/css/skins/_all-skins.min.css">
      
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  
	<!-- scrollup -->
	<link rel="stylesheet" href="${request.contextPath}/static/plugins/scrollup/image.css">
	<!-- pace -->
	<link rel="stylesheet" href="${request.contextPath}/static/plugins/pace/themes/pace-theme-flash.css">
</#macro>

<#macro commonScript>
	<!-- jQuery 2.1.4 -->
	<script src="${request.contextPath}/static/adminlte/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="${request.contextPath}/static/adminlte/bootstrap/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="${request.contextPath}/static/adminlte/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="${request.contextPath}/static/adminlte/dist/js/app.min.js"></script>

    <!-- scrollup -->
    <script src="${request.contextPath}/static/plugins/scrollup/jquery.scrollUp.min.js"></script>
    <!-- pace -->
    <script src="${request.contextPath}/static/plugins/pace/pace.min.js"></script>
    <#-- jquery cookie -->
	<script src="${request.contextPath}/static/plugins/jquery/jquery.cookie.js"></script>

	<#-- common -->
    <script src="${request.contextPath}/static/js/cuckoo.alert.1.js"></script>
    <script src="${request.contextPath}/static/js/common.1.js"></script>
    <script>var base_url = '${request.contextPath}';</script>
	<script>var redirectURL = '${RequestParameters["redirectURL"]}';</script>
	
</#macro>

<#macro commonHeader>
	<header class="main-header">
		<a href="${request.contextPath}/" class="logo">
			<span class="logo-mini">CUCKOO</span>
			<span class="logo-lg"><b>任务调度</b>中心</span>
		</a>
		<nav class="navbar navbar-static-top" role="navigation">
			<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"><span class="sr-only">切换导航</span></a>
          	<div class="navbar-custom-menu">
      			
				<ul class="nav navbar-nav">
					<li class="dropdown user user-menu">
						
	                    <a href=";" id="userInfoBtn"  class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                      		<span class="hidden-xs">亲爱的${logonInfo.cuckooUserAuthType.description}：${logonInfo.userName}</span>
	                    </a>
					</li>
					<li class="dropdown user user-menu">
						
	                    <a href=";" id="logoutBtn" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                      		<span class="hidden-xs">注销</span>
	                    </a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
</#macro>

<#macro commonLeft>
	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu">
				<li class="header">常用模块</li>
				<li class="nav-click" ><a href="${request.contextPath}/workstudio"><i class="fa fa-circle-o text-red"></i> <span>工作台</span></a></li>
				<li class="nav-click" ><a href="${request.contextPath}/jobgroup"><i class="fa fa-circle-o text-orange"></i> <span>任务分组</span></a></li>
				<li class="nav-click" ><a href="${request.contextPath}/jobinfo"><i class="fa fa-circle-o text-yellow"></i> <span>任务详情</span></a></li>
                <li class="nav-click" ><a href="${request.contextPath}/jobclient"><i class="fa fa-circle-o text-green"></i> <span>注册任务</span></a></li>
				<li class="nav-click" ><a href="${request.contextPath}/joblog"><i class="fa fa-circle-o text-aqua"></i><span>调度日志</span></a></li>
				<li class="nav-click" ><a href="${request.contextPath}/crontab"><i class="fa fa-circle-o text-blue"></i><span>CronTab设置</span></a></li>
				<li class="nav-click" ><a href="${request.contextPath}/manage"><i class="fa fa-circle-o text-purple"></i><span>用户管理</span></a></li>
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>
</#macro>

<#macro commonControl >
	
</#macro>

<#macro commonFooter >
	<footer class="main-footer">
		
		<strong>Copyright &copy; 2015-${.now?string('yyyy')} &nbsp;
			<a href="https://github.com/suyin58/cuckoo-schedule" target="_blank" >github</a>&nbsp;
		</strong><!-- All rights reserved. -->
		<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=63c412c72a53a284440c0c1549302e4aab00255fc83f6cf442ca92d02d33654c"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="Cuckoo-Schedule" title="Cuckoo-Schedule"></a>
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0
		</div>
	</footer>
</#macro>