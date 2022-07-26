<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}/sb-admin2" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style>
	span{
		font-weight: bold;
		color: #224abe;
	}
</style>
</head>
<body>
	<ul
		class="navbar-nav sidebar sidebar-dark accordion" style="background-color: orange;
		background-image: linear-gradient(180deg, orange 10%, #f9eba7 100%);"
		id="accordionSidebar">

		<!-- Sidebar - Brand -->
		<a
			class="sidebar-brand d-flex align-items-center justify-content-center"
			href="home.do">
			<div class="sidebar-brand-icon rotate-n-15">
				<i class="fas fa-laugh-wink"></i>
			</div>
			<div class="sidebar-brand-text mx-3">
				FORWIZ SYSTEM
			</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="home.do"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a>
			</li> <!-- Divider -->
			<hr class="sidebar-divider">

				<!-- Heading -->
				<div class="sidebar-heading">Interface</div>

				<!-- Nav Item - Pages Collapse Menu -->
				<li class="nav-item"><a class="nav-link collapsed" href="#"
					data-toggle="collapse" data-target="#collapseTwo"
					aria-expanded="true" aria-controls="collapseTwo"> <i
						class="fas fa-fw fa-cog"></i> <span>경비</span>
				</a>
					<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
						data-parent="#accordionSidebar">
						<div class="bg-white py-2 collapse-inner rounded">
							<h6 class="collapse-header">경비 정보:</h6>
							<a class="collapse-item" href="costSelectList.do">경비 전체리스트</a> 
							<a class="collapse-item" href="costInsertForm.do">경비 등록</a>
							<a class="collapse-item" href="costCalendar.do">경비 사용 일정</a>
						</div>
					</div></li> <!-- Nav Item - Utilities Collapse Menu -->
				<li class="nav-item"><a class="nav-link collapsed" href="#"
					data-toggle="collapse" data-target="#collapseUtilities"
					aria-expanded="true" aria-controls="collapseUtilities"> <i
						class="fas fa-fw fa-wrench"></i> <span>영화</span>
				</a>
					<div id="collapseUtilities" class="collapse"
						aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
						<div class="bg-white py-2 collapse-inner rounded">
							<h6 class="collapse-header">영화 정보:</h6>
							<a class="collapse-item" href="movieSelectList.do">영화 전체리스트</a> <a
								class="collapse-item" href="movieInsertForm.do">영화 등록</a>
						</div>
					</div></li> <!-- Divider -->
				<hr class="sidebar-divider">

					<!-- Heading -->
					<div class="sidebar-heading">회원</div>

					<!-- Nav Item - Pages Collapse Menu -->
					<li class="nav-item"><a class="nav-link collapsed" href="#"
						data-toggle="collapse" data-target="#collapsePages"
						aria-expanded="true" aria-controls="collapsePages"> <i
							class="fas fa-fw fa-folder"></i> <span>회원</span>
					</a>
						<div id="collapsePages" class="collapse"
							aria-labelledby="headingPages" data-parent="#accordionSidebar">
							<div class="bg-white py-2 collapse-inner rounded">
								<h6 class="collapse-header">접속관련: </h6>
								<sec:authorize access="isAnonymous()">
								<a class="collapse-item" href="userLoginForm.do">로그인</a> <a
									class="collapse-item" href="userRegisterForm.do">회원가입</a> 
								</sec:authorize>
								<sec:authorize access="isAuthenticated()">
									<a class="collapse-item" href="logout">로그아웃</a>
								</sec:authorize>
								<div class="collapse-divider"></div>
								<sec:authorize access="isAnonymous()">
									<h6 class="collapse-header">특수기능: </h6>
									<a class="collapse-item" href="findUserPasswordForm.do">비밀번호 찾기</a>
								</sec:authorize>
							</div>
						</div></li> 
						
						<!-- 연습메뉴(validation) -->
						<li class="nav-item"><a class="nav-link" href="exRegisterForm.do">
							<i class="fas fa-fw fa-chart-area"></i> <span>주민등록번호 유효성검사</span>
					</a></li>
						
						<!-- Nav Item - Charts -->
					<li class="nav-item"><a class="nav-link" href="charts.html">
							<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
					</a></li> <!-- Nav Item - Tables -->
					<li class="nav-item"><a class="nav-link" href="tables.html">
							<i class="fas fa-fw fa-table"></i> <span>Tables</span>
					</a></li> <!-- Divider -->
					<hr class="sidebar-divider d-none d-md-block">

						<!-- Sidebar Toggler (Sidebar) -->
						<div class="text-center d-none d-md-inline">
							<button class="rounded-circle border-0" id="sidebarToggle"></button>
						</div>
	</ul>
</body>
</html>