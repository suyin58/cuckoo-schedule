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
			<h1>调度管理<small>任务调度中心</small></h1>
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
	                	<span class="input-group-addon">分组名称</span>
                		<select class="form-control" id="groupId" >
                			<#list jobGroupsWithNull as group>
                				<option value="${group.id}" >${group.groupName}</option>
                			</#list>
	                  	</select>
	              	</div>
	            </div>
                <div class="col-xs-4">
                    <div class="input-group">
	                	<span class="input-group-addon">执行应用</span>
	                	
                		<select class="form-control" id="jobClassApplication" >
                			<#list jobAppWithNull?keys as app>
                				<option value="${app}" >${jobAppWithNull[app]}</option>
                			</#list>
	                  	</select>
                    </div>
                </div>
                
                <div class="col-xs-4">
	              	<div class="input-group">
	                	<span class="input-group-addon">任务ID</span>
                		<input type="text" class="form-control" id="jobId" value="${id}" autocomplete="on" >
	              	</div>
	            </div>
          	</div>
	    	
	    	<div class="row">
	    		<div class="col-xs-4">
	              	<div class="input-group">
	                	<span class="input-group-addon">任务状态</span>
                		<select class="form-control" id="jobStatus" >
                			<#list jobStatusList as list>
                				<option value="${list.value}" >${list.description}</option>
                			</#list>
	                  	</select>
	              	</div>
	            </div>
	            <!--
                <div class="col-xs-4">
                    <div class="input-group">
	                	<span class="input-group-addon">执行状态</span>
                		<select class="form-control" id="jobExecStatus" >
                			<#list jobExecStatusList as list>
                				<option value="${list.value}" >${list.description}</option>
                			</#list>
	                  	</select>
                    </div>
                </div>
                -->
	            <div class="col-xs-2">
	            	<button class="btn btn-block btn-info" id="searchBtn">搜索</button>
	            </div>
	            <div class="col-xs-2">
	            	<button class="btn btn-block btn-success add" type="button">+新增任务</button>
	            </div>
          	</div>
          	
	    	
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
			            <div class="box-header">
			            	<h3 class="box-title">调度列表</h3>
			            	<button class="btn btn-primary btn-xs job_pause_all" type="job_pause_all"  type="button">全部暂停</button>  
			            	<button class="btn btn-primary btn-xs job_resume_all" type="job_resume_all" type="button">全部恢复</button>  
			            </div>
			            <div class="box-body">
			              	<table id="job_list" class="table table-bordered table-striped">
				                <thead>
					            	<tr>
					            		<th name="id" >id</th>
					                	<th name="groupId" >分组ID</th>
					                	<th name="groupName" >分组名称</th>
					                  	<th name="jobName" >任务名称</th>
					                	<th name="execJobType" >任务类型</th> 
					                	<th name="execJobTypeDesc" >任务类型</th> 
					                  	<th name="jobClassApplication" >执行应用</th>
					                  	<th name="jobDesc" >描述</th> 
					                  	<th name="triggerType" >触发类型</th>
					                  	<th name="cronExpression" >Cron</th> 
					                  	<th name="typeDaily" >是否日切任务</th> 
					                  	<th name="offset" >业务偏移日期</th> 
					                  	<th name="jobStatus" >任务状态</th> 
					                  	<th name="cuckooParallelJobArgs" >任务参数</th> 
					                  	<th name="overTime" >超时告警时间</th> 
					                  	<th name="mailTo" >邮件接收人</th> 
					                  	<th name="quartzInit" >CRON任务是否初始化</th> 
					                  	<th>操作</th>
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

