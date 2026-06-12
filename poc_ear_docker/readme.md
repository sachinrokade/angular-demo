build
docker build -t websphere-server .

run image
docker run -d --name websphere-server -p 9080:9080 -p 9443:9443 -p 9060:9060 -p 9043:9043 websphere-server

check status
docker logs -f websphere-server


D:\poc_ear_k8>kubectl apply -f deployment.yaml
deployment.apps/websphere-server configured

D:\poc_ear_k8>kubectl get pods
NAME                                READY   STATUS    RESTARTS   AGE
websphere-server-66d5c68c86-9lkw8   1/1     Running   0          12s

D:\poc_ear_k8>kubectl logs -f websphere-server-66d5c68c86-9lkw8
ADMU0116I: Tool information is being logged in file
           /opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/server1/startServer.log
ADMU0128I: Starting tool with the AppSrv01 profile
ADMU3100I: Reading configuration for server: server1
ADMU3200I: Server launched. Waiting for initialization status.
ADMU3000I: Server server1 open for e-business; process id is 570

C:\Users\mrsac>kubectl port-forward deployment/websphere-server 9043:9043
Forwarding from 127.0.0.1:9043 -> 9043
Forwarding from [::1]:9043 -> 9043
Handling connection for 9043
Handling connection for 9043
Handling connection for 9043