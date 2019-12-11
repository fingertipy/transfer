#!/bin/bash
app='transfer-1.0-SNAPSHOT.jar'
cmd=$1
pid=`ps -ef|grep java|grep $app|awk '{print $2}'`

startup(){
  cat /opt/null > nohup.out
  nohup java -jar $app &
  tail -f nohup.out
}

if [ ! $cmd ]; then
  echo "Please specify args 'start|restart|stop'"
  exit
fi

if [ $cmd == 'start' ]; then
  if [ ! $pid ]; then
    startup
  else
    echo "transfer service is running! pid=$pid"
  fi
fi

if [ $cmd == 'restart' ]; then
  if [ $pid ]
    then
      echo "transfer service will be restart!"
      sleep 3
      kill -9 $pid
  fi
  startup  
fi

if [ $cmd == 'stop' ]; then
  if [ $pid ]; then
    echo "transfer service will be stop!"
    sleep 3
    kill -9 $pid
  fi
  echo "$app is stopped"
fi
