<!DOCTYPE html>
<html>
<head>
  	<title>任务调度中心</title>
  	<#import "/common/common.macro.ftl" as netCommon>
	<@netCommon.commonStyle />
	<!-- DataTables -->
  	<link rel="stylesheet" href="${request.contextPath}/static/adminlte/plugins/datatables/dataTables.bootstrap.css">

	<#-- select2
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/plugins/select2/select2.min.css">
    <script src="${request.contextPath}/static/adminlte/plugins/select2/select2.min.js"></script>
    //$(".select2").select2();
    -->

</head>
<body class="hold-transition skin-blue sidebar-mini <#if cookieMap?exists && "off" == cookieMap["adminlte_settings"].value >sidebar-collapse</#if>">
<div class="wrapper">
	<!-- header -->
	<@netCommon.commonHeader />
	<!-- left -->
	<@netCommon.commonLeft />
	
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>调度管理<small>客户端管理</small></h1>
			<!--
			<ol class="breadcrumb">
				<li><a><i class="fa fa-dashboard"></i>调度管理</a></li>
				<li class="active">调度中心</li>
			</ol>
			-->
		</section>
		
		<!-- Main content -->
	    <section class="content">
	    	<div class="row">
	    		<div class="col-xs-4">
	              	<div class="input-group">
	                	<span class="input-group-addon">作业应用</span>
                		
                		<select class="form-control" id="jobClassApplication" >
                			<#list jobAppWithNull?keys as app>
                				<option value="${app}" >${jobAppWithNull[app]}</option>
                			</#list>
	                  	</select>
	                 </div>
	            </div>
	    		<div class="col-xs-4">
	              	<div class="input-group">
	    			 	<span class="input-group-addon">任务名称</span>
                		<input type="text" class="form-control" id="jobNameInput" value="${jobName}" autocomplete="on" >
	              	 </div>
	            </div>
	            <div class="col-xs-2">
	            	<button class="btn btn-block btn-info" id="searchBtn">搜索</button>
	            </div>
          	</div>
          	
	    	
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
			            <div class="box-body">
			              	<table id="job_list" class="table table-bordered table-striped">
				                <thead>
					            	<tr>
					            		<th name="id" >标准ID</th>
					                	<th name="jobClassApplication" >作业执行应用名</th>
					                  	<th name="jobName" >任务名称</th> 
					                  	<th name="beanName" >实现类名称</th>
					                  	<th name="methodName" >方法名称</th> 
					                  	<th name="servers" >可用服务器</th>
					                  	<th name="clients" >可用执行端</th>
					                  	<th name="createDate" >创建时间</th> 
					                  	<th name="modifyDate" >修改时间</th> 
					                </tr>
				                </thead>
				                <tbody></tbody>
				                <tfoot></tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
	    </section>
	</div>
	
	<!-- footer -->
	<@netCommon.commonFooter />
</div>
  
<@netCommon.commonScript />
<!-- DataTables -->
<script src="${request.contextPath}/static/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${request.contextPath}/static/plugins/jquery/jquery.validate.min.js"></script>
<!-- daterangepicker -->
<script src="${request.contextPath}/static/adminlte/plugins/daterangepicker/moment.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${request.contextPath}/static/js/jobclient.index.1.js"></script>
</body>
</html>
