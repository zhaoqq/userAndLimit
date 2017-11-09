## JobServer安装及测试

*by 张成亮*

*2017.0.18*

----------------------------------------

# 特性

针对job和contexts的各个方面提供**REST**风格的api接口进行管理；

# 安装
* 安装sbt
```
git clone https://github.com/spark-jobserver/spark-jobserver
```
* 拷贝 conf/local.sh.template 文件到 local.sh，修改相关配置；
* 拷贝 config/local.conf.template 到 <environment>.conf；
>备注: enviroment这里为local，即local.conf。

* 执行 bin/server_package.sh local，这一步将job-server以及配置文件打包，并一同推送到配置的远程服务器上；

# 启动
```
bin/server_start.sh 
```
启动后，应有SparkSubmit这个进程；

## web ui
```
http://10.108.17.77:8090
```

# 测试
## 创建demo
* 使用Idea建立一个SBT项目(也可以使用maven进行项目的创建)；
  [demo github地址](https://github.com/spark-jobserver/spark-jobserver.g8/tree/master/src/main/g8)
* 添加依赖(build.sbt)；
  因为默认的maven库中并不包含job-server的jar包，因此需要添加[远程仓库](https://dl.bintray.com/spark-jobserver/maven/spark/jobserver/job-server-api_2.10/0.7.0/)
```
resolvers += "job-server-api" at "https://dl.bintray.com/spark-jobserver/maven"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.0" % "provided"

libraryDependencies += "spark.jobserver" % "job-server-api_2.10" % "0.7.0"
```
> 注意spark，scala的版本需要和集群软件环境版本相一致；


# 打包
* **File - Project Structure - Atifacts**
* 点左上绿色的加号，添加jar(Create JAR from Modules)，选择项目和主函数所在类 - ；
* OK
* Build - Build Artifacts

# 上传服务器
生成的jar文件默认在 项目名 / out / artifacts /里；
使用**XShell的rz**命令或者FileZilla客户端将jar文件上传服务器；

# 上传Jar到JobServer
```
curl --data-binary @job-server-tests/target/scala-2.10/job-server-tests-$VER.jar localhost:8090/jars/test
```

# 运行
```
curl -d "input.string = a b c a b see" "localhost:8090/jobs?appName=test&classPath=spark.jobserver.WordCountExample"
```
可在Web UI界面查看任务情况；











