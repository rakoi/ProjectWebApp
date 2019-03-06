<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link  href="css/bootstrap.css" rel="stylesheet" ></link>
    <link  href="css/bootstrap.css.map" rel="stylesheet"></link>
    <link  href="css/bootstrap-theme.css" rel="stylesheet"></link>
    <link  href="css/bootstrap-theme.css.map" rel="stylesheet"></link>
    <link  href="css/custom.css" rel="stylesheet"></link>
    <title>Servlet</title>
</head>
<body>
<!-- Start Page Content -->
<div class="loginPage col col-md-12">
    <div class="col col-md-6 col-md-offset-4">
        <!-- Start Login Panel -->
        <div class="panel loginPanel ">
            <div class="panel-heading">
                <h4>Sign In</h4>
                <hr>
            </div>
            <form action="/login" method="POST" class="form" role="login">
                <div class="panel-body">
                    <label >USERNAME</label>
                    <input type="text" name="username" class="form-control" ><br>
                    <label>PASSWORD</label>
                    <input type="password" name="password" class="form-control" ><br>

                    <c:if test="${error!=null}">
                        <div class="alert alert-danger">
                            ${error}
                        </div>
                    </c:if>


                    <div class="panel-footer">
                        <input type="submit" value="Login" class="btn btn-block btn-large btn-info"/>

                    </div>
                    </div>
            </form>
        </div>
    </div>
    <!-- 	End of Panel -->
</div>
</div>
<!-- End Page Content -->
</body>
</html>