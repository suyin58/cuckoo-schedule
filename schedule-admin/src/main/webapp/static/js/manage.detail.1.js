$(function(){
	
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
				required : false,
				rangelength:[6, 12]
			},
			userPwd2 : {
				required : false,
//				digits:true,
				rangelength:[6, 12],
				equalTo: "#registModal [name='userPwd']"
			}
		},
		messages : {
			userName : {
				rangelength:"名称长度4~16位",
			},
			userPwd : {
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

				if (data.resultCode == "success") {
					setTimeout(function () {
						ComAlert.show(1, "保存成功", function(){
							$('#registModal').modal('hide');
						});
					}, 315);
					
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