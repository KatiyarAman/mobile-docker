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

    <title>Form Component | Creative - Bootstrap 3 Responsive Admin Template</title>

    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet"/>
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/daterangepicker.css" rel="stylesheet"/>
    <link href="css/bootstrap-datepicker.css" rel="stylesheet"/>
    <link href="css/bootstrap-colorpicker.css" rel="stylesheet"/>
    <!-- date picker -->

    <!-- color picker -->

    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet"/>

    <script src="https://code.jquery.com/jquery-1.7.1.js"
            integrity="sha256-n8wkEJNAWUaIUDnfQoz6fwBRofK9vMWjE6F3qeNfiAY=" crossorigin="anonymous"></script>

    <!-- cascading javascript function start here -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#comboboxCountry').on('change', function () {
                var countryId = $(this).val();
                //alert("countryId");
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/loadStatesByCountry/' + countryId,
                    success: function (result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for (var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxState').html(s);
                    }
                });
            });
            $('#comboboxState').on('change', function () {
                var stateId = $(this).val();
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/loadCitiesByState/' + stateId,
                    success: function (result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for (var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxCity').html(s);
                    }
                });
            });
        });
    </script>
    <!-- cascading javascript function start end here -->

    <!-- admin insertion brand and series and mobile parts javascript function start here -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function addBrand() {
            var brand = document.getElementById("idBrand").value;
            //alert(brand);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '${pageContext.request.contextPath }/addBrand?brand=' + brand,
                success: function (data) {
                    alert("sucess " + JSON.stringify(data));
                    $(".modal-body").text("Successfully Added.");
                }
            });
            if (brand == "") {
            } else
                swal("Registration Success!", "You clicked the button!", "success");
        }
    </script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function addNewModal() {
            var brandId = document.getElementById("comboboxCountryy").value;
            var idModel = document.getElementById("idModel").value;
            //alert(brandId +" "+idModel);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '${pageContext.request.contextPath }/addNewModal?brandId=' + brandId
                    + "&idModel=" + idModel,
                success: function (data) {
                    alert("sucess " + JSON.stringify(data));
                    $(".modal-body").text("Successfully Added.");
                }
            });

        }
    </script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function addMoblieParts() {
            var brand = document.getElementById("comboboxCountry").value;
            var brandSeries = document.getElementById("comboboxState").value;
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
            alert(brandSeries);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '${pageContext.request.contextPath }/addMoblieParts?brand=' + brand
                    + "&brandSeries=" + brandSeries
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
                    + "&earspeaker=" + earspeaker,
                success: function (data) {
                    alert("sucess " + JSON.stringify(data));
                    $(".modal-body").text("Successfully Added.");
                }
            });
        }
    </script>
    <!-- admin insertion brand and series and mobile parts javascript function end here -->

    <!-- brand table javascript  all function start here -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
            $('table .btn-danger').on('click', function () {
                var BrandId = $(this).parent().find('#BrandId').val();
                //alert(BrandId);
                /*  $('#SeriesModal #responseIddeleted').val(BrandId); */
                if (BrandId == "" || BrandId == null || BrandId == " ") {

                } else {
                    $.ajax({
                        type: 'POST',
                        url: '${pageContext.request.contextPath}/data/branddelete-user/' + BrandId,
                        success: function (data) {
                            //alert(data);
                            $('#SeriesModal #responseIddeleted').val(BrandId);
                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }
            });
            $('table .btn-success').on('click', function () {
                var BrandId = $(this).parent().find('#BrandId').val();
                //alert(BrandId);
                if (BrandId == "" || BrandId == null || BrandId == " ") {

                } else {
                    $.ajax({
                        type: 'GET',
                        url: '${pageContext.request.contextPath}/data/brandedit-user/' + BrandId,
                        success: function (data) {
                            // alert(data);
                            $('#BrandModal #responseId').val(data.id);
                            $('#BrandModal #brandname').val(data.name);
                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }
            });
        });
    </script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function updateBrand() {
            var brandId = document.getElementById("responseId").value;
            var brandname = document.getElementById("brandname").value;
            alert(brandname + " " + brandId);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '${pageContext.request.contextPath }/data/updateBrand?brandId=' + brandId
                    + "&brandname=" + brandname,
                success: function (data) {
                    alert("sucess " + JSON.stringify(data));
                    $(".modal-body").text("Successfully Added.");
                }
            });

        }
    </script>
    <!-- brand table javascript  all function ennd here -->

    <!-- series table javascript all function start here -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
            $('table .btn-danger').on('click', function () {
                var seriesId = $(this).parent().find('#seriesId').val();
                //alert(BrandId);
                /*  $('#SeriesModal #responseIddeleted').val(BrandId); */
                if (seriesId == "" || seriesId == null || seriesId == " ") {
                } else {
                    $.ajax({
                        type: 'POST',
                        url: '${pageContext.request.contextPath}/data/seriesdeleteuser/' + seriesId,
                        success: function (data) {
                            //alert(data);
                            $('#BrandSeriesDeleteModal #seriesresponseIddeleted').val(seriesId);
                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }

            });
            $('table .btn-success').on('click', function () {
                var seriesId = $(this).parent().find('#seriesId').val();
                //alert(seriesId);
                if (seriesId == "" || seriesId == null || seriesId == " ") {

                } else {
                    $.ajax({
                        type: 'GET',
                        url: '${pageContext.request.contextPath}/data/seriesedit-user/' + seriesId,
                        success: function (data) {
                            // alert(data);
                            $('#BrandSeriesUpdateModal #seriesresponseId').val(data.id);
                            $('#BrandSeriesUpdateModal #seriesname').val(data.name);
                            $('#BrandSeriesUpdateModal #seriesbrandId').val(data.brandId);
                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }
            });
        });
    </script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function updateSeries() {
            var seriesId = document.getElementById("seriesresponseId").value;
            var brandId = document.getElementById("seriesbrandId").value;
            var seriesname = document.getElementById("seriesname").value;
            alert(seriesname + " " + brandId + " " + seriesId);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '${pageContext.request.contextPath }/data/updateSeries?seriesId=' + seriesId
                    + "&brandId=" + brandId
                    + "&seriesname=" + seriesname,
                success: function (data) {
                    alert("sucess " + JSON.stringify(data));
                    $(".modal-body").text("Successfully Added.");
                }
            });
        }
    </script>

    <!-- series table javascript all function end here -->


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
            <%-- <div class="row">
              <div class="col-lg-12">
                <!-- <h3 class="page-header"><i class="fa fa-file-text-o"></i> Form elements</h3> -->
                <ol class="breadcrumb">
                  <li><i class="fa fa-home"></i><a href="${contextPath}/t">Home</a></li>
                  <li><i class="icon_document_alt"></i>Forms</li>
                  <li><i class="fa fa-file-text-o"></i>Form elements</li>
                </ol>
              </div>
            </div> --%>
            <div class="row">
                <div class="col-lg-12">
                </div>
            </div>
            <!-- Basic Forms & Horizontal Forms start here-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <div class="panel-body">
                            <a href="#myModal" data-toggle="modal" class="btn btn-primary">
                                Add New Brands
                            </a>
                            <a href="#myModal-1" data-toggle="modal" class="btn  btn-warning">
                                Add New Model
                            </a>
                            <a href="#myModal-2" data-toggle="modal" class="btn  btn-danger">
                                Add Mobile Parts
                            </a>
                            <!-- add mobile brands modal start here  -->
                            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
                                 id="myModal" class="modal fade">
                                <div class="modal-dialog" style="width:300px">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">
                                                ×
                                            </button>
                                            <h4 class="modal-title"><b>Add Mobile Brands</b></h4>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">Brands</label>
                                                    <input type="text" style="width:150px" class="form-control"
                                                           id="idBrand" placeholder="Enter Brand">
                                                </div>
                                                <button onClick="addBrand();" class="btn btn-primary">Add</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--  add brands modal ends here -->
                            <!-- add new modal start here  -->
                            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
                                 id="myModal-1" class="modal fade">
                                <div class="modal-dialog" style="width:300px">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">
                                                ×
                                            </button>
                                            <h4 class="modal-title"><b>Add New Mobile Model</b></h4>

                                        </div>
                                        <div class="modal-body">

                                            <form class="form-horizontal" role="form">

                                                <div class="form-group">
                                                    <label for="inputEmail1"
                                                           class="col-lg-2 control-label">Brand</label>
                                                    <div class="col-lg-10">
                                                        <select id="comboboxCountryy" style="width:150px"
                                                                class="form-control"
                                                                aria-describedby="passwordHelpInline">
                                                            <c:forEach var="country" items="${countries }">
                                                                <option value="${country.id }">${country.name }</option>
                                                            </c:forEach>
                                                        </select>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="inputEmail1"
                                                           class="col-lg-2 control-label">Model</label>
                                                    <div class="col-lg-10">
                                                        <input type="text" style="width:150px" class="form-control"
                                                               id="idModel" placeholder="Model Number">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-lg-offset-2 col-lg-10">
                                                        <button onClick="addNewModal()" class="btn btn-info">Submit
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>

                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- add new modal end here -->
                            <!--  add mobile parts modal start here -->
                            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
                                 id="myModal-2" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">
                                                ×
                                            </button>
                                            <h4 class="modal-title">Add Mobile Parts</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form class="form-horizontal " role="form">

                                                <div class="form-group">
                                                    <div class="col-lg-10">
                                                        <div class="row">
                                                            <div class="col-lg-3">
                                                                <select id="comboboxCountry" class="form-control"
                                                                        aria-describedby="passwordHelpInline">
                                                                    <c:forEach var="country" items="${countries }">
                                                                        <option value="${country.id }">${country.name }</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <select id="comboboxState" class="form-control">
                                                                    <option selected>Series</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" id="touchandlcd" class="form-control"
                                                                       placeholder="touchandlcd">
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-lg-10">
                                                        <div class="row">
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="touchscreenglass"
                                                                       class="form-control"
                                                                       placeholder="touchscreenglass">
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="standbyphone"
                                                                       class="form-control" placeholder="standbyphone">

                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="battery"
                                                                       class="form-control" placeholder="battery">
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-lg-10">
                                                        <div class="row">
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="chargeport"
                                                                       class="form-control" placeholder="chargeport">
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="loudspeaker"
                                                                       class="form-control" placeholder="loudspeaker">
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="earspeaker"
                                                                       class="form-control" placeholder="earspeaker">
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-lg-10">
                                                        <div class="row">
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="audiojack"
                                                                       class="form-control" placeholder="audiojack">
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="microphone"
                                                                       class="form-control" placeholder="microphone">
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="network"
                                                                       class="form-control" placeholder="network">
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="form-group">

                                                    <div class="col-lg-10">
                                                        <div class="row">
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="softwarediagnosis"
                                                                       class="form-control"
                                                                       placeholder="softwarediagnosis">
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="deadphonediagnosis"
                                                                       class="form-control"
                                                                       placeholder="deadphonediagnosis">
                                                            </div>
                                                            <div class="col-lg-3">
                                                                <input type="text" name="" id="waterdiagnosis"
                                                                       class="form-control"
                                                                       placeholder="waterdiagnosis">
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="form-group">

                                                    <div class="form-group">
                                                        <div class="col-lg-offset-2 col-lg-10">
                                                            <button onClick="addMoblieParts()" class="btn btn-primary">
                                                                Save changes
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                Close
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- add mobile parts modal ends here -->

                    </section>
                </div>
            </div>
            <!-- Basic Forms & Horizontal Forms end here-->


            <!-- table start here -->
            <div class="row">
                <!--  brand tables start here-->
                <div class="col-sm-6">
                    <div class="nav search-row">
                        <!--  search form start -->
                        <ul class="nav top-menu">
                            <li>
                                <form class="navbar-form">
                                    <input class="form-control" onkeyup="searchbrand()" id="search-brand"
                                           placeholder="Search" type="text">
                                    <span class="lite" style="color:blue;font-weight:bold;margin-left: 80px""> ALL
                                    BRANDS </span>
                                </form>
                            </li>
                            <li>
                                <div class="col-lg-3">
                                    <div class="search-result">
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <!--  search form end -->
                    </div>
                    <section class="panel panel-default">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Brand Name</th>
                                <th><i class="icon_cogs"></i>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="country" items="${countries }">
                                <tr>
                                    <td>${country.id}</td>
                                    <td>${country.name }</td>
                                    <td>
                                        <div class="btn-group">
                                            <a class="btn btn-success" href="#BrandModal" data-toggle="modal"><i
                                                    class="icon_check_alt2" data-toggle="tooltip"></i></a>
                                            <input type="hidden" id="BrandId" value="${country.id}">
                                            <a class="btn btn-danger" href="#SeriesModal" data-toggle="modal"><i
                                                    class="icon_close_alt2"></i></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </section>
                </div>
                <!--  brands table end here -->


                <!--  series table start here -->
                <div class="col-sm-6">
                    <div class="nav search-row">
                        <!--  search form start -->
                        <ul class="nav top-menu">
                            <li>
                                <form class="navbar-form">

                                    <input class="form-control" onkeyup="searchseries()" id="search-series"
                                           placeholder="Search-series" type="text">
                                    <span class="lite" style="color:blue;font-weight:bold;margin-left: 90px""> BRAND
                                    SERIES </span>
                                </form>
                            </li>
                            <li>
                                <div class="search-result-series">
                                </div>
                            </li>
                        </ul>
                        <!--  search form end -->
                    </div>

                    <section class="panel">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Brand Name</th>
                                <th>Series Name</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="models" items="${series}">
                                <tr>
                                    <td>${models.id}</td>
                                    <td>${models.name}</td>
                                    <td>
                                        <div class="btn-group">
                                            <a class="btn btn-success" data-toggle="modal"
                                               href="#BrandSeriesUpdateModal"><i class="icon_check_alt2"></i></a>
                                            <input type="hidden" id="seriesId" value="${models.id}">
                                            <a class="btn btn-danger" data-toggle="modal"
                                               href="#BrandSeriesDeleteModal"><i class="icon_close_alt2"></i></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </section>
                </div>
                <!-- series table ends here -->

            </div>

            <!-- table end here -->
            <!-- tablespage end-->
        </section>
    </section>

</section>
<!-- container section end -->

<!--  table models start here -->
<!-- brand table model start here -->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="BrandModal" class="modal fade">
    <div class="modal-dialog" style="width:300px">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title"><b>UPDATE BRAND</b></h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputEmail1" class="col-lg-2 control-label">NAME</label>
                        <div class="col-lg-10">
                            <input type="text" style="width:150px" class="form-control" id="brandname"
                                   placeholder="Brand Name">
                        </div>
                    </div>
                    <input type="hidden" id="responseId">
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button onClick="updateBrand()" class="btn btn-info">Update</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<!-- brand table model end here -->
<!-- series table model start here -->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="SeriesModal" class="modal fade">
    <div class="modal-dialog" style="width:300px">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title"><b>DELETED BRAND ID</b></h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-lg-10">
                            <input type="text" style="width:150px" class="form-control" id="responseIddeleted" readOnly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">Close</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<!-- series table model end here -->
<!-- table models end here -->

<!-- brand table model start here -->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="BrandSeriesUpdateModal"
     class="modal fade">
    <div class="modal-dialog" style="width:300px">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title"><b>BRAND SERIES</b></h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputEmail1" class="col-lg-2 control-label">NAME</label>
                        <div class="col-lg-10">
                            <input type="text" style="width:150px" class="form-control" id="seriesname"
                                   placeholder="Series Name">
                        </div>
                    </div>
                    <input type="hidden" id="seriesresponseId">
                    <input type="hidden" id="seriesbrandId">
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button onClick="updateSeries()" class="btn btn-info">UPDATE</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<!-- brand table model end here -->
<!-- series table model start here -->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="BrandSeriesDeleteModal"
     class="modal fade">
    <div class="modal-dialog" style="width:300px">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title"><b>DELETED SERIES ID</b></h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-lg-10">
                            <input type="text" style="width:150px" class="form-control" id="seriesresponseIddeleted"
                                   readOnly>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">Close</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<!-- series table model end here -->

<!-- javascripts -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<!-- jquery ui -->
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>

<!--custom checkbox & radio-->
<script type="text/javascript" src="js/ga.js"></script>
<!--custom switch-->
<script src="js/bootstrap-switch.js"></script>
<!--custom tagsinput-->
<script src="js/jquery.tagsinput.js"></script>

<!-- colorpicker -->
<script src="js/search.js"></script>
<!-- bootstrap-wysiwyg -->
<script src="js/jquery.hotkeys.js"></script>
<script src="js/bootstrap-wysiwyg.js"></script>
<script src="js/bootstrap-wysiwyg-custom.js"></script>
<script src="js/moment.js"></script>
<script src="js/bootstrap-colorpicker.js"></script>
<script src="js/daterangepicker.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<!-- ck editor -->
<script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>
<!-- custom form component script for this page-->
<script src="js/form-component.js"></script>
<!-- custome script for all page -->
<script src="js/scripts.js"></script>
<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>


</body>

</html>