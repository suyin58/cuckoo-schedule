var jsondata = {
		"title" : "手机上网套餐办理",
		"nodes" : {
			"demo_node_48" : {
				"name" : "开始节点",
				"left" : 200,
				"top" : 145,
				"type" : "node",
				"width" : 100,
				"height" : 24,
				"alt" : true
			},
			"demo_node_49" : {
				"name" : "中间节点1",
				"left" : 350,
				"top" : 147,
				"type" : "node",
				"width" : 100,
				"height" : 24,
				"alt" : true
			},
			"demo_node_50" : {
				"name" : "中间节点2",
				"left" : 511,
				"top" : 145,
				"type" : "node",
				"width" : 100,
				"height" : 24,
				"alt" : true
			},
			"demo_node_51" : {
				"name" : "结束节点",
				"left" : 674,
				"top" : 144,
				"type" : "node",
				"width" : 100,
				"height" : 24,
				"alt" : true
			},
			"demo_node_56" : {
				"name" : "测试节点",
				"left" : 281,
				"top" : 239,
				"type" : "node",
				"width" : 100,
				"height" : 24,
				"alt" : true
			}
		},
		"lines" : {
			"demo_line_52" : {
				"type" : "lr",
				"M" : 325,
				"job" : "direct",
				"from" : "demo_node_48",
				"to" : "demo_node_49",
				"name" : ""
			},
			"demo_line_53" : {
				"type" : "lr",
				"M" : 480,
				"job" : "direct",
				"from" : "demo_node_49",
				"to" : "demo_node_50",
				"name" : ""
			},
			"demo_line_54" : {
				"type" : "lr",
				"M" : 642,
				"job" : "direct",
				"from" : "demo_node_50",
				"to" : "demo_node_51",
				"name" : ""
			},
			"demo_line_57" : {
				"type" : "lr",
				"M": 290.5,
				"job" : "direct",
				"from" : "demo_node_48",
				"to" : "demo_node_56",
				"name" : "",
				"alt" : true
			},
			"demo_line_58" : {
				"type" : "tb",
				"M": 205,
				"job" : "dependency",
				"from" : "demo_node_56",
				"to" : "demo_node_49",
				"name" : "",
				"alt" : true
			}
		},
		"areas" : {},
		"initNum" : 60
	}