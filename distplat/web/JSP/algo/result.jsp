<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/27
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>the result</title>
</head>
<body>
<s:iterator value="executeResult">
    <h3><s:property value="key" /></h3>
    <s:if test="#executeResult.key==result">
        <s:iterator value="result">
            <s:property value="key"/>
            <s:property value="value"/>
        </s:iterator>
    </s:if>
    <s:property value="value" />
</s:iterator>
</body>
</html>
