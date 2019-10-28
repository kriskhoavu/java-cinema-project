<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<input type="hidden" value='<c:url value="/user/role"/>' id="roleApi" />

<header class="container-fluid border-bottom">
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<a class="navbar-brand" href='<c:url value=""/>'>Profiles</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation"></button>
		<div class="collapse navbar-collapse row" id="collapsibleNavId">
			<div class="col-md-6">
				<ul
					class="navbar-nav mr-auto mt-2 mt-lg-0 d-flex align-items-center justify-content-between">
					<li class="nav-item mr-3">
						<div class="dropdown">
							<a class="btn btn-outline-light dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-th"></i> <span
								class="ml-2">Categories</span>
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="#"> <i
									class="fa fa-laptop mr-1"></i> <span>Development</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-camera-retro mr-1"></i> <span>Photography</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-bar-chart mr-1"></i> <span>Business</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-desktop mr-1"></i> <span>IT and Software</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-handshake-o mr-1"></i> <span>Marketing</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-music mr-1"></i> <span>Music</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-pencil-square-o mr-1"></i> <span>Design</span>
								</a> <a class="dropdown-item" href="#"> <i
									class="fa fa-cutlery mr-1"></i> <span>Cooking</span>
								</a>
							</div>
						</div>
					</li>
					<li class="nav-item w-100">
						<form class="input-group nav-search">
							<input type="text" class="form-control"
								placeholder="Search courses">
							<div class="input-group-append">
								<button class="btn bg-white text-danger">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</form>
					</li>
				</ul>
			</div>
			<div class="col-md-1 nav-cart">
				<i class="fa fa-shopping-basket"></i>
			</div>
			<div class="col-md-5 d-flex justify-content-end">

				<!-- Nếu chưa đăng nhập thì show giao diện này  -->
				<sec:authorize access="!isAuthenticated()">
					<button class="btn btn-outline-secondary" data-toggle="modal"
						data-target="#loginModal">Login</button>
					<button class="btn btn-danger ml-2" data-toggle="modal"
						data-target="#registerModal">Sign up</button>
				</sec:authorize>
				<!-- Nếu đăng nhập rồi thì show giao diện này -->
				<sec:authorize access="isAuthenticated()">
					<div class="dropdown">
						<%-- <img height="50px" width="50px" src='<c:url value="/statics/upload/"/><sec:authentication property="principal.avatar" />' class="img-radius">  --%>
						<button type="button"
							class="btn btn-outline-primary dropdown-toggle"
							data-toggle="dropdown"><sec:authentication property="principal.fullname" />
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Đặt vé</a> 
							<a class="dropdown-item" href='<c:url value="/logout" />'>Đăng xuất</a>
						</div>
					</div>
				</sec:authorize>
			</div>
		</div>
	</nav>
</header>

<!-- LOGIN MODAL -->
<div class="modal" id="loginModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Đăng nhập</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action='<c:url value="/account/login" />' method="post" id="frmLogin">
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" name="email">
					</div>
					<div class="form-group">
						<label for="pwd">Mật khẩu</label> <input type="password"
							class="form-control" name="password">
					</div>
					<button class="btn btn-primary">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- REGISTER MODAL -->
<div class="modal" id="registerModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Đăng ký</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form action='<c:url value="/auth/register" />' method="post"
					id="frmRegister">
					<div class="form-group">
						<label for="reg_fullname">Họ tên</label> <input type="text"
							class="form-control" name="reg_fullname" id="reg_fullname">
					</div>
					<div class="form-group">
						<label for="reg_email">Email</label> <input type="email"
							class="form-control" name="reg_email" id="reg_email">
					</div>
					<div class="form-group">
						<label for="reg_password">Mật khẩu</label> <input type="password"
							class="form-control" id="reg_password" name="reg_password">
					</div>
					<div class="form-group">
						<label for="reg_confirm">Nhập lại mật khẩu</label> <input
							type="password" class="form-control" name="confirm" id="confirm">
					</div>
					<div class="form-group">
						<label for="reg_roleId">Loại thành viên</label> <select
							class="form-control" name="reg_roleId" id="reg_roleId">
						</select>
					</div>
					<button class="btn btn-primary">Đăng ký</button>
				</form>
			</div>
		</div>
	</div>
</div>