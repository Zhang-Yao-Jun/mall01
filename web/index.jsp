<%--
  Created by IntelliJ IDEA.
  User: 张尧俊
  Date: 2019/3/14
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:redirect url="${request.contextPath}/ItemsServlet?method=query"></c:redirect>
  </body>
</html>
