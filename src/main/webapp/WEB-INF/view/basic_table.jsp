<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Basic Table | Creative </title>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet"/>
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet"/>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <script src="js/lte-ie7.js"></script>
    <![endif]-->

    <!-- =======================================================
      Theme Name: NiceAdmin
      Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
      Author: BootstrapMade
      Author URL: https://bootstrapmade.com
    ======================================================= -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();

            $('table .btn-danger').on('click', function () {
                var warehouseId = $(this).parent().find('#warehouseId').val();
                alert(warehouseId);
                $('#deleteModal #warehouseId').val(warehouseId);
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.request.contextPath}/data/sdelete-user/' + warehouseId,
                    success: function (data) {
                        alert(data);
                        $('#deleteModal #warehouseId').val(warehouseId);
                    }
                });

            });
            $('table .btn-success').on('click', function () {
                var warehouseId = $(this).parent().find('#warehouseId').val();
                //alert(warehouseId);

                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath}/data/sedit-user/' + warehouseId,
                    success: function (data) {
                        //alert(data);
                        $('#myModal-3 #brandName').val(data.brandName);
                        $('#myModal-3 #seriesName').val(data.seriesName);
                        $('#myModal-3 #touchandlcd').val(data.touchandlcd);
                        $('#myModal-3 #audiojack').val(data.audiojack);
                        $('#myModal-3 #microphone').val(data.microphone);
                        $('#myModal-3 #network').val(data.network);
                        $('#myModal-3 #softwarediagnosis').val(data.softwarediagnosis);
                        $('#myModal-3 #deadphonediagnosis').val(data.deadphonediagnosis);
                        $('#myModal-3 #waterdiagnosis').val(data.waterdiagnosis);
                        $('#myModal-3 #standbyphone').val(data.standbyphone);
                        $('#myModal-3 #touchscreenglass').val(data.touchscreenglass);
                        $('#myModal-3 #battery').val(data.battery);
                        $('#myModal-3 #chargeport').val(data.chargeport);
                        $('#myModal-3 #loudspeaker').val(data.loudspeaker);
                        $('#myModal-3 #earspeaker').val(data.earspeaker);
                        $('#myModal-3 #warehouseIdd').val(data.warehouseId);
                        $('#myModal-3 #brandseries').val(data.brandseries);
                        $('#myModal-3 #brand').val(data.brand);
                    }
                });
            });
        });
    </script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function UpdateMoblieParts() {
            var brand = document.getElementById("brand").value;
            var brandSeries = document.getElementById("brandseries").value;
            var brandName = document.getElementById("brandName").value;
            var seriesName = document.getElementById("seriesName").value;
            var touchandlcd = document.getElementById("touchandlcd").value;
            var audiojack = document.getElementById("audiojack").value;
            var microphone = document.getElementById("microphone").value;
            var network = document.getElementById("network").value;
            var softwarediagnosis = document.getElementById("softwarediagnosis").value;
            var deadphonediagnosis = document.getElementById("deadphonediagnosis").value;
            var waterdiagnosis = document.getElementById("waterdiagnosis").value;
            var standbyphone = document.getElementById("standbyphone").value;
            var touchscreenglass = document.getElementById("touchscreenglass").value;
            var battery = document.getElementById("battery").value;
            var chargeport = document.getElementById("chargeport").value;
            var loudspeaker = document.getElementById("loudspeaker").value;
            var earspeaker = document.getElementById("earspeaker").value;
            var warehouseId = document.getElementById("warehouseIdd").value;
            //alert(brand+"  "+brandSeries + " "+warehouseId + " " +battery);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '${pageContext.request.contextPath }/data/UpdateMoblieParts?brand=' + brand
                    + "&brandSeries=" + brandSeries
                    + "&brandName=" + brandName
                    + "&seriesName=" + seriesName
                    + "&touchandlcd=" + touchandlcd
                    + "&audiojack=" + audiojack
                    + "&microphone=" + microphone
                    + "&network=" + network
                    + "&softwarediagnosis=" + softwarediagnosis
                    + "&deadphonediagnosis=" + deadphonediagnosis
                    + "&waterdiagnosis=" + waterdiagnosis
                    + "&standbyphone=" + standbyphone
                    + "&touchscreenglass=" + touchscreenglass
                    + "&battery=" + battery
                    + "&chargeport=" + chargeport
                    + "&loudspeaker=" + loudspeaker
                    + "&earspeaker=" + earspeaker
                    + "&warehouseId=" + warehouseId,
                success: function (data) {
                    alert("sucess " + JSON.stringify(data));
                    $(".modal-body").text("Successfully Added.");
                }
            });
        }
    </script>


