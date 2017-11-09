<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/8
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>work with spark</title>
</head>
<body>

        <s:form action="runAlgorithm" method="POST">

            <s:select
                    label="algorithm"
                    list="algos"
                    listKey="id"
                    listValue="alName"
                    name="yourAlgo"
            />
            <s:select
                    label="dataset"
                    list="dataSets"
                    listKey="id"
                    listValue="name"
                    name="yourDataset"
            />


            <s:submit value="运行"/>
        </s:form>
</body>
</html>
