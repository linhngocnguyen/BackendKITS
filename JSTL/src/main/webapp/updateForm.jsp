<html>
<head>
  <title>Delete Student</title>
</head>
<body>
<h2>Delete Student</h2>
<form method="post" action="updateResult.jsp">
  Enter the ID of the student you want to delete: <input type="text" name="txtID">
  <br><br>
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
  <input type="submit" value="Update">
</form>
</body>
</html>