<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Linux Distributions - Edit Distro</title>
    </head>
    <body>
        <h1>Edit the Linux distribution:</h1>
        <form action="UpdateDistroServlet" method="post">
            <fieldset>
                <legend>Enter the Linux distro's new name:</legend>
                <input type="text" name="name" value="${newDistro.name}">
            </fieldset>
            <fieldset>
                <legend>Enter the new Linux distro this Linux distro is based on:</legend>
                <input type="text" name="basedOn" value="${newDistro.basedOn}">
            </fieldset>
            <fieldset>
                <legend>Enter the Linux distro's new origin:</legend>
                <input type="text" name="origin" value="${newDistro.origin}">
            </fieldset>
            <fieldset>
                <legend>Update the Linux distro:</legend>
                <input type="hidden" name="id" value="${newDistro.id}">
                <input type="submit" value="Save">
            </fieldset>
        </form>
    </body>
</html>