<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav aria-label="breadcrumb">
	<div class="container-fluid">
		<ol class="breadcrumb bg-white mb-0 py-2">
			<li class="breadcrumb-item"><a href="/"><i
					class="fa fa-home mr-1"></i> Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">My course</li>
		</ol>
	</div>
</nav>
<!-- BEGIN BANNER -->
<section class="course-banner">
	<div class="container">
		<div class="banner-content">
			<h1>My course</h1>
			<h5>tienhoang1211@gmail.com</h5>
		</div>
	</div>
</section>
<!-- BEGIN BANNER -->
<!-- BEGIN CONTENT -->
<section class="mt-5">
	<div class="container">
		<div class="row">
			<c:forEach begin="1" end="8">
				<div class="col-md-3">
					<a href="#" class="my-course-item"> <img
						src='<c:url value="/statics/img/html-css.jpg" />' alt="html-css">
						<h6 class="my-course-title">React - The Complete Guide (incl
							Hooks, React Router, Redux)</h6>
						<div class="my-course-desc">Java Python Android and C#
							Expert Developer - 467K+ students The Complete Guide (incl Hooks,
							React Router, Redux)</div>
						<div class="my-course-author">
							<h6>
								<small>Lê Quang Song</small> <small>Start course</small>
							</h6>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
</section>
<!-- END CONTENT -->