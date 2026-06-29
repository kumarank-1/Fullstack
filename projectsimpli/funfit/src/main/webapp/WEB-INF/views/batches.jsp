<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Batches | Funfit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/styles.css">
</head>
<body>
<div class="app-shell">
    <header class="topbar">
        <div class="topbar-inner">
            <a class="brand" href="${pageContext.request.contextPath}/index.html">
                <img src="${pageContext.request.contextPath}/assets/funfit-mark.svg" alt="">
                <span>Funfit</span>
            </a>
            <nav class="nav" aria-label="Primary">
                <a href="${pageContext.request.contextPath}/participants">Participants</a>
                <a href="${pageContext.request.contextPath}/add-batch.html">Add Batch</a>
                <a href="${pageContext.request.contextPath}/add-participant.html">Add Participant</a>
            </nav>
        </div>
    </header>

    <main class="content">
        <div class="page-heading">
            <div>
                <h1>Batches</h1>
                <p class="subtitle">Morning and evening Zumba sessions.</p>
            </div>
            <a class="button primary" href="${pageContext.request.contextPath}/add-batch.html">Add Batch</a>
        </div>

        <c:if test="${not empty param.message}">
            <div class="notice">${param.message}</div>
        </c:if>

        <section class="table-panel">
            <c:choose>
                <c:when test="${empty batches}">
                    <div class="empty">No batches found.</div>
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Slot</th>
                            <th>Instructor</th>
                            <th>Capacity</th>
                            <th>Time</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="batch" items="${batches}">
                            <c:url var="batchEditUrl" value="/update-batch.html">
                                <c:param name="id" value="${batch.id}"/>
                                <c:param name="batchName" value="${batch.batchName}"/>
                                <c:param name="timeSlot" value="${batch.timeSlot}"/>
                                <c:param name="instructorName" value="${batch.instructorName}"/>
                                <c:param name="capacity" value="${batch.capacity}"/>
                                <c:param name="startTime" value="${batch.startTime}"/>
                                <c:param name="endTime" value="${batch.endTime}"/>
                            </c:url>
                            <tr>
                                <td>${batch.id}</td>
                                <td>${batch.batchName}</td>
                                <td>${batch.timeSlot}</td>
                                <td>${batch.instructorName}</td>
                                <td>${batch.capacity}</td>
                                <td>${batch.startTime} - ${batch.endTime}</td>
                                <td>
                                    <div class="row-actions">
                                        <a class="button" href="${pageContext.request.contextPath}/participants?batchId=${batch.id}">Members</a>
                                        <a class="button" href="${batchEditUrl}">Edit</a>
                                        <form action="${pageContext.request.contextPath}/batches" method="post">
                                            <input type="hidden" name="_method" value="DELETE">
                                            <input type="hidden" name="id" value="${batch.id}">
                                            <button class="danger" type="submit">Delete</button>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </section>
    </main>
</div>
</body>
</html>
