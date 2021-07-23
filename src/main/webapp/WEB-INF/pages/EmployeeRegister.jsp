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
                <h3>EMPLOYEE REGISTER</h3>
            </div> 
            <!-- header end -->
            <div class="card-body">
                <form action="save" method="POST">
                    NAME : 
                    <input type="text" name="empName" class="form-control" required/> 
                    SALARY :
                    <input type="number" name="empSal" class="form-control" min="0" required/> 
                    DEPT :
                    <select name="empDept" class="form-control">
                      <option value="">-SELECT-</option>
                      <option value="BA">BA</option>
                      <option value="DEV">DEV</option>
                      <option value="QA">QA</option>
                    </select>
                    <input type="submit" value="Add" class="btn btn-success" />
                  </form>
            </div>
            <!-- card body end -->
            <div class="card-footer">
                <b>${message}</b>
            </div>

        </div> 
        <!-- card end -->
     
    </div>
  </body>
</html>
