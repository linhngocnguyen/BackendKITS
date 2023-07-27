<%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUS PC
  Date: 7/24/2023
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="list" method="get" action="insertResult.jsp">
    <h1>Insert a student</h1>
    <table>
        <tr>
            <td>ID: </td>
            <td><input type="text" name="txtID" value=""/></td>
        </tr>

        <tr>
            <td>Name: </td>
            <td><input type="text" name="txtName" value=""/></td>
        </tr>

        <tr>
            <td>Gender: </td>
            <td><input type="text" name="txtGender" value=""/></td>
        </tr>

        <tr>
            <td>ClassID: </td>
            <td><input type="text" name="txtClassID" value=""/></td>
        </tr>

        <tr>
            <td>Mark: </td>
            <td><input type="text" name="txtMark" value=""/></td>
        </tr>
    </table>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
