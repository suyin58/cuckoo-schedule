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
			<h1>调度管理<small>日志详情</small></h1>
			<!--
			<ol class="breadcrumb">
				<li><a><i class="fa fa-dashboard"></i>调度管理</a></li>
				<li class="active">调度中心</li>
			</ol>
			-->
		</section>
		
		<!-- Main content ${log} -->
	    <section class="content">

		
		<div  tabindex="-1" role="dialog"  aria-hidden="false">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
		         	<div class="modal-body">
						<form class="form-horizontal form" role="form" >
							<div class="modal-header">
				            	<h4 class="modal-title" name="title" >任务基础信息:日志ID(${log.id})</h4>
				         	</div>
				         	
							<div class="form-group">
								<label   class="col-sm-2 control-label">分组ID<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"  readonly="readonly"  value="${log.groupId}" maxlength="100" > 
								</div>
								
		                        <label   class="col-sm-2 control-label">分组名称<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.groupName}" maxlength="100" > 
								</div>
							</div>
							
							<div class="form-group">
								<label   class="col-sm-2 control-label">任务ID<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"   readonly="readonly"  value="${log.jobId}" maxlength="100" > 
								</div>
								
		                        <label  class="col-sm-2 control-label">任务名称<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.jobName}" maxlength="100" > 
								</div>
								
								<label   class="col-sm-2 control-label">任务描述<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.jobDesc}" maxlength="100" > 
								</div>
							</div>
							
							<div class="form-group">
								<label   class="col-sm-2 control-label">执行应用<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"  readonly="readonly"  value="${log.jobClassApplication}" maxlength="100" > 
								</div>
								
		                        <label   class="col-sm-2 control-label">触发类型<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.triggerTypeDesc}" maxlength="100" > 
								</div>
								
								<#if log.triggerType=="CRON">
								<label   class="col-sm-2 control-label">CRON表达式<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.cronExpression}" maxlength="100" > 
								</div>
								</#if>
							</div>
		                    
		                    
		                    <div class="form-group">
								<label   class="col-sm-2 control-label">是否手工调度<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"  readonly="readonly"  value="${log.forceTriggleDesc}" maxlength="100" > 
								</div>
								
		                        <label   class="col-sm-2 control-label">是否触发后续任务<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.needTriggleNextDesc}" maxlength="100" > 
								</div>
							</div>
							
							
							<div class="modal-header">
				            	<h4 class="modal-title" name="title" >任务执行信息</h4>
				         	</div>
				         	<div class="form-group">
								<label   class="col-sm-2 control-label">执行状态<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"  readonly="readonly"  value="${log.execJobStatusDesc}" maxlength="100" > 
								</div>
								
								<label   class="col-sm-2 control-label">客户机IP<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"  readonly="readonly"  value="${log.cuckooClientIp}" maxlength="100" > 
								</div>
							</div>
							
							<div class="form-group">
								<label   class="col-sm-2 control-label">开始时间<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"  readonly="readonly"  value="${log.jobStartTimeDesc}" maxlength="100" > 
								</div>
								
		                        <label   class="col-sm-2 control-label">结束时间<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.jobEndTimeDesc}" maxlength="100" > 
								</div>
								
								<label   class="col-sm-2 control-label">执行时间<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.jobExecTimeDesc}" maxlength="100" > 
								</div>
								
							</div>
				         	
				         	
				         	<div class="form-group">
								<label   class="col-sm-2 control-label">是否日切任务<font color="red">*</font></label>
								<div class="col-sm-4">
									<input type="text" class="form-control"  readonly="readonly"  value="${log.typeDailyDesc}" maxlength="100" > 
								</div>
								
		                        <label   class="col-sm-2 control-label">执行参数<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.cuckooParallelJobArgs}" maxlength="100" > 
								</div>
								
								
								<#if log.typeDaily == "YES">
									<label   class="col-sm-2 control-label">业务日期<font color="red">*</font></label>
			                        <div class="col-sm-4">
				                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.txDate}" maxlength="100" > 
									</div>
								</#if>
								
								<#if log.typeDaily == "NO">
									<label   class="col-sm-2 control-label">业务开始时间<font color="red">*</font></label>
			                        <div class="col-sm-4">
				                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.flowLastTimeDesc}" maxlength="100" > 
									</div>
									
									<label   class="col-sm-2 control-label">业务结束时间<font color="red">*</font></label>
			                        <div class="col-sm-4">
				                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.flowCurTimeDesc}" maxlength="100" > 
									</div>
								</#if>
							</div>
							
		                    
		                    
							<div class="form-group">
								
								<!--
		                        <label   class="col-sm-2 control-label">客户机标识<font color="red">*</font></label>
		                        <div class="col-sm-4">
			                  		<input type="text" class="form-control"  readonly="readonly"  value="${log.cuckooClientTag}" maxlength="100" > 
								</div>
								-->
								
		                        <label   class="col-sm-2 control-label">执行备注<font color="red">*</font></label>
		                        <div class="col-sm-8 row" >
			                  		<textarea type="text" class="form-control"  readonly="readonly"  maxlength="100" >
			                  		${log.remark}
			                  		</textarea> 
								</div>
							</div>
		                    
		                    <!--
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-6">
									<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
								</div>
							</div>
							-->
							
						</form>
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
<script src="${request.contextPath}/static/js/joblog.detail.1.js"></script>
</body>
</html>
