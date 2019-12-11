#!/bin/bash
#service name
app='transfer-1.0-SNAPSHOT.jar'
#input args
cmd=$1
#pid
pid=`ps -ef|grep java|grep $app|awk '{print $2}'`

#funcation to start transfer service
startup(){
  cat /opt/null > nohup.out
  nohup java -jar $app &
  tail -f nohup.out
}

#validate pramater
if [ ! $cmd ]; then
  echo "Please specify args 'start|restart|stop'"
  exit
fi

#start service
if [ $cmd == 'start' ]; then
  if [ ! $pid ]; then
    startup
  else
    echo "transfer service is running! pid=$pid"
  fi
fi

#restart service
if [ $cmd == 'restart' ]; then
  if [ $pid ]
    then
      echo "transfer service will be restart!"
      sleep 3
      kill -9 $pid
  fi
  startup  
fi

#stop service
if [ $cmd == 'stop' ]; then
  if [ $pid ]; then
    echo "transfer service will be stop!"
    sleep 3
    kill -9 $pid
  fi
  echo "$app is stopped"
fi
