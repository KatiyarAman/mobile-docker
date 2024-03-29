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
    <title>Admin Dashboard</title>
    <!-- bootstrap theme main css-->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!-- font icon -->
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <link href="css/elegant-icons-style.css" rel="stylesheet"/>
    <!--external css-->
    <link href="css/style.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
            $('table .btn-success').on('click', function () {
                var customerId = $(this).parent().find('#customerId').val();
                //alert(warehouseId);

                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath}/data/sedit-status/' + customerId,
                    success: function (data) {
                        // alert(data);
                        $('#myModal-3 #mobilenumber').val(data.mobilenumber);
                        $('#myModal-3 #selectbrands').val(data.selectbrands);
                        $('#myModal-3 #selectmodel').val(data.selectmodel);
                        $('#myModal-3 #descrip').val(data.descrip);
                        $('#myModal-3 #reason').val(data.reason);
                        $('#myModal-3 #zipcode').val(data.zipcode);
                        $('#myModal-3 #cityname').val(data.cityname);
                        $('#myModal-3 #fname').val(data.fname);
                        $('#myModal-3 #dateCreated').val(data.dateCreated);
                        $('#myModal-3 #currentstatus').val(data.currentstatus);
                        $('#myModal-3 #customerIdd').val(data.customerId);

                    }
                });
            });
        });
    </script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        function UpdateStatus() {
            var mobilenumber = document.getElementById("mobilenumber").value;
            var selectbrands = document.getElementById("selectbrands").value;
            var selectmodel = document.getElementById("selectmodel").value;
            var descrip = document.getElementById("descrip").value;
            var reason = document.getElementById("reason").value;
            var zipcode = document.getElementById("zipcode").value;
            var cityname = document.getElementById("cityname").value;
            var fname = document.getElementById("fname").value;
            var currentstatus = document.getElementById("currentstatus").value;
            var customerId = document.getElementById("customerIdd").value;

            alert(customerId + "  " + currentstatus + " " + mobilenumber + " " + zipcode);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '${pageContext.request.contextPath }/data/UpdateStatus?customerId=' + customerId
                    + "&mobilenumber=" + mobilenumber
                    + "&selectbrands=" + selectbrands
                    + "&selectmodel=" + selectmodel
                    + "&descrip=" + descrip
                    + "&reason=" + reason
                    + "&zipcode=" + zipcode
                    + "&cityname=" + cityname
                    + "&fname=" + fname
                    + "&currentstatus=" + currentstatus,
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
            <!--overview start-->
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="${contextPath}/t">Home</a></li>
                        <li><i class="fa fa-laptop"></i>Dashboard</li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-9 col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><i class="fa fa-flag-o red"></i><strong>Booked Users</strong></h2>
                            <div class="panel-actions">
                                <!-- search form start    -->
                                <div class="search-container my-3">
                                    <input class="form-control" onkeyup="searchbookeduser()" id="search-input"
                                           placeholder="Search By " type="text">
                                    <div class="search-result">
                                        <h2>This is Search result</h2>
                                    </div>
                                </div>
                                <!--  search form end -->
                            </div>
                        </div>
                        <div class="panel-body">
                            <table id="data-table" class="table bootstrap-datatable countries">

                                <thead>
                                <tr>
                                    <th>Date & Time</th>
                                    <th>City</th>
                                    <th>Name</th>
                                    <th>Contact No.</th>
                                    <th>Brand</th>
                                    <th>Series</th>
                                    <th>Issues</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="customers" items="${customer}">
                                    <tr>
                                        <td>${customers.dateCreated}</td>
                                        <td>${customers.cityname}</td>
                                        <td>${customers.fname}</td>
                                        <td>${customers.mobilenumber}</td>
                                        <td>${customers.selectbrands}</td>
                                        <td>${customers.selectmodel}</td>
                                        <td>${customers.descrip}</td>
                                        <td>${customers.reason}</td>
                                        <td>${customers.currentstatus}</td>
                                        <td>
                                            <!--  <a class="btn btn-success"  href="${pageContext.request.contextPath}/sedit-user?warehouseId=${user.warehouseId}"><i class="icon_check_alt2"></i></a></td>
                       -->
                                            <a class="btn btn-success" href="#myModal-3" data-toggle="modal"><i
                                                    class="icon_close_alt2" data-toggle="tooltip"></i></a>
                                            <input type="hidden" id="customerId" value="${customers.customerId}">
                                        <td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>
                <!--/col-->
                <div class="col-md-3">

                    <div class="social-box facebook">
                        <i class="fa fa-facebook"></i>
                        <ul>
                            <li>
                                <strong>256k</strong>
                                <span>friends</span>
                            </li>
                            <li>
                                <strong>359</strong>
                                <span>feeds</span>
                            </li>
                        </ul>
                    </div>
                    <!--/social-box-->
                </div>
                <div class="col-md-3">

                    <div class="social-box google-plus">
                        <i class="fa fa-google-plus"></i>
                        <ul>
                            <li>
                                <strong>962</strong>
                                <span>followers</span>
                            </li>
                            <li>
                                <strong>256</strong>
                                <span>circles</span>
                            </li>
                        </ul>
                    </div>
                    <!--/social-box-->

                </div>
                <!--/col-->
                <div class="col-md-3">

                    <div class="social-box twitter">
                        <i class="fa fa-twitter"></i>
                        <ul>
                            <li>
                                <strong>1562k</strong>
                                <span>followers</span>
                            </li>
                            <li>
                                <strong>2562</strong>
                                <span>tweets</span>
                            </li>
                        </ul>
                    </div>
                    <!--/social-box-->

                </div>
                <!--/col-->

            </div>
            <!-- statics end -->
            <!-- project team & activity start -->
            <div class="row">
                <div class="col-md-4 portlets">
                    <!-- Widget -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="pull-left">Message</div>
                            <div class="widget-icons pull-right">
                                <a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
                                <a href="#" class="wclose"><i class="fa fa-times"></i></a>
                            </div>
                            <div class="clearfix"></div>
                        </div>

                        <div class="panel-body">
                            <!-- Widget content -->
                            <div class="padd sscroll">

                                <ul class="chats">

                                    <!-- Chat by us. Use the class "by-me". -->
                                    <li class="by-me">
                                        <!-- Use the class "pull-left" in avatar -->
                                        <div class="avatar pull-left">
                                            <img src="img/user.jpg" alt=""/>
                                        </div>

                                        <div class="chat-content">
                                            <!-- In meta area, first include "name" and then "time" -->
                                            <div class="chat-meta">John Smith <span
                                                    class="pull-right">3 hours ago</span></div>
                                            Vivamus diam elit diam, consectetur dapibus adipiscing elit.
                                            <div class="clearfix"></div>
                                        </div>
                                    </li>

                                    <!-- Chat by other. Use the class "by-other". -->
                                    <li class="by-other">
                                        <!-- Use the class "pull-right" in avatar -->
                                        <div class="avatar pull-right">
                                            <img src="img/user22.png" alt=""/>
                                        </div>

                                        <div class="chat-content">
                                            <!-- In the chat meta, first include "time" then "name" -->
                                            <div class="chat-meta">3 hours ago <span
                                                    class="pull-right">Jenifer Smith</span></div>
                                            Vivamus diam elit diam, consectetur fconsectetur dapibus adipiscing elit.
                                            <div class="clearfix"></div>
                                        </div>
                                    </li>

                                    <li class="by-me">
                                        <div class="avatar pull-left">
                                            <img src="img/user.jpg" alt=""/>
                                        </div>

                                        <div class="chat-content">
                                            <div class="chat-meta">John Smith <span
                                                    class="pull-right">4 hours ago</span></div>
                                            Vivamus diam elit diam, consectetur fermentum sed dapibus eget, Vivamus
                                            consectetur dapibus adipiscing elit.
                                            <div class="clearfix"></div>
                                        </div>
                                    </li>

                                    <li class="by-other">
                                        <!-- Use the class "pull-right" in avatar -->
                                        <div class="avatar pull-right">
                                            <img src="img/user22.png" alt=""/>
                                        </div>

                                        <div class="chat-content">
                                            <!-- In the chat meta, first include "time" then "name" -->
                                            <div class="chat-meta">3 hours ago <span
                                                    class="pull-right">Jenifer Smith</span></div>
                                            Vivamus diam elit diam, consectetur fermentum sed dapibus eget, Vivamus
                                            consectetur dapibus adipiscing elit.
                                            <div class="clearfix"></div>
                                        </div>
                                    </li>

                                </ul>

                            </div>
                            <!-- Widget footer -->
                            <div class="widget-foot">

                                <form class="form-inline">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Type your message here...">
                                    </div>
                                    <button type="submit" class="btn btn-info">Send</button>
                                </form>


                            </div>
                        </div>


                    </div>
                </div>

                <div class="col-lg-8">
                    <!--Project Activity start-->
                    <section class="panel">
                        <div class="panel-body progress-panel">
                            <div class="row">
                                <div class="col-lg-8 task-progress pull-left">
                                    <h1>To Do Everyday</h1>
                                </div>
                                <div class="col-lg-4">
                    <span class="profile-ava pull-right">
                                        <img alt="" class="simple" src="img/avatar1_small.jpg">
                                        Jenifer smith
                                </span>
                                </div>
                            </div>
                        </div>
                        <table class="table table-hover personal-task">
                            <tbody>
                            <tr>
                                <td>Today</td>
                                <td>
                                    web design
                                </td>
                                <td>
                                    <span class="badge bg-important">Upload</span>
                                </td>
                                <td>
                      <span class="profile-ava">
                                        <img alt="" class="simple" src="img/avatar1_small.jpg">
                                    </span>
                                </td>
                            </tr>
                            <tr>
                                <td>Yesterday</td>
                                <td>
                                    Project Design Task
                                </td>
                                <td>
                                    <span class="badge bg-success">Task</span>
                                </td>
                                <td>
                                    <div id="work-progress2"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>21-10-14</td>
                                <td>
                                    Generate Invoice
                                </td>
                                <td>
                                    <span class="badge bg-success">Task</span>
                                </td>
                                <td>
                                    <div id="work-progress3"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>22-10-14</td>
                                <td>
                                    Project Testing
                                </td>
                                <td>
                                    <span class="badge bg-primary">To-Do</span>
                                </td>
                                <td>
                      <span class="profile-ava">
                                        <img alt="" class="simple" src="img/avatar1_small.jpg">
                                      </span>
                                </td>
                            </tr>
                            <tr>
                                <td>24-10-14</td>
                                <td>
                                    Project Release Date
                                </td>
                                <td>
                                    <span class="badge bg-info">Milestone</span>
                                </td>
                                <td>
                                    <div id="work-progress4"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>28-10-14</td>
                                <td>
                                    Project Release Date
                                </td>
                                <td>
                                    <span class="badge bg-primary">To-Do</span>
                                </td>
                                <td>
                                    <div id="work-progress5"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>Last week</td>
                                <td>
                                    Project Release Date
                                </td>
                                <td>
                                    <span class="badge bg-primary">To-Do</span>
                                </td>
                                <td>
                                    <div id="work-progress1"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>last month</td>
                                <td>
                                    Project Release Date
                                </td>
                                <td>
                                    <span class="badge bg-success">To-Do</span>
                                </td>
                                <td>
                      <span class="profile-ava">
                                        <img alt="" class="simple" src="img/avatar1_small.jpg">
                                      </span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </section>
                    <!--Project Activity end-->
                </div>
            </div>
            <br><br>

            <div class="row">
                <div class="col-md-6 portlets">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><strong>Calendar</strong></h2>
                            <div class="panel-actions">
                                <a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
                                <a href="#" class="wclose"><i class="fa fa-times"></i></a>
                            </div>

                        </div>
                        <br><br><br>
                        <div class="panel-body">
                            <!-- Widget content -->

                            <!-- Below line produces calendar. I am using FullCalendar plugin. -->
                            <div id="calendar"></div>

                        </div>
                    </div>

                </div>

                <div class="col-md-6 portlets">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="pull-left">Quick Post</div>
                            <div class="widget-icons pull-right">
                                <a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
                                <a href="#" class="wclose"><i class="fa fa-times"></i></a>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="panel-body">
                            <div class="padd">

                                <div class="form quick-post">
                                    <!-- Edit profile form (not working)-->
                                    <form class="form-horizontal">
                                        <!-- Title -->
                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="title">Title</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" id="title">
                                            </div>
                                        </div>
                                        <!-- Content -->
                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="content">Content</label>
                                            <div class="col-lg-10">
                                                <textarea class="form-control" id="content"></textarea>
                                            </div>
                                        </div>
                                        <!-- Cateogry -->
                                        <div class="form-group">
                                            <label class="control-label col-lg-2">Category</label>
                                            <div class="col-lg-10">
                                                <select class="form-control">
                                                    <option value="">- Choose Cateogry -</option>
                                                    <option value="1">General</option>
                                                    <option value="2">News</option>
                                                    <option value="3">Media</option>
                                                    <option value="4">Funny</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- Tags -->
                                        <div class="form-group">
                                            <label class="control-label col-lg-2" for="tags">Tags</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" id="tags">
                                            </div>
                                        </div>

                                        <!-- Buttons -->
                                        <div class="form-group">
                                            <!-- Buttons -->
                                            <div class="col-lg-offset-2 col-lg-9">
                                                <button type="submit" class="btn btn-primary">Publish</button>
                                                <button type="submit" class="btn btn-danger">Save Draft</button>
                                                <button type="reset" class="btn btn-default">Reset</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>


                            </div>
                            <div class="widget-foot">
                                <!-- Footer goes here -->
                            </div>
                        </div>
                    </div>

                </div>

            </div>
            <!-- project team & activity end -->

        </section>
        <div class="text-right">
            <div class="credits">
                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
            </div>
        </div>
    </section>
    <!--main content end-->
</section>
<!-- container section start -->


<!--edit modal start-->
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-3" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">Update Mobile Status</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal " role="form">
                    <div class="form-group">
                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">customerId</span>
                                    <input type="text" id="customerIdd" readOnly="readOnly" class="form-control"
                                           aria-describedby="passwordHelpInline">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">mobilenumber</span>
                                    <input type="text" id="mobilenumber" readOnly="readOnly" class="form-control">
                                </div>

                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">Brand</span>
                                    <input type="text" id="selectbrands" class="form-control" placeholder="Brand">
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">Zip Code</span>
                                    <input type="text" id="zipcode" name="" class="form-control" placeholder="Zip Code">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">Name</span>
                                    <input type="text" id="fname" name="" class="form-control" placeholder="Name">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">cityname</span>
                                    <input type="text" id="cityname" name="" class="form-control"
                                           placeholder="cityname">
                                </div>
                            </div>


                        </div>
                    </div>


                    <div class="form-group">

                        <div class="col-lg-10">
                            <div class="row">
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">Model No</span>
                                    <input type="text" id="selectmodel" name="" class="form-control"
                                           placeholder="Model No">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">Description</span>
                                    <input type="text" id="descrip" name="" class="form-control"
                                           placeholder="Description">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">reason</span>
                                    <input type="text" id="reason" name="" class="form-control" placeholder="reason">
                                </div>
                                <div class="col-lg-3">
                                    <span class="input-group-text" STYLE="text-transform:capitalize">Status</span>
                                    <input type="text" id="currentstatus" name="" class="form-control"
                                           placeholder="currentstatus">
                                </div>
                            </div>


                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button onClick="UpdateStatus()" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<!-- edit modal end here -->
<!-- javascripts -->
<script src="js/jquery.js"></script>
<script src="js/search.js"></script>
<script src="js/jquery-ui-1.10.4.min.js"></script>
<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<!-- bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- nice scroll -->
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!-- charts scripts -->
<script src="assets/jquery-knob/js/jquery.knob.js"></script>
<script src="js/jquery.sparkline.js" type="text/javascript"></script>
<script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
<script src="js/owl.carousel.js"></script>
<!-- jQuery full calendar -->
<
<script src="js/fullcalendar.min.js"></script>
<!-- Full Google Calendar - Calendar -->
<script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
<!--script for this page only-->
<script src="js/calendar-custom.js"></script>
<script src="js/jquery.rateit.min.js"></script>
<!-- custom select -->
<script src="js/jquery.customSelect.min.js"></script>
<script src="assets/chart-master/Chart.js"></script>

<!--custome script for all page-->
<script src="js/scripts.js"></script>
<!-- custom script for this page-->
<script src="js/sparkline-chart.js"></script>
<script src="js/easy-pie-chart.js"></script>
<script src="js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="js/jquery-jvectormap-world-mill-en.js"></script>
<script src="js/xcharts.min.js"></script>
<script src="js/jquery.autosize.min.js"></script>
<script src="js/jquery.placeholder.min.js"></script>
<script src="js/gdp-data.js"></script>
<script src="js/morris.min.js"></script>
<script src="js/sparklines.js"></script>
<script src="js/charts.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<script>
    //knob
    $(function () {
        $(".knob").knob({
            'draw': function () {
                $(this.i).val(this.cv + '%')
            }
        })
    });

    //carousel
    $(document).ready(function () {
        $("#owl-slider").owlCarousel({
            navigation: true,
            slideSpeed: 300,
            paginationSpeed: 400,
            singleItem: true

        });
    });

    //custom select box

    $(function () {
        $('select.styled').customSelect();
    });

    /* ---------- Map ---------- */
    $(function () {
        $('#map').vectorMap({
            map: 'world_mill_en',
            series: {
                regions: [{
                    values: gdpData,
                    scale: ['#000', '#000'],
                    normalizeFunction: 'polynomial'
                }]
            },
            backgroundColor: '#eef3f7',
            onLabelShow: function (e, el, code) {
                el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
            }
        });
    });
</script>

</body>

</html>