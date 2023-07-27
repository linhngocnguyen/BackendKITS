<%@ page import="student.StudentProcess" %>
<%@ page import="student.Student" %>
<%@ page import="java.util.List" %>
<%
  String ID=request.getParameter("txtID");
  String Name=request.getParameter("txtName");
  String Gender=request.getParameter("txtGender");
  String ClassID=request.getParameter("txtClassID");
  String MarkString = request.getParameter("txtMark");
  Double Mark= Double.parseDouble(MarkString);
  StudentProcess sp = new StudentProcess();
  boolean result = sp.updateStudent(ID, Name, Gender, ClassID, Mark);
  List<Student> studentList = sp.getListStudent();
%>
<html>
<head>
  <title>Update Student Result</title>
</head>
<body>
<% if (result) { %>
<h2>Student with ID <%= ID %> has been updated.</h2>
<% } else { %>
<h2>Failed to update student with ID <%= ID %>.</h2>
<% } %>

<h2>List of Students</h2>
<table>
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

<br>
<a href="updateForm.jsp">Update another student</a>
</body>
</html>