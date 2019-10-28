<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="adminScripts"/>
<!DOCTYPE html>
<html lang="en">

<head>
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="header" />
</head>

<body>
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<nav class="navbar header-navbar pcoded-header">
				<!-- NAVBAR -->
				<tiles:insertAttribute name="navbar" />
			</nav>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">
					<!-- SIDE BAR -->
					<tiles:insertAttribute name="sidebar" />

					<div class="pcoded-content">
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<!-- BODY -->
								<tiles:insertAttribute name="body" />
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
	<c:forEach items="${adminScripts}" var="item" >
		<script src="<c:url value="${item}" />"></script>
	</c:forEach>	
</body>

</html>