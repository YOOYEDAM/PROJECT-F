<%-- 学生更新JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">
        得点管理システム
    </c:param>

    <c:param name="scripts"></c:param>

    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生情報削除</h2>
            <form action = "StudentDeleteExecute.action" method="post">
                <div class="mx-3 py-2">
                       「${student.name}(${student.no})」を削除してよろしいですか
                    <input type="hidden" name = "no" value = "${student.no}">
                   	<div class="mt-3">
    					<input class="btn btn-primary" type="submit" value="削除" style="background-color: #FF0033; color: white; border: none;">
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