<div style="background-image:url(images\\bg-body.jpg); height:150%; width:100%"></div>
<jsp:include page="UserHeader.jsp"/>

<br/>
<!-- Content -->
<div class="container" style="margin-top:-870px">
	<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%"> 
		<br/><br/><br/>
		<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">
		<br/><br/>
	<h1 style="font-family:Monotype Corsiva; text-align:center; color:brown; font-size:30px; font-weight:bold">Update Profile</h1>     
  	<br/>
<form class="form-horizontal" action="updateUser" method="post" style="margin-left:25%">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email address:</label>
    <div class="col-sm-5">
    <input type="email" class="form-control" id="email" name="email" value="${sessionScope.user.email}" readonly="readonly">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="fname">First Name:</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="fname" name="fName" value="${sessionScope.user.firstName}" >
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="lname">Last Name:</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="lname" name="lName" value="${sessionScope.user.lastName}">
    </div>
  </div>

  
   <div class="form-group">
    <label class="control-label col-sm-2" for="address">Address:</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="address" name="address" value="${sessionScope.user.address }">
    </div>
  </div> 
  <div class="form-group">
    <label class="control-label col-sm-2" for="mob">Mobile No.:</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" id="mob" name="mob" value="${sessionScope.user.mobileNo }">
    </div>
  </div> 
  <button type="submit" class="btn btn-default" style="margin-left:30%">Update</button>
</form>
<br/>
<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">

 </div>
