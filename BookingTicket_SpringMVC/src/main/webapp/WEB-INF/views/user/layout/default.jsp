 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:importAttribute name="styles"/>   
<tiles:importAttribute name="scripts"/> 

<!doctype html>
<html lang="en">

<head>
    <title><tiles:getAsString name="title"/></title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<tiles:insertAttribute name="header" />
    <c:forEach items="${styles}" var="item">
    	<link rel="stylesheet" href='<c:url value="${ item }"/>'>
    </c:forEach>
</head>
<body>
	<tiles:insertAttribute name="navbar"/>

	<tiles:insertAttribute name="body"/>

	<tiles:insertAttribute name="footer" />
	<c:forEach items="${scripts}" var="item">
    	<script src='<c:url value="${ item }"/>'></script>
    </c:forEach>
</body> 