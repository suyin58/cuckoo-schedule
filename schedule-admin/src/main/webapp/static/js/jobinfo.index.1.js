$(function() {
	// init date tables
	var jobTable = $("#job_list").dataTable({
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
			url: base_url + "/jobinfo/pageList",
			type:"post",
	        data : function ( d ) {
	        	var obj = {};
	        	obj.groupId = $('#groupId').val();
	        	obj.jobClassApplication = $('#jobClassApplication').val();
	        	obj.jobId = $('#jobId').val();
	        	obj.jobStatus = $('#jobStatus').val();
	        	obj.jobExecStatus = $('#jobExecStatus').val();
	        	obj.start = d.start;
	        	obj.limit = d.length;
                return obj;
            }
	    },
	    "searching": false,
	    "ordering": false,
	    //"scrollX": true,	// X轴滚动条，取消自适应
	    "columns": [
	                { "data": 'id', "bSortable": false, "visible" : true}, 
	                { "data": 'groupId', "bSortable": false, "visible" : false},
	                { "data": 'groupName' , "visible" : true },
					{ "data": 'jobName', "visible" : true},
					{ "data": 'execJobType', "visible" : false},
					{ "data": 'execJobTypeDesc', "visible" : true},
	                { "data": 'jobClassApplication', "visible" : true},
	                { "data": 'jobDesc', "visible" : false},
	                { "data": 'triggerType', "visible" : true},
	                { "data": 'cronExpression', "visible" : true},
	                { "data": 'typeDaily', "visible" : true},
	                
	                { "data": 'offset', "visible" : false},
	                { "data": 'jobStatus', "visible" : true},
	               
	                { "data": 'cuckooParallelJobArgs', "visible" : true},

	                { "data": 'overTime'
	                	,"visible" : false
	                	,"render": function ( data, type, row ) {
	                		if(row.overTime == null){
	                			return "";
	                		}else{
	                			return row.overTime/60/60/1000;
	                		}
	                	}
	                },
	                { "data": 'mailTo'
	                	, "visible" : false
	                	,"render": function ( data, type, row ) {
	                		if(row.mailTo == null){
	                			return "";
	                		}else{
	                			return row.mailTo;
	                		}
	                	}
	                },
	                
	                { "data": 'quartzInit', 
	                	"visible" : true,
	                	"render": function ( data, type, row ) {
	                			return row.triggerType == "CRON"? data?"是":"否" : "";
	                	}
	                },
	                	                
	                { "data": '操作' ,
	                	"render": function ( data, type, row ) {
	                		return function(){
	                			// status
	                			var pause_resume = "";
	                			if ('RUNNING' == row.jobStatus) {
	                				pause_resume = '<button class="btn btn-primary btn-xs job_operate" type="job_pause" type="button">暂停</button>  ';
								} else if ('PAUSE' == row.jobStatus){
									pause_resume = '<button class="btn btn-primary btn-xs job_operate" type="job_resume" type="button">恢复</button>  ';
								}
	                			// log url
	                			var logUrl = base_url +'/joblog?groupId='+row.groupId+'&jobId='+ row.id;
	                			
	                			
	                			 
								// html
								var html = '<p id="'+ row.id +'" '+
								' groupName="'+ row.groupName +'" '+
								' groupId="'+ row.groupId +'" '+
								' jobName="'+ row.jobName +'" '+
								' execJobType="'+ row.execJobType +'" '+
								' jobClassApplication="'+ row.jobClassApplication +'" '+
								' jobDesc="'+ row.jobDesc +'" '+
								' triggerType="'+ row.triggerType +'" '+
								' cronExpression="'+ row.cronExpression +'" '+
								' typeDaily="'+ row.typeDaily +'" '+
								' offset="'+ row.offset +'" '+
								' jobStatus="'+ row.jobStatus +'" '+
								' cuckooParallelJobArgs="'+ row.cuckooParallelJobArgs +'" '+
								' overTime="'+ (row.overTime == null ? "" : row.overTime/60/60/1000 ) +'" '+
								' mailTo="'+ (row.mailTo == null ? "": row.mailTo) +'" '+
//								' txDate="'+ row.txDate +'" '+
//								' execJobStatus="'+ row.execJobStatus +'" '+
//								' flowLastTime="'+ row.flowLastTime +'" '+
//								' flowCurTime="'+ row.flowCurTime +'" '+
								'>'+
								'<button class="btn btn-primary btn-xs trigger"  type="button">执行</button>  '+
								'<button class="btn btn-primary btn-xs jobdependency"  type="button">查看依赖</button>  '+
								pause_resume +
								'<button class="btn btn-primary btn-xs" type="job_del" type="button" onclick="javascript:window.open(\'' + logUrl + '\')" >日志</button><br>  '+
								'<button class="btn btn-warning btn-xs update" type="button">编辑</button>  '+
								'<button class="btn btn-danger btn-xs job_operate" type="job_del" type="button">删除</button>  '+
								'</p>';

	                			return html;
							};
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
	
	// 搜索按钮
	$('#searchBtn').on('click', function(){
		jobTable.fnDraw();
	});
	
	$(".box-header :button").on('click', function(){
		
		var url;
		var type = $(this).attr("type");
		if ("job_pause_all" == type) {
			typeName = "暂停按条件查询出的全部任务？";
			url = base_url + "/jobinfo/paushAll";
		} else if ("job_resume_all" == type) {
			typeName = "恢复按条件查询出的全部任务？";
			url = base_url + "/jobinfo/resumeAll";
		}
		
		ComConfirm.show("确认" + typeName, function(){
			$.ajax({
				type : 'POST',
				url : url,
				data : {
		        	"groupId" : $('#groupId').val(),
		        	"jobClassApplication" : $('#jobClassApplication').val(),
		        	"jobId" : $('#jobId').val(),
		        	"jobStatus" : $('#jobStatus').val(),
		        	"jobExecStatus" : $('#jobExecStatus').val()
	            },
				dataType : "json",
				success : function(data){
					if (data.resultCode == "success") {
						ComAlert.show(1, typeName + data.resultMsg, function(){
							jobTable.fnDraw();
						});
					} else {
						ComAlert.show(2, typeName + "失败," + data.resultMsg);
					}
				},
			});
		});
	});
	
  
	
	
	// job operate
	$("#job_list").on('click', '.job_operate',function() {
		var typeName;
		var url;
		var needFresh = false;

		var type = $(this).attr("type");
		
		if ("job_pause" == type) {
			typeName = "暂停";
			url = base_url + "/jobinfo/pause";
			needFresh = true;
		} else if ("job_resume" == type) {
			typeName = "恢复";
			url = base_url + "/jobinfo/resume";
			needFresh = true;
		} else if ("job_del" == type) {
			typeName = "删除";
			url = base_url + "/jobinfo/remove";
			needFresh = true;
//		} else if ("job_trigger" == type) {
//			typeName = "执行";
//			url = base_url + "/jobinfo/trigger";
//			return;
		} else {
			
			return;
		}
		
		var id = $(this).parent('p').attr("id");
		var groupName = $(this).parent('p').attr("groupName");
		var jobName = $(this).parent('p').attr("jobName");
		
		ComConfirm.show("确认" + typeName +" ["+ groupName +"]-[" +jobName+ "]?", function(){
			$.ajax({
				type : 'POST',
				url : url,
				data : {
					"id" : id
				},
				dataType : "json",
				success : function(data){
					if (data.resultCode == "success") {
						ComAlert.show(1, typeName + data.resultMsg, function(){
							if (needFresh) {
								//window.location.reload();
								jobTable.fnDraw();
							}
						});
					} else {
						ComAlert.show(2, typeName + "失败," + data.resultMsg);
					}
				},
			});
		});
	});
	
	// jquery.validate 自定义校验 “英文字母开头，只含有英文字母、数字和下划线”
	jQuery.validator.addMethod("myValid01", function(value, element) {
		var length = value.length;
		var valid = /^[a-zA-Z][a-zA-Z0-9_]*$/;
		return this.optional(element) || valid.test(value);
	}, "只支持英文字母开头，只含有英文字母、数字和下划线");
	
	// 新增
	$(".add").click(function(){
		
		$('#editModal').modal({backdrop: false, keyboard: false}).modal('show');
		// 修改标题
		$("#editModal .modal-header h4[name='title']").html("新增任务");
		$("#editModal .form input[name='id']").val("");
		
	});
	var editModalValidate = $("#editModal .form").validate({
		errorElement : 'span',  
        errorClass : 'help-block',
        focusInvalid : true,  
        rules : {
        	groupId : {
				required : true 
			},
			execJobType : {
            	required : true
            },
            jobName : {
				required : true
			},
			triggerType : {
				required : true
			},
			typeDaily : {
            	required : true
            },
            jobDesc : {
				required : true,
				maxlength: 200
			},
			preJobId : {
				digits : true
            },
            overTime : {
            	number : true
            }
        }, 
        messages : {  
        	groupId : {
            	required :"请选择“任务分组”."
            },
            execJobType : {
            	required :"请选择“任务类型”."
            },
            jobName : {
				required : '请输入“执行详细信息”.'
			},
			triggerType : {
				required : "请选择触发方式"
			},
			typeDaily : {
            	required : "请选择是否为日切任务"
            },
            jobDesc : {
            	required : "请输入“任务描述”."
            },
            preJobId : {
            	digits : "只能输入一个触发任务的ID."
            },
            overTime : {
            	number : "触发小时，必须是数字"
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
        	$.post(base_url + "/jobinfo/add",  $("#editModal .form").serialize(), function(data, status) {
        		if (data.resultCode == "success") {
					$('#editModal').modal('hide');
					setTimeout(function () {
						ComAlert.show(1, "操作成功", function(){
							jobTable.fnDraw();
							//window.location.reload();
						});
					}, 315);
    			} else {
    				ComAlert.show(2, "操作失败"+ data.resultMsg);
    			}
    		});
		}
	});
	$("#editModal").on('hide.bs.modal', function () {
		$("#editModal .form")[0].reset();
		editModalValidate.resetForm();
		$("#editModal .form .form-group").removeClass("has-error");
		$(".remote_panel").show();	// remote
	});

	
	
	$("#editModal .form select[name='execJobType']").change(function(){
		var execJobType = $("#editModal .form select[name='execJobType']").val();
		if("CUCKOO" == execJobType){
			// 显示app信息  ，参数信息
			$("#editModal .form textarea[name='cuckooTypeContainer']").removeClass("hide");
			$("#editModal .form textarea[name='cuckooTypeContainer']").val("Cuckoo任务需要注解支持，可以通过方法获得对应的参数\n" +
					"执行参数：JobInfoBean.getCuckooParallelJobArgs()\n" +
					"日切任务参数：JobInfoBean.getTxDate()\n" +
					"非日期任务参数：JobInfoBean.getFlowLastTime();	JobInfoBean.getFlowCurrTime();");
			//修改placeHolder
			$("#editModal .form input[name='jobName']").attr("placeholder","与@CuckooTask(‘任务名称’)对应");
			
			
		}else if("SCRIPT" == execJobType){
			// 隐藏app信息  ，参数信息
			$("#editModal .form textarea[name='cuckooTypeContainer']").removeClass("hide");
			$("#editModal .form textarea[name='cuckooTypeContainer']").val("客户端脚本执行自动追加参数：script 执行参数  配置参数(日切:txDate【yyyyMMdd】 / 非日切:flowLastTime【时间戳Long】 flowCurTime【时间戳Long】) \n" +
					"例如：日切任务--&lt; sh /home/job/execdaily.sh 执行参数  20150101 \n" +
					"非日切任务-->&lt; sh /home/job/execundaily.sh 执行参数  1490926800000 1490926800000  ");
			
			// 修改placeHolder
			$("#editModal .form input[name='jobName']").attr("placeholder","脚本(script)执行的完整命令,(请确保脚本已经同步指定APP客户端服务器)");
		}
	});

	// 编辑框触发类型监听
	$("#editModal .form select[name='triggerType']").change(function(){
		var triggerType = $("#editModal .form select[name='triggerType']").val();
		if("CRON" == triggerType){

			$("#editModal .form div[name='typeDailyDiv']").removeClass("hide");
			$("#editModal .form div[name='cronDiv']").removeClass("hide");
			$("#editModal .form div[name='triggerJobDiv']").addClass("hide");
			// 判断是否为日切任务处理
			var typeDaily = $("#editModal .form select[name='typeDaily']").val();
			if("NO" == typeDaily){
				$("#editModal .form div[name='offsetDiv']").addClass("hide");
				$("#editModal .form input[name='offset']").val("");
			}else if("YES" == typeDaily){
				$("#editModal .form div[name='offsetDiv']").removeClass("hide");
			}
		}else if("JOB" == triggerType){

			$("#editModal .form div[name='typeDailyDiv']").removeClass("hide");

			$("#editModal .form div[name='triggerJobDiv']").removeClass("hide");
//			,triggerJobDiv
			$("#editModal .form div[name='cronDiv']").addClass("hide");
			// 非日切任务处理 -- 不需要配置offset
			$("#editModal .form div[name='offsetDiv']").addClass("hide");
			$("#editModal .form input[name='offset']").val("");
		}else if("NONE" == triggerType){
			$("#editModal .form div[name='typeDailyDiv']").addClass("hide");
			$("#editModal .form div[name='cronDiv']").addClass("hide");
			$("#editModal .form div[name='triggerJobDiv']").addClass("hide");
			// 非日切任务处理 -- 不需要配置offset
			$("#editModal .form div[name='offsetDiv']").addClass("hide");
			$("#editModal .form input[name='offset']").val("");
		}else{ 
			alert("unknow trigger type!!!");
		}
	});
	

	// 编辑框是否为日切任务监听
	$("#editModal .form select[name='typeDaily']").change(function(){
		var typeDaily = $("#editModal .form select[name='typeDaily']").val();
		if("NO" == typeDaily){
			$("#editModal .form div[name='offsetDiv']").addClass("hide");
			$("#editModal .form input[name='offset']").val("");
		}else if("YES" == typeDaily){
			// 是日切任务，还需要判断是否为CRON类型任务，非CRON任务offset不需要配置，txdate有上级任务决定
			if("CRON" == $("#editModal .form select[name='triggerType']").val()){
				$("#editModal .form div[name='offsetDiv']").removeClass("hide");
			}else{
				$("#editModal .form div[name='offsetDiv']").addClass("hide");
				$("#editModal .form input[name='offset']").val("");
			}
		}else{
			$("#editModal .form div[name='offsetDiv']").addClass("hide");
			$("#editModal .form input[name='offset']").val("");
		}
	});
	
	
	
	// 更新
	$("#job_list").on('click', '.update',function() {
		// 修改标题
		$("#editModal .modal-header h4[name='title']").html("修改任务");
		$("#editModal .form input[name='id']").val($(this).parent('p').attr("id"));
		// base data
		$("#editModal .form select[name='groupId']").val($(this).parent('p').attr("groupId"));

		$("#editModal .form select[name='execJobType']").val($(this).parent('p').attr("execJobType"));
		
		$("#editModal .form input[name='jobClassApplication']").val($(this).parent('p').attr("jobClassApplication"));
		
		$("#editModal .form input[name='jobName']").val($(this).parent('p').attr("jobName"));
		$("#editModal .form input[name='cuckooParallelJobArgs']").val($(this).parent('p').attr("cuckooParallelJobArgs"));
		
		$("#editModal .form input[name='jobCron']").val($(this).parent('p').attr("jobCron"));
		$("#editModal .form input[name='author']").val($(this).parent('p').attr("author"));

		$("#editModal .form input[name='jobStatus']").val($(this).parent('p').attr("jobStatus"));
		
		$("#editModal .form select[name='triggerType']").val($(this).parent('p').attr("triggerType")).trigger('change');
//		$("#editModal .form select[name='triggerType']").find("option[value='"+$(this).parent('p').attr("triggerType")+"']").attr("selected",true);
		
		$("#editModal .form input[name='cronExpression']").val($(this).parent('p').attr("cronExpression"));

		$("#editModal .form input[name='overTime']").val($(this).parent('p').attr("overTime"));
		$("#editModal .form input[name='mailTo']").val($(this).parent('p').attr("mailTo"));
		
		$.post(base_url + "/jobinfo/getPreJobIdByJobId", 
			{"jobId" : $(this).parent('p').attr("id")}
			, function(data, status) {
				if (data.resultCode == "success") {
					$("#editModal .form input[name='preJobId']").val(data.data); 
				}  
		});
		
		
		$("#editModal .form select[name='typeDaily']").val($(this).parent('p').attr("typeDaily")).trigger('change');
		$("#editModal .form input[name='offset']").val($(this).parent('p').attr("offset")); 

        $.post(base_url + "/jobinfo/getDependencyIdsByJobId", 
    			{"jobId" : $(this).parent('p').attr("id")}
    			, function(data, status) {
    				if (data.resultCode == "success") {
    			        $("#editModal .form input[name='dependencyIds']").val(data.data); 
    				}  
    		});
        $("#editModal .form input[name='jobDesc']").val($(this).parent('p').attr("jobDesc"));

		// jobGroupTitle
		var jobGroupTitle = $("#editModal .form select[name='jobGroup']").find("option[value='" + $(this).parent('p').attr("jobGroup") + "']").text();
		$("#editModal .form .jobGroupTitle").val(jobGroupTitle);


		// show
		$('#editModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	
	
	
	
	$("#job_list").on('click', '.jobdependency',function() {

		var _id = $(this).parent('p').attr("id");
		
		// show
		
		$.ajax({
			type : 'POST',
			url : base_url + '/jobinfo/execview',
			data : {"jobId":_id},
			dataType : "json",
			success : function(data){
				if (data.resultCode = "success") {
					
					// 增加当前任务信息
					var curJob = data.data.curJob;

					var preJob = data.data.preJob;
					var depJobs = data.data.depJobs;
					var nextJobs = data.data.nextJobs;
					
					if(curJob == null){
						ComAlert.show(2, "无法获得当前日志信息");
						return;
					}
					
					
					
					// 删除所有信息
					$('#modalContainer').html("");
					
					// 添加当前任务
					var curContainer = $('<div class="form-group  modal-header" > </div>' ) ;
					curContainer.append(createJob("当前任务",curJob));
					$('#modalContainer').append(curContainer);
					
					// 添加前置任务
					var preContainer = $('<div class="form-group  modal-header" > </div>');
					curContainer.before(preContainer);
					
					if(preJob != null){
						preContainer.append(createJob("触发任务",preJob));
					}
					if(depJobs != null && depJobs.length > 0){
						for(var i = 0 ; i < depJobs.length ; i++){
							preContainer.append(createJob("依赖任务",depJobs[i]));
						}
					}
					

					// 添加后续任务
					
					var nextContainer = $('<div class="form-group  modal-header" > </div>');
					curContainer.after(nextContainer);
					if(nextJobs != null && nextJobs.length > 0){
						for(var i = 0 ; i < nextJobs.length ; i++){
							nextContainer.append(createJob("后续任务",nextJobs[i]));
						}
					}
					
					
					//  显示
					$('#dependencyModal').modal({backdrop: false, keyboard: false}).modal('show');
				} else {
					ComAlert.show(2, data.resultMsg);
				}
			},
		});
	});

	function createJob(jobTitle, jobInfo){
		
		var html = '<div class="col-sm-5 form-group "> '+
			   			'<div> '+ jobTitle + '【' + jobInfo.groupId + ' ~ ' + jobInfo.id+ '】' +  '</div> '+
			   			'<div> 【'+
			   				jobInfo.groupName + '-'+jobInfo.jobName+
						'】</div> ';
		html +=	'<div> 触发类型:'+
					jobInfo.triggerType +(jobInfo.triggerType == 'CRON' ? '['+jobInfo.cronExpression +']': '') +'<br/>'
					+ (jobInfo.typeDaily == 'YES' ? '日切任务':'非日切任务' ) + ',状态:' + jobInfo.jobStatus +
				'</div> ';
//		html +=	 '</div> ';
		
		
		return $(html);
	}
	
	
	// 执行
	$("#job_list").on('click', '.trigger',function() {
		
		// header - 
		$("#triggerModal .form input[name='triggerHeader']").html($(this).parent('p').attr("typeDaily") + " 任务");
		if("YES" == $(this).parent('p').attr("typeDaily")){
			$("#triggerModal .form div[name='dailyParam']").removeClass("hide");
			$("#triggerModal .form div[name='cronParam']").addClass("hide");
		}else if("NO" == $(this).parent('p').attr("typeDaily")){
			$("#triggerModal .form div[name='dailyParam']").addClass("hide");
			$("#triggerModal .form div[name='cronParam']").removeClass("hide");
		}else{
			$("#triggerModal .form div[name='dailyParam']").addClass("hide");
			$("#triggerModal .form div[name='cronParam']").addClass("hide");
		}
		// base data
		$("#triggerModal .form input[name='id']").val($(this).parent('p').attr("id"));
		$("#triggerModal .form input[name='triggerType']").val($(this).parent('p').attr("triggertype"));
		$("#triggerModal .form input[name='typeDaily']").val($(this).parent('p').attr("typeDaily"));
		

		// show
		$('#triggerModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	var triggerModalValidate = $("#triggerModal .form").validate({
		errorElement : 'span',  
        errorClass : 'help-block',
        focusInvalid : true,

		
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
			// post
    		$.post(base_url + "/jobinfo/trigger", $("#triggerModal .form").serialize(), function(data, status) {
    			if (data.resultCode == "success") {
					$('#triggerModal').modal('hide');
					setTimeout(function () {
						ComAlert.show(1, "添加执行完成", function(){
							//window.location.reload();
							jobTable.fnDraw();
						});
					}, 315);
    			} else {
    				if (data.resultMsg) {
    					ComAlert.show(2, data.resultMsg);
					} else {
						ComAlert.show(2, "更新失败");
					}
    			}
    		});
		}
	});
	$("#triggerModal").on('hide.bs.modal', function () {
		$("#triggerModal .form")[0].reset();
	});
	

});
