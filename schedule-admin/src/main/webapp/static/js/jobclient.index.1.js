$(function() {
	// init date tables
	var jobTable = $("#job_list").dataTable({
	    "iDisplayLength":5,
	    "aLengthMenu":[5,15,50,100],
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
			url: base_url + "/jobclient/pageList",
			type:"post",
	        data : function ( d ) {
	        	var obj = {};
	        	obj.jobClassApplication = $('#jobClassApplication').val();
	        	obj.jobName = $('#jobNameInput').val();
	        	obj.start = d.start;
	        	obj.limit = d.length;
                return obj;
            }
	    },
	    "searching": false,
	    "ordering": false,
	    //"scrollX": true,	// X轴滚动条，取消自适应
	    "columns": [
	                { "data": 'id', "bSortable": false, "visible" : false}, 
	                { "data": 'jobClassApplication', "bSortable": false, "visible" : true},
	                { "data": 'jobName', "visible" : true},
	                { "data": 'beanName', "visible" : true},
	                { "data": 'methodName', "visible" : true},
	                { "data": 'servers', 
	                	"visible" : true,
	                	"render": function ( data, type, row ) {
	                		if(data != null){
	                			var servers = "";
	                			for (var i = 0; i < data.length; i++) {
	                				servers += (i == 0 ? "":"</br>") + data[i];
								}
	                			
	                			return servers;
	                		}else{
	                			return "";
	                		}
	                		
	                	}
	                },
	                { "data": 'clients', 
	                	"visible" : true,
	                	"render": function ( data, type, row ) {
	                		if(data != null){
	                			var clients = "";
	                			for (var i = 0; i < data.length; i++) {
	                				clients += (i == 0 ? "":"</br>") + data[i];
								}
	                			
	                			return clients;
	                		}else{
	                			return "";
	                		}
	                		
	                	}
	                },
	                
	                { "data": 'createDate', 
	                	"visible" : true,
	                	"render": function ( data, type, row ) {
	                		return data != 0 ?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
	                	}
	                },
	                { "data": 'modifyDate', 
	                	"visible" : true,
	                	"render": function ( data, type, row ) {
	                		return data != 0 ?moment(new Date(data)).format("YYYY-MM-DD HH:mm:ss"):"";
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
	
	
	

});
