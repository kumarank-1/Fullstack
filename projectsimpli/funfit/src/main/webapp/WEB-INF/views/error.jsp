<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error | Funfit</title>
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
            </nav>
        </div>
    </header>
    <main class="content">
        <div class="notice">
            ${errorMessage}
        </div>
        <a class="button primary" href="${pageContext.request.contextPath}/index.html">Back to Home</a>
    </main>
</div>
</body>
</html>
