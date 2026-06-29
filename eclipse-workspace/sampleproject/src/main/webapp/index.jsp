<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Form</title>
</head>
<body>

    <form action="HelloForm" method="POST">
        First Name:
        <input type="text" name="first_name" />
        <br /><br />

        Last Name:
        <input type="text" name="last_name" />
        <br /><br />

        <input type="submit" value="Submit" />
    </form>

</body>
</html>