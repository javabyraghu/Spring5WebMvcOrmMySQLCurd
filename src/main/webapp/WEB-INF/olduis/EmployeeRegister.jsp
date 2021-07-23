<html>
<head>
  <title>EMPLOYEE REGISTER PAGE</title>
</head>
<body>
<h3>EMPLOYEE REGISTER</h3>
<form action="save" method="POST">
<pre>
NAME   : <input type="text" name="empName" />
SALARY : <input type="text" name="empSal" />
DEPT   : <select name="empDept"> 
			<option value="">-SELECT-</option>
			<option value="BA">BA</option>
			<option value="DEV">DEV</option>
			<option value="QA">QA</option>
		</select>
		<input type="submit" value="Add"/>
</pre>
</form>  
<b>${message}</b>
</body>
</html>
