<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/9
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>The result</title>
</head>
<body>
<s:iterator value="executeResult">
    <h3><s:property value="key" /></h3>
    <s:property value="value" />

</s:iterator>
<a href="<s:url action="showresult" >
        <s:param name="jobId" value="jobId"></s:param>
    </s:url>">
    点击查看结果
</a>
</body>
</html>
