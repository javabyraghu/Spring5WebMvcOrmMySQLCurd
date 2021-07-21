<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>EMPLOYEE DATA PAGE</title>
</head>
<body>
<h3>EMPLOYEE DATA</h3>
<table border="1">
	<tr>	
		<th>ID</th>
		<th>NAME</th>
		<th>SAL</th>
		<th>DEPT</th>
		<th>HRA</th>
		<th>TA</th>
		<th>OPERATION</th>
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob.empId}</td>
			<td>${ob.empName}</td>
			<td>${ob.empSal}</td>
			<td>${ob.empDept}</td>
			<td>${ob.empHra}</td>
			<td>${ob.empTa}</td>
			<td> 
				<a href="delete?id=${ob.empId}">DELETE</a>  
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>