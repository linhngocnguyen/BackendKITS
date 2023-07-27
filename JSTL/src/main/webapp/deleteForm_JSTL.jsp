<%--
  Created by IntelliJ IDEA.
  User: MULTICAMPUS PC
  Date: 7/24/2023
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
  <title>Delete Student</title>
</head>
<body>
<sql:setDataSource var="db" driver="org.mariadb.jdbc.Driver"
                   url="jdbc:mariadb://localhost:3306/dbstudent"
                   user="root" password="1105"/>

<c:set var="id" value="${param.id}"/>

<sql:query dataSource="${db}" var="rs">
  DELETE from tbstudent where id=?;
  <sql:param value="${id}" />
</sql:query>

<h2>Delete Student</h2>
<form method="post" action="">
  Enter the ID of the student you want to delete: <input type="text" name="id">
  <br><br>
  <input type="submit" value="Delete">
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
</form>
</body>
</html>