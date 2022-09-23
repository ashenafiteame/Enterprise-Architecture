<%--
  Created by IntelliJ IDEA.
  User: yemane
  Date: 9/19/22
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Books currently in the BookStore</h1>
<table>
    <b:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.ISBN}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <sec:authorize access="hasRole('ADMIN')">
                <td><a href="books/${book.id}">edit</a></td>

            </sec:authorize>
        </tr>
    </b:forEach>
    <sec:authorize access="hasRole('ADMIN')">
        <a href="books/add"> Add a Book</a>
    </sec:authorize>

    <a href="logout">Logout</a>
</table>

</body>
</html>
