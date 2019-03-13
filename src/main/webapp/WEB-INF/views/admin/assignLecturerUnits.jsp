<%@ include file="includes/header.jsp"%>
<!-- Start Page Content -->
<div class="addLec col-md-6 col-md-offset-3">
    <c:if test="${msg!=null}">
        <div class="alert alert-success">
            <h4>${msg}</h4>
        </div>
    </c:if>
    <h4>Step 2 <small><b>Add Units</b></small></h4>

    <input type="text" id="lectureNames" name="lectureUsername" placeholder="Lecture's Name" class="form-control" value="" onkeyup="getLecturer()" >
    <ul class="list-group" id="lecturers">

    </ul>

    <hr><br>
    <form class="form" action="/admin/addLecturerUnits" role="form" method="POST">

        <input type="hidden" id="username" name="username"  class="form-control" value=""  >



        <input type="text" name="unit1" placeholder="unit 1" id="unit1" onkeyup="getUnit1()" class="form-control">
        <ul class="list-group" id="unitslist">

        </ul>
        <input type="text" onkeyup="getUnit2()" id="unit2" name="unit2" placeholder="unit 2"class="form-control">
        <ul class="list-group" id="units2list">

        </ul>
        <input type="text" id="unit3" onkeyup="getUnit3()" name="unit3" placeholder="unit 3"class="form-control">
        <ul class="list-group" id="units3list">

        </ul>
        <!-- <div class="alert alert-danger">
            <p><i id="error"></i></p>
        </div> -->
        <input type="submit" value="Assign" class="btn btn-info btn-block form-control" >
    </form>
</div>
<!-- End Page Content -->
</body>
</html>