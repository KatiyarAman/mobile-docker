<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<div class="card">
	<div class="container">
	<div class="card-body">
		<form  action="${contextPath}/addP" method="post" enctype="multipart/form-data">
         
			<!-- Name -->
			<div class="form-group">
			<input type="text" name="touchandlcd" id="touchandlcd" class="form-control mb-4"placeholder="touchandlcd">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="touchandlcdImage" id="touchandlcdImage" >
					<label class="custom-file-label"for="customFile">Product Image</label>
					</div>
					</div>
					
			<!-- Name -->
			<div class="form-group">
			<input type="text" name="touchscreenglass" id="touchscreenglass" class="form-control mb-4"placeholder="touchscreenglass">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="touchscreenglassImage" id="touchscreenglassImage" >
					<label class="custom-file-label"for="customFile">touchscreenglass Image</label>
                   </div>
                   </div>
           <!-- Name -->
           <div class="form-group">
			<input type="text" name="battery" id="battery" class="form-control mb-4"placeholder="battery">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="batteryImage" id="batteryImage" >
					<label class="custom-file-label"for="customFile">battery Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="chargeport" id="chargeport" class="form-control mb-4"placeholder="chargeport">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="chargeportImage" id="chargeportImage" >
					<label class="custom-file-label"for="customFile">chargeport Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="loudspeaker" id="loudspeaker" class="form-control mb-4"placeholder="loudspeaker">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="loudspeakerImage" id="loudspeakerImage" >
					<label class="custom-file-label"for="customFile">loudspeaker Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="earspeaker" id="earspeaker" class="form-control mb-4"placeholder="earspeaker">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="earspeakerImage" id="earspeakerImage" >
					<label class="custom-file-label"for="customFile">earspeaker Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="audiojack" id="audiojack" class="form-control mb-4"placeholder="audiojack">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="audiojackImage" id="audiojackImage" >
					<label class="custom-file-label"for="customFile">audiojack Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="microphone" id="microphone" class="form-control mb-4"placeholder="microphone">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="microphoneImage" id="microphoneImage" >
					<label class="custom-file-label"for="customFile">microphone Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="network" id="network" class="form-control mb-4"placeholder="network">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="networkImage" id="networkImage" >
					<label class="custom-file-label"for="customFile">network Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="softwarediagnosis" id="softwarediagnosis" class="form-control mb-4"placeholder="softwarediagnosis">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="softwarediagnosisImage" id="softwarediagnosisImage" >
					<label class="custom-file-label"for="customFile">softwarediagnosis Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="deadphonediagnosis" id="deadphonediagnosis" class="form-control mb-4"placeholder="deadphonediagnosis">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="deadphonediagnosisImage" id="deadphonediagnosisImage" >
					<label class="custom-file-label"for="customFile">deadphonediagnosis Image</label>
					</div>
					</div>
					<!-- Name -->
					<div class="form-group">
			<input type="text" name="waterdiagnosis" id="waterdiagnosis" class="form-control mb-4"placeholder="waterdiagnosis">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="waterdiagnosisImage" id="waterdiagnosisImage" >
					<label class="custom-file-label"for="customFile">waterdiagnosis Image</label>
					</div>
					</div>
							<!-- Name -->
							<div class="form-group">
			<input type="text" name="standbyphone" id="standbyphone" class="form-control mb-4"placeholder="standbyphone">
				<div class="custom-file mb-2">
				<input type="file"  class="custom-file-input" name="standbyphoneImage" id="standbyphoneImage" >
					<label class="custom-file-label"for="customFile">standbyphone Image</label>
					</div>
					</div>
							<!-- Name -->
							<div class="form-group">
			<input type="text" name="brand" id="brand" class="form-control mb-4"placeholder="brand">
				</div>
				<div class="form-group">
				
							<!-- Name -->
			<input type="text" name="modelseries" id="modelseries" class="form-control mb-4"placeholder="modelseries">
				</div>
			<!-- Sign in button -->
			<button class="btn btn-info btn-block" type="submit">add</button>
		</form>
	</div>
	</div>
</div>
<script  src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>