<!-- job新增.模态框 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
            	<h4 class="modal-title" name="title" >新增任务</h4>
         	</div>
         	<div class="modal-body">
				<form class="form-horizontal form" role="form" >
				
					
				
				
					<div class="form-group">
						<!--
						.分组下拉
		            	.任务执行应用名称下拉
		            	-->
						<label for="firstname" class="col-sm-2 control-label">分组名称<font color="red">*</font></label>
						<div class="col-sm-4">
							<select class="form-control" name="groupId" >
								<option value="" ></option>
	                			<#list jobGroupList as group>
	                				<option value="${group.id}" >${group.groupName}</option>
	                			</#list>
		                  	</select>
						</div>
						
						<label for="lastname" class="col-sm-2 control-label">任务类型<font color="red">*</font></label>
                        <div class="col-sm-4">
	                        <select class="form-control" name="execJobType" >
								<option value="" ></option>
	                			<#list execJobTypes as type>
	                				<option value="${type.value}" >${type.description}</option>
	                			</#list>
		                  	</select>
	                  	</div>
		                  	
						<div id="cuckooType">
	                        
						</div>
					</div>
					
					
					<div class="form-group">
						<!--
						.任务执行应用名称
            			.并发参数设置  
						-->
                        <textarea type="text" name="cuckooTypeContainer" class="col-sm-6 form-control hide" readonly="readonly"> 
                        </textarea>
					</div>
					
					<div class="form-group">
						<!--
						.任务名称
						-->
						<label for="lastname" class="col-sm-2 control-label">执行应用<font color="red">*</font></label>
	                    <div class="col-sm-4">
	                      	<input type="text" class="form-control" name="jobClassApplication" placeholder="与CuckooClient中的appName对应" maxlength="100" > 
							<!--
		                    <select class="form-control" name="jobClassApplication" >
								<option value="" ></option>
		                		<#list jobAppList?keys as app>
		                			<option value="${app}" >${jobAppList[app]}</option>
		                		</#list>
			               	</select>
			               	-->
		                </div>
						
						<label for="firstname" class="col-sm-2 control-label">执行参数<font color="black">*</font></label>
                        <div class="col-sm-4">
                        	<input type="text" class="form-control" name="cuckooParallelJobArgs" placeholder="请输入“执行参数”" maxlength="100" >
                        </div>
                        <label for="firstname" class="col-sm-2 control-label">任务名称<font color="red">*</font></label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" name="jobName" placeholder="与@CuckooTask(‘任务名称’)对应" maxlength="100" > 
						</div>
					</div>
					
					
					
					
                    <div class="form-group">
                       	<!--
                       	.触发类型下拉【CRON触发/上级任务触发】
            			.CRON表达式/上级任务名称（与4对应）
                       	-->
                    	<label for="firstname" class="col-sm-2 control-label">触发方式<font color="red">*</font></label>
					    <div class="col-sm-4">
							<select class="form-control" name="triggerType" >
								<option value="" ></option>
		                		<#list jobTriggerTypeNoNull as item>
		                			<option value="${item.value}" >${item.description}</option>
		                		</#list>
			                </select>
						</div>
                       	
                       	<div name="cronDiv"  class="">
                       		<!-- 如果是cron触发，需要输入cron表达式 -->
                       		<label for="lastname" class="col-sm-2 control-label">CRON表达式<font color="black">*</font></label>
                        	<div class="col-sm-4"><input type="text" class="form-control" name="cronExpression" placeholder="请输入CRON表达式" maxlength="100" ></div>
                       	</div>
                       	
                       	<div name="triggerJobDiv" class="hide">
                       		<!-- 如果是上级任务触发，需要选择上级任务信息-->
                       		<label for="lastname" class="col-sm-2 control-label">上级任务ID<font color="black">*</font></label>
                        	<div class="col-sm-4"><input type="text" class="form-control" name="preJobId" placeholder="请输入上级触发任务的ID" maxlength="100" ></div>
                       	</div>
						
                    </div>
                    
                    
					<div class="form-group">
						<!--
						.是否日切任务
            			.日切偏移量
            			-->
					
						
						<div name="typeDailyDiv" class="hide">
							<label for="lastname" class="col-sm-2 control-label">日切任务<font color="red">*</font></label>
							<div class="col-sm-4">
								<select class="form-control" name="typeDaily" >
									<option value="" ></option>
			                		<#list jobIsTypeDailyNoNull as item>
			                			<option value="${item.value}" >${item.description}</option>
			                		</#list>
				                </select>
							</div>
						</div>
						
						<div name="offsetDiv" class="hide">
	                        <label for="lastname" class="col-sm-2 control-label">偏移量<font color="red">*</font></label>
	                        <div class="col-sm-4"><input type="text" class="form-control" name="offset" placeholder="-1表示执行时间减1为业务日期(txDate)" maxlength="50" ></div>
						</div>
					</div>
                    
                    
	            	<div class="form-group">
	            		<!--
		            	.设置依赖任务
		            	.任务描述
		            	-->
                       	<label for="lastname" class="col-sm-2 control-label">依赖任务<font color="black">*</font></label>
                        <div class="col-sm-4"><input type="text" class="form-control" name="dependencyIds" placeholder="依赖任务ID，以逗号分隔，例如【1,2】" maxlength="100" ></div>
                       	<label for="lastname" class="col-sm-2 control-label">任务描述<font color="red">*</font></label>
                        <div class="col-sm-4"><input type="text" class="form-control" name="jobDesc" placeholder="任务描述说明" maxlength="100" ></div>
					</div>
                    
                    <div class="form-group">
	            		<!--
		            	.任务超时
		            	-->
		            	<label for="lastname" class="col-sm-2 control-label">超时告警时间(小时)<font color="black">*</font></label>
                        <div class="col-sm-4"><input type="text" class="form-control" name="overTime"   value="${overTime}"  maxlength="100" ></div>
		            </div>
                    <div class="form-group">
                   		 <!--
		            	.邮件提醒
		            	-->	 
                       	<label for="lastname" class="col-sm-2 control-label">邮件接收列表<font color="black">*</font></label>
                        <div class="col-sm-10"><input type="text" class="form-control" name="mailTo"  value="${defaltMailTo}" maxlength="100" ></div>
					</div>
                    
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-6">
							<button type="submit" class="btn btn-primary"  >保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<input type="hidden" name="id" >
                            <input type="hidden" name="jobStatus" >
						</div>
					</div>
					
				</form>
         	</div>
		</div>
	</div>
