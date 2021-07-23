<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>EMPLOYEE REGISTER PAGE</title>
  </head>
  <body>
  <%@include file="menu.html"%>
    <div class="container">
        <div class="card">
            <div class="card-header bg-primary text-white text-center">
                <h3>EMPLOYEE EDIT</h3>
            </div> 
            <!-- header end -->
            <div class="card-body">
                <form:form action="update" method="POST" modelAttribute="employee">
                    ID : 
                    <form:input path="empId" class="form-control" readOnly="true"/> 
                    NAME : 
                    <form:input path="empName" class="form-control"/> 
                    SALARY :
                    <form:input path="empSal" class="form-control" min="0"/> 
                    DEPT :
                    <form:select path="empDept" class="form-control">
                      <form:option value="">-SELECT-</form:option>
                      <form:option value="BA">BA</form:option>
                      <form:option value="DEV">DEV</form:option>
                      <form:option value="QA">QA</form:option>
                    </form:select>
                    <input type="submit" value="UPDATE" class="btn btn-success" />
                  </form:form>
            </div>
            <!-- card body end -->
         
        </div> 
        <!-- card end -->
     
    </div>
  </body>
</html>
