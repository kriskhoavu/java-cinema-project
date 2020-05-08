<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<li class="breadcrumb-item"><a href="#!">Danh sách tài
							khoản</a></li>
				</ul>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="card px-3">
				<div class="card-header px-0 pb-2">
					<h2 class="text-uppercase text-center">Danh sách tài khoản</h2>
					<a href='<c:url value="/admin/user/add"/>'
						class="btn btn-sm btn-primary">Thêm mới</a>
				</div>
				<div class="card-block table-border-style">
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Index</th>
									<th>Họ Tên</th>
									<th>Email</th>
									<th>Số ĐT</th>
									<th>Avatar</th>
									<th>#</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ users }" var="item" varStatus="loop">
									<tr>
										<th>${ loop.index + 1 }</th>
										<td>${ item.fullname }</td>
										<td>${ item.email }</td>
										<td>${ item.phone }</td>
										<td><img
											src="<c:url value='/statics/upload/'/>${item.avatar}" height="50px">
										</td>
										<td><a
											href='<c:url value="/admin/user/edit/${item.id}"/>'
											class="btn btn-sm btn-info btn-round py-1 font-weight-bold">Sửa</a>
											<a href='<c:url value="/admin/user/delete/${item.id}"/>'
											class="btn btn-sm btn-danger btn-round py-1 font-weight-bold">Xóa</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>