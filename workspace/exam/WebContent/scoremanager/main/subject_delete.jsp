<%-- 科目削除JSP --%>
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
            <form action = "SubjectDeleteExecute.action" method="post">
                <div class="mx-3 py-2">
                    <div class="mb-3">
                        <label class="form-label" for="subject-cd-input">「${name}(${cd})」を削除してもよろしいですか</label>
                        <input readonly class="form-control-plaintext ms-3" type="hidden"
                            id="subject-cd-input" name="cd" value="${cd}" />
                    </div>
                    <div class="mt-3">
                        <input class="btn btn-primary" type="submit" value="削除"
                        style="background-color:#FF4C4C;border-color:#FF4C4C;color:white">
                    </div>
                </div>
            </form>
            <div class="lh-lg row">
                <div class="mx-3 col-1">
                    <a href="SubjectList.action">戻る</a>
                </div>
            </div>
        </section>
    </c:param>
</c:import>
