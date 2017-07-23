<!DOCTYPE html>
<html>
<head>
  	<title>调度中心</title>
  	<#import "/common/common.macro.ftl" as netCommon>
	<@netCommon.commonStyle />
    <link rel="stylesheet" href="${request.contextPath}/static/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a><b>Cuckoo</b>JOB</a>
		</div>
		<form id="loginForm" method="post" >
			<div class="login-box-body">
				<p class="login-box-msg">任务调度中心</p>
				<div class="form-group has-feedback">
	            	<input type="text" name="user" class="form-control" placeholder="请输入登陆账号" value="guest" >
	            	<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
	          	<div class="form-group has-feedback">
	            	<input type="password" name="pwd" class="form-control" >
	            	<span class="glyphicon glyphicon-lock form-control-feedback"></span>
	          	</div>
				<div class="row">
					<div class="col-xs-8">
		              	<div class="checkbox icheck">
		                	<label>
		                  		<input type="checkbox" name="ifRemember" > 记住密码</input>
		                	</label>
						</div>
		            </div>
		            
		           
		            <div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
					</div>
				</div>
			</div>
		</form>
		<!--
		<div class="form-group">
			<button id="registBtn" class="btn btn-primary btn-block btn-flat">免费注册</button>
		</div>
		-->
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
		
	
<@netCommon.commonScript />
<script src="${request.contextPath}/static/plugins/jquery/jquery.validate.min.js"></script>
<script src="${request.contextPath}/static/plugins/iCheck/icheck.min.js"></script>
<script src="${request.contextPath}/static/js/login.1.js"></script>

</body>
</html>
