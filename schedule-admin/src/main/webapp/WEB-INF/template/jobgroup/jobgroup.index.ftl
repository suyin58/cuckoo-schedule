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
			<h1>调度管理<small>分组管理</small></h1>
		</section>

		<!-- Main content -->
	    <section class="content">
			
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
			            <div class="box-header">
							<h3 class="box-title">分组列表</h3>&nbsp;&nbsp;
							<button class="btn btn-info btn-xs pull-left2 add" >+新增分组</button>
							
						</div>
			            <div class="box-body">
			              	<table id="jobgroup_list" class="table table-bordered table-striped display" width="100%" >
				                <thead>
					            	<tr>
                                        <th name="id" >ID</th>
                                        <th name="groupName" >分组名称</th>
                                        <th name="groupDesc" >分组描述</th>
                                        <th name="operate" >操作</th>
					                </tr>
				                </thead>
                                <tbody>
								<#if jobGroups?exists && jobGroups?size gt 0>
								<#list jobGroups as group>
									<tr>
                                        <td>${group.id}</td>
                                        <td>${group.groupName}</td>
                                        <td>${group.groupDesc}</td>
                                        <td>
											
	                                       <button class="btn btn-warning btn-xs add" id="${group.id}" groupName="${group.groupName}"  groupDesc="${group.groupDesc}" >编辑</button>
	                                       <button class="btn btn-danger btn-xs remove" id="${group.id}" >删除</button>
										   <button class="btn btn-info btn-xs auth" id="${group.id}" >权限管理</button>
										</td>
									</tr>
								</#list>
								</#if>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
	    </section>
	</div>

    <!-- 新增.模态框 -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" >新增分组</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal form" role="form" >
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">名称<font color="red">*</font></label>
                            <div class="col-sm-10"><input type="text" class="form-control" name="groupName" placeholder="请输入“分组名称”" maxlength="50" ></div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">描述<font color="red">*</font></label>
                            <div class="col-sm-10"><input type="text" class="form-control" name="groupDesc" placeholder="请输入“分组描述”" maxlength="200" ></div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6">
                                <button type="submit" class="btn btn-primary"  >保存</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <input type="hidden" name="id" >
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


<!-- job新增.模态框 -->
<div class="modal fade" id="authModal" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="box">
		    <div class="box-header">
		    	<h3 class="box-title">权限分配</h3>
		    </div>
		    <div class="box-body">
		      	<table id="job_list" class="table table-bordered table-striped">
					<thead>
					<tr>
						<th name="id" >id</th>
						<th name="userId" >用户ID</th>
						<th name="groupId" >分组ID</th>
						<th name="userName" >用户姓名</th>
						<th name="userAuthType" >权限类型</th>
						<th name="writable" >写权限</th>
						<th name="readable" >读权限</th>
						<th name="grantable" >分配权限</th>
					</tr>
					</thead>
					<tbody></tbody>
					<tfoot></tfoot>
				</table>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-6"> 
				<input type="hidden" name="groupId" >
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
		</div>
		
	</div>
</div>

	
	<!-- footer -->
	<@netCommon.commonFooter />
</div>

<@netCommon.commonScript />
<!-- DataTables -->
<script src="${request.contextPath}/static/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${request.contextPath}/static/plugins/jquery/jquery.validate.min.js"></script>
<script src="${request.contextPath}/static/js/jobgroup.index.1.js"></script>
</body>
</html>
