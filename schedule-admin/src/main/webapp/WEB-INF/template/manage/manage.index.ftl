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
			<h1>调度管理<small>管理台</small></h1>
		</section>

		<!-- Main content -->
	    <section class="content">
			<div class="row">
	    		<div class="col-xs-4">
	              	<div class="input-group">
	                	<span class="input-group-addon">分组名称</span>
                		<select class="form-control" id="userAuthType" >
                			<option value="" >全部</option>
                			<#list userTypes as userType>
                				<option value="${userType.value}" >${userType.description}</option>
                			</#list>
	                  	</select>
	              	</div>
	            </div>
	            <div class="col-xs-2">
	            	<button class="btn btn-block btn-info" id="searchBtn">搜索</button>
	            </div>
	            <div class="col-xs-2">
	            	<button class="btn btn-block btn-success" id="registBtn" type="button">+新增用户</button>
	            </div>
          	</div>
          	
          	
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
			            <div class="box-body">
			              	<table id="user_list" class="table table-bordered table-striped">
				                <thead>
					            	<tr>
					            		<th name="id" >标准ID</th>
					                  	<th name="userAuthType" >用户类型</th> 
					                	<th name="userName" >用户名称</th>
					                  	<th name="phone" >电话</th>
					                  	<th name="email" >邮箱</th> 
					                  	<th name="orgName" >机构</th>
					                  	<th name="handleMsg" >操作</th>
					                  	 
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

     
     
     <!-- 新增.模态框 -->
    <div class="modal fade" id="registModal" tabindex="-1" role="dialog"  aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" >注册新账户</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal form" role="form" >
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">登录名<font color="red">*</font></label>
                            <div class="col-sm-8"><input type="text" class="form-control" name="userName" placeholder="请输入“登录名称”" maxlength="50" ></div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">密码<font color="red">*</font></label>
                            <div class="col-sm-8"><input type="password" class="form-control"  name="userPwd"  maxlength="200" ></div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">确认密码<font color="red">*</font></label>
                            <div class="col-sm-8"><input type="password" class="form-control" name="userPwd2"  maxlength="200" ></div>
                        </div>
                        
                        <div class="form-group">
	                        <label for="firstname" class="col-sm-2 control-label">用户类型<font color="red">*</font></label>
						    <div class="col-sm-8">
								<select class="form-control" name="userAuthType" >
									<option value="" ></option>
			                		<#list userTypes as userType>
			                			<option value="${userType.value}" >${userType.description}</option>
			                		</#list>
				                </select>
							</div>
                        </div>
                        
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">公司名称</label>
                            <div class="col-sm-8"><input type="text" class="form-control" name="orgName" placeholder="请输入公司名称(仅作交流)" maxlength="200" ></div>
                        </div>
                        
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-8"><input type="text" class="form-control" name="email" placeholder="请输入邮箱(仅作交流)" maxlength="200" ></div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-sm-2 control-label">电话号码</label>
                            <div class="col-sm-8"><input type="text" class="form-control" name="phone" placeholder="请输入手机号码(仅作交流)" maxlength="200" ></div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6">
                                <button type="submit" class="btn btn-primary"  >保存</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
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
<script src="${request.contextPath}/static/js/manage.index.1.js"></script>
</body>
</html>
