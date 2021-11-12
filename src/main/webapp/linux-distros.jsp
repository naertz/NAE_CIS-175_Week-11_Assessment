<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Linux Distributions - Distro List</title>
    </head>
    <body>
        <form method="post" action="NavigationServlet">
            <table>
                <c:forEach items="${requestScope.linuxDistroList}" var="currentDistro">
                    <tr>
                        <td><input type="radio" name="id" value="${currentDistro.id}"></td>
                        <td>${currentDistro.name}</td>
                        <td>${currentDistro.basedOn}</td>
                        <td>${currentDistro.origin}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Add Distro" name="performDistroAction">
            <input type="submit" value="Edit Distro" name="performDistroAction">
            <input type="submit" value="Delete Distro" name="performDistroAction">
        </form>
    </body>
</html>