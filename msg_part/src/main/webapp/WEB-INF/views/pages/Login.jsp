<%--
  Created by IntelliJ IDEA.
  User: Ogudsogud
  Date: 7/21/2018
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div class="container" style="margin:50px">
  <h3>Spring Security Login Example</h3>
  <c:if test="${param.error ne null}">
    <div style="color: #296aff">Invalid credentials.</div>
  </c:if>
  <form action="/login" method="post">

    <div class="form-group">
      <label for="nik">NIK:</label> <input type="nik" class="form-control" id="nik" name="nik">
    </div>

    <div class="form-group">
      <label for="password">Password:</label> <input type="password" class="form-control" id="password" name="passwd">
    </div>

    <button type="submit" class="btn btn-success">Submit</button>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
  </form>
</div>

</body>
</html>
