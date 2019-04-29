<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background-image:url(images\\bg-body.jpg); height:150%; width:100%"></div>
<!--<jsp:include page="AdminHeader.jsp"/>-->

<c:if test="${sessionScope.user.role eq 'Admin'}">
<jsp:include page="AdminHeader.jsp"/>
</c:if>
<c:if test="${sessionScope.user.role eq 'user'}">
<jsp:include page="UserHeader.jsp"/>
</c:if>

<c:if test="${empty sessionScope.user.role}">
<jsp:include page="Navbar.jsp"/>
</c:if>

	<br/><br/><br/><br/><br/><br/>
<!-- Content -->
<div class="container" style="margin-top:-900px">
	<c:if test="${not empty msg}">
		<div class="alert alert-success">
			${msg}
		</div>
	</c:if>
	
	<h1 style="font-family:Monotype Corsiva; text-align:center; color:brown; font-size:30px; font-weight:bold">List of Vendors</h1>
	<br/>
	<c:choose>
		<c:when test="${vList.size() eq 0}">
		
			No Vendors Found...
			
		</c:when>
		<c:otherwise>
				<c:forEach items="${vList}" var="vendorObj">
					<div class="col-md-4 column productbox">
		<img src="images/${vendorObj.image}.jpg" style="height:250px;width:300px" class="img-responsive">
        <div class="vendorName">${vendorObj.vendorName}</div>
        <div class="vendorLocation">${vendorObj.location}</div>
        <div class="vendorprice">
        
        
        <c:if test="${sessionScope.user.role ne 'Admin'}">
        <div class="pull-right">
        <a href="#" class="btn btn-danger btn-sm" role="button">BUY</a>
        </div>
        </c:if>
        
        
        <div class="pricetext">${vendorObj.price}</div></div>
        
        
       	<c:if test="${sessionScope.user.role eq 'Admin'}">
        <a href="deleteVendor?vendorId=${vendorObj.vendorId}" class="btn btn-primary"><i class="fa fa-trash " aria-hidden="true"></i>Delete</a>
		<a href="updateVendor?vendorId=${vendorObj.vendorId}" class="btn btn-primary"><i class="fa fa-edit"  aria-hidden="true"></i>Update</a>
		</c:if>
		
    </div>
				</c:forEach>
	
		</c:otherwise>
	</c:choose>
 </div>
  <style>
 	.productbox {
    background-color:#ffffff;
	padding:10px;
	margin-bottom:10px;
	-webkit-box-shadow: 0 8px 6px -6px  #999;
	   -moz-box-shadow: 0 8px 6px -6px  #999;
	        box-shadow: 0 8px 6px -6px #999;
}

.vendorName {
    font-weight:bold;
	padding:5px 0 5px 0;
}

.vendorLocation {
	border-top:1px solid #dadada;
	padding-top:5px;
}

.vendorPrice {
	font-weight:bold;
	font-size:1.4em;
}
 </style>