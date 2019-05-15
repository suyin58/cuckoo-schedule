

INSERT INTO `cuckoo_auth_user` (`id`, `user_name`, `user_pwd`, `user_auth_type`, `phone`, `email`, `org_name`) VALUES (1, 'guest', 'e10adc3949ba59abbe56e057f20f883e', 'GUEST', '', '', '');
INSERT INTO `cuckoo_auth_user` (`id`, `user_name`, `user_pwd`, `user_auth_type`, `phone`, `email`, `org_name`) VALUES (2, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'ADMIN', '', '', '');
INSERT INTO `cuckoo_auth_user` (`id`, `user_name`, `user_pwd`, `user_auth_type`, `phone`, `email`, `org_name`) VALUES (3, 'test', 'e10adc3949ba59abbe56e057f20f883e', 'NORMAL', '', '', '');


INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (1, 'Dubbo单个任务测试', 'Dubbo单个任务测试');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (2, 'HTTP单个任务测试', 'HTTP单个任务测试');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (3, '日切-两层任务', '日切-两层任务调度');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (4, 'Flow-两层任务', 'Flow-两层任务');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (5, 'Dubbo-日切-多级任务', 'Dubbo-日切-多级任务');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (6, 'Dubbo-Flow-多级任务', 'Dubbo-Flow-多级任务');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (7, '压测单个任务', '压测单个任务');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (8, '压测多级任务flow', '压测多级任务flow');
INSERT INTO `cuckoo_job_group` (`id`, `group_name`, `group_desc`) VALUES (9, '压测多级任务日切', '压测多级任务日切');


INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (1, 1, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', 'Dubbo，日切任务', 'CRON', 'YES', '0 0 0 1/1 * ?', 0, 'PAUSE', '1');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (2, 2, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', 'miaos', 'CRON', 'NO', '0 0/15 * * * ?', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (3, 3, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', '多级任务，第一级别', 'CRON', 'YES', '0 0 0 1/1 * ?', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (4, 3, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', '多级任务，第二级别', 'JOB', 'YES', '', 0, 'PAUSE', '执行参数1');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (5, 4, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', 'flow任务第一层', 'CRON', 'NO', '0 0 0 1/1 * ?', 0, 'PAUSE', '分片参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (6, 4, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', 'flow任务第二层', 'JOB', 'NO', '', 0, 'PAUSE', '');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (7, 5, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第一级别', 'CRON', 'YES', '0 0 0 1/1 * ?', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (8, 5, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第二级别', 'JOB', 'YES', '', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (9, 5, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第二级别', 'JOB', 'YES', '', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (10, 5, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第二级别', 'JOB', 'YES', '', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (11, 5, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第三级别', 'JOB', 'YES', '', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (12, 5, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第三级别', 'JOB', 'YES', '', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (13, 5, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第四级别', 'JOB', 'YES', '', 0, 'PAUSE', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (14, 6, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第一级别', 'CRON', 'NO', '0 0 0 1/1 * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (15, 6, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '多级任务，第二级别', 'JOB', 'NO', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (16, 6, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', 'flow任务第二层', 'JOB', 'NO', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (17, 6, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', 'flow任务第三层', 'JOB', 'NO', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (18, 7, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', '压测单个任务1', 'CRON', 'NO', '0 0/15 * * * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (19, 7, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', '压测单个任务2', 'CRON', 'NO', '0 0/15 * * * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (20, 7, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测单个任务3', 'CRON', 'NO', '0 0/15 * * * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (21, 7, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测单个任务4', 'CRON', 'NO', '0 0/15 * * * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (22, 8, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', '压测多级任务A1', 'CRON', 'NO', '0 0/15 * * * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (23, 8, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', '压测多级任务A2', 'JOB', 'NO', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (24, 8, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测多级任务A3', 'JOB', 'NO', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (25, 8, 'HTTP', 'http://127.0.0.1:8280/test/succed', '', '压测多级任务A4', 'JOB', 'NO', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (26, 9, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测多级任务日期1', 'CRON', 'YES', '0 0 0 1/1 * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (27, 9, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测多级任务日期1-1', 'CRON', 'YES', '0 0 0 1/1 * ?', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (28, 9, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测多级任务日期2', 'JOB', 'YES', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (29, 9, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测多级任务日期3', 'JOB', 'YES', '', 0, 'RUNNING', '执行参数');
INSERT INTO `cuckoo_job_detail` (`id`, `group_id`, `exec_job_type`, `job_class_application`, `job_name`, `job_desc`, `trigger_type`, `type_daily`, `cron_expression`, `offset`, `job_status`, `cuckoo_parallel_job_args`) VALUES (30, 9, 'DUBBO', 'com.wjs.schedule.service.CuckooTestService', 'testJobSucced', '压测多级任务日期4', 'JOB', 'YES', '', 0, 'RUNNING', '执行参数');



INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (1, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (2, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (3, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (4, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (5, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (6, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (7, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (8, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (9, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (10, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (11, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (12, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (13, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (14, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (15, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (16, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (17, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (18, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (19, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (20, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (21, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (22, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (23, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (24, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (25, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (26, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (27, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (28, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (29, '609061217@qq.com', 10800000);
INSERT INTO `cuckoo_job_extend` (`job_id`, `email_list`, `over_time_long`) VALUES (30, '609061217@qq.com', 10800000);



INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (2, 6, 5);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (4, 4, 3);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (6, 8, 7);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (7, 9, 7);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (8, 10, 7);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (9, 11, 8);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (11, 12, 9);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (12, 12, 10);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (13, 13, 7);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (14, 13, 12);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (15, 15, 14);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (16, 16, 14);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (17, 17, 16);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (18, 23, 22);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (19, 24, 23);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (21, 25, 24);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (22, 28, 26);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (23, 28, 27);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (24, 29, 26);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (25, 29, 28);
INSERT INTO `cuckoo_job_dependency` (`id`, `job_id`, `dependency_job_id`) VALUES (26, 30, 29);
