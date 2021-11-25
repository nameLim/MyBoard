#!/bin/bash

CURRENT_PORT=$(cat /home/ubuntu/service_url.inc | grep -Po '[0-9]+' | tail -1)
TARGET_PORT=0

 echo "> Current port of running WAS is ${CURRENT_PORT}."

if [ $CURRENT_PORT -eq 8081 ]
then
  TARGET_PORT=8082
elif [ $CURRENT_PORT -eq 8082 ]
then
  TARGET_PORT=8081
else
  echo "> No WAS is connected to nginx"
fi

TARGET_PID=$(lsof -Fp -i TCP:$TARGET_PORT | grep -Po 'p[0-9]+' | grep -Po '[0-9]+')


if [ -z $TARGET_PID ]
then
  echo "> 종료할 것 없음"
#  echo "> 종료할 것 없음."
else
  kill -15 $TARGET_PID
fi

for RETRY_COUNT in 1 2 3 4 5 6 7 8 9 10
do
  nohup java -jar -Dserver.port=$TARGET_PORT /home/ubuntu/myboard/build/libs/*SNAPSHOT.jar &
  echo "> #${RETRY_COUNT} trying..."

  RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://127.0.0.1:${TARGET_PORT}/health)
  MY_RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://13.124.233.40:${TARGET_PORT}/health)

  echo "> TARGET_PORT :  ${TARGET_PORT}"
  echo "> RESPONSE_CODE : ${RESPONSE_CODE}"
  echo "> MY_RESPONSE_CODE : ${MY_RESPONSE_CODE}"

   if [ ${RESPONSE_CODE} -eq 200 ]; then
     echo "> New WAS successfully running"
     exit 0
  elif [ ${RETRY_COUNT} -eq 10 ]; then
    echo "> Health check failed."
    exit 1
  fi
  sleep 10
done




echo "> Now new WAS runs at $TARGET_PORT."
exit 0