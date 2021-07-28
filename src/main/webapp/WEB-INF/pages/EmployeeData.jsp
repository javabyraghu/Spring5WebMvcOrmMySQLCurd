<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>EMPLOYEE DATA PAGE</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
  <%@include file="menu.html"%>
    <div class="container">
      <div class="card">
        <div class="card-header bg-primary text-white text-center">
          <h3>EMPLOYEE DATA</h3>
        </div>
        <!-- header end -->
        <div class="card-body">
          <a href="excel" class="btn btn-success">EXCEL EXPORT</a>
          <table class="table table-hover">
            <tr class="bg-info text-white">
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
                  <a href="delete?id=${ob.empId}" class="btn btn-danger"
                    >DELETE</a
                  >
                  <a href="edit?id=${ob.empId}" class="btn btn-warning">EDIT</a>
                </td>
              </tr>
            </c:forEach>
          </table>
        </div>
        <!-- card body end -->
      </div>
      <!-- card end -->
    </div>
    <!-- container end -->
  </body>
</html>
