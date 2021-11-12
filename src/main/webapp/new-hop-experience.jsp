<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Linux Distributions - Add Hop Experience</title>
        <script>
        function validateHopExperienceForm(event) {
            event.preventDefault();
            
            let selectedMonth = document.querySelector('#textfieldMonth').value.trim();
            let selectedDay = document.querySelector('#textfieldDay').value.trim();
            let selectedYear = document.querySelector('#textfieldYear').value.trim();
            let selectedRating = document.querySelector('#textfieldRating').value.trim();
            
            let isValid = true;
            
            if (isNaN(selectedMonth) || selectedMonth === '' || selectedMonth < 1 || selectedMonth > 12) {
                document.querySelector('#wrongMonth').textContent = 'Month is invalid.';
                document.hopExperienceForm.month.focus();
                isValid = false;
            } else {
                document.querySelector('#wrongMonth').textContent = '';
            }
            
            if (isNaN(selectedDay) || selectedDay === '' || selectedDay < 1 || selectedDay > 31) {
                document.querySelector('#wrongDay').textContent = 'Day is invalid.';
                document.hopExperienceForm.day.focus();
                isValid = false;
            } else {
                document.querySelector('#wrongDay').textContent = '';
            }
            
            if (isNaN(selectedYear) || selectedYear === '' || selectedYear < 1 || selectedYear > 9999) {
                document.querySelector('#wrongYear').textContent = 'Year is invalid.';
                document.hopExperienceForm.year.focus();
                isValid = false;
            } else {
                document.querySelector('#wrongYear').textContent = '';
            }
            
            if (isNaN(selectedRating) || selectedRating === '' || selectedRating < 0 || selectedRating > 100) {
                document.querySelector('#wrongRating').textContent = 'Rating is invalid.';
                document.hopExperienceForm.rating.focus();
                isValid = false;
            } else {
                document.querySelector('#wrongRating').textContent = '';
            }
            
            if (isValid) {
            	document.hopExperienceForm.submit();
            } else {
                return isValid;
            }
        }
        </script>
    </head>
    <body>
        <form name="hopExperienceForm" method="post" action="AddNewHopExperienceServlet" onSubmit="return validateHopExperienceForm(event);">
            <fieldset>
                <legend>Select the Linux distro you are testing:</legend>
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
                <legend>Enter the date you hopped onto this distro:</legend>
                <input type="text" name="month" id="textfieldMonth" placeholder="mm" size="4"><br><p id="wrongMonth"></p><br>
                <input type="text" name="day" id="textfieldDay" placeholder="dd" size="4"><br><p id="wrongDay"></p><br>
                <input type="text" name="year" id="textfieldYear" placeholder="yyyy" size="4"><br><p id="wrongYear"></p>
            </fieldset>
            <fieldset>
                <legend>Rate your experience with this distro with a value between 0 and 100:</legend>
                <input type="text" id="textfieldRating" name="rating"><br><p id="wrongRating"></p>
            </fieldset>
            <fieldset>
                <legend>Enter notes detailing your experience as you test this distro:</legend>
                <textarea name="journal" rows="8" cols="64"></textarea>
            </fieldset>
            <fieldset>
                <legend>Enter your final thoughts for this distro:</legend>
                <textarea name="finalThoughts" rows="2" cols="64"></textarea>
            </fieldset>
            <fieldset>
                <legend>Submit your distro hop experience:</legend>
                <input type="submit" value="Submit">
            </fieldset>
        </form>
        <a href="index.html">Add Linux distros</a>
    </body>
</html>