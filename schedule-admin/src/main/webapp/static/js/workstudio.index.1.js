// init date tables
	var logErrTable = $("#joblog_err_list").dataTable({
	    "iDisplayLength":5,
	    "aLengthMenu":[5,15,50,100],
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
	        url: base_url + "/joblog/pageList" ,
	        data : function ( d ) {
	        	var obj = {};
	        	obj.jobStatusStr = "FAILED,BREAK";
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
	                { "data": 'triggerType', "visible" : false},
	                { "data": 'cronExpression', "visible" : false},
	                { "data": 'execJobStatus', "visible" : true},
	                { "data": 'jobStartTimeDesc',  "visible" : false},
	                { "data": 'jobExecTimeDesc',  "visible" : true},
	                { "data": 'jobEndTimeDesc',  "visible" : true},
	                { "data": 'needTriggleNext', "visible" : false},
	                { "data": 'forceTriggle', "visible" : false},
	                { "data": 'remark', "visible" : false},
	                { "data": 'cuckooClientIp', "visible" : false},
	                { "data": 'cuckooClientTag', "visible" : false},
	                { "data": 'typeDaily', "visible" : false},
	                { "data": 'txDate',
	                	"render": function ( data, type, row ) {
	                		return data == 0 ? "" : data;
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowLastTime',
	                	"render": function ( data, type, row ) {
	                		return data!=0?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowCurTime',
	                	"render": function ( data, type, row ) {
	                		return data!=0?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	},
	                	"visible" : true
	                },
	                { "data": 'cuckooParallelJobArgs',"bSortable": false, "visible" : false},
	                { "data": 'handleMsg' , "bSortable": false,
	                	"render": function ( data, type, row ) {
	                		// better support expression or string, not function
	                		return function () {
	                			var temp = '<a class="btn btn-primary btn-xs detail" href="/joblog/logdetail?logId='+ row.id +'" target="_blank"   ">详情</a> &nbsp; &nbsp;';
		                		return temp;	
	                		}
	                	}
	                }
	            ],
		"language" : {
			"sProcessing" : "处理中...",
			"sLengthMenu" : "每页 _MENU_ 条记录",
			"sZeroRecords" : "没有匹配结果",
			"sInfo" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
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
		logErrTable.fnDraw();
	});
	
	
	
	
	var logIngTable = $("#joblog_ing_list").dataTable({
	    "iDisplayLength":5,
	    "aLengthMenu":[5,15,50,100],
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
	        url: base_url + "/joblog/pagePendingList" ,
	        data : function ( d ) {
	        	var obj = {};
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
	                { "data": 'triggerType', "visible" : false},
	                { "data": 'cronExpression', "visible" : false},
	                { "data": 'execJobStatus', "visible" : true},
	                { "data": 'jobStartTimeDesc',  "visible" : true},
	                { "data": 'jobExecTimeDesc',  "visible" : true},
	                { "data": 'jobEndTimeDesc',  "visible" : true},
	                { "data": 'needTriggleNext', "visible" : false},
	                { "data": 'forceTriggle', "visible" : false},
	                { "data": 'remark', "visible" : false},
	                { "data": 'cuckooClientIp', "visible" : false},
	                { "data": 'cuckooClientTag', "visible" : false},
	                { "data": 'typeDaily', "visible" : false},
	                { "data": 'txDate',
	                	"render": function ( data, type, row ) {
	                		return data == 0 ? "" : data;
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowLastTime',
	                	"render": function ( data, type, row ) {
	                		return data!=0?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowCurTime',
	                	"render": function ( data, type, row ) {
	                		return data!=0?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	},
	                	"visible" : true
	                },
	                { "data": 'cuckooParallelJobArgs',"bSortable": false, "visible" : false},
	                { "data": 'handleMsg' , "bSortable": false,
	                	"render": function ( data, type, row ) {
	                		// better support expression or string, not function
	                		return function () {
	                			var temp = '<a class="btn btn-primary btn-xs detail" href="/joblog/logdetail?logId='+ row.id +'" target="_blank"   ">详情</a> &nbsp; &nbsp;';
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
		logIngTable.fnDraw();
	});
	
	
	
	
	var logOverTable = $("#joblog_over_list").dataTable({
	    "iDisplayLength":5,
	    "aLengthMenu":[5,15,50,100],
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
	        url: base_url + "/joblog/pageOverTimeList" ,
	        data : function ( d ) {
	        	var obj = {};
	        	var overHours = $("#overHours").val();
	        	obj.overTime = 4 * 60 * 60 * 1000;// 4小时
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
	                { "data": 'triggerType', "visible" : false},
	                { "data": 'cronExpression', "visible" : false},
	                { "data": 'execJobStatus', "visible" : true},
	                { "data": 'jobStartTimeDesc',  "visible" : false},
	                { "data": 'jobExecTimeDesc',  "visible" : true},
	                { "data": 'jobEndTimeDesc',  "visible" : true},
	                { "data": 'needTriggleNext', "visible" : false},
	                { "data": 'forceTriggle', "visible" : false},
	                { "data": 'remark', "visible" : false},
	                { "data": 'cuckooClientIp', "visible" : false},
	                { "data": 'cuckooClientTag', "visible" : false},
	                { "data": 'typeDaily', "visible" : false},
	                { "data": 'txDate',
	                	"render": function ( data, type, row ) {
	                		return data == 0 ? "" : data;
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowLastTime',
	                	"render": function ( data, type, row ) {
	                		return data!=0?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	}, 
	                	"visible" : true
	                },
	                { 
	                	"data": 'flowCurTime',
	                	"render": function ( data, type, row ) {
	                		return data!=0?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	},
	                	"visible" : true
	                },
	                { "data": 'cuckooParallelJobArgs',"bSortable": false, "visible" : false},
	                { "data": 'handleMsg' , "bSortable": false,
	                	"render": function ( data, type, row ) {
	                		// better support expression or string, not function
	                		return function () {
	                			var temp = '<a class="btn btn-primary btn-xs detail" href="/joblog/logdetail?logId='+ row.id +'" target="_blank"   ">详情</a> &nbsp; &nbsp;';
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
		logErrTable.fnDraw();
	});