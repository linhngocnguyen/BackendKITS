<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students by Class ID</title>
</head>

<sql:setDataSource var="db" driver="org.mariadb.jdbc.Driver"
                   url="jdbc:mariadb://localhost:3306/dbstudent"
                   user="root" password="1105"/>

<c:set var="classid" value="${param.classID}"/>

<sql:query dataSource="${db}" var="rs">
    SELECT * from tbstudent where classid=?;
    <sql:param value="${classid}" />
</sql:query>

<body>
<h1>Students by Class ID</h1>
<form method="post" action="">
    Class ID: <input type="text" name="classID" />
    <input type="submit" value="Search" />
</form>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Class ID</th>
        <th>Mark</th>
    </tr>
    </thead>
    <c:forEach var="table" items="${rs.rows}">
        <tbody>
        <tr>
            <th><c:out value="${table.id}"/></th>
            <th><c:out value="${table.name}"/></th>
            <th><c:out value="${table.gender}"/></th>
            <th><c:out value="${table.classid}"/></th>
            <th><c:out value="${table.mark}"/></th>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>