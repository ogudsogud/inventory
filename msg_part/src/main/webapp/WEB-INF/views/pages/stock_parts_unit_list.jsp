<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Stock Unit Part List</title>
  <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
  <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
  <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<div class="container">
  <h2>Stock Unit List</h2>
  <table class="table table-striped">
    <thead>
    <tr>
      <th scope="row">Nama Unit Parts</th>
      <th scope="row">Jumlah Unit</th>
      <th scope="row">Created By</th>
      <th scope="row">Created on</th>
      <th scope="row">Updated By</th>
      <th scope="row">Updated On</th>
      <th scope="row">AKSI</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${stockunitpartList }" var="msg" >
      <tr>
        <td>${msg.id_part_number }</td>
        <td>${msg.unit_parts_name }</td>
        <td>${msg.part_name }</td>
        <td>${msg.brand_name }</td>
        <td>${msg.specification }</td>
          <%--<td>${msg.bad_part }</td>--%>
        <td>${msg.created_by }</td>
        <td>${msg.created_on }</td>
        <td>${msg.updated_by }</td>
        <td>${msg.updated_on }</td>


        <td>
          <spring:url value="/msg/parts-update/${msg.id_part_number }" var="updateURL" />
          <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
        </td>
        <td>
          <spring:url value="/msg/parts-delete/${msg.id_part_number }" var="deleteURL" />
          <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <spring:url value="/msg/parts-add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">TAMBAH PARTS</a>
</div>
</body>
</html>