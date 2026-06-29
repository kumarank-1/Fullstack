<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Participants | Funfit</title>
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
                <a href="${pageContext.request.contextPath}/batches">Batches</a>
                <a href="${pageContext.request.contextPath}/add-participant.html">Add Participant</a>
                <a href="${pageContext.request.contextPath}/add-batch.html">Add Batch</a>
            </nav>
        </div>
    </header>

    <main class="content">
        <div class="page-heading">
            <div>
                <h1>Participants</h1>
                <p class="subtitle">Participant records across all batches.</p>
            </div>
            <a class="button primary" href="${pageContext.request.contextPath}/add-participant.html">Add Participant</a>
        </div>

        <c:if test="${not empty param.message}">
            <div class="notice">${param.message}</div>
        </c:if>

        <section class="table-panel">
            <c:choose>
                <c:when test="${empty participants}">
                    <div class="empty">No participants found.</div>
                </c:when>
                <c:otherwise>
                    <table>
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Age</th>
                            <th>Gender</th>
                            <th>Batch</th>
                            <th>Joined</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="participant" items="${participants}">
                            <c:url var="participantEditUrl" value="/update-participant.html">
                                <c:param name="id" value="${participant.id}"/>
                                <c:param name="fullName" value="${participant.fullName}"/>
                                <c:param name="email" value="${participant.email}"/>
                                <c:param name="phone" value="${participant.phone}"/>
                                <c:param name="age" value="${participant.age}"/>
                                <c:param name="gender" value="${participant.gender}"/>
                                <c:param name="batchId" value="${participant.batchId}"/>
                                <c:param name="joinedDate" value="${participant.joinedDate}"/>
                            </c:url>
                            <tr>
                                <td>${participant.id}</td>
                                <td>${participant.fullName}</td>
                                <td>${participant.email}</td>
                                <td>${participant.phone}</td>
                                <td>${participant.age}</td>
                                <td>${participant.gender}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${participant.batchId != null}">
                                            <a href="${pageContext.request.contextPath}/participants?batchId=${participant.batchId}">${participant.batchId}</a>
                                        </c:when>
                                        <c:otherwise>Not assigned</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${participant.joinedDate}</td>
                                <td>
                                    <div class="row-actions">
                                        <a class="button" href="${participantEditUrl}">Edit</a>
                                        <form action="${pageContext.request.contextPath}/participants" method="post">
                                            <input type="hidden" name="_method" value="DELETE">
                                            <input type="hidden" name="id" value="${participant.id}">
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
