<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>PART LIST</title>
  <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
  <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
  <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<div class="container">
  <h2>Part List</h2>
  <table class="table table-striped">
    <thead>
    <tr>
      <th scope="row">Part Number</th>
      <th scope="row">Part Name</th>
      <th scope="row">Quantity</th>
      <th scope="row">Created_By</th>
      <th scope="row">Created_On</th>
      <th scope="row">Updated_By</th>
      <th scope="row">Updated_On</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${}" var="part" >
      <tr>
        <td>${employee.employeeId }</td>
        <td>${employee.firstName }</td>
        <td>${employee.lastName }</td>
        <td>${employee.email }</td>
        <td>${employee.phone }</td>
        <td>${employee.jobTitle }</td>
        <td>
          <spring:url value="/employee/update/${employee.employeeId }" var="updateURL" />
          <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
        </td>
        <td>
          <spring:url value="/employee/delete/${employee.employeeId }" var="deleteURL" />
          <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <spring:url value="/employee/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Add New Employee</a>
</div>
</body>
</html>