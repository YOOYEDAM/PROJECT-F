<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">
        得点管理システム
    </c:param>

    <c:param name="scripts"></c:param>

    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績参照</h2>
            <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
                <form method="get" action="SubjectTestList.action">

                    <div class="row align-items-center mx-3 border-bottom">
                        <div class="col">
                            <div class="reft">
                                <label class="form-label" for="subject-info">科目情報</label>
                            </div>
                        </div>
                        <div class="col-2">
                            <input type="hidden" name="f" value="sj"> <!-- 科目情報識別コード -->
                            <label class="form-label" for="student-f1-select">入学年度 </label>
                            <select class="form-select " id="student-f1-select" name="f1">
                                <option value="0">--------</option>
                                <c:forEach var="year" items="${ent_year_set}">
                                    <%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
                                    <option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-2">
                            <label class="form-label" for="student-f2-select">クラス</label>
                            <select class="form-select " id="student-f2-select" name="f2">
                                <option value="0">--------</option>
                                <c:forEach var="num" items="${class_num_set}">
                                    <%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>
                                    <option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-4">
                            <label class="form-label" for="student-f3-select">科目</label>
                            <select class="form-select " id="student-f3-select" name="f3">
                                <option value="0">--------</option>
                                <c:forEach var="subject" items="${subjects}">
                                    <%-- 現在のsubjectと選択されていたf3が一致していた場合selectedを追記 --%>
                                    <option value="${subject.cd}" <c:if test="${subject.cd eq f3}">selected</c:if>>${subject.name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-2 text-center">
                            <button class="btn btn-secondary" id="filter-button">検索</button>
                        </div>
                        <div class="mt-2 text-warning">${errors.get("f1")}</div>
                    </div>

                </form>
                <form method="get" action="StudentTestList.action">
                    <div class="row align-items-center mx-3"> <!-- 真ん中の線 -->
                        <div class="col-2"> <!-- 学生情報ラベル -->
                            <div class="reft">
                                <label class="form-label" for="subject-info">学生情報</label>
                            </div>
                        </div>
                        <div class="col-6"> <!-- 学生番号入力欄 -->
                            <div class="row align-items-center">
                                <div class="col-9">
                                    <label class="form-label" for="student-name-input">学生番号</label>
                                    <input class="form-control" type="text" id="student-name-input" name="f4" placeholder="学生番号を入力してください" maxlength="10" value="${studentNo}" required style="color: black;" />
                                    <div class="mt-2 text-warning">${errors.get("studentNo")}</div>
                                </div>
                                <div class="col-3 text-end"> <!-- 検索ボタン -->
                                    <button class="btn btn-secondary" id="filter-button">検索</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

           <div class="reft">氏名 : ${studentName} (${studentNo})</div>




            <c:choose>
                <c:when test="${testList.size()>0}">
                    <table class="table table-hover">
                        <tr>
                            <th>科目名</th>
                            <th>科目コード</th>
                            <th>回数</th>
                            <th>点数</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="test" items="${testList}">
                            <tr>
                                <td>${test.subjectName}</td>
                                <td>${test.subjectCd}</td>
                                <td>${test.num}</td>
                                <td>${test.point}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <div>成績情報が存在しませんでした</div>
                </c:otherwise>
            </c:choose>
            </section>

</c:param>
</c:import>