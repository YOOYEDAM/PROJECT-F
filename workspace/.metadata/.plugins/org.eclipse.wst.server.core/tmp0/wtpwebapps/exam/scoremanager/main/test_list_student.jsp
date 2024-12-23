<%-- 学生一覧JSP --%>
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
        <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績参照</h2>
        <c:import url = "test_list_filter.jsp"/>
            <c:choose>
            <c:when test="${subjectlists.size()>0}">

                <div>氏名 : ${name.name}(${name.no})</div> <!-- 氏名、学生番号-->
                <table class="table table-hover">

                    <tr>
                    <th>科目名</th>
                    <th>科目コード</th>
                    <th>回数</th>
                    <th>点数</th>
                    </tr>
                    <c:forEach var="subjectlist" items="${subjectlists}">
                    <tr>
                    <td>${subjectlist.subjectName}</td>
                    <td>${subjectlist.subjectCd}</td>
                    <td>${subjectlist.num}</td>
                    <td>${subjectlist.point}</td>
                    </tr>
                    </c:forEach>
                </table>
            </c:when>

            <c:otherwise>
            <div>氏名 : ${name.name}(${name.no})</div>
                <div>成績情報が存在しませんでした</div>
            </c:otherwise>

            </c:choose>

        </section>
    </c:param>
</c:import>