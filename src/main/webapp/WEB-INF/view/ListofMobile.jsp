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
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Day Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
  <link href="assets/css/multistep.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Day - v2.2.0
  * Template URL: https://bootstrapmade.com/day-multipurpose-html-template-for-free/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
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
	  <style>
body {
  
  background-color:#F4F4F4;
}
</style>
</head>

<body >

  <!-- ======= Top Bar ======= -->
  <div id="topbar" class="d-none d-lg-flex align-items-center fixed-top ">
    <div class="container d-flex">
      <div class="contact-info mr-auto">
        <i class="icofont-envelope"></i> <a href="mailto:contact@example.com"><b style="color:red;">contact@example.com</b></a>
        <i class="icofont-phone"></i> <b style="color:red;">+1 5589 55488 55</b>
      </div>
      <div class="social-links">
        <a href="#" class="twitter"><i class="icofont-twitter"></i></a>
        <a href="#" class="facebook"><i class="icofont-facebook"></i></a>
        <a href="#" class="instagram"><i class="icofont-instagram"></i></a>
        <a href="#" class="skype"><i class="icofont-skype"></i></a>
        <a href="#" class="linkedin"><i class="icofont-linkedin"></i></i></a>
      </div>
    </div>
  </div>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top ">
    <div class="container d-flex align-items-center">

      <h1 class="logo mr-auto"><a href="index.html">Day</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="${contextPath}/">Home</a></li>
          <li><a href="#about">About</a></li>
          <li><a href="#services">Services</a></li>
          <li><a href="#pricing">Pricing</a></li>
          <li><a href="#team">Team</a></li>
          <li class="drop-down"><a href="">Drop Down</a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="drop-down"><a href="#">Deep Drop Down</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li>
          <li><a href="#contact">Contact</a></li>
          <li><a href="#cta">Book Your Repair</a></li>
        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->

  <!-- ======= Hero Section ======= -->
  <!-- ======= Pricing Section ======= -->
    
  <!-- End Hero -->

  <main id="main">
  <div class="row">
  
  </div>
      <!-- End Pricing Section -->
    <section id="pricing" class="pricing">
      <div class="container">
        <div class="section-title">
          <span>Pricing</span>
           <c:choose>
        <c:when test="${mode=='ALL_USERS' }">
              <!-- table start here -->
              <table class="table">
              <tbody>
				<c:forEach var="user" items="${users }">
			   <tr>
              <div class="row">
            <div class="col-lg-4 col-md-6 d-flex align-items-stretch" data-aos="fade-up">
             <td class="col-lg-3">
            <div class="box">
              <h3>Touch and Lcd</h3>
              <h4><sup>₹</sup>${user.touchandlcd}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>

          <div class="col-lg-4 col-md-6 mt-4 mt-md-0" data-aos="zoom-in">
          <td class="col-lg-3">
            <div class="box">
              <h3>toch screen glass</h3>
              <h4><sup>₹</sup>${user.touchscreenglass}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>
           <div class="col-lg-4 col-md-6 mt-4 mt-md-0" data-aos="zoom-in">
          <td class="col-lg-3">
            <div class="box">
              <h3>Battery</h3>
              <h4><sup>₹</sup>${user.battery}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>

          <div class="col-lg-4 col-md-6 mt-4 mt-lg-0" data-aos="zoom-in" data-aos-delay="150">
          <td class="col-lg-3">
            <div class="box">
              <h3>Charging port</h3>
              <h4><sup>₹</sup>${user.chargeport}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li>Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>
         </div>
         </tr>
         <tr>
              <div class="row">
            <div class="col-lg-4 col-md-6" data-aos="zoom-in" data-aos-delay="150">
             <td class="col-lg-3">
            <div class="box">
              <h3>loud speaker</h3>
              <h4><sup>₹</sup>${user.loudspeaker}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>

          <div class="col-lg-4 col-md-6 mt-4 mt-md-0" data-aos="zoom-in">
          <td class="col-lg-3">
            <div class="box">
              <h3>ear speaker</h3>
              <h4><sup>₹</sup>${user.earspeaker}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>
           <div class="col-lg-4 col-md-6 mt-4 mt-md-0" data-aos="zoom-in">
          <td class="col-lg-3">
            <div class="box">
              <h3>audio jack</h3>
              <h4><sup>₹</sup>${user.audiojack}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>

          <div class="col-lg-4 col-md-6 mt-4 mt-lg-0" data-aos="zoom-in" data-aos-delay="150">
          <td class="col-lg-3">
            <div class="box">
              <h3>microphone</h3>
              <h4><sup>₹</sup>${user.microphone}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li>Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>
         </div>
         </tr>
         <tr>
              <div class="row">
            <div class="col-lg-4 col-md-6" data-aos="zoom-in" data-aos-delay="150">
             <td class="col-lg-3">
            <div class="box">
              <h3>network</h3>
              <h4><sup>₹</sup>${user.network}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>

          <div class="col-lg-3" data-aos="zoom-in">
          <td class="col-lg-3">
            <div class="box">
              <h3>software diagnosis</h3>
              <h4><sup>₹</sup>${user.softwarediagnosis}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>
           <div class="col-lg-4 col-md-6 mt-4 mt-md-0" data-aos="zoom-in">
          <td class="col-lg-3">
            <div class="box">
              <h3>dead phone diagnosis</h3>
              <h4><sup>₹</sup>${user.deadphonediagnosis}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li class="na">Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>

          <div class="col-lg-3 col-md-3 mt-4 mt-lg-0" data-aos="zoom-in" data-aos-delay="150">
          <td class="col-lg-3">
            <div class="box">
              <h3>water diagnosis</h3>
              <h4><sup>₹</sup>${user.waterdiagnosis}</h4>
              <ul>
                <li>Aida dere</li>
                
                <li>Massa ultricies mi</li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Buy Now</a>
              </div>
            </div>
            </td>
          </div>
         </div>
         </tr>
        </c:forEach>
        </tbody>
        </table>
</c:when>
</c:choose>
      </div>
    </section>
    <!-- ======= About Section ======= -->
    <section id="about" class="about">
      <div class="container">

        <div class="row">
          <div class="col-lg-6 order-1 order-lg-2" data-aos="fade-left">
            <img src="assets/img/about.jpg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6 pt-4 pt-lg-0 order-2 order-lg-1 content" data-aos="fade-right">
            <h3>Voluptatem dignissimos provident quasi corporis voluptates sit assumenda.</h3>
            <p class="font-italic">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
              magna aliqua.
            </p>
            <ul>
              <li><i class="icofont-check-circled"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
              <li><i class="icofont-check-circled"></i> Duis aute irure dolor in reprehenderit in voluptate velit.</li>
              <li><i class="icofont-check-circled"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate trideta storacalaperda mastiro dolore eu fugiat nulla pariatur.</li>
            </ul>
            <p>
              Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
              velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
              culpa qui officia deserunt mollit anim id est laborum
            </p>
          </div>
        </div>

      </div>
    </section><!-- End About Section -->
  </main>

    <!-- ======= About Section ======= -->
   <!-- End About Section -->

    <!-- ======= Why Us Section ======= -->
   <!-- End Why Us Section -->

    <!-- ======= Clients Section ======= -->
   <!-- End Clients Section -->

    
  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>
  <div id="preloader"></div>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script src="assets/js/multistep.js"></script>

</body>

</html>