<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-image:url(images\\bg-body.jpg); height:170%; width:100%"></div>
<jsp:include page="Navbar.jsp"/>
<br/><br/><br/>
<!-- Content -->
<div class="container" style="margin-top:-1030px">
	<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%"> 
		<br/><br/><br/>
		<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">
		<br/><br/>
	<h1 style="font-family:Monotype Corsiva; text-align:center; color:brown; font-size:30px; font-weight:bold">User Register From</h1>     
  	<br/>

<form class="form-horizontal" action="registerUser" method="post" style="margin-left:25%">
  <div class="form-group">
    <label class="control-label col-sm-2" for="email">Email address:</label>
    <div class="col-sm-4">
    <input type="email" class="form-control" id="email" name="email">
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-4">
    <input type="password" class="form-control" id="pwd" name="pwd">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="fname">First Name:</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="fname" name="fName">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="lname">Last Name:</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="lname" name="lName">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="gender">Gender:</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="gender" name="gender">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="dob">Date Of Birth:</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="dob" name="dob">
    </div>
  </div> 
  <div class="form-group">
    <label class="control-label col-sm-2" for="address">Address:</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="address" name="address">
    </div>
  </div> 
  <div class="form-group">
    <label class="control-label col-sm-2" for="mob">Mobile No.:</label>
    <div class="col-sm-4">
    <input type="text" class="form-control" id="mob" name="mob">
    </div>
  </div> 
  
  <button type="submit" class="btn btn-default" style="margin-left:30%;">Register</button>
</form>
<br/>
	<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">
<br/>
 </div>


