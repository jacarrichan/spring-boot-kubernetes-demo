
测试命令

```shell

PS C:\Users\jacarrichan\temp\spring-boot-demo> mvn clean  package  -DskipTests
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------< com.jacarrichan.demo:spring-boot-demo >----------------
[INFO] Building spring-boot-demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ spring-boot-demo ---
[INFO] Deleting C:\Users\jacarrichan\temp\spring-boot-demo\target
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ spring-boot-demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ spring-boot-demo ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to C:\Users\jacarrichan\temp\spring-boot-demo\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ spring-boot-demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] skip non existing resourceDirectory C:\Users\jacarrichan\temp\spring-boot-demo\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ spring-boot-demo ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\jacarrichan\temp\spring-boot-demo\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ spring-boot-demo ---
[INFO] Tests are skipped.
[INFO]
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ spring-boot-demo ---
[INFO] Building jar: C:\Users\jacarrichan\temp\spring-boot-demo\target\spring-boot-demo-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.6.6:repackage (repackage) @ spring-boot-demo ---
[INFO] Replacing main artifact with repackaged archive
[INFO]
[INFO] --- docker-maven-plugin:1.2.2:build (default) @ spring-boot-demo ---
[INFO] Using authentication suppliers: [ConfigFileRegistryAuthSupplier]
[INFO] Copying C:\Users\jacarrichan\temp\spring-boot-demo\target\spring-boot-demo-0.0.1-SNAPSHOT.jar -> C:\Users\jacarrichan\temp\spring-boot-demo\target\docker\spring-boot-demo-0.0.1-SNAPSHOT.jar
[INFO] Copying C:\Users\jacarrichan\temp\spring-boot-demo\src\main\docker\Dockerfile -> C:\Users\jacarrichan\temp\spring-boot-demo\target\docker\Dockerfile
[INFO] Building image jacarrichan/spring-boot-demo
Step 1/4 : FROM openjdk:8-jdk-oracle

 ---> 5783fe09fd20
Step 2/4 : ADD spring-boot-demo-0.0.1-SNAPSHOT.jar /app.jar

 ---> f7b34cfdfa7e
Step 3/4 : ENV TZ=Asia/Shanghai

 ---> Running in ff2c71c3397d
Removing intermediate container ff2c71c3397d
 ---> 125e9bf78a95
Step 4/4 : ENTRYPOINT [ "java", "-jar", "/app.jar" ]

 ---> Running in e071a464bab4
Removing intermediate container e071a464bab4
 ---> 9a19d48fe90a
ProgressMessage{id=null, status=null, stream=null, error=null, progress=null, progressDetail=null}
Successfully built 9a19d48fe90a
Successfully tagged jacarrichan/spring-boot-demo:latest
[INFO] Built jacarrichan/spring-boot-demo
[INFO] Tagging jacarrichan/spring-boot-demo with 0.0.1-SNAPSHOT
[INFO] Tagging jacarrichan/spring-boot-demo with latest
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  11.752 s
[INFO] Finished at: 2022-04-10T20:00:58+08:00
[INFO] ------------------------------------------------------------------------


PS C:\Users\jacarrichan\temp\spring-boot-demo> kubectl create  -f  .\k8s.yaml
service/spring-boot-demo created
deployment.apps/spring-boot-demo created
PS C:\Users\jacarrichan\temp\spring-boot-demo> kubectl  get  pods  
NAME                               READY   STATUS    RESTARTS   AGE
spring-boot-demo-d8bdc7896-nrjj7   1/1     Running   0          10s


PS C:\Users\jacarrichan\temp\spring-boot-demo> kubectl  describe  pod  spring-boot-demo-d8bdc7896-nrjj7 
Name:         spring-boot-demo-d8bdc7896-nrjj7
Namespace:    default
Priority:     0
Node:         docker-desktop/192.168.65.4
Start Time:   Sun, 10 Apr 2022 20:01:33 +0800
Labels:       app=spring-boot-demo
              pod-template-hash=d8bdc7896
Annotations:  <none>
Status:       Running
IP:           10.1.1.189
IPs:
  IP:           10.1.1.189
Controlled By:  ReplicaSet/spring-boot-demo-d8bdc7896
Containers:
  spring-boot-demo:
    Container ID:   docker://abf6c48fd2d0392f5238344904307005728395985f0f7917736961038405254d
    Image:          jacarrichan/spring-boot-demo:0.0.1-SNAPSHOT
    Image ID:       docker://sha256:9a19d48fe90af076c9c2a3b012a4f01bfd1f16ff390606f414f9f1a980239ddb
    Port:           8080/TCP
    Host Port:      0/TCP
    State:          Running
      Started:      Sun, 10 Apr 2022 20:01:34 +0800
    Ready:          True
    Restart Count:  0
    Environment:    <none>
    Mounts:
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-7fqb7 (ro)
Conditions:
  Type              Status
  Initialized       True
  Ready             True
  ContainersReady   True
  PodScheduled      True
Volumes:
  kube-api-access-7fqb7:
    Type:                    Projected (a volume that contains injected data from multiple sources)
    TokenExpirationSeconds:  3607
    ConfigMapName:           kube-root-ca.crt
    ConfigMapOptional:       <nil>
    DownwardAPI:             true                                                                                                                                                         QoS Class:                   BestEffort                                                                                                                                                   Node-Selectors:              <none>                                                                                                                                                       Tolerations:                 node.kubernetes.io/not-ready:NoExecute op=Exists for 300s                                                                                                    
                             node.kubernetes.io/unreachable:NoExecute op=Exists for 300s
Events:
  Type    Reason     Age   From               Message
  ----    ------     ----  ----               -------
  Normal  Scheduled  64s   default-scheduler  Successfully assigned default/spring-boot-demo-d8bdc7896-nrjj7 to docker-desktop
  Normal  Pulled     64s   kubelet            Container image "jacarrichan/spring-boot-demo:0.0.1-SNAPSHOT" already present on machine
  Normal  Created    64s   kubelet            Created container spring-boot-demo
  Normal  Started    64s   kubelet            Started container spring-boot-demo
PS C:\Users\jacarrichan\temp\spring-boot-demo> kubectl  get svc                                         
NAME               TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
kubernetes         ClusterIP   10.96.0.1      <none>        443/TCP          9d
spring-boot-demo   NodePort    10.97.24.220   <none>        8080:30000/TCP   117s



PS C:\Users\jacarrichan\temp\spring-boot-demo> curl  http://localhost:30000                             


StatusCode        : 200
StatusDescription :
Content           : Hello World Sun Apr 10 20:03:36 CST 2022
RawContent        : HTTP/1.1 200
                    Keep-Alive: timeout=60
                    Connection: keep-alive
                    Content-Length: 40
                    Content-Type: text/plain;charset=UTF-8
                    Date: Sun, 10 Apr 2022 12:03:36 GMT

                    Hello World Sun Apr 10 20:03:36 CST 20...
Forms             : {}
Headers           : {[Keep-Alive, timeout=60], [Connection, keep-alive], [Content-Length, 40], [Content-Type, text/plain;charset=UTF-8]...}
Images            : {}
InputFields       : {}
Links             : {}
ParsedHtml        : mshtml.HTMLDocumentClass
RawContentLength  : 40



PS C:\Users\jacarrichan\temp\spring-boot-demo>



```