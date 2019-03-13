<%@include file="includes/header.jsp"%>

<!-- Start Page Content -->
<div class="pageContent col col-md-12">

    <!-- Start of sesion place -->
    <div class="col col-md-4">
        <div class="panel">
            <div class="panel-heading">
                <h4>Current Session</h4>
                <hr>
            </div>
            <div class="panel-body">
                Unit Code: <i class="pull-right">${lesson.unitcode}</i>
                <br>
                Unit: <i class="pull-right">${lesson.name}</i>
                <br>
                Time:<i class="pull-right">
                        ${lesson.ltime}

            </i>
            </div>
        </div>


        <c:if test="${imageUrl!=null}">
          <a href="${imageUrl}">  <img src="${imageUrl}" width="410" height="400" class="barcode"></a>
        </c:if>

        <c:if test="${imageUrl==null}">
            <img src="/img/lesson.png" width="370" height="300" class="barcode">
        </c:if>


    </div>
    <!-- End of Session place -->

    <div class="col col-md-6 col-md-offset-2">
        <div class="panel">
            <div class="panel-heading">
                <img src="img/morty.png" height="150" width="150" class="img-circle pull-right">
                <br>
                <div class="panel-body" style="margin-top:170px;">

                    <table class="table">
                        <thead>
                        <tr></tr>
                        <tr></tr>
                        </thead>
                        <tr>
                            <td><b>Name</b></td>
                            <td>${username}</td>
                        </tr>
                        <tr>
                            <td><b>Department</b></td>
                            <td>I.T and Computing</td>
                        </tr>
                        <tr>
                            <td>
                                <h4><b>Lessons</b></h4>
                            <td>
                                <ul class="lec-details">
                                    <c:forEach items="${lessons}" var="lesson" >
                                    <li>
                                       ${lesson.name}
                                        <i class="pull-right">${lesson.day} ${lesson.ltime}</i>
                                        <hr>
                                    </li>
                                    </c:forEach>
                                </ul>

                            </td>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- End Page Content -->
<script src="js/jquery.js"></script>

</body>
</html>