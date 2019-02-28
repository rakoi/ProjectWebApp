<%@ include file="includes/header.jsp"%>
<!-- Start Page Content -->
<div class="addLec col-md-6 col-md-offset-3">
    <h4>Step 2 <small><b>Add Units</b></small></h4>

    <input type="text" name="lectureName" placeholder="Lecture's Name" class="form-control">
    <hr><br>


    <form class="form" action="/addLecturer" role="form" method="POST">
        <input type="text" name="unit1" placeholder="unit 1" class="form-control">
        <input type="text" name="unit2" placeholder="unit 2"class="form-control">
        <input type="text" name="unit3" placeholder="unit 3"class="form-control">
        <!-- <div class="alert alert-danger">
            <p><i id="error"></i></p>
        </div> -->
        <input type="submit" value="Assign" class="btn btn-info btn-block form-control" >
    </form>
</div>
<!-- End Page Content -->
</body>
</html>