</div>

 


<!-- 执行参数.模态框 -->
<div class="modal fade" id="triggerModal" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
            	<h4 class="modal-title" name="triggerHeader" >CRON任务</h4>
         	</div>
         	<div class="modal-body">
				<form class="form-horizontal form" role="form" >
					<div class="form-group" name="dailyParam">
                        <label for="lastname" class="col-sm-2 control-label">执行日期<font color="red">*</font></label>
                        <div class="col-sm-4">
                        	<input type="text" class="form-control" name="txDate" placeholder="格式 “yyyyMMdd”" maxlength="8" >
                        </div>
                        
					</div>
                   
                   	<div class="form-group hide" name="cronParam">
                        <label for="lastname" class="col-sm-2 control-label">任务起始日期<font color="red">*</font></label>
                        <div class="col-sm-4">
                        	<input type="text" class="form-control" name="flowLastTime" placeholder="格式“yyyy-MM-dd HH:mm:ss:SSS”" maxlength="30" >
                        </div>
                        <label for="lastname" class="col-sm-2 control-label">任务结束日期<font color="red">*</font></label>
                        <div class="col-sm-4">
                        	<input type="text" class="form-control" name="flowCurTime" placeholder="格式“yyyy-MM-dd HH:mm:ss:SSS”" maxlength="30" >
                        </div>
					</div>
                   
                   
                   <div class="form-group" >
                        <label for="lastname" class="col-sm-2 control-label">触发后续任务<font color="red">*</font></label>
                        <div class="col-sm-4">
                        	<select class="form-control" name="needTriggleNext" >
                				<option value="false" selected>否</option>
                				<option value="true" >是</option>
	                  		</select>
                        </div>
                        
					</div>
                   
                   
                   <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
							<button type="submit" class="btn btn-primary"  >执行</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <input type="hidden" name="id" >
                            <input type="hidden" name="typeDaily" >
                            <input type="hidden" name="triggerType" >
                            <input type="hidden" name="jobStatus" >
                            
						</div>
					</div>
				</form>
         	</div>
		</div>
	</div>
</div>



<!-- 重做参数.模态框 -->
<div class="modal fade" id="dependencyModal" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
            	<h4 class="modal-title" id="triggerHeader" >任务依赖关系，业务时间：</h4>
         	</div>
         	<div class="modal-body">
         		<form id="modalContainer" class="form-horizontal" role="form" >
                   <div class="form-group modal-header" >
	               		<div class="col-sm-4 form-group ">
	               			<div>
								触发
							</div>
	               			<div>
								分组名称-任务名称
							</div>
	               			<div>
								成功<br/>2016-01-01:12:00:00~2016-01-01:13:00:00
							</div>
	               			
						</div>
								
		                <div class="col-sm-4 form-group ">
	               			<div>
								依赖
							</div>
	               			<div>
								分组名称-任务名称
							</div>
	               			<div>
								成功<br/>2016-01-01:12:00:00~2016-01-01:13:00:00
							</div>
	               			
						</div>
				   </div>
				   
				   <div class="form-group  modal-header" >
                        <div class="col-sm-4 form-group ">
	               			<div>
								当前任务
							</div>
	               			<div>
								分组名称-任务名称
							</div>
	               			<div>
								成功<br/>2016-01-01:12:00:00~2016-01-01:13:00:00
							</div>
	               			
						</div>
				   </div>
				   
				    <div class="form-group  modal-header" >
                       <div class="col-sm-4 form-group ">
	               			<div>
								后续
							</div>
	               			<div>
								分组名称-任务名称
							</div>
	               			<div>
								成功<br/>2016-01-01:12:00:00~2016-01-01:13:00:00
							</div>
	               			
						</div>
						
						
						<div class="col-sm-4 form-group ">
	               			<div>
								后续
							</div>
	               			<div>
								分组名称-任务名称
							</div>
	               			<div>
								成功<br/>2016-01-01:12:00:00~2016-01-01:13:00:00
							</div>
	               			
						</div>
				   </div>
					
                </form>   
                
					<div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</div>
         	</div>
		</div>
	</div>
</div>


<@netCommon.commonScript />
<!-- DataTables -->
<script src="${request.contextPath}/static/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${request.contextPath}/static/plugins/jquery/jquery.validate.min.js"></script>
<!-- daterangepicker -->
<script src="${request.contextPath}/static/adminlte/plugins/daterangepicker/moment.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${request.contextPath}/static/js/jobinfo.index.1.js"></script>
</body>
</html>
