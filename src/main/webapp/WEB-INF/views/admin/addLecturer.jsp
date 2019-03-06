<%@ include file="includes/header.jsp"%>
<!-- Start Page Content -->
<div class="addLec col-md-6 col-md-offset-3">

    <c:if test="${msg!=null}">
    <div class="alert alert-success">
        <h4>User added Successfully</h4>
    </div>
    </c:if>


    <h4>Step 1 <small>Create Account</small></h4>
    <form class="form" action="/admin/addLecturer" role="form" method="POST">
        <input type="text" name="username" placeholder="username" class="form-control"> <br>
        <label >Account Type</label>
        <select class="form-control" name="accountType">
            <option class="form-control" value="admin">Admin</option>
            <option class="form-control" value="lecturer">Lecturer</option>
        </select>
        <br>
        <input type="password" name="password" placeholder="password"class="form-control">
        <input type="password" name="cpassword" placeholder="confirmpassword"class="form-control">
        <!-- <div class="alert alert-danger">
            <p><i id="error"></i></p>
        </div> -->
        <input type="submit" value="Register" class="btn btn-info btn-block form-control" >
    </form>
</div>
<!-- End Page Content -->
</body>
</html>