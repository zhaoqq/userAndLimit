###Spark JobServer使用说明

------------------------------

*by 商军英*

*2017.9.11*

---------------

####1. Introduction

因为spark程序需要和JavaWeb连通，所以我们的spark程序是通过spark jobserver来进行管理和运行spark程序的。所以第一步是要现在服务器上成功部署spark jobserver。参加本目录下的文档 **JobServer安装与测试**。

我们需要将spark程序在自己本地编写后打包成为一个jar文件，然后上传到服务器上通过spark jobserver来执行程序。但是因为是通过spark jobserver来进行管理和执行jar文件的。所以在程序编写上，需要遵从spark jobserver的一些规则和条件。具体的创建一个可以通过spark jobserver管理和运行的spark程序请参考<https://github.com/spark-jobserver/spark-jobserver#create-a-job-server-project>

 #### 2. 参数说明

通过spark jobserver执行spark程序的时候，通常可以有一个输入字段。所以我们要求，在spark程序内将所需要的数据集的位置等信息定义为参数形式，然后通过传参的形式，明确spark程序所需要的数据。然后将数据传入spark程序内进行执行。即调用spark jobserver时的输入字段为数据集的位置等信息。

通常情况以下会有3种情况：

1. 自己上传算法和数据集，进行执行，得出结果。这时候只需要自己明确数据存放位置，在调用spark jobserver执行spark程序时，通过传参方式将数据集的位置信息传入spark程序内。
2. 自己上传算法（一个jar文件），执行服务器内已有数据集。因为服务器中的数据都是以hbase形式存储。所以需要在自己算法中有调用hbase中的数据的功能。在通过spark jobserver执行spark程序时，通过传参形式可以指定hbase中具体所需的数据。
3. 执行服务器上已有算法和数据。这时候只需要指定算法和hbase中的数据，然后通过传参形式，向指定算法中传入所需数据。