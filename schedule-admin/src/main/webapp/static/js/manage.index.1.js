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
	
});