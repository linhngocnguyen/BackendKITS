<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%--
  Created by IntelliJ IDEA.
  Date: 7/20/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello</h1>
//display all student
<sql:setDataSource var="db" driver="org.mariadb.jdbc.Driver"
                   url="jdbc:mariadb://localhost:3306/dbstudent"
                   user="root" password="1105"/>

<sql:query dataSource="${db}" var="rs">
    SELECT * from tbstudent;
</sql:query>

<table border="0.5">
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