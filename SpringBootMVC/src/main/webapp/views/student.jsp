<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<html>

<body>
		
	<form action="saveStudent" method="post">
		
		<div>
			<h2><a href="getAllStudent">GetAllStudents</a></h2><h2><a href="delete">Delete Students</a></h2>
			StudentId:<input type="text" name="studentId"><br>
			StudentName:<input type="text" name="studentName"><br>
			StudentMarks:<input type="text" name="studentMarks"><br>
			StudentClass:<input type="text" name="studentClass"><br>
			StudentGrade:<input type="text" name="studentGrade"><br>
			<input type="submit" value="Submit"> <input type="reset"
				value="Clear">
		</div>
		Status :${status}
	</form>
	
</body>
</html>