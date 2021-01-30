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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- SEO Meta Tags -->
    <meta name="description" content="Free mobile app HTML landing page template to help you build a great online presence for your app which will convert visitors into users">
    <meta name="author" content="Inovatik">

    <!-- OG Meta Tags to improve the way the post looks when you share the page on LinkedIn, Facebook, Google+ -->
	<meta property="og:site_name" content="" /> <!-- website name -->
	<meta property="og:site" content="" /> <!-- website link -->
	<meta property="og:title" content=""/> <!-- title shown in the actual shared post -->
	<meta property="og:description" content="" /> <!-- description shown in the actual shared post -->
	<meta property="og:image" content="" /> <!-- image link, make sure it's jpg -->
	<meta property="og:url" content="" /> <!-- where do you want your post to link to -->
	<meta property="og:type" content="article" />

    <!-- Website Title -->
    <title>Leno - Free Mobile App Landing Page Template</title>
    
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,700i" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/fontawesome-all.css" rel="stylesheet">
    <link href="css/swiper.css" rel="stylesheet">
	<link href="css/magnific-popup.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<!-- Favicon  -->
    <link rel="icon" href="images/favicon.png">
    <link href="assets/css/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/jquery-1.7.1.min.js"></script>
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
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="phoneno-all-numeric-validation.js"></script>
	  <script type="text/javascript">
	   function myFunction()
	    {
		   var id = document.getElementById("idEdit").value;
		   var status = document.getElementById("inlineFormC").value;
			var username = document.getElementById("inlineFormC1").value;
			var firstname = document.getElementById("descriptionEdit").value;
			var lastname = document.getElementById("codeEdit").value;
			var password = document.getElementById("nationalityEdit").value;
					
			alert(id + "  " + status +" "+username+" "+firstname+" "+lastname+" "+password);
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : '${pageContext.request.contextPath }/myFunction?id=' + id
						+ "&status=" + status
						+ "&username=" + username
						+ "&firstname=" + firstname
						+ "&lastname=" + lastname
						+ "&password=" + password,
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
	<script src="phoneno-all-numeric-validation.js"></script>
	  <script type="text/javascript">
	   function myFunctionn()
	    {
		   var id = document.getElementById("comboboxCountry").value;
		   var status = document.getElementById("comboboxState").value;
			var username = document.getElementById("comboboxCity").value;
					
			$.ajax({
				type : 'POST',
				dataType : 'json',
				url : '${pageContext.request.contextPath }/myFunctionn?id=' + id
						+ "&status=" + status
						+ "&username=" + username,
				success : function(data) {
					alert("sucess " + JSON.stringify(data));
					$(".modal-body").text("Successfully Added.");
				}
			});
			 if(lastname == "" ){}else
			swal("Registration Success!", "You clicked the button!", "success");
	    }   
	  </script>
</head>
<body data-spy="scroll" data-target=".fixed-top">
    
    <!-- Preloader -->
	<div class="spinner-wrapper">
        <div class="spinner">
            <div class="bounce1"></div>
            <div class="bounce2"></div>
            <div class="bounce3"></div>
        </div>
    </div>
    <!-- end of preloader -->
    

    <!-- Navbar -->
    <nav class="navbar navbar-expand-md navbar-dark navbar-custom fixed-top">
        <!-- Text Logo - Use this if you don't have a graphic logo -->
        <!-- <a class="navbar-brand logo-text page-scroll" href="index.html">Leno</a> -->

        <!-- Image Logo -->
        <a class="navbar-brand logo-image" href="index.html"><img src="images/logo.svg" alt="alternative"></a> 
        
        <!-- Mobile Menu Toggle Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-awesome fas fa-bars"></span>
            <span class="navbar-toggler-awesome fas fa-times"></span>
        </button>
        <!-- end of mobile menu toggle button -->

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link page-scroll" href="#header">HOME <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link page-scroll" href="#features">FEATURES</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link page-scroll" href="#preview">PREVIEW</a>
                </li>

                <!-- Dropdown Menu -->          
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle page-scroll" href="#details" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false">DETAILS</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${contextPath}/terms-conditionss"><span class="item-text">TERMS CONDITIONS</span></a>
                        <div class="dropdown-items-divide-hr"></div>
                        <a class="dropdown-item" href="privacy-policy.html"><span class="item-text">PRIVACY POLICY</span></a>
                    </div>
                </li>
                <!-- end of dropdown menu -->

                <li class="nav-item">
                    <a class="nav-link page-scroll" href="#contact">CONTACT</a>
                </li>
            </ul>
                 <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#addModal">Book Now</button>
           
        </div>
    </nav> <!-- end of navbar -->
    <!-- end of navbar -->

       
           <!-- Update Modal -->
          <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">  
         <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b style="color:black;">Information</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form> 
          <div class="form-group">
            <label for="Description" class="col-form-label">Mobile Number</label>
            <input type="text" class="form-control" id="idEdit" name="id" >
          </div>
           <div class="input-group mb-2 mr-sm-2">
 <select class="form-control mb-2 mr-sm-2" id="inlineFormC">
    <option selected>Select Brand</option>
    <option value="1">One</option>
    <option value="2">Two</option>
    <option value="3">Three</option>
  </select> <select class="form-control mb-2 mr-sm-2" id="inlineFormC1">
    <option selected>Select Model</option>
    <option value="1">One</option>
    <option value="2">Two</option>
    <option value="3">Three</option>
  </select>
  </div>
          
            <label for="Description" class="col-form-label">Description:</label>
            <input type="text" class="form-control" id="descriptionEdit" name="description">
            <label for="Code" class="col-form-label">Zip Code:</label>
            <input type="text" class="form-control" id="codeEdit" name="code">
            <label for="Nationality" class="col-form-label">State:</label>
            <input type="text" class="form-control" id="nationalityEdit" name="nationality">
          
          <div class="form-group">
             <button type="submit" class="btn btn-primary" onClick="myFunction()">Book Now..</button>
          </div>   
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" >Close</button>
      </div>
    </div>
    </div>
     </div>
      <!-- update Modal End -->
       
       
    <!-- Header -->
    <header id="header" class="header">
        <div class="header-content"> 
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="text-container">
                            <h1>You Break !<br><span id="js-rotating" style="color:red;">We Collect!,We Fix!</span></h1>
           <p class="p-large">Repair Estimate for your <b style="color:black;"> Smartphone & Laptop!</b> </p>
  <!-- cascadding dropdownlist --> 
  <div class="row g-3 align-items-center">
  <div class="col-auto" >
   <form action="myFunctionn" >
     <table>
  <tr>	
				<td>
					<select id="comboboxCountry" style="width:100px" class="form-control" aria-describedby="passwordHelpInline" name="comboboxCountry">
						<c:forEach var="country" items="${countries }">
							<option value="${country.id }">${country.name }</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select id="comboboxState" style="width:100px" class="form-control" aria-describedby="passwordHelpInline" name="comboboxState">
					<option selected>Series</option>
					
					</select>
				</td>	
				<td>
					<select id="comboboxCity" style="width:100px" class="form-control" aria-describedby="passwordHelpInline" name="comboboxCity">
					<option selected>Gadget</option>
					</select>
				</td>
				<td>
	    <input type="submit" class="btn btn-danger"  aria-describedby="passwordHelpInline" value="Take The Plunge"/>
				
				</td>
			</tr>
  
    <span id="passwordHelpInline" class="form-text">
      Must be 8-20 characters long.
    </span>
 
  </table>
  </form>
</div>
</div>
                        </div>
                    </div> <!-- end of col -->
                    <div class="col-lg-6">
                       
                        <div class="image-container">
                        <marquee attribute_name = "attribute_value"....more attributes>
                        <p class="text-uppercase" style="color:white; ">
        we are fixing all models of smartphones, laptops and other electronic gadgets. Our service included touch screen repair/replacement, liquid and water damage repair, broken and physical damage repair, mainboard chip-level repairing, charging port, power button, side button, camera repair, headphone jack, wifi, bluetooth, battery replacement, software troubleshoot and up-gradation
   </p>
</marquee>
                            <img class="img-fluid" src="images/header-iphone.png" alt="alternative">
                        </div> <!-- end of image-container -->
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of header-content -->
    </header> <!-- end of header -->
    <!-- end of header -->

         <!-- Features -->
    <div id="features" class="tabs">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>SERVICES</h2>
                </div> <!-- end of col -->
            </div> <!-- end of row -->
            <div class="row">

                <!-- Tabs Links -->
                <ul class="nav nav-tabs" id="lenoTabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="nav-tab-1" data-toggle="tab" href="#tab-1" role="tab" aria-controls="tab-1" aria-selected="true"><i class="fas fa-cog"></i>OUR SERVICES</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="nav-tab-2" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="false"><i class="fas fa-binoculars"></i>REPAIR ONLINE</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="nav-tab-3" data-toggle="tab" href="#tab-3" role="tab" aria-controls="tab-3" aria-selected="false"><i class="fas fa-search"></i>VISIT KIOSK</a>
                    </li>
                </ul>
                <!-- end of tabs links -->


                <!-- Tabs Content-->
                <div class="tab-content" id="lenoTabsContent">
                    
                    <!-- Tab -->
                    <div class="tab-pane fade show active" id="tab-1" role="tabpanel" aria-labelledby="tab-1">
                        <div class="container">
                            <div class="row">
                                
                                <!-- Icon Cards Pane -->
                                <div class="col-lg-4">
                                    <div class="card left-pane first">
                                        <div class="card-body">
                                            <div class="text-wrapper">
                                                <h4 class="card-title">All Brands & Models</h4>
                                                <p>We repair all mobile & laptop brands and models!</p>
                                            </div>
                                            <div class="card-icon">
                                                <i class="far fa-compass"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card left-pane">
                                        <div class="card-body">
                                            <div class="text-wrapper">
                                                <h4 class="card-title">1 Day Service</h4>
                                                <p>We repair devices in just 1 day!</p>
                                            </div>
                                            <div class="card-icon">
                                                <i class="far fa-file-code"></i>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card left-pane">
                                        <div class="card-body">
                                            <div class="text-wrapper">
                                                <h4 class="card-title">Skilled Technicians</h4>
                                                <p>Certified professional team repair your device!</p>
                                            </div>
                                            <div class="card-icon">
                                                <i class="far fa-gem"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end of icon cards pane -->

                                <!-- Image Pane -->
                                <div class="col-lg-4">
                                    <img class="img-fluid" src="images/features-iphone-1.png" alt="alternative">
                                </div>
                                <!-- end of image pane -->
                                
                                <!-- Icon Cards Pane -->
                                <div class="col-lg-4">
                                    <div class="card right-pane first">
                                        <div class="card-body">
                                            <div class="card-icon">
                                                <i class="far fa-calendar-check"></i>
                                            </div>
                                            <div class="text-wrapper">
                                                <h4 class="card-title">Genuine Parts</h4>
                                                <p>We provide quality & original products only!</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card right-pane">
                                        <div class="card-body">
                                            <div class="card-icon">
                                                <i class="far fa-bookmark"></i>
                                            </div>
                                            <div class="text-wrapper">
                                                <h4 class="card-title">Data Security</h4>
                                                <p>Don't worry, your data is safe with us!</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card right-pane">
                                        <div class="card-body">
                                            <div class="card-icon">
                                                <i class="fas fa-cube"></i>
                                            </div>
                                            <div class="text-wrapper">
                                                <h4 class="card-title">90 Days Warranty</h4>
                                                <p>Genuine products with a warranty of 3 months!</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end of icon cards pane -->

                            </div> <!-- end of row -->
                        </div> <!-- end of container -->
                    </div> <!-- end of tab-pane -->
                    <!-- end of tab -->

                    <!-- Tab -->
                    <div class="tab-pane fade" id="tab-2" role="tabpanel" aria-labelledby="tab-2">
                        <div class="container">
                            <div class="row">

                                <!-- Image Pane -->
                                <div class="col-md-4">
                                    <img class="img-fluid" src="images/features-iphone-2.png" alt="alternative">
                                </div>
                                <!-- end of image pane -->
                                
                                <!-- Text And Icon Cards Area -->
                                <div class="col-md-8">
                                    <div class="text-area">
                                        <h3>Book Your Repair</h3>
                                        <p>View prices upfront and book repair online. Pay by Card or Choose Cash on Delivery <a class="turquoise" href="#your-link">interesting details</a>. You can always change them.</p>
                                    </div> <!-- end of text-area -->
                                    
                                    <div class="icon-cards-area">
                                            <div class="card">
                                                <div class="card-icon">
                                                    <i class="fas fa-cube"></i>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class="card-title">Free Pickup</h4>
                                                    <p>Relax while our executives pick the device from your place.</p>
                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-icon">
                                                    <i class="far fa-bookmark"></i>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class="card-title">Diagnosis & Repair</h4>
                                                    <p>Get a 30 point quality check report on your mail while your device is repaired.</p>
                                                </div>
                                            </div>
                                            <div class="card">
                                                <div class="card-icon">
                                                    <i class="far fa-calendar-check"></i>
                                                </div>
                                                <div class="card-body">
                                                    <h4 class="card-title">Receive & Pay</h4>
                                                    <p>Receive the device at your place and pay.</p>
                                                </div>
                                            </div>
                                            
                                    </div> <!-- end of icon cards area -->
                                </div> <!-- end of col-md-8 -->
                                <!-- end of text and icon cards area -->

                            </div> <!-- end of row -->
                        </div> <!-- end of container -->
                    </div> <!-- end of tab-pane -->
                    <!-- end of tab -->

                    <!-- Tab -->
                    <div class="tab-pane fade" id="tab-3" role="tabpanel" aria-labelledby="tab-3">
                        <div class="container">
                            <div class="row">

                                <!-- Text And Icon Cards Area -->
                                <div class="col-md-8">
                                    <div class="icon-cards-area">
                                        <div class="card">
                                            <div class="card-icon">
                                                <i class="far fa-calendar-check"></i>
                                            </div>
                                            <div class="card-body">
                                                <h4 class="card-title">Book It Yourself</h4>
                                                <p>Schedule your appointments, Walk-in to your nearest smart Kiosk and handover the device to our executive.</p>
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-icon">
                                                <i class="far fa-file-code"></i>
                                            </div>
                                            <div class="card-body">
                                                <h4 class="card-title">Diagnosis & Repair</h4>
                                                <p>Your device will get repaired from nearest Kiosk store.</p>
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-icon">
                                                <i class="fas fa-cube"></i>
                                            </div>
                                            <div class="card-body">
                                                <h4 class="card-title">Collect & Pay</h4>
                                                <p>Check your device & pay by Cash / Card.</p>
                                            </div>
                                        </div>
                                        <div class="card">
                                            <div class="card-icon">
                                                <i class="far fa-bookmark"></i>
                                            </div>
                                            <div class="card-body">
                                                <h4 class="card-title">Easy Reading</h4>
                                                <p>Reading focus mode for long form articles, ebooks and other materials which involve large text areas</p>
                                            </div>
                                        </div>
                                    </div> <!-- end of icon cards area -->
                                    
                                    <div class="text-area">
                                        <h3>Monitoring Tools Evaluation</h3>
                                        <p>Monitor the evolution of your finances and health state using tools integrated in Leno. The generated real time reports can be filtered based on any <a class="turquoise" href="#your-link">desired criteria</a>.</p>
                                    </div> <!-- end of text-area -->
                                </div> <!-- end of col-md-8 -->
                                <!-- end of text and icon cards area -->

                                <!-- Image Pane -->
                                <div class="col-md-4">
                                    <img class="img-fluid" src="images/features-iphone-3.png" alt="alternative">
                                </div>
                                <!-- end of image pane -->
                                    
                            </div> <!-- end of row -->
                        </div> <!-- end of container -->
                    </div><!-- end of tab-pane -->
                    <!-- end of tab -->

                </div> <!-- end of tab-content -->
                <!-- end of tabs content -->

            </div> <!-- end of row --> 
        </div> <!-- end of container --> 
    </div> <!-- end of tabs -->
    <!-- end of features -->

        

      
    
    
  <!-- Image slider -->
   <div id="features" class="tabs">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>   <div class="p-3 mb-2 bg-primary text-white"><p class="fs-2" align="center"><b>WE REPAIRED <b style="color:red;">ALL BRANDS..!</b></b></p></div>
                    </h2>
                </div> <!-- end of col -->
            </div> <!-- end of row -->
            <div class="row">

                  <!-- Image Slider -->
                    <div class="slider-container">
                        <div class="swiper-container image-slider">
                            <div class="swiper-wrapper">
                                
                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-1.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/iphone1.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->
                                
                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-2.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-2.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->

                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-3.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-3.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->

                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-4.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-4.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->

                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-5.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-5.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->
                                
                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-6.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-6.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->

                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-7.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-7.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->

                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-8.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-8.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->

                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-9.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-9.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->

                                <!-- Slide -->
                                <div class="swiper-slide">
                                    <a href="images/screenshot-10.png" class="popup-link" data-effect="fadeIn">
                                        <img class="img-fluid" src="images/screenshot-10.png" alt="alternative">
                                    </a>
                                </div>
                                <!-- end of slide -->
                                
                            </div> <!-- end of swiper-wrapper -->

                            <!-- Add Arrows -->
                            <div class="swiper-button-next"></div>
                            <div class="swiper-button-prev"></div>
                            <!-- end of add arrows -->

                        </div> <!-- end of swiper-container -->
                    </div> <!-- end of slider-container -->
                    <!-- end of image slider -->
                 



            </div> <!-- end of row --> 
        </div> <!-- end of container --> 
    </div> <!-- end of tabs -->
    <!-- end of features -->

<!-- Image slider end -->
   

   


    <!-- Download -->
    <div class="basic-4">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-xl-5">
                    <div class="text-container">
                        <h2>Book<span id="js-rotating" style="color:red;">Now !</span></h2>
                        <p class="p-large">where we are fixing all models of smartphones, laptops and other electronic gadgets. Our service included touch screen repair/replacement, liquid and water damage repair, broken and physical damage repair, mainboard chip-level repairing, charging port, power button, side button, camera repair, headphone jack, wifi, bluetooth, battery replacement, software troubleshoot and up-gradation</p>
                 <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#addModal">Book Now</button>
                    </div> <!-- end of text-container -->
                </div> <!-- end of col -->
                <div class="col-lg-6 col-xl-7">
                    <div class="image-container">
                        <img class="img-fluid" src="images/download.png" alt="alternative">
                    </div> <!-- end of img-container -->
                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of basic-4 -->
    <!-- end of download -->


    <!-- Statistics -->
    <div class="counter">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    
                    <!-- Counter -->
                    <div id="counter">
                        <div class="cell">
                            <div class="counter-value number-count" data-count="231">1</div>
                            <p class="counter-info">Happy Users</p>
                        </div>
                        <div class="cell">
                            <div class="counter-value number-count" data-count="85">1</div>
                            <p class="counter-info">Issues Solved</p>
                        </div>
                        <div class="cell">
                            <div class="counter-value number-count" data-count="59">1</div>
                            <p class="counter-info">Good Reviews</p>
                        </div>
                        <div class="cell">
                            <div class="counter-value number-count" data-count="127">1</div>
                            <p class="counter-info">Case Studies</p>
                        </div>
                    </div>
                    <!-- end of counter -->
                    
                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of counter -->
    <!-- end of statistics -->


    <!-- Contact -->
    <div id="contact" class="form">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>CONTACT</h2>
                    <ul class="list-unstyled li-space-lg">
                        <li class="address">Don't hesitate to give us a call or just use the contact form below</li>
                        <li><i class="fas fa-map-marker-alt"></i>22 Innovative, San Francisco, CA 94043, US</li>
                        <li><i class="fas fa-phone"></i><a class="blue" href="tel:003024630820">+81 720 2212</a></li>
                        <li><i class="fas fa-envelope"></i><a class="blue" href="mailto:office@leno.com">office@leno.com</a></li>
                    </ul>
                </div> <!-- end of col -->
            </div> <!-- end of row -->
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    
                    <!-- Contact Form -->
                    <form id="contactForm" data-toggle="validator" data-focus="false">
                        <div class="form-group">
                            <input type="text" class="form-control-input" id="cname" required>
                            <label class="label-control" for="cname">Name</label>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control-input" id="cemail" required>
                            <label class="label-control" for="cemail">Email</label>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <textarea class="form-control-textarea" id="cmessage" required></textarea>
                            <label class="label-control" for="cmessage">Your message</label>
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group checkbox">
                            <input type="checkbox" id="cterms" value="Agreed-to-Terms" required>I have read and agree to Leno's stated conditions in <a href="privacy-policy.html">Privacy Policy</a> and <a href="terms-conditions.html">Terms Conditions</a> 
                            <div class="help-block with-errors"></div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="form-control-submit-button">SUBMIT MESSAGE</button>
                        </div>
                        <div class="form-message">
                            <div id="cmsgSubmit" class="h3 text-center hidden"></div>
                        </div>
                    </form>
                    <!-- end of contact form -->

                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of form -->
    <!-- end of contact -->

    
    <!-- Footer -->
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="footer-col">
                        <h4>About Leno</h4>
                        <p>We're passionate about creating the best mobile apps for personal development</p>
                    </div>
                </div> <!-- end of col -->
                <div class="col-md-4">
                    <div class="footer-col middle">
                        <h4>Important Links</h4>
                        <ul class="list-unstyled li-space-lg">
                            <li class="media">
                                <i class="fas fa-square"></i>
                                <div class="media-body">Our business partners <a class="turquoise" href="#your-link">startupguide.com</a></div>
                            </li>
                            <li class="media">
                                <i class="fas fa-square"></i>
                                <div class="media-body">Read our <a class="turquoise" href="terms-conditions.html">Terms & Conditions</a>, <a class="turquoise" href="privacy-policy.html">Privacy Policy</a></div>
                            </li>
                        </ul>
                    </div>
                </div> <!-- end of col -->
                <div class="col-md-4">
                    <div class="footer-col last">
                        <h4>Social Media</h4>
                        <span class="fa-stack">
                            <a href="#your-link">
                                <i class="fas fa-circle fa-stack-2x"></i>
                                <i class="fab fa-facebook-f fa-stack-1x"></i>
                            </a>
                        </span>
                        <span class="fa-stack">
                            <a href="#your-link">
                                <i class="fas fa-circle fa-stack-2x"></i>
                                <i class="fab fa-twitter fa-stack-1x"></i>
                            </a>
                        </span>
                        <span class="fa-stack">
                            <a href="#your-link">
                                <i class="fas fa-circle fa-stack-2x"></i>
                                <i class="fab fa-google-plus-g fa-stack-1x"></i>
                            </a>
                        </span>
                        <span class="fa-stack">
                            <a href="#your-link">
                                <i class="fas fa-circle fa-stack-2x"></i>
                                <i class="fab fa-instagram fa-stack-1x"></i>
                            </a>
                        </span>
                        <span class="fa-stack">
                            <a href="#your-link">
                                <i class="fas fa-circle fa-stack-2x"></i>
                                <i class="fab fa-linkedin-in fa-stack-1x"></i>
                            </a>
                        </span>
                    </div> 
                </div> <!-- end of col -->
            </div> <!-- end of row -->
        </div> <!-- end of container -->
    </div> <!-- end of footer -->  
    <!-- end of footer -->


    <!-- Copyright -->
    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p class="p-small">Copyright © Leno - Mobile App Landing Page Template by <a href="http://www.inovatik.com">Inovatik</a></p>
                </div> <!-- end of col -->
            </div> <!-- enf of row -->
        </div> <!-- end of container -->
    </div> <!-- end of copyright --> 
    <!-- end of copyright -->
    
    	
    <!-- Scripts -->
    <script src="js/jquery.min.js"></script> <!-- jQuery for Bootstrap's JavaScript plugins -->
    <script src="js/popper.min.js"></script> <!-- Popper tooltip library for Bootstrap -->
    <script src="js/bootstrap.min.js"></script> <!-- Bootstrap framework -->
    <script src="js/jquery.easing.min.js"></script> <!-- jQuery Easing for smooth scrolling between anchors -->
    <script src="js/swiper.min.js"></script> <!-- Swiper for image and text sliders -->
    <script src="js/jquery.magnific-popup.js"></script> <!-- Magnific Popup for lightboxes -->
    <script src="js/morphext.min.js"></script> <!-- Morphtext rotating text in the header -->
    <script src="js/validator.min.js"></script> <!-- Validator.js - Bootstrap plugin that validates forms -->
    <script src="js/scripts.js"></script> <!-- Custom scripts -->
</body>
</html>