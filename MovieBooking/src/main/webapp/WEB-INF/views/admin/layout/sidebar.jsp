<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="pcoded-navbar">
	<div class="pcoded-inner-navbar main-menu">
		<ul class="pcoded-item pcoded-left-item">
			<li class=""><a href="javascript:void(0)"> <span
					class="pcoded-micon"><i class="feather icon-home"></i></span> <span
					class="pcoded-mtext">Dashboard</span>
			</a></li>
			<li class=""><a href="#"> <span class="pcoded-micon"><i
						class="feather icon-layers"></i></span> <span class="pcoded-mtext">Danh
						mục</span>
			</a></li>
			<li class=""><a href='<c:url value="/admin/user" />'> <span
					class="pcoded-micon"> <i class="feather icon-layers"></i></span> <span
					class="pcoded-mtext">Khóa học</span>
			</a></li>
			<li class=""><a href="<c:url value="/admin/user" />"> <span class="pcoded-micon"><i
						class="feather icon-user"></i></span> <span class="pcoded-mtext">Tài
						khoản</span>
			</a></li>
			<li class=""><a href='<c:url value="/admin/role" />'> <span
					class="pcoded-micon"> <i class="feather icon-user"></i>
				</span> <span class="pcoded-mtext">Quyền</span>
			</a></li>
			<li class="pcoded-hasmenu"><a href="javascript:void(0)"> <span
					class="pcoded-micon"><i class="feather icon-layers"></i></span> <span
					class="pcoded-mtext">Widget</span>
			</a>
				<ul class="pcoded-submenu">
					<li class=""><a href="widget-statistic.htm"> <span
							class="pcoded-mtext">Statistic</span>
					</a></li>
					<li class=" "><a href="widget-data.htm"> <span
							class="pcoded-mtext">Data</span>
					</a></li>
					<li class=""><a href="widget-chart.htm"> <span
							class="pcoded-mtext">Chart Widget</span>
					</a></li>

				</ul></li>
		</ul>
	</div>
</nav>