<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Batch Participants | Funfit</title>
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
                <a href="${pageContext.request.contextPath}/participants">Participants</a>
                <a href="${pageContext.request.contextPath}/add-participant.html">Add Participant</a>
            </nav>
        </div>
    </header>

    <main class="content">
        <div class="page-heading">
            <div>
                <h1>Batch Participants</h1>
                <c:choose>
                    <c:when test="${batch != null}">
                        <p class="subtitle">${batch.batchName} (${batch.timeSlot})</p>
                    </c:when>
                    <c:otherwise>
                        <p class="subtitle">Batch id ${param.batchId}</p>
                    </c:otherwise>
                </c:choose>
            </div>
            <a class="button primary" href="${pageContext.request.contextPath}/add-participant.html?batchId=${param.batchId}">Add Participant</a>
        </div>

        <section class="table-panel">
            <c:choose>
                <c:when test="${empty participants}">
                    <div class="empty">No participants found for this batch.</div>
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
