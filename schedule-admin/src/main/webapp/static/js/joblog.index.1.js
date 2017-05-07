$(function() {

	// 任务组列表选中, 任务列表初始化和选中
    var ifParam = true;
	$("#groupId").on("change", function () {

		var groupId = $(this).children('option:selected').val();
		$.ajax({
			type : 'POST',
            async: false,   // async, avoid js invoke pagelist before jobName data init
			url : base_url + '/joblog/getJobsByGroup',
			data : {"groupId":groupId},
			dataType : "json",
			success : function(data){
				if (data.resultCode == "success") {
					$("#jobId").html('<option value="" >请选择</option>');
                        $.each(data.data, function (n, value) {
                        $("#jobId").append('<option value="' + value.id + '" >' +value.jobName +"【"+ value.jobDesc + '】</option>');
                    });
                    if ($("#jobId").attr("paramVal")){
                        $("#jobId").find("option[value='" + $("#jobId").attr("paramVal") + "']").attr("selected",true);
                        $("#jobId").attr("paramVal")
                    }
				} else {
					ComAlertTec.show(data.resultMsg);
				}
			},
		});
	});
	
	
	if ($("#groupId").attr("paramVal")){
		$("#groupId").find("option[value='" + $("#groupId").attr("paramVal") + "']").attr("selected",true);
        $("#groupId").change();
        $("#groupId").attr("")
	}

	// 过滤时间
	$('#filterTime').daterangepicker({
		timePicker: true, 			//是否显示小时和分钟
		timePickerIncrement: 10, 	//时间的增量，单位为分钟
		timePicker12Hour : false,	//是否使用12小时制来显示时间
		format: 'YYYY-MM-DD HH:mm:ss',
		separator : ' - ',
		ranges : {
            '最近1小时': [moment().subtract('hours',1), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
            '最近7日': [moment().subtract('days', 6), moment()],
            '最近30日': [moment().subtract('days', 29), moment()]
        },
        opens : 'left', //日期选择框的弹出位置
        locale : {
        	customRangeLabel : '自定义',
            applyLabel : '确定',
            cancelLabel : '取消',
            fromLabel : '起始时间',
            toLabel : '结束时间',
            daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
            monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ],
            firstDay : 1
        }
	});
	$('#filterTime').val( moment(new Date()).add(-30, 'days').format("YYYY-MM-DD 00:00:00") + ' - ' + moment(new Date()).add(1, 'days').format("YYYY-MM-DD 00:00:00") );	// YYYY-MM-DD HH:mm:ss
	
	// init date tables
	var logTable = $("#joblog_list").dataTable({
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
	        url: base_url + "/joblog/pageList" ,
	        data : function ( d ) {
	        	var obj = {};
	        	obj.groupId = $('#groupId').val();
	        	obj.jobId = $('#jobId').val();
	        	obj.jobStatusStr = $("#jobStatusStr").val();
				obj.filterTime = $('#filterTime').val();
	        	obj.logId = $('#logId').val();
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
	                { "data": 'groupId', "bSortable": false, "visible" : true},
	                { "data": 'jobId', "bSortable": false, "visible" : true},	                 
	                { "data": 'jobName', "visible" : true},
	                { "data": 'jobClassApplication', "visible" : false},
	                { "data": 'triggerType', "visible" : true},
					

	                { "data": 'cronExpression', "visible" : false},
	                { "data": 'execJobStatus', "visible" : true},
	                { 
	                	"data": 'jobStartTime', 
	                	"render": function ( data, type, row ) {
	                		return data != 0 ?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	}
	                },
	                { "data": 'jobExecTimeDesc', "visible" : true},
	                { 
	                	"data": 'jobEndTime', 
	                	"render": function ( data, type, row ) {
	                		return data!= 0 ?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	}
	                },
	                { "data": 'needTriggleNext'},
	                { "data": 'forceTriggle'},
	                { "data": 'remark', "visible" : false},
	                
	                
//	                { 
//	                	"data": 'triggerMsg',
//	                	"render": function ( data, type, row ) {
//	                		return data?'<a class="logTips" href="javascript:;" >查看<span style="display:none;">'+ data +'</span></a>':"无";
//	                	}
//	                },
	                
	                
	                


	                { "data": 'cuckooClientIp', "visible" : false},
	                { "data": 'cuckooClientTag', "visible" : false},
	                { "data": 'typeDaily', "visible" : true},
	                { "data": 'txDate',
	                	"render": function ( data, type, row ) {
	                		return data == 0 ? "" : data;
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowLastTime',
	                	"render": function ( data, type, row ) {
	                		return row.flowLastTimeDesc;
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowCurTime',
	                	"render": function ( data, type, row ) {
	                		return row.flowCurTimeDesc;
	                	},
	                	"visible" : true
	                },

	                { "data": 'cuckooParallelJobArgs',"bSortable": false, "visible" : false},
	                
//	                { 
//	                	"data": 'handleMsg',
//	                	"render": function ( data, type, row ) {
//	                		return data?'<a class="logTips" href="javascript:;" >查看<span style="display:none;">'+ data +'</span></a>':"无";
//	                	}
//	                },
	                { "data": 'handleMsg' , "bSortable": false,
	                	"render": function ( data, type, row ) {
	                		// better support expression or string, not function
	                		return function () {

//	                			PENDING("PENDING", "等待执行"), 
//	                			RUNNING("RUNNING", "正在执行"), 
//	                			FAILED("FAILED", "执行失败"),
//	                			SUCCED("SUCCED", "执行成功"),
//	                			BREAK("BREAK", "断线");
	                			var temp = '<button class="btn btn-primary btn-xs detail"  type="button"  _id="'+ row.id +'" _execJobStatus="'+ row.execJobStatus+'"">详情</button> &nbsp; &nbsp;';
                					temp += '<button class="btn btn-primary btn-xs dependency"  type="button"  _id="'+ row.id +'" _execJobStatus="'+ row.execJobStatus+'">查看依赖</button>';
	                				temp += '<button class="btn btn-primary btn-xs redo"  type="button"  _id="'+ row.id +'" _execJobStatus="'+ row.execJobStatus+'">再次执行</button>';	
	                			if (row.execJobStatus != 'SUCCED'){	                			
//		                			if (row.execJobStatus == 'RUNNING'){
//		                				
//		                				temp += '<button class="btn btn-primary btn-xs redo"  type="button"   _id="'+ row.id +'">强制结束</button>';		                			
//		                			}else{
		                				
		                				temp += '<button class="btn btn-primary btn-xs reset"  type="button"   _id="'+ row.id +'" _execJobStatus="'+ row.execJobStatus+'">修改为成功</button>';		                			
//		                			}
		                		}
		                		
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
	

	// 搜索按钮
	$('#searchBtn').on('click', function(){
		logTable.fnDraw();
	});
	
	
	 
	$('#joblog_list').on('click', '.redo', function(){
		
		$("#redoModal .form input[name='logId']").val($(this).attr('_id'));

		// show
		$('#redoModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	
	var triggerModalValidate = $("#redoModal .form").validate({
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
    		$.post(base_url + "/joblog/redo", $("#redoModal .form").serialize(), function(data, status) {
    			if (data.resultCode == "success") {
					$('#redoModal').modal('hide');
					setTimeout(function () {
						ComAlert.show(1, "已加入重新执行队列 ,新日志ID:"+ data.data, function(){
							//window.location.reload();
//							jobTable.fnDraw();
						});
					}, 315);
    			} else {
    				if (data.resultMsg) {
    					ComAlert.show(2, data.resultMsg);
					} else {
						ComAlert.show(2, "操作失败");
					}
    			}
    		});
		}
	});
	$("#triggerModal").on('hide.bs.modal', function () {
		$("#triggerModal .form")[0].reset();
	});
	
	
	 
	$('#joblog_list').on('click', '.reset', function(){
//		var msg = $(this).find('span').html();
//		ComAlertTec.show(msg);
		// 修改为成功
		var _id = $(this).attr('_id');
		var _execJobStatus = $(this).attr('_execJobStatus');
		ComConfirm.show("确认将任务"+_id+"【"+_execJobStatus+"】状态重置成功吗？", function(){
			$.ajax({
				type : 'POST',
				url : base_url + '/joblog/reset',
				data : {"logId":_id},
				dataType : "json",
				success : function(data){
					if (data.resultCode == "success") {
						ComAlert.show(1, '操作成功');
						logTable.fnDraw();
					} else {
						ComAlert.show(2, data.resultMsg);
					}
				},
			});
		});
	});
	
	// 查看执行器详细执行日志
	$('#joblog_list').on('click', '.detail', function(){
		var _id = $(this).attr('_id');
		
		window.open(base_url + '/joblog/logdetail?logId=' + _id);
		return;
		
		
	});
	
	
	
	// 搜索按钮
	$('#joblog_list').on('click', '.dependency', function(){

		var _id = $(this).attr('_id');
		
		// show
		
		$.ajax({
			type : 'POST',
			url : base_url + '/joblog/execview',
			data : {"logId":_id},
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
					
					// 业务时间显示
					if(curJob.typeDaily == 'YES'){

						$('#triggerHeader').html("任务依赖关系，业务时间："+ curJob.txDate);
					}else{
						$('#triggerHeader').html("任务依赖关系，业务时间："+ curJob.jobEndTimeDesc+'~'+curJob.jobStartTimeDesc);
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
			   			'<div> '+ jobTitle +  '【' + jobInfo.groupId + ' ~ ' + jobInfo.jobId+ '~' + jobInfo.id +'】' +  '</div> '+
			   			'<div> 【'+
			   			jobInfo.groupName + '-'+jobInfo.jobName+
						'】</div> ';
		html +='<div> ['+
			(jobInfo.execJobStatusDesc == '' ? '未开始' : jobInfo.execJobStatusDesc) + ']' + jobInfo.remark  + '<br/>'
			+ '等待:'+jobInfo.jobStartTimeDesc  + ',执行:'
			+ jobInfo.jobExecTimeDesc+',结束:'+jobInfo.jobEndTimeDesc+
				'</div> ';
		html +=	 '</div> ';
		
		
		return $(html);
	}
	
});
