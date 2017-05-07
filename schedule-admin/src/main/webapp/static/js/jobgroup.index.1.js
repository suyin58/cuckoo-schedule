$(function() {
	
	
	var groupTable = $("#job_list").dataTable({
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
			url: base_url + "/jobgroup/groupauthlist",
			type:"post",
	        data : function ( d ) {
	        	var obj = {};
	        	obj.groupId = $("#authModal .form-group input[name='groupId']").val();
	        	obj.start = d.start;
	        	obj.limit = d.length;
                return obj;
            }
	    },
	    "searching": false,
	    "ordering": false,
	    //"scrollX": true,	// X轴滚动条，取消自适应
	    "columns": [
	                { "data": 'id', "bSortable": true, "visible" : true}, 
	                { "data": 'userId', "bSortable": true, "visible" : false}, 
	                { "data": 'groupId', "bSortable": true, "visible" : false}, 
	                { "data": 'userName', "bSortable": false, "visible" : true},
	                { "data": 'userAuthType' , "visible" : true },
	                { "data": 'writable'
	                	, "visible" : true
	                	,"render": function ( data, type, row ) {
	                		
	                		var text = "否";
	                		var color = "btn-warning";
	                		if(row.writable == "YES"){
	                			text = "是";
	                			color = "btn-info";
	                		} 
	                		if(row.userAuthType == "ADMIN"){
	                			text = "是";
	                		}
	                		if(row.userAuthType == "NORMAL"){
	                			return "<button class='btn "+color+" btn-xs auth' dataType='writable' authId='"+(row.id==null ?"":row.id)+"' userId='"+(row.userId==null ?"":row.userId)+"' groupId='"+(row.groupId==null ?"":row.groupId) +"' \"> "+text+"</button>";
	                		}
	                		return text;
	                	}
	                },
	                { "data": 'readable'
	                	, "visible" : true
	                	,"render": function ( data, type, row ) {
	                		var text = "否";
	                		var color = "btn-warning";
	                		if(row.readable == "YES"){
	                			text = "是";
	                			color = "btn-info";
	                		} 
	                		if(row.userAuthType != "NORMAL"){
	                			text = "是";
	                		}
	                		
	                		if(row.userAuthType == "NORMAL"){
	                			return "<button class='btn "+color+" btn-xs auth' dataType='readable' authId='"+(row.id==null ?"":row.id)+"' userId='"+(row.userId==null ?"":row.userId)+"' groupId='"+(row.groupId==null ?"":row.groupId) +"' \"> "+text+"</button>";
	                		}
	                		return text;
	                	}
	                },
	                { "data": 'grantable'
	                	, "visible" : true
	                	,"render": function ( data, type, row ) {
	                		var text = "否";
	                		var color = "btn-warning";
	                		if(row.grantable == "YES"){
	                			text = "是";
	                			color = "btn-info";
	                		} 
	                		if(row.userAuthType == "ADMIN"){
	                			text = "是";
	                		}
	                		if(row.userAuthType == "NORMAL"){
	                			return "<button class='btn "+color+" btn-xs auth' dataType='grantable' authId='"+(row.id==null ?"":row.id)+"' userId='"+(row.userId==null ?"":row.userId)+"' groupId='"+(row.groupId==null ?"":row.groupId) +"' \"> "+text+"</button>";
	                		}
	                		return text;
	                	}
	                },
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
	
	$("#job_list").on('click', '.auth',function() {

		$.ajax({
			type : 'POST',
			url : base_url + '/jobgroup/changeAuth',
			data : {
				"type" : $(this).attr("dataType"),
				"authId" : $(this).attr("authid"),
				"userId" : $(this).attr("userid"),
				"groupId" : $(this).attr("groupid"),
				},
			dataType : "json",
			success : function(data){
				if (data.resultCode == "success") {
					ComAlert.show(1, '修改成功');
					groupTable.fnDraw();
				} else {
					if (data.resultMsg) {
						ComAlert.show(2, data.resultMsg);
					} else {
						ComAlert.show(2, '修改失败');
					}
				}
			},
		});
	});

	// remove
	$("#jobgroup_list").on('click', '.remove',function() {
		var id = $(this).attr('id');

		ComConfirm.show("确认删除分组,删除分组的用时，分组的任务也会一起删除?", function(){
			$.ajax({
				type : 'POST',
				url : base_url + '/jobgroup/remove',
				data : {"id":id},
				dataType : "json",
				success : function(data){
					if (data.resultCode == "success") {
						ComAlert.show(1, '删除成功');
						window.location.reload();
					} else {
						if (data.resultMsg) {
							ComAlert.show(2, data.resultMsg);
						} else {
							ComAlert.show(2, '删除失败');
						}
					}
				},
			});
		});
	});


	$(".add").on('click',function() {
		$('#addModal').modal({backdrop: false, keyboard: false}).modal('show');
		$("#addModal .form input[name='id']").val($(this).attr("id"));
		$("#addModal .form input[name='groupName']").val($(this).attr("groupName"));
		$("#addModal .form input[name='groupDesc']").val($(this).attr("groupDesc"));
		$('#addModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	
	$("#jobgroup_list").on('click', '.auth',function() {
		
		$("#authModal .form-group input[name='groupId']").val($(this).attr("id"));
		groupTable.fnDraw();
		$('#authModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	
	
	$("#authModal").on('hide.bs.modal', function () {
		$("#authModal .form .form-group").removeClass("has-error");
	});
	
	var addModalValidate = $("#addModal .form").validate({
		errorElement : 'span',
		errorClass : 'help-block',
		focusInvalid : true,
		rules : {
			groupName : {
				required : true,
				rangelength:[4,64],
			},
//			title : {
//				required : true,
//				rangelength:[4, 12]
//			},
//			order : {
//				required : true,
//				digits:true,
//				range:[1,1000]
//			}
		},
		messages : {
			appName : {
				required :"请输入“分组名称”",
				rangelength:"分组名称长度限制为4~64",
			},
//			title : {
//				required :"请输入“执行器名称”",
//				rangelength:"长度限制为4~12"
//			},
//			order : {
//				required :"请输入“排序”",
//				digits: "请输入整数",
//				range: "取值范围为1~1000"
//			}
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
			$.post(base_url + "/jobgroup/save",  $("#addModal .form").serialize(), function(data, status) {
				if (data.resultCode == "success") {
					$('#addModal').modal('hide');
					setTimeout(function () {
						ComAlert.show(1, "保存成功", function(){
							window.location.reload();
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
	$("#addModal").on('hide.bs.modal', function () {
		$("#addModal .form")[0].reset();
		addModalValidate.resetForm();
		$("#addModal .form .form-group").removeClass("has-error");
	});

	
	
});


 
