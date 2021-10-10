<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Linux Distributions - Edit Hop Experience</title>
    </head>
    <body>
        <h1>Edit the distro hop experience:</h1>
        <form method="post" action="UpdateHopExperienceServlet">
            <fieldset>
                <legend>Edit the Linux distro you are testing:</legend>
                <table>
                    <c:forEach items="${requestScope.linuxDistroList}" var="currentDistro">
                        <tr>
                            <td><input type="radio" name="distroId" value="${currentDistro.id}"></td>
                            <td>
                                <h3>${currentDistro.name}</h3>
                            </td>
                            <td>
                                <ul>
                                    <li>Based On: ${currentDistro.basedOn}</li>
                                    <li>Origin: ${currentDistro.origin}</li>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
            <fieldset>
                <legend>Edit the date you hopped onto this distro:</legend>
                <input type="text" name="month" placeholder="mm" size="4" value="${month}">
                <input type="text" name="day" placeholder="dd" size="4" value="${date}">
                <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
            </fieldset>
            <fieldset>
                <legend>Edit your experience rating for this distro with a value between 0 and 100:</legend>
                <input type="text" name="rating" value="${newHopExperience.rating}">
            </fieldset>
            <fieldset>
                <legend>Edit your notes detailing your experience as you test this distro:</legend>
                <textarea name="journal" rows="8" cols="64">${newHopExperience.journal}</textarea>
            </fieldset>
            <fieldset>
                <legend>Edit your final thoughts for this distro:</legend>
                <textarea name="finalThoughts" rows="2" cols="64">${newHopExperience.finalThoughts}</textarea>
            </fieldset>
            <fieldset>
                <legend>Submit your edited distro hop experience:</legend>
                <input type="hidden" name="id" value="${newHopExperience.id}">
                <input type="submit" value="Submit">
            </fieldset>
        </form>
        <a href="index.html">Add Linux distros</a>
    </body>
</html>