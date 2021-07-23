<%@page isELIgnored="false"%>
<html>
  <head>
    <title>EMPLOYEE MESSAGE PAGE</title>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
    <div class="container">
      <div class="card">
        <div class="card-header bg-primary text-white text-center">
            <h3>EMPLOYEE MESSAGE</h3>
        </div>
        <!-- header end -->
        <div class="card-body">
          <b>${message}</b> <br/>
          <a href="all" class="btn btn-info">VIEW ALL</a>
        </div>
      </div>
    </div>
  </body>
</html>
