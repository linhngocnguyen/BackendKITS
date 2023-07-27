<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Delete Student Result</title>
</head>
<body>


<h2>List of Students</h2>
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

<br>
<a href="deleteForm_JSTL.jsp">Delete another student</a>
</body>
</html>