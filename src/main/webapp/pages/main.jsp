<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
  <c:if test="${not empty stringParam}">
      <h1>String parameter: ${stringParam}</h1>
  </c:if>
  <c:if test="${not empty intParam}">
      <h1>Integer parameter: ${intParam}</h1>
  </c:if>
</body>
</html>
