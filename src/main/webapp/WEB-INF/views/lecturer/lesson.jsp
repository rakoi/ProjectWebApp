<%@include file="includes/header.jsp"%>
<!-- Start Page Content -->
<div class="col col-md-12">
    <div class="col col-md-6 col-md-offset-2">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Student</th>
                <th>Attendance</th>
            </tr>
            </thead>
            <tbody>
            ${studentAttendance.size()}
            <c:forEach var="attendance" items="${studentAttendance}">
                <tr>
                    <td><b>${attendance.key.firstname} ${attendance.key.lastname} </b></td>
                    <td>${attendance.value} out of 12</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>
</div>
<!-- End Page Content -->
<script src="js/jquery.js"></script>

</body>
</html>