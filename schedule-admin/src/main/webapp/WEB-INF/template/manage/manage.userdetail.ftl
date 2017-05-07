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
			
		    <div class="" id="registModal" tabindex="-1" role=""  aria-hidden="true">
		        <div class="modal-dialog ">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <h4 class="modal-title" name="title" >信息管理-第(${userInfo.id + 100})位用户</h4>
		                </div>
		                <div class="modal-body">
		                    <form class="form-horizontal form" role="form" >
		                    	<div class="form-group">
		                            <label for="lastname" class="col-sm-2 control-label">用户类型<font color="red">*</font></label>
		                            <div class="col-sm-8">
		                            	<#if "ADMIN"==logonInfo.cuckooUserAuthType.value>
		                            		<select class="form-control" name="userAuthType"  paramVal="${groupId}" >
					                			<!--
					                            <option value="0" selected>请选择</option>
					                            -->
					                			<#list userTypes as userType>
					                				<option value="${userType.value}" <#if userInfo.userAuthType == userType.value>selected</#if> >${userType.description}</option>
					                			</#list>
						                  	</select>
		                        		<#else> 
			                        		<input type="text" class="form-control" name="userAuthType" placeholder="请输入“登录名称”" maxlength="50" value="${userInfo.userAuthType}" readonly="readonly">
			                        	</#if>
		                            </div>
		                        </div>
		                    
		                        <div class="form-group">
		                            <label for="lastname" class="col-sm-2 control-label">登录名<font color="red">*</font></label>
		                            <div class="col-sm-8">
		                            	<input type="text" class="form-control" name="userName" placeholder="请输入“登录名称”" maxlength="50" value="${userInfo.userName}" <#if userInfo!=null>readonly="readonly"</#if>>
		                            </div>
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
		                            <label for="lastname" class="col-sm-2 control-label">公司名称</label>
		                            <div class="col-sm-8"><input type="text" class="form-control" name="orgName" placeholder="请输入公司名称(仅作交流)" maxlength="200" value="${userInfo.orgName}"></div>
		                        </div>
		                        
		                        <div class="form-group">
		                            <label for="lastname" class="col-sm-2 control-label">邮箱</label>
		                            <div class="col-sm-8"><input type="text" class="form-control" name="email" placeholder="请输入邮箱(仅作交流)" maxlength="200" value="${userInfo.email}" ></div>
		                        </div>
		                        <div class="form-group">
		                            <label for="lastname" class="col-sm-2 control-label">电话号码</label>
		                            <div class="col-sm-8"><input type="text" class="form-control" name="phone" placeholder="请输入手机号码(仅作交流)" maxlength="200" value="${userInfo.phone}"></div>
		                        </div>
		                        <hr>
		                        <div class="form-group">
		                            <div class="col-sm-offset-3 col-sm-6">
		                                <button type="submit" class="btn btn-primary"  >保存</button>
		                                <input type="hidden" class="form-control" name="id"    value="${userInfo.id}">
		                            </div>
		                        </div>
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
<!-- DataTables -->
<!-- daterangepicker -->
<script src="${request.contextPath}/static/adminlte/plugins/daterangepicker/moment.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${request.contextPath}/static/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${request.contextPath}/static/plugins/jquery/jquery.validate.min.js"></script>
<script src="${request.contextPath}/static/js/manage.detail.1.js"></script>
</body>
</html>
