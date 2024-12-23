<%-- 学生登録JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
    <c:param name="scripts"></c:param>

    <c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2>
			<c:if test="${!empty done}">
				<div class="bg-success bg-opacity-50 text-center lh-lg">
					<p>${done}</p>
				</div>
			</c:if>
			<form action="SubjectCreateExecute.action" method="post">
				<div class="mx-3 py-2">
					<div class="mb-3 my-3">
						<label class="form-label" for="sbject-cd-input">科目コード</label>
							<input class="form-control" type="text" id="sbject-cd-input" name="cd"
                            	placeholder="科目コードを入力してください" maxlength="10" value="${cd}" required />
							<div class="mt-2 text-warning">${errors.get("cd")}</div>
					</div>

                    <div class="my-3">
						<label class="form-label" for="student-name-input">科目名</label>
						<input class="form-control" type="text" id="student-name-input" name="name"
                               placeholder="科目名を入力してください" maxlength="10" value="${name}" required />
						<div class="mt-2 text-warning">${errors.get("name")}</div>
					</div>

                    <div class="mt-3">
						<input class="btn btn-secondary" type="submit" value="登録" name="end" style="background-color: blue; color: white;">
					</div>
				</div>
			</form>
			<div class="lh-lg row">
				<div class="mx-3 col-1">
					<a href="StudentList.action">戻る</a>
				</div>
			</div>
		</section>
		</c:param>
</c:import>