<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
  <link href="css/elegant-icons-style.css" rel="stylesheet" />
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <link href="css/daterangepicker.css" rel="stylesheet" />
  <link href="css/bootstrap-datepicker.css" rel="stylesheet" />
  <link href="css/bootstrap-colorpicker.css" rel="stylesheet" />
  <!-- date picker -->

  <!-- color picker -->

  <!-- Custom styles -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet" />
  
    <script
			  src="https://code.jquery.com/jquery-1.7.1.js"
			  integrity="sha256-n8wkEJNAWUaIUDnfQoz6fwBRofK9vMWjE6F3qeNfiAY="
			  crossorigin="anonymous"></script>
      <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
      <script type="text/javascript">
$(document).ready(function(){

	$('#comboboxCountry').on('change', function(){
		var countryId = $(this).val();
		//alert("countryId");
		$.ajax({
			type: 'GET',
			url: '${pageContext.request.contextPath }/loadStatesByCountry/' + countryId,
			success: function(result) {
				var result = JSON.parse(result);
				var s = '';
				for(var i = 0; i < result.length; i++) {
					s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
				}
				$('#comboboxState').html(s);
			}
		});
	});

	$('#comboboxState').on('change', function(){
		var stateId = $(this).val();
		$.ajax({
			type: 'GET',
			url: '${pageContext.request.contextPath }/loadCitiesByState/' + stateId,
			success: function(result) {
				var result = JSON.parse(result);
				var s = '';
				for(var i = 0; i < result.length; i++) {
					s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
				}
				$('#comboboxCity').html(s);
			}
		});
	});
});
</script>
	  <script type="text/javascript">
	   function addBrand()
	    {
		   var brand = document.getElementById("idBrand").value;
		   //alert(brand);
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : '${pageContext.request.contextPath }/addBrand?brand=' + brand,
				success : function(data) {
					alert("sucess " + JSON.stringify(data));
					$(".modal-body").text("Successfully Added.");
				}
			});
			 if(brand == "" ){}else
			swal("Registration Success!", "You clicked the button!", "success");
	    }   
	  </script>
	 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	  <script type="text/javascript">
	   function myFunction()
	    {
		   var fname = document.getElementById("fname").value;
		   var phone = document.getElementById("phone").value;
			var brand = document.getElementById("brand").value;
			var model = document.getElementById("model").value;
			var issue = document.getElementById("issue").value;
			var reason = document.getElementById("reason").value;
			var zipcode = document.getElementById("zipcode").value;
			var cityname = document.getElementById("cityname").value;
					
			alert(fname + "  " + brand +"  "+model+" "+issue+" "+reason);
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : '${pageContext.request.contextPath }/myFunction?fname=' + fname
						+ "&phone=" + phone
						+ "&brand=" + brand
						+ "&model=" + model
						+ "&issue=" + issue
						+ "&reason=" + reason
						+ "&zipcode=" + zipcode
						+ "&cityname=" + cityname,
				success : function(data) {
					alert("sucess " + JSON.stringify(data));
					$(".modal-body").text("Successfully Added.");
				}
			});
			 if(lastname == "" ){}else
			swal("Registration Success!", "You clicked the button!", "success"); 
		 
	    }
	   
	   
	  </script>
	  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	  <script type="text/javascript">
	   function addMoblieParts()
	    {
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
				type : 'POST',
				dataType : 'json',
				url : '${pageContext.request.contextPath }/addMoblieParts?brand=' + brand
				+ "&brandSeries=" + brandSeries
				+ "&touchandlcd=" + touchandlcd
				+ "&audiojack=" + audiojack
				+ "&microphone=" + microphone
				+ "&network=" + network
				+ "&softwarediagnosis=" + softwarediagnosis
				+ "&deadphonediagnosis=" + deadphonediagnosis
				+ "&waterdiagnosis=" + waterdiagnosis
				+ "&standbyphone=" + standbyphone
				+ "&touchscreenglass=" +touchscreenglass
				+ "&battery=" + battery
				+ "&chargeport=" + chargeport
				+ "&loudspeaker=" + loudspeaker
				+ "&earspeaker=" + earspeaker,
				success : function(data) {
					alert("sucess " + JSON.stringify(data));
					$(".modal-body").text("Successfully Added.");
				}
			});	
	    }   
	  </script>	  
	  <script type="text/javascript">
	  function addNewModal(){
		  var brandId=document.getElementById("comboboxCountryy").value;
		  var idModel=document.getElementById("idModel").value;
		  //alert(brandId +" "+idModel);
		  $.ajax({
				type : 'POST',
				dataType : 'json',
				url : '${pageContext.request.contextPath }/addNewModal?brandId=' + brandId
						+ "&idModel=" + idModel,
				success : function(data) {
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
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
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

          <!-- task notificatoin start -->
          <li id="task_notificatoin_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="icon-task-l"></i>
                            <span class="badge bg-important">5</span>
                        </a>
            <ul class="dropdown-menu extended tasks-bar">
              <div class="notify-arrow notify-arrow-blue"></div>
              <li>
                <p class="blue">You have 5 pending tasks</p>
              </li>
              <li>
                <a href="#">
                  <div class="task-info">
                    <div class="desc">Design PSD </div>
                    <div class="percent">90%</div>
                  </div>
                  <div class="progress progress-striped">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                      <span class="sr-only">90% Complete (success)</span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="task-info">
                    <div class="desc">
                      Project 1
                    </div>
                    <div class="percent">30%</div>
                  </div>
                  <div class="progress progress-striped">
                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                      <span class="sr-only">30% Complete (warning)</span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="task-info">
                    <div class="desc">Digital Marketing</div>
                    <div class="percent">80%</div>
                  </div>
                  <div class="progress progress-striped">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                      <span class="sr-only">80% Complete</span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="task-info">
                    <div class="desc">Logo Designing</div>
                    <div class="percent">78%</div>
                  </div>
                  <div class="progress progress-striped">
                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100" style="width: 78%">
                      <span class="sr-only">78% Complete (danger)</span>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a href="#">
                  <div class="task-info">
                    <div class="desc">Mobile App</div>
                    <div class="percent">50%</div>
                  </div>
                  <div class="progress progress-striped active">
                    <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
                      <span class="sr-only">50% Complete</span>
                    </div>
                  </div>

                </a>
              </li>
              <li class="external">
                <a href="#">See All Tasks</a>
              </li>
            </ul>
          </li>
          <!-- task notificatoin end -->
          <!-- inbox notificatoin start-->
          <li id="mail_notificatoin_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <i class="icon-envelope-l"></i>
                            <span class="badge bg-important">5</span>
                        </a>
            <ul class="dropdown-menu extended inbox">
              <div class="notify-arrow notify-arrow-blue"></div>
              <li>
                <p class="blue">You have 5 new messages</p>
              </li>
              <li>
                <a href="#">
                                    <span class="photo"><img alt="avatar" src="./img/avatar-mini.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Greg  Martin</span>
                                    <span class="time">1 min</span>
                                    </span>
                                    <span class="message">
                                        I really like this admin panel.
                                    </span>
                                </a>
              </li>
              <li>
                <a href="#">
                                    <span class="photo"><img alt="avatar" src="./img/avatar-mini2.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Bob   Mckenzie</span>
                                    <span class="time">5 mins</span>
                                    </span>
                                    <span class="message">
                                     Hi, What is next project plan?
                                    </span>
                                </a>
              </li>
              <li>
                <a href="#">
                                    <span class="photo"><img alt="avatar" src="./img/avatar-mini3.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Phillip   Park</span>
                                    <span class="time">2 hrs</span>
                                    </span>
                                    <span class="message">
                                        I am like to buy this Admin Template.
                                    </span>
                                </a>
              </li>
              <li>
                <a href="#">
                                    <span class="photo"><img alt="avatar" src="./img/avatar-mini4.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Ray   Munoz</span>
                                    <span class="time">1 day</span>
                                    </span>
                                    <span class="message">
                                        Icon fonts are great.
                                    </span>
                                </a>
              </li>
              <li>
                <a href="#">See all messages</a>
              </li>
            </ul>
          </li>
          <!-- inbox notificatoin end -->
          <!-- alert notification start-->
          <li id="alert_notificatoin_bar" class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                            <i class="icon-bell-l"></i>
                            <span class="badge bg-important">7</span>
                        </a>
            <ul class="dropdown-menu extended notification">
              <div class="notify-arrow notify-arrow-blue"></div>
              <li>
                <p class="blue">You have 4 new notifications</p>
              </li>
              <li>
                <a href="#">
                                    <span class="label label-primary"><i class="icon_profile"></i></span>
                                    Friend Request
                                    <span class="small italic pull-right">5 mins</span>
                                </a>
              </li>
              <li>
                <a href="#">
                                    <span class="label label-warning"><i class="icon_pin"></i></span>
                                    John location.
                                    <span class="small italic pull-right">50 mins</span>
                                </a>
              </li>
              <li>
                <a href="#">
                                    <span class="label label-danger"><i class="icon_book_alt"></i></span>
                                    Project 3 Completed.
                                    <span class="small italic pull-right">1 hr</span>
                                </a>
              </li>
              <li>
                <a href="#">
                                    <span class="label label-success"><i class="icon_like"></i></span>
                                    Mick appreciated your work.
                                    <span class="small italic pull-right"> Today</span>
                                </a>
              </li>
              <li>
                <a href="#">See all notifications</a>
              </li>
            </ul>
          </li>
          <!-- alert notification end-->
          <!-- user login dropdown start-->
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
            <a class="" href="index.html">
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
              <li><a class="" href="#">Form Elements</a></li>
              
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;" class="">
                          <i class="icon_desktop"></i>
                          <span>UI Fitures</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
            <ul class="sub">
              <li><a class="" href="general.html">Components</a></li>
              <li><a class="" href="buttons.html">Buttons</a></li>
              <li><a class="" href="grids.html">Grids</a></li>
            </ul>
          </li>
          <li>
            <a class="" href="widgets.html">
                          <i class="icon_genius"></i>
                          <span>Widgets</span>
                      </a>
          </li>
          <li>
            <a class="" href="chart-chartjs.html">
                          <i class="icon_piechart"></i>
                          <span>Charts</span>

                      </a>

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

          <li class="sub-menu">
            <a href="javascript:;" class="">
                          <i class="icon_documents_alt"></i>
                          <span>Pages</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
            <ul class="sub">
              <li><a class="" href="profile.html">Profile</a></li>
              <li><a class="" href="login.html"><span>Login Page</span></a></li>
              <li><a class="" href="contact.html"><span>Contact Page</span></a></li>
              <li><a class="" href="blank.html">Blank Page</a></li>
              <li><a class="" href="404.html">404 Error</a></li>
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
            <h3 class="page-header"><i class="fa fa-file-text-o"></i> Form elements</h3>
            <ol class="breadcrumb">
              <li><i class="fa fa-home"></i><a href="${contextPath}/t">Home</a></li>
              <li><i class="icon_document_alt"></i>Forms</li>
              <li><i class="fa fa-file-text-o"></i>Form elements</li>
            </ol>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-12">
            
         
          </div>
        </div>
        <!-- Basic Forms & Horizontal Forms-->

        <div class="row">
          
          
            <section class="panel">

              <div class="panel-body">
                <a href="#myModal" data-toggle="modal" class="btn btn-primary">
                                  Add New Brands
                              </a>
                <a href="#myModal-1" data-toggle="modal" class="btn  btn-warning">
                                  Add New Model
                              </a>
                <a href="#myModal-2" data-toggle="modal" class="btn  btn-danger" >
                                  Add Mobile Parts 
                              </a>

                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                  <div class="modal-dialog" style="width:300px">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title"><b>Add Mobile Brands</b></h4>
                      </div>
                      <div class="modal-body">
                        <form role="form">
                          <div class="form-group">
                            <label for="exampleInputEmail1">Brands</label>
                            <input type="text" style="width:150px" class="form-control" id="idBrand" name="idBrand" placeholder="Enter Brand">
                          </div>                                              
                          <button  onClick="addBrand()" class="btn btn-primary">Add</button>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
                              
                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-1" class="modal fade">
                  <div class="modal-dialog" style="width:300px">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title"><b>Add New Mobile Model</b></h4>
                        
                      </div>
                      <div class="modal-body">

                        <form class="form-horizontal" role="form" >
                        
                          <div class="form-group">
                            <label for="inputEmail1" class="col-lg-2 control-label">Brand</label>
                            <div class="col-lg-10">
                            <select id="comboboxCountryy" style="width:150px" class="form-control" aria-describedby="passwordHelpInline" name="comboboxCountry">
						<c:forEach var="country" items="${countries }">
							<option value="${country.id }">${country.name }</option>
						</c:forEach>
					     </select>
                             
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="inputEmail1" class="col-lg-2 control-label">Model</label>
                            <div class="col-lg-10">
                              <input type="text" style="width:150px" class="form-control" id="idModel" placeholder="Model Number">
                            </div>
                          </div>
                          
                          <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                              <button   onClick="addNewModal()" class="btn btn-info">Submit</button>
                            </div>
                          </div>
                        </form>

                      </div>

                    </div>
                  </div>
                </div>
                
                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-2" class="modal fade">
                  <div class="modal-dialog" >
                    <div class="modal-content">
                      <div class="modal-header">
                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="modal-title">Add Mobile Parts</h4>
                      </div>
                      <div class="modal-body" >
                    
                <form class="form-horizontal " role="form">

                  <div class="form-group">
                    <div class="col-lg-10">
                      <div class="row">
                        <div class="col-lg-3">
                          <select id="comboboxCountry"  class="form-control" aria-describedby="passwordHelpInline" name="comboboxCountry">
						     <c:forEach var="country" items="${countries }">
							    <option value="${country.id }">${country.name }</option>
						      </c:forEach>
					          </select>
                        </div>
                        <div class="col-lg-3">
                          <select id="comboboxState"  class="form-control"  name="comboboxState">
					            <option selected>Series</option>
					          </select>
                        </div>                        
                        <div class="col-lg-3">
                             <input type="text" name="touchandlcd" id="touchandlcd" class="form-control"placeholder="touchandlcd">                        
                        </div>                      
                      </div>
                      
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-10">
                      <div class="row">
                        <div class="col-lg-3">
                          <input type="text" name="touchscreenglass" id="touchscreenglass"  class="form-control"placeholder="touchscreenglass">
                        </div>
                        <div class="col-lg-3">
                        <input type="text" name="standbyphone" id="standbyphone"  class="form-control"placeholder="standbyphone">

                        </div>
                        <div class="col-lg-3">
                            <input type="text" name="battery" id="battery"  class="form-control"placeholder="battery">
                        </div>
                      </div>
                      
                    </div>
                  </div>
                   <div class="form-group">
                    <div class="col-lg-10">
                      <div class="row">
                        <div class="col-lg-3">
                          <input type="text" name="chargeport" id="chargeport"  class="form-control"placeholder="chargeport">
                        </div>
                        <div class="col-lg-3">
                          <input type="text" name="loudspeaker" id="loudspeaker" class="form-control"placeholder="loudspeaker">
                        </div>
                        <div class="col-lg-3">
                          <input type="text" name="earspeaker" id="earspeaker"  class="form-control"placeholder="earspeaker">
                        </div>
                      </div>
                      
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-lg-10">
                      <div class="row">
                        <div class="col-lg-3">
                       <input type="text" name="audiojack" id="audiojack"  class="form-control"placeholder="audiojack">
                        </div>
                        <div class="col-lg-3">
                          <input type="text" name="microphone" id="microphone"  class="form-control"placeholder="microphone">
                        </div>
                        <div class="col-lg-3">
                         <input type="text" name="network" id="network"  class="form-control"placeholder="network">
                        </div>
                      </div>
                      
                    </div>
                  </div>
                  <div class="form-group">
                    
                    <div class="col-lg-10">
                      <div class="row">
                        <div class="col-lg-3">
                          <input type="text" name="softwarediagnosis" id="softwarediagnosis"  class="form-control"placeholder="softwarediagnosis">
                        </div>
                        <div class="col-lg-3">
                         <input type="text" name="deadphonediagnosis" id="deadphonediagnosis"  class="form-control"placeholder="deadphonediagnosis">
                        </div>
                        <div class="col-lg-3">
                          <input type="text" name="waterdiagnosis" id="waterdiagnosis" class="form-control"placeholder="waterdiagnosis">
                        </div>
                      </div>
                      
                    </div>
                  </div>
                  <div class="form-group">
                    
                    <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                              <button  onClick="addMoblieParts()" class="btn btn-primary">Save changes</button>
                            </div>
                          </div>
       
        
        
      
                  </div>
                </form>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </div>
       
        

    
            
        <!-- page end-->
      </section>
    </section>
      
  </section>
  <!-- container section end -->
  
   
  
  
  
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