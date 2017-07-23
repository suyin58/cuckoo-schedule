$(function(){
	// 复选框
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    
	// 登陆.规则校验
	var loginFormValid = $("#loginForm").validate({
		errorElement : 'span',  
        errorClass : 'help-block',
        focusInvalid : true,  
        rules : {  
        	userName : {  
        		required : true ,
                minlength: 5,
                maxlength: 18
            },  
            password : {  
            	required : true ,
                minlength: 5,
                maxlength: 18
            } 
        }, 
        messages : {  
        	userName : {  
                required :"请输入登陆账号."  ,
                minlength:"登陆账号不应低于5位",
                maxlength:"登陆账号不应超过18位"
            },  
            password : {
            	required :"请输入登陆密码."  ,
                minlength:"登陆密码不应低于5位",
                maxlength:"登陆密码不应超过18位"
            }
        }, 
		highlight : function(element) {  
            $(element).closest('.form-group').addClass('has-error');  
        },
        success : function(label) {  
            label.closest('.form-group').removeClass('has-error');  
            label.remove();  
        },
        errorPlacement : function(error, element) {  
            element.parent('div').append(error);  
        },
        submitHandler : function(form) {
			$.post(base_url + "/logon/in", $("#loginForm").serialize(), function(data, status) {
				if (data.resultCode == "success") {
//					ComAlert.show(1, "登陆成功", function(){
						window.location.href = base_url + redirectURL;
//					});
				} else {
					ComAlert.show(2, data.resultMsg);
				}
			});
		}
	});
	
	
	// 注册按钮
	$('#registBtn').on('click', function(){
		$('#registModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	
	
	var addModalValidate = $("#registModal .form").validate({
		errorElement : 'span',
		errorClass : 'help-block',
		focusInvalid : true,
		rules : {
			userName : {
				required : true,
				rangelength:[4,16]
			},
			userPwd : {
				required : true,
				rangelength:[6, 12]
			},
			userPwd2 : {
				required : true,
//				digits:true,
				rangelength:[6, 12],
				equalTo: "#registModal [name='userPwd']"
			}
		},
		messages : {
			userName : {
				required :"请输入“登录名称”",
				rangelength:"名称长度4~16位",
			},
			userPwd : {
				required :"请输入“密码”",
				rangelength:"长度限制为6~12"
			},
			userPwd2 : {
				required :"请再次输入“密码”",
//				digits: "请输入整数",
				rangelength: "长度限制为6~12",
				equalTo: "请输入相同的密码"
			}
		},
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		success : function(label) {
			label.closest('.form-group').removeClass('has-error');
			label.remove();
		},
		errorPlacement : function(error, element) {
			element.parent('div').append(error);
		},
		
		submitHandler : function(form) {
			$.post(base_url + "/logon/regist",  $("#registModal .form").serialize(), function(data, status) {

				var userName = $("#registModal [name='userName']").val();
				if (data.resultCode == "success") {
					setTimeout(function () {
						ComAlert.show(1, "保存成功", function(){
							$("#loginForm [name='user']").val(userName);
						});
					}, 315);
					$('#registModal').modal('hide');
				} else {
					if (data.resultMsg) {
						ComAlert.show(2, data.resultMsg);
					} else {
						ComAlert.show(2, "保存失败");
					}
				}
			});
		}
	});
	$("#registModal").on('hide.bs.modal', function () {
		$("#registModal .form")[0].reset();
		addModalValidate.resetForm();
		$("#registModal .form .form-group").removeClass("has-error");
	});
	
	// jquery.validate 自定义校验 “英文字母开头，只含有英文字母、数字和下划线”
	jQuery.validator.addMethod("equalTo", function(value, element, param) {

		var pwd = $(param).val();
		
		return pwd == value; 
	}, "两次密码不一致");

	
});