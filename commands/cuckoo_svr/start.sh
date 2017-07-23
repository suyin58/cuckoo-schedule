server1_path="/home/lovsa/project/tomcat-cuckoo-server-8380"
server2_path="/home/lovsa/project/tomcat-cuckoo-server-8580"

ps -ef|grep $server1_path|grep -v grep|awk -F ' ' '{print $2}'|xargs kill -9
echo $server1_path"进程已经结束"
sleep 10
rm -rf $server1_path/webapps/ROOT/*
echo "删除应用文件完成"   
unzip schedule-admin.war -d  $server1_path/webapps/ROOT/ 1>/dev/null 2>/dev/null
echo "解压完毕"
cp service5.properties $server1_path/webapps/ROOT/WEB-INF/classes/service.properties  


cp logback5.xml $server1_path/webapps/ROOT/WEB-INF/classes/logback.xml 
echo "开始启动应用"$$server1_path
sleep 10
sh $server1_path/bin/startup.sh

sleep 90
echo $server1_path"启动完成"

ps -ef|grep $server2_path|grep -v grep|awk -F ' ' '{print $2}'|xargs kill -9
echo $server2_path"进程已经结束"
sleep 10
rm -rf $server2_path/webapps/ROOT/* 
echo "删除应用文件完成"   
unzip schedule-admin.war -d  $server2_path/webapps/ROOT/ 1>/dev/null 2>/dev/null
echo "解压完毕"
cp service6.properties $server2_path/webapps/ROOT/WEB-INF/classes/service.properties  

cp logback6.xml $server2_path/webapps/ROOT/WEB-INF/classes/logback.xml  

echo "开始启动应用"
sleep 10
sh $server2_path/bin/startup.sh

sleep 90
echo $server2_path"启动完成"
