$(function(){
	
	var userTable = $("#user_list").dataTable({
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
	        url: base_url + "/manage/userList" ,
	        data : function ( d ) {
	        	var obj = {};
	        	obj.userAuthType = $('#userAuthType').val();
	        	obj.start = d.start;
	        	obj.limit = d.length;
                return obj;
            }
	    },
	    "searching": false,
	    "ordering": false,
	    //"scrollX": false,
	    "columns": [
	                { "data": 'id', "bSortable": false, "visible" : true},
	                { "data": 'userAuthType', "bSortable": false, "visible" : true},
	                { "data": 'userName', "bSortable": false, "visible" : true},	                 
	                { "data": 'phone', "visible" : true},
	                { "data": 'email', "visible" : false},
	                { "data": 'orgName', "visible" : true},
	                { "data": 'handleMsg' , "bSortable": false,
	                	"render": function ( data, type, row ) {
	                		// better support expression or string, not function
	                		return function () {

	                			var temp = '<button class="btn btn-primary btn-xs detail"  type="button"  _id="'+ row.id +'"">详情</button> &nbsp; &nbsp;';
		                		return temp;	
	                		}
	                	}
	                }
	            ],
		"language" : {
			"sProcessing" : "处理中...",
			"sLengthMenu" : "每页 _MENU_ 条记录",
			"sZeroRecords" : "没有匹配结果",
			"sInfo" : "第 _PAGE_ 页 ( 总共 _TOTAL_ 行 )",
			"sInfoEmpty" : "无记录",
			"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
			"sInfoPostFix" : "",
			"sSearch" : "搜索:",
			"sUrl" : "",
			"sEmptyTable" : "表中数据为空",
			"sLoadingRecords" : "载入中...",
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "上页",
				"sNext" : "下页",
				"sLast" : "末页"
			},
			"oAria" : {
				"sSortAscending" : ": 以升序排列此列",
				"sSortDescending" : ": 以降序排列此列"
			}
		}
	});
	
	$('#user_list').on('click', '.detail', function(){
		var _id = $(this).attr('_id');
		window.open(base_url + '/manage/userdetail?id=' + _id);
		return;
		
		
	});
	// 搜索按钮
	$('#searchBtn').on('click', function(){
		userTable.fnDraw();
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