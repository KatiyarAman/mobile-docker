<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>products</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
    <title>Dash PAGE| Super</title>
    <link href="css/bootstrap.css" rel="stylesheet">

</head>
<body>

<div class="container">
    <div class="col-12">

        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>UserName</th>
                <th> Name</th>
                <th>MOBILE NO</th>
                <th>CLASS</th>
                <th>Status</th>
                <th>Delete</th>
                <th>Edit</th>
                <td>${id}</td>
                <td>${brand}</td>
            </tr>
            </thead>
            <tbody>
            <td><img src="data:image/jpg;base64,${image} alt=" Girl in a jacket" style="width:50px;height:50px;"></img>
            </td>

            <!--
							<c:forEach var="user" items="${products}">
								<tr>
									<td>${user.brand}</td>
									<td>${user.audiojack}</td>
									<td>${user.brandseries}</td>
									
			<td><img  src="{'data:image/jpg;base64,'+${image}" style="width: 100px;height: 100px;"></td> 
							       
								</tr>
							</c:forEach>-->
            </tbody>
        </table>
        <hr>
    </div>
</div>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>