</head>

<body>

<!-- container section start -->
<section id="container" class="">
    <!--header start-->
    <header class="header dark-bg">
        <div class="toggle-nav">
            <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i
                    class="icon_menu"></i></div>
        </div>
        <!--logo start-->
        <a href="index.html" class="logo">Nice <span class="lite">Admin</span></a>
        <!--logo end-->

        <div class="nav search-row" id="top_menu">
            <!--  search form start -->
            <ul class="nav top-menu">
                <li>
                    <form class="navbar-form">
                        <input class="form-control" placeholder="Search" type="text">
                    </form>
                </li>
            </ul>
            <!--  search form end -->
        </div>

        <div class="top-nav notification-row">
            <!-- notificatoin dropdown start-->
            <ul class="nav pull-right top-menu">

                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="img/avatar1_small.jpg">
                            </span>
                        <span class="username">Jenifer Smith</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li class="eborder-top">
                            <a href="#"><i class="icon_profile"></i> My Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon_mail_alt"></i> My Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon_clock_alt"></i> Timeline</a>
                        </li>
                        <li>
                            <a href="#"><i class="icon_chat_alt"></i> Chats</a>
                        </li>
                        <li>
                            <a href="login.html"><i class="icon_key_alt"></i> Log Out</a>
                        </li>
                        <li>
                            <a href="documentation.html"><i class="icon_key_alt"></i> Documentation</a>
                        </li>
                        <li>
                            <a href="documentation.html"><i class="icon_key_alt"></i> Documentation</a>
                        </li>
                    </ul>
                </li>
                <!-- user login dropdown end -->
            </ul>
            <!-- notificatoin dropdown end-->
        </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li class="active">
                    <a class="" href="${contextPath}/t">
                        <i class="icon_house_alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon_document_alt"></i>
                        <span>Forms</span>
                        <span class="menu-arrow arrow_carrot-right"></span>
                    </a>
                    <ul class="sub">
                        <li><a class="" href="${contextPath}/form_component">Form Elements</a></li>
                        <li><a class="" href="form_validation.html">Form Validation</a></li>
                    </ul>
                </li>


                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon_table"></i>
                        <span>Tables</span>
                        <span class="menu-arrow arrow_carrot-right"></span>
                    </a>
                    <ul class="sub">
                        <li><a class="" href="${contextPath}/basic_table">Basic Table</a></li>
                    </ul>
                </li>


            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->

    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="fa fa-table"></i> Table</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
                        <li><i class="fa fa-table"></i>Table</li>
                        <li><i class="fa fa-th-list"></i>Basic Table</li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <!--  search form start -->
                    <div class="nav search-row">
                        <ul class="nav top-menu">
                            <li>
                                <form class="navbar-form">
                                    <input class="form-control" onkeyup="searchwarehouse()" id="search-warehouse"
                                           placeholder="Search by name" type="text">
                                    <span class="lite" style="color:blue;font-weight:bold;margin-left: 80px""> ALL
                                    BRANDS </span>
                                </form>
                            </li>
                            <li>
                                <div class="col-lg-3">
                                    <div class="search-result-series">
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!--  search form end -->
                    <section class="panel">
                        <c:choose>
                            <c:when test="${mode=='ALL_USERS' }">
                                <div class="table-responsive">
                                    <table class="table">

                                        <thead>
                                        <tr>
                                            <th>Brand Name</th>
                                            <th>Series Name</th>
                                            <th>Touch Lcd</th>
                                            <th>Touch Glass</th>
                                            <th>Battery</th>
                                            <th>Charge Port</th>
                                            <th>Loud Speaker</th>
                                            <th>Ear Speaker</th>
                                            <th>Audio Jack</th>
                                            <th>Micro Phone</th>
                                            <th>Network</th>
                                            <th>S/W Diagnosis</th>
                                            <th>Dead Diagnosis</th>
                                            <th>Water Diagnosis</th>
                                            <th>StandBy Phone</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="user" items="${users}">
                                            <tr>

                                                <td>${user.brandName}</td>
                                                <td>${user.seriesName}</td>
                                                <td>${user.touchandlcd}</td>
                                                <td>${user.touchscreenglass}</td>
                                                <td>${user.battery}</td>
                                                <td>${user.chargeport}</td>
                                                <td>${user.loudspeaker}</td>
                                                <td>${user.earspeaker}</td>
                                                <td>${user.audiojack}</td>
                                                <td>${user.microphone}</td>
                                                <td>${user.network}</td>
                                                <td>${user.softwarediagnosis}</td>
                                                <td>${user.deadphonediagnosis}</td>
                                                <td>${user.waterdiagnosis}</td>
                                                <td>${user.standbyphone}</td>
                                                <td>
                                                    <!--  <a class="btn btn-success"  href="${pageContext.request.contextPath}/sedit-user?warehouseId=${user.warehouseId}"><i class="icon_check_alt2"></i></a></td>
                       -->
                                                    <a class="btn btn-success" href="#myModal-3" data-toggle="modal"><i
                                                            class="icon_close_alt2" data-toggle="tooltip"></i></a>
                                                    <input type="hidden" id="warehouseId" value="${user.warehouseId}">
                                                <td>
                                                    <div class="d-grid gap-2 d-md-block">

                                                        <a class="btn btn-danger" href="#deleteModal"
                                                           data-toggle="modal"><i class="icon_close_alt2"
                                                                                  data-toggle="tooltip"></i></a>
                                                        <input type="hidden" id="warehouseId"
                                                               value="${user.warehouseId}">
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </c:when>
                        </c:choose>
                    </section>
                </div>
            </div>

        </section>
    </section>
    <!--main content end-->
    <div class="text-right">
        <div class="credits">
            <!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version form: https://bootstrapmade.com/buy/?theme=NiceAdmin
            -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
    </div>
