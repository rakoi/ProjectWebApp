<%@include file="includes/header.jsp"%>
<!-- Start Page Content -->
<div class="col col-md-12">
    <div class="col col-md-6 col-md-offset-2">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Lesson</th>
                <th>Attendance</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lessonMap" items="${lessons}">
                <tr>
                    <td><b><a href="/lesson/${lessonMap.key.getName()}">${lessonMap.key.getName()}</a></b></td>
                    <td>${lessonMap.value}</td>
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