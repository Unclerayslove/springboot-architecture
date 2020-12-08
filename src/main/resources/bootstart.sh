#!/bin/sh
#这里可替换为你自己的执行程序，其他代码无需更改
JAR_NAME=cu-corpvrbt-web-server-1.0.0
Suffix=jar
APP_NAME=$JAR_NAME.$Suffix
#$(pwd)表示执行pwd命令，获得当前路径
CUR_SHELL_DIR=$(pwd)
JAR_PATH=$CUR_SHELL_DIR/$APP_NAME
#LOG_PATH=./logs/start.log
LOG_PATH=$CUR_SHELL_DIR/logs/${JAR_NAME}.log
#LOG_PATH=$LOG_DIR/${JAR_NAME}.log
#SPRING_PROFILES_ACTIVE="-Dspring.profiles.active=eureka2"
SPRING_PROFILES_ACTIVE=""
JAVA_MEM_OPTS=" -server -Xms1024m -Xmx1024m -XX:PermSize=128m"
#JAVA_MEM_OPTS=""
#使用说明，用来提示输入参数
usage() {
  echo "Usage: sh 脚本名.sh [start|stop|restart|status]"
  exit 1
}

#检查程序是否在运行
is_exist() {
  pid=$(ps -ef | grep $APP_NAME | grep -v grep | awk '{print $2}')
  #如果不存在返回1，存在返回0
  if [ -z "${pid}" ]; then
    return 1
  else
    return 0
  fi
}

#启动方法
start() {
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is already running. pid=${pid} ."
  else
    nohup java -jar $JAR_PATH $JAVA_MEM_OPTS >>$LOG_PATH 2>&1 &
    echo "${APP_NAME} start success"
  fi
}

#停止方法
stop() {
  is_exist
  if [ $? -eq "0" ]; then
    kill -9 $pid
  else
    echo "${APP_NAME} is not running"
  fi
}

#输出运行状态
status() {
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is running. Pid is ${pid}"
  else
    echo "${APP_NAME} is NOT running."
  fi
}

#重启
restart() {
  stop
  start
}

#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
"start")
  start
  ;;
"stop")
  stop
  ;;
"status")
  status
  ;;
"restart")
  restart
  ;;
*)
  usage
  ;;
esac
