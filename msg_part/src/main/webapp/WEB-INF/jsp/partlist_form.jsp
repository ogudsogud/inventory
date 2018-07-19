<%--
  Created by IntelliJ IDEA.
  User: yoga.wiguna
  Date: 19/07/2018
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Employees</title>
  <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
  <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
  <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<div class="container">
  <spring:url value="/msg/save" var="saveURL" />
  <h2>PART LIST</h2>
  <form:form modelAttribute="partForm" method="post" action="${saveURL }" cssClass="form">
    <form:hidden path="id_unit_parts"/>
    <div class="form-group">
      <lable for="unit_parts_name">Nama Unit Part</lable>
      <form:input path="unit_parts_name" cssClass="form-control" id="unit_parts_name" />
    </div>
    <div class="form-group">
      <lable for="id_part_number">ID Part Number</lable>
      <form:input path="id_part_number" cssClass="form-control" id="id_part_number" />
    </div>
    <div class="form-group">
      <lable for="part_name">Nama Part</lable>
      <form:input path="part_name" cssClass="form-control" id="part_name" />
    </div>
    <div class="form-group">
      <lable for="brand_name">Nama Brand</lable>
      <form:input path="brand_name" cssClass="form-control" id="brand_name" />
    </div>
    <div class="form-group">
      <lable for="specification">Spesifikasi</lable>
      <form:input path="specification" cssClass="form-control" id="specification" />
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
  </form:form>
</div>
</body>
</html>