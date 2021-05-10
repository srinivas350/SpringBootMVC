<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="deleteStudent" method="get">
		<input type="text" name="studentId">
		<input type="submit" value="Submit">
	</form>
	
	<table border="2px">
		<tr>
			<th>StudentId</th>
			<th>StudentName</th>
			<th>StudentMarks</th>
			<th>StudentClass</th>
			<th>StudentGrade</th>
		</tr>
		<tbody>
			<c:forEach items="${student}" var="student">
				<tr>
					<td><c:out value="${student.studentId}" /></td>
					<td><c:out value="${student.studentName}" /></td>
					<td><c:out value="${student.studentMarks}" /></td>
					<td><c:out value="${student.studentClass}" /></td>
					<td><c:out value="${student.studentGrade}" /></td>
				</tr>
				<p>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>