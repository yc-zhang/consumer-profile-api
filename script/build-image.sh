#!/bin/bash -eu

VERSION=${BUILD_NUM:=local}
LOCAL_IMAGE_NAME=consumer-profile-api

docker-compose run dev ./sbt universal:packageBin

docker build -t ${LOCAL_IMAGE_NAME} .
docker tag ${LOCAL_IMAGE_NAME} ${LOCAL_IMAGE_NAME}:latest
docker tag ${LOCAL_IMAGE_NAME} ${LOCAL_IMAGE_NAME}:${VERSION}
