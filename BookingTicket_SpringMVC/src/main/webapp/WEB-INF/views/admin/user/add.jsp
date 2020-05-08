<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-body">
	<div class="row">
		<div class="col-md-12 mb-2">
			<div class="page-header-breadcrumb">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a
						href="<c:url value="/admin/user"/>"> <i
							class="feather icon-home"></i> Trang chủ
					</a></li>
					<li class="breadcrumb-item"><a href="#!">Thêm mới tài
							khoản</a></li>
				</ul>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="card">
				<div class="card-header">
					<h2 class="text-uppercase text-center">Thêm mới tài khoản</h2>
				</div>
				<div class="card-block">
					<c:url value="/admin/user/add" var="action" />
					<mvc:form action="${ action }" method="post" modelAttribute="user"
						enctype="multipart/form-data">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label>Họ tên</label>
									<mvc:input type="text" path="fullname" cssClass="form-control" />
									<mvc:errors path="fullname" cssClass="text-danger" />
								</div>
								<div class="form-group">
									<label>Email</label>
									<mvc:input type="text" path="email" cssClass="form-control" />
									<mvc:errors path="email" cssClass="text-danger" />
								</div>
								<div class="form-group">
									<label>Mật khẩu</label>
									<mvc:input type="password" path="password"
										cssClass="form-control" />
									<mvc:errors path="password" cssClass="text-danger" />
								</div>
								<div class="form-group">
									<label>Nhập lại mật khẩu</label>
									<mvc:input type="password" path="confirm"
										cssClass="form-control" />
									<mvc:errors path="confirm" cssClass="text-danger" />
								</div>
								<div class="form-group">
									<label>Loại người dùng</label>
									<mvc:select path="roleId" items="${ roles }" itemValue="id"
										itemLabel="description" cssClass="form-control" />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label>Điện thoại</label>
									<mvc:input type="text" path="phone" cssClass="form-control" />
								</div>
								<div class="form-group">
									<label>Địa chỉ</label>
									<mvc:input type="text" path="address" cssClass="form-control" />
								</div>
								<div class="form-group">
									<label>Địa chỉ website</label>
									<mvc:input type="text" path="website" cssClass="form-control" />
								</div>
								<div class="form-group">
									<label>Địa chỉ facebook</label>
									<mvc:input type="text" path="facebook" cssClass="form-control" />
								</div>
								<div class="form-group">
									<label>Avatar</label>
									<mvc:input type="hidden" path="avatar" />
									<div id="DropZoneUpload" class="dropzone"
										data-upload='<c:url value="/file/upload/"/>'
										data-load='<c:url value="/file/load/"/>'>
										<div class="dz-default dz-message"></div>
									</div>
								</div>
							</div>
							<div class="col-12 mt-3">
								<div class="form-group">
									<button type="submit" class="btn btn-primary m-b-0">Lưu
										lại</button>
									<a href="<c:url value="/admin/user"/>"
										class="btn btn-secondary text-white">Quay lại</a>
								</div>
							</div>
						</div>
					</mvc:form>
				</div>
			</div>
		</div>
	</div>
</div>
