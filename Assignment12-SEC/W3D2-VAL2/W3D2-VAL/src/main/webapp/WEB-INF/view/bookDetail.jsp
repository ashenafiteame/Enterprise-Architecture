<%--
  Created by IntelliJ IDEA.
  User: yemane
  Date: 9/19/22
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${msg} a Car</title>
    <sec:csrfMetaTags />
    <script type="text/javascript" language="javascript">
        var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
        var csrfHeader = $("meta[name='_csrf_header']").attr("content");
        var csrfToken = $("meta[name='_csrf']").attr("content");
    </script>
</head>
<body>
<b:if test="${msg == 'Update'}">
<form action="../cars/${car.id}" method="post">
    </b:if>
    <b:if test="${msg == 'Add'}">
    <form action="../cars" method="post">
        </b:if>
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="make" value="${book.title}" /> </td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><input type="text" name="model" value="${book.ISBN}" /> </td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><input type="text" name="year" value="${book.author}" /> </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="color" value="${book.price}" /> </td>
            </tr>
        </table>
<%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <input type="submit" value="${msg}"/>
    </form>
    <b:if test="${msg == 'Update'}">
    <form action="delete?bookId=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form>
    </b:if>
</body>

</html>
