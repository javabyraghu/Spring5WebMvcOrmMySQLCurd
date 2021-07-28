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
                <form id="myEmpForm" action="save" method="POST">
                    NAME : 
                    <input type="text" name="empName" id="empName" class="form-control"/>
                    <div id="empNameError"></div> 
                    SALARY :
                    <input type="number" name="empSal" id="empSal" class="form-control" min="0" max="100000"/>
                    <div id="empSalError"></div> 
                    DEPT :
                    <select name="empDept" id="empDept" class="form-control">
                      <option value="">-SELECT-</option>
                      <option value="BA">BA</option>
                      <option value="DEV">DEV</option>
                      <option value="QA">QA</option>
                    </select>
                    <div id="empDeptError"></div>
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
     <script type="text/javascript">
      $(document).ready(function () {
        $("#empNameError").hide();
        $("#empSalError").hide();
        $("#empDeptError").hide();

        var empNameError = false;
        var empSalError = false;
        var empDeptError = false;

        function validate_empName() {
          var val = $("#empName").val();
          var exp =/^[A-Z]{4,10}$/;
          if (val == "") {
            $("#empNameError").show();
            $("#empNameError").css("color", "red");
            $("#empNameError").html("**Please Enter Employee Name");
            empNameError = false;
          } else if (!exp.test(val)) {
            $("#empNameError").show();
            $("#empNameError").css("color", "red");
            $("#empNameError").html("**Name must be 4-10 Chars only");
            empNameError = false;
          } else {
            $.ajax({
               url : 'validate',
               data : { 'name' : val},
               success:function(resTxt) {
               		if(resTxt!=''){
               			$("#empNameError").show();
            			$("#empNameError").css("color", "red");
            			$("#empNameError").html(resTxt);
            			empNameError = false;
               		} else {
               			 $("#empNameError").hide();
            			  empNameError = true;
               		} 
               }
            });
          }
          return empNameError;
        }

        function validate_empSal() {
          var val = $("#empSal").val();
          if (val == "") {
            $("#empSalError").show();
            $("#empSalError").css("color", "red");
            $("#empSalError").html("**Please Enter Employee Salary");
            empSalError = false;
          } else {
            $("#empSalError").hide();
            empSalError = true;
          }
          return empSalError;
        }

        function validate_empDept() {
          var val = $("#empDept").val();
          if (val == "") {
            $("#empDeptError").show();
            $("#empDeptError").css("color", "red");
            $("#empDeptError").html("**Please Select Employee Department");
            empDeptError = false;
          } else {
            $("#empDeptError").hide();
            empDeptError = true;
          }
          return empDeptError;
        }

        $("#empName").keyup(function () {
          $(this).val($(this).val().toUpperCase());
          validate_empName();
        });

        $("#empSal").keyup(function () {
          validate_empSal();
        });
        $("#empDept").change(function () {
          validate_empDept();
        });

        $("#myEmpForm").submit(function () {
          validate_empSal();
          validate_empName();
          validate_empDept();

          if (empDeptError && empNameError && empSalError) return true;
          else return false;
        });
      });
    </script>
  </body>
</html>
