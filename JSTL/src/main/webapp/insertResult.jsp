<%@ page import="student.StudentProcess" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="student.Student" %>
<%
  String ID=request.getParameter("txtID");
  String Name=request.getParameter("txtName");
  String Gender=request.getParameter("txtGender");
  String ClassID=request.getParameter("txtClassID");
  Double Mark= Double.valueOf(request.getParameter("txtMark"));
  StudentProcess sp = new StudentProcess();
  boolean result = sp.insertStudent(ID, Name, Gender, ClassID, Mark);

%>
<html>
<head>
  <title>Insert Student</title>
</head>
<body>
<% if (result)
  { %>
      <h1>OK</h1>
      <p>Student added successfully!</p>
      <% } else { %>
      <h1>Not OK</h1>
      <p>Failed to add student.</p>
  <% }
%>

<h2>List of Students</h2>
<table border="0.5">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Gender</th>
    <th>ClassID</th>
    <th>Mark</th>
  </tr>
  <% for (Student student : studentList) { %>
  <tr>
    <td><%=student.getID()%></td>
    <td><%=student.getName()%></td>
    <td><%=student.getGender()%></td>
    <td><%=student.getClassID()%></td>
    <td><%=student.getMark()%></td>
  </tr>
  <% } %>
</table>
</body>
</html>