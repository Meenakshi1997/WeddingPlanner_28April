<div style="background-image:url(images\\bg-body.jpg); height:150%; width:100%"></div>
<jsp:include page="AdminHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.user.role eq 'Admin'}">
<jsp:include page="AdminHeader.jsp"/>
</c:if>
<c:if test="${sessionScope.user.role eq 'user'}">
<jsp:include page="UserHeader.jsp"/>
</c:if>

<c:if test="${empty sessionScope.user.role}">
<jsp:include page="Navbar.jsp"/>
</c:if>

	<br/>
<!-- Content -->
<div class="container" style="margin-top:-870px">
	<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%">
	<br/><br/>
	<img src="images/separator.png" alt="Main_Image" style="width:100%">
	
	<div align="center"><h2 style="font-family:Monotype Corsiva; color:brown; font-size:30px; font-weight:bold">Update Venue Form</h2></div>

<form class="form-horizontal" action="updateCateringProcess" method="post" enctype="multipart/form-data" style="margin-left:25%">

<div class="form-group">
    <label class="control-label col-sm-2" for="catererId">Caterer Id :</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="catererId" name="catererId" value="${requestScope.cateringObj.catererId}">
    </div>
</div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="catererName">Caterer Name :</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="catererName" name="catererName" value="${requestScope.cateringObj.catererName}">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="price"> Price :</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="price" name="price" value="${requestScope.cateringObj.price}">
    </div>
  </div>
     
  <div class="form-group">
    <label class="control-label col-sm-2" for="location">Location :</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="location" name="location" value="${requestScope.cateringObj.location}">
    </div>
  </div>
  
      <div class="form-group">
    <label class="control-label col-sm-2" for="image">Image:</label>
    <div class="col-sm-5">
    <input type="file" class="form-control" id="image" name="image" value="${requestScope.cateringObj.image}">
    </div>
  </div>
  

    <button type="submit" class="btn btn-default" style=" margin-left:30%;">Update Catering</button>
</form>
<img src="images/separator.png" alt="Main_Image" style="width:100%">
 </div>
	

