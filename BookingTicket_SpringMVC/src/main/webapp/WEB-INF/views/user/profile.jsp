<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>

<nav aria-label="breadcrumb">
	<div class="container-fluid">
		<ol class="breadcrumb bg-white mb-0 py-2">
			<li class="breadcrumb-item"><a href="#"><i
					class="fa fa-home mr-1"></i> Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">Profile</li>
		</ol>
	</div>
</nav>
<!-- BEGIN BANNER -->
<section class="course-banner">
	<div class="container">
		<div class="banner-content">
			<h1>${ user.fullname }</h1>
			<h5>${ user.email }</h5>
		</div>
	</div>
</section>
<!-- BEGIN BANNER -->
<!-- BEGIN CONTENT -->
<section class="mt-4">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs nav-tabs__custom">
					<li class="nav-item"><a class="nav-link active"
						data-toggle="tab" href="#profile">User profile</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#picture">Profile picture</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#security">Security</a></li>
				</ul>

				<!-- Tab panes -->
				<c:url value="/user/profile/edit" var="updateUser" />
				<mvc:form action="${ updateUser }" method="post"
					modelAttribute="user">
					<div class="tab-content custom">
						<div class="tab-pane container-fluid active" id="profile">
							<div class="row">
								<div class="col-md-6">
									<mvc:hidden path="id" />
									<mvc:hidden path="roleId" value="${ user.roleId }" />
									<mvc:hidden path="avatar" value="${ user.avatar }" />
									<div class="form-group">
										<label>Email</label>
										<mvc:input type="text" path="email" cssClass="form-control" />
									</div>
									<div class="form-group">
										<label>FullName</label>
										<mvc:input type="text" path="fullname" cssClass="form-control" />
									</div>
									<div class="form-group">
										<label>Address</label>
										<mvc:input type="text" path="address" cssClass="form-control" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Phone</label>
										<mvc:input type="text" path="phone" cssClass="form-control" />
									</div>
									<div class="form-group">
										<label>Website</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">Website</span>
											</div>
											<mvc:input type="text" path="website" cssClass="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label>Facebook</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">http://www.facebook.com/</span>
											</div>
											<mvc:input type="text" path="facebook"
												cssClass="form-control" />
										</div>
									</div>

								</div>
								<div class="col-md-12">
									<button class="btn btn-outline-secondary">Save</button>
								</div>
							</div>
						</div>
				</mvc:form>
				<div class="tab-pane container-fluid fade picture" id="picture">
					<div class="row">
						<div class="col-md-6">
							<h6>Image preview</h6>
							<small>Minimum 200x200 pixels, Maximum 6000x6000 pixels</small>
							<div class="picture-wapper">
								<div class="picture-img">
									<c:url value="/statics/upload/" var="url" />
									<input type="hidden" id="url" value="${url}" /> <img
										id="avatar"
										src="<c:url value='/statics/upload/'/>${user.avatar}" alt=""
										height="250px" width="400px">
								</div>
							</div>
							<input type="file" id="fileUpload" class="form-control" />
							<c:url value="/file/upload/" var="path" />
							<input type="hidden" id="path" value="${path}" />
							<button class="btn btn-outline-secondary mt-3">Save</button>
						</div>
					</div>
				</div>
				<div class="tab-pane container-fluid fade" id="security">
					<c:url value="/admin/user/edit" var="changePassword" />
					<mvc:form action="${ changePassword }" method="post">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Password</label> <input id="userPassword"
										name="userPassword" type="password" class="form-control" />
								</div>
								<div class="form-group">
									<label>Confirm password</label> <input
										id="confirm_userPassword" name="confirm_userPassword"
										type="password" class="form-control" />
								</div>
							</div>
							<div class="col-md-12">
								<button class="btn btn-outline-secondary">Save</button>
							</div>
						</div>
					</mvc:form>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>
<!-- END CONTENT -->