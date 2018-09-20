<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-12
  Time: 오후 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp"%>

<!-- 제목 -->
<table width="100%">
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header">이해...했니?</h3>
			</div>
		</div>
		
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-4">
			<c:forEach var="response" items="${response}" >
				<div class="panel panel-default">
					<div class="panel-heading">
						<div style="height: auto; max-width: 1080px; text-align: right;">
							${response.qno}. ${response.question}</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="panel panel-default">
						<div style="height: 350px; max-width: 1080px; text-align: left">
							<br>${response.reply}
							<br>${response.percent}
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
		
	</div>
</table>
							<a href="response?page=${page}">

								<button type="button" class="btn btn-outline btn-primary btn-sm">목록보기</button>
							</a>

<%@ include file="includes/footer.jsp"%>