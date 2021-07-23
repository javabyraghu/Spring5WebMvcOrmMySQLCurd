<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <title>EMPLOYEE EDIT PAGE</title>
</head>
<body>
<h3>EMPLOYEE EDIT</h3>
<form:form action="update" method="POST" modelAttribute="employee">
<pre>
ID     : <form:input path="empId" readOnly="readOnly"/>
NAME   : <form:input path="empName" />
SALARY : <form:input path="empSal" />
DEPT   : <form:select path="empDept"> 
			<form:option value="">-SELECT-</form:option>
			<form:option value="BA">BA</form:option>
			<form:option value="DEV">DEV</form:option>
			<form:option value="QA">QA</form:option>
		</form:select>
		<input type="submit" value="Update"/>
</pre>
</form:form>  
<b>${message}</b>
</body>
</html>