</section>
<!-- container section end -->
<script src="js/search.js"></script>
<script src="js/search.js"></script>
<!-- javascripts -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- nicescroll -->
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!--custome script for all page-->
<script src="js/scripts.js"></script>


<!--edit modal start-->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-3" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">update Mobile Parts</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal " role="form">
                    <div class="form-group">
                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">brandName</span>
                                    <input type="text" id="brandName" readOnly="readOnly" class="form-control"
                                           aria-describedby="passwordHelpInline">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">seriesName</span>
                                    <input type="text" id="seriesName" readOnly="readOnly" class="form-control">
                                </div>

                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">touch&Lcd</span>
                                    <input type="text" id="touchandlcd" class="form-control" placeholder="touchandlcd">
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text"
                                          STYLE="text-transform:capitalize">touchScreenGlass</span>
                                    <input type="text" id="touchscreenglass" name="" class="form-control"
                                           placeholder="touchscreenglass">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">standbyphone</span>
                                    <input type="text" id="standbyphone" name="" class="form-control"
                                           placeholder="standbyphone">

                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">battery</span>
                                    <input type="text" id="battery" name="" class="form-control" placeholder="battery">
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">chargeport</span>
                                    <input type="text" id="chargeport" name="" class="form-control"
                                           placeholder="chargeport">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">loudspeaker</span>
                                    <input type="text" id="loudspeaker" name="" class="form-control"
                                           placeholder="loudspeaker">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">earspeaker</span>
                                    <input type="text" id="earspeaker" name="" class="form-control"
                                           placeholder="earspeaker">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">audiojack</span>
                                    <input type="text" id="audiojack" name="" class="form-control"
                                           placeholder="audiojack">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">microphone</span>
                                    <input type="text" id="microphone" name="" class="form-control"
                                           placeholder="microphone">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">network</span>
                                    <input type="text" id="network" name="" class="form-control" placeholder="network">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">

                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">s/wdiagnosis</span>
                                    <input type="text" id="softwarediagnosis" name="" class="form-control"
                                           placeholder="softwarediagnosis">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text"
                                          STYLE="text-transform:capitalize">dead/pdiagnosis</span>
                                    <input type="text" id="deadphonediagnosis" name="" class="form-control"
                                           placeholder="deadphonediagnosis">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text"
                                          STYLE="text-transform:capitalize">waterdiagnosis</span>
                                    <input type="text" id="waterdiagnosis" name="" class="form-control"
                                           placeholder="waterdiagnosis">
                                </div>
                            </div>
                            <input type="hidden" id="warehouseIdd" name="">
                            <input type="hidden" id="brand" name="">
                            <input type="hidden" id="brandseries" name="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button onClick="UpdateMoblieParts()" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </form>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- edit modal end here -->


<!--  deleteModal Modal -->

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="deleteModal" class="modal fade">
    <div class="modal-dialog" style="width:300px; color:red;">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">DELETE</h4>
            </div>
            <div class="modal-body">
                <p>Are You Sure..</p>
                <form class="form-inline" role="form">
                    <div class="form-group">


                    </div>

                    <input type="text" id="warehouseId">
                    <button type="submit" class="btn btn-success">Delete</button>
                </form>

            </div>

        </div>
    </div>
</div>


</body>

</html>