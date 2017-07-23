client1_path="/home/lovsa/project/tomcat-cuckoo-client-8480"
clinet2_path="/home/lovsa/project/tomcat-cuckoo-client-8680"

ps -ef|grep $client1_path|grep -v grep|awk -F ' ' '{print $2}'|xargs kill -9
echo $client1_path"进程已经结束"
sleep 10
rm -rf $client1_path/webapps/ROOT/*  
echo "删除应用文件完成"   
unzip schedule-executor-example.war -d $client1_path/webapps/ROOT/ 1>/dev/null 2>/dev/null
echo "解压完毕"
cp spring-mvc-context5.xml $client1_path/webapps/ROOT/WEB-INF/classes/spring-mvc-context.xml   

cp logback5.xml $client1_path/webapps/ROOT/WEB-INF/classes/logback.xml 

echo "开始启动"$client1_path
sleep 10
sh $client1_path/bin/startup.sh

sleep 90
echo $client1_path" 启动完成"

ps -ef|grep $clinet2_path|grep -v grep|awk -F ' ' '{print $2}'|xargs kill -9
echo $clinet2_path"进程已经结束"
sleep 10
rm -rf $clinet2_path/webapps/ROOT/* 
echo "删除应用文件完成"   
unzip schedule-executor-example.war -d $clinet2_path/webapps/ROOT/ 1>/dev/null 2>/dev/null
echo "解压完毕"

cp spring-mvc-context6.xml $clinet2_path/webapps/ROOT/WEB-INF/classes/spring-mvc-context.xml  

cp logback6.xml $clinet2_path/webapps/ROOT/WEB-INF/classes/logback.xml  

echo "开始启动"$clinet2_path
sleep 10
sh $clinet2_path/bin/startup.sh


sleep 90
echo $clinet2_path"启动完成"

