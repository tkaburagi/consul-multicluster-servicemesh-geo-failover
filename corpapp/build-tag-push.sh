#!/bin/sh
cd /Users/kabu/hashicorp/consul/multicluster-servicemesh-geo-failover-demo/corpapp
pwd
./mvnw clean package -DskipTests
pwd
docker build -t tkaburagi/corxpapp-geox-$1 .
docker tag tkaburagi/corxpapp-geox-$1 gcr.io/se-kabu/corxpapp-geox-$1
docker push gcr.io/se-kabu/corxpapp-geox-$1
pwd