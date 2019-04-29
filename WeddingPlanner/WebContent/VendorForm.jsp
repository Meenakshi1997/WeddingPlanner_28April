<div style="background-image:url(images\\bg-body.jpg); height:150%; width:100%"></div>
<jsp:include page="AdminHeader.jsp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<br/>
<!-- Content -->
<div class="container" style="margin-top:-870px">
	<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%">
	<br/><br/>
	<img src="images/separator.png" alt="Main_Image" style="width:100%">
	
	<div align="center"><h2 style="font-family:Monotype Corsiva; color:brown; font-size:30px; font-weight:bold">Vendor Form</h2></div>

<form class="form-horizontal" action="addVendor" method="post" enctype="multipart/form-data" style="margin-left:25%">
     
  <div class="form-group">
    <label class="control-label col-sm-2" for="vendorName">Vendor Name :</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="vendorName" name="vendorName">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="price"> Price :</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="price" name="price">
    </div>
  </div>
     
  <div class="form-group">
    <label class="control-label col-sm-2" for="location">Location :</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="location" name="location">
    </div>
  </div>
  
      <div class="form-group">
    <label class="control-label col-sm-2" for="image">Image:</label>
    <div class="col-sm-5">
    <input type="file" class="form-control" id="image" name="image">
    </div>
  </div>
  

    <button type="submit" class="btn btn-default" style=" margin-left:30%;">Add Vendors</button>
</form>
<img src="images/separator.png" alt="Main_Image" style="width:100%">
 </div>
	

