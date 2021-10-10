<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Linux Distributions - Hop Experience List</title>
    </head>
    <body>
        <form method="post" action="HopExperienceNavigationServlet">
            <table>
                <c:forEach items="${requestScope.hopExperienceList}" var="currentHopExperience">
                    <tr>
                        <td><input type="radio" id="distro" name="id" value="${currentHopExperience.id}"><label for="distro">${currentHopExperience.distro.name}</label></td>
                    </tr>
                    <tr>
                        <td>Hop Date: ${currentHopExperience.hopDate}</td>
                    </tr>
                    <tr>
                        <td>Rating: ${currentHopExperience.rating}</td>
                    </tr>
                    <tr>
                        <td>Journal: ${currentHopExperience.journal}</td>
                    </tr>
                    <tr>
                        <td>Final Thoughts: ${currentHopExperience.finalThoughts}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Add Hop Experience" name="performHopExperienceAction">
            <input type="submit" value="Edit Hop Experience" name="performHopExperienceAction">
            <input type="submit" value="Delete Hop Experience" name="performHopExperienceAction">
        </form>
        <a href="AddHopExperienceServlet">Add New Hop Experience</a><br>
        <a href="index.html">Add New Distro</a>
    </body>
</html>