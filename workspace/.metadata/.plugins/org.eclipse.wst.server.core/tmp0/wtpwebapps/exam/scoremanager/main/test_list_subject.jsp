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
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生管理</h2>
            <c:import url = "test_list_filter.jsp"/>
            <c:choose>
                <c:when test="${students.size()>0}">
                	 <div>科目:${f3.name}</div>
                    <table class="table table-hover">
                        <tr>
                            <th>入学年度</th>
                            <th>学生番号</th>
                            <th>クラス</th>
                            <th>氏名</th>
                            <th>1回</th>
                            <th>2回</th>
                        </tr>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.entYear}</td>
                                <td>${student.classNum}</td>
                                <td>${student.studentNo}</td>
                                <td>${student.studentName}</td>
                                <td>${student.getPoint(1)}</td>
                                <td>${student.getPoint(2)}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
               		     <div>学生情報が存在しませんでした</div>
                </c:otherwise>
            </c:choose>
        </section>
    </c:param>
</c:import>