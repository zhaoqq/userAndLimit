<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<head>
  <title>跳转中...</title>
  <script type="text/javascript">
      function go(){
          location.href='${pageContext.request.contextPath}/JSP/login.jsp';
      }
  </script>
</head>
<body onload="setTimeout(go,3000);">
<br><br><br><br>

<h2 style="color:#1F1;">操作成功！ </h2>
<h1 style="color:#58F;">3秒后自动转到登录页面</h1>
<h2>如果没有跳转，请按<a href="${pageContext.request.contextPath}/JSP/login.jsp">这里</a></h2>

</body>
</html>