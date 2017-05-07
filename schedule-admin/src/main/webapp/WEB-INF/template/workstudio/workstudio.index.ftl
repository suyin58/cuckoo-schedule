<!DOCTYPE html>
<html>
<head>
  	<title>任务调度中心</title>
  	<#import "/common/common.macro.ftl" as netCommon>
	<@netCommon.commonStyle />
	<!-- DataTables -->
  	<link rel="stylesheet" href="${request.contextPath}/static/adminlte/plugins/datatables/dataTables.bootstrap.css">
  	<!-- daterangepicker -->
  	<link rel="stylesheet" href="${request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker-bs3.css">
</head>
<body class="hold-transition skin-blue sidebar-mini <#if cookieMap?exists && "off" == cookieMap["adminlte_settings"].value >sidebar-collapse</#if> ">
<div class="wrapper">
	<!-- header -->
	<@netCommon.commonHeader />
	<!-- left -->
	<@netCommon.commonLeft />
	
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>调度管理<small>工作台</small></h1>
		</section>

		<!-- Main content -->
	    <section class="content">
			
			<div class="row">
				<div class="col-xs-12">
					PENDING("PENDING", "等待执行"), 
					RUNNING("RUNNING", "正在执行"), 
					FAILED("FAILED", "执行失败"),
					SUCCED("SUCCED", "执行成功"),
					BREAK("BREAK", "断线");
					<div class="box">
			            <div class="box-header">
							<h3 class="box-title">失败/断线列表</h3>&nbsp;&nbsp;
						</div>
			            <div class="box-body">
			              	<table id="joblog_err_list" class="table table-bordered table-striped display" width="100%" >
				                <thead>
					            	<tr>
                                        
					                	<th name="id" >id</th>
					                	<th name="groupId" >分组ID</th>
					                	<th name="jobId" >任务ID</th>
					                  	<th name="jobName" >任务名称</th>
					                  	<th name="jobClassApplication" >作业执行应用名</th>
                                        <th name="triggerType" >触发类型</th>
					                  	<th name="cronExpression" >cron任务表达式</th>
					                  	<th name="execJobStatus" >执行状态</th>
					                  	<th name="jobStartTime" >任务开始时间</th>
					                  	<th name="jobExecTimeDesc" >任务执行时间</th>
					                  	<th name="jobEndTime" >任务结束时间</th>
					                  	<th name="needTriggleNext" >触发下级</th>
					                  	<th name="forceTriggle" >强制触发</th>
					                  	<th name="remark" >执行结果</th>
					                  	<th name="cuckooClientIp" >执行器IP</th>
					                  	<th name="cuckooClientTag" >客户端标识</th>
					                  	<th name="typeDaily" >是否日切</th>
					                  	<th name="txDate" >业务日期</th>
					                  	<th name="flowLastTime" >开始时间参数 </th>
					                  	<th name="flowCurTime" >结束时间参数 </th>
					                  	<th name="cuckooParallelJobArgs" >并发/集群任务参数</th>
					                  	<th name="handleMsg" >操作</th>
					                </tr>
				                </thead>
							</table>
						</div>
					</div>
					
					<div class="box">
			            <div class="box-header">
							<h3 class="box-title">等待/执行中列表</h3>&nbsp;&nbsp;
						</div>
			            <div class="box-body">
			              	<table id="joblog_ing_list" class="table table-bordered table-striped display" width="100%" >
				                <thead>
					            	<tr>
                                        
					                	<th name="id" >id</th>
					                	<th name="groupId" >分组ID</th>
					                	<th name="jobId" >任务ID</th>
					                  	<th name="jobName" >任务名称</th>
					                  	<th name="jobClassApplication" >作业执行应用名</th>
                                        <th name="triggerType" >触发类型</th>
					                  	<th name="cronExpression" >cron任务表达式</th>
					                  	<th name="execJobStatus" >执行状态</th>
					                  	<th name="jobStartTime" >任务开始时间</th>
					                  	<th name="jobExecTimeDesc" >任务执行时间</th>
					                  	<th name="jobEndTime" >任务结束时间</th>
					                  	<th name="needTriggleNext" >触发下级</th>
					                  	<th name="forceTriggle" >强制触发</th>
					                  	<th name="remark" >执行结果</th>
					                  	<th name="cuckooClientIp" >执行器IP</th>
					                  	<th name="cuckooClientTag" >客户端标识</th>
					                  	<th name="typeDaily" >是否日切</th>
					                  	<th name="txDate" >业务日期</th>
					                  	<th name="flowLastTime" >开始时间参数 </th>
					                  	<th name="flowCurTime" >结束时间参数 </th>
					                  	<th name="cuckooParallelJobArgs" >并发/集群任务参数</th>
					                  	<th name="handleMsg" >操作</th>
					                </tr>
				                </thead>
							</table>
						</div>
					</div>
					
					<div class="box">
			            <div class="box-header">
							<h3 class="box-title">超时列表</h3>&nbsp;&nbsp;
							<input type="hidden" id="overHours" value="${overHours}"/>
						</div>
			            <div class="box-body">
			              	<table id="joblog_over_list" class="table table-bordered table-striped display" width="100%" >
				                <thead>
					            	<tr>
                                        
					                	<th name="id" >id</th>
					                	<th name="groupId" >分组ID</th>
					                	<th name="jobId" >任务ID</th>
					                  	<th name="jobName" >任务名称</th>
					                  	<th name="jobClassApplication" >作业执行应用名</th>
                                        <th name="triggerType" >触发类型</th>
					                  	<th name="cronExpression" >cron任务表达式</th>
					                  	<th name="execJobStatus" >执行状态</th>
					                  	<th name="jobStartTime" >任务开始时间</th>
					                  	<th name="jobExecTimeDesc" >任务执行时间</th>
					                  	<th name="jobEndTime" >任务结束时间</th>
					                  	<th name="needTriggleNext" >触发下级</th>
					                  	<th name="forceTriggle" >强制触发</th>
					                  	<th name="remark" >执行结果</th>
					                  	<th name="cuckooClientIp" >执行器IP</th>
					                  	<th name="cuckooClientTag" >客户端标识</th>
					                  	<th name="typeDaily" >是否日切</th>
					                  	<th name="txDate" >业务日期</th>
					                  	<th name="flowLastTime" >开始时间参数 </th>
					                  	<th name="flowCurTime" >结束时间参数 </th>
					                  	<th name="cuckooParallelJobArgs" >并发/集群任务参数</th>
					                  	<th name="handleMsg" >操作</th>
					                </tr>
				                </thead>
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
<!-- DataTables -->
<!-- daterangepicker -->
<script src="${request.contextPath}/static/adminlte/plugins/daterangepicker/moment.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${request.contextPath}/static/plugins/jquery/jquery.validate.min.js"></script>
<script src="${request.contextPath}/static/js/workstudio.index.1.js"></script>
</body>
</html>
