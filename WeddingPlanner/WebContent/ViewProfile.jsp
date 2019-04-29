<div style="background-image:url(images\\bg-body.jpg); height:150%; width:100%"></div>
<jsp:include page="UserHeader.jsp"/>
<br/><br/><br/><br/><br/><br/>


<div class="container table-responsive" style="margin-top:-970px">    
		<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%"> 
		<br/><br/><br/>
		<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">
		<br/><br/>
	<h1 style="font-family:Monotype Corsiva; text-align:center; color:brown; font-size:30px; font-weight:bold"> View Profile</h1>     
  	<br/>
  <table class="table table-striped">
      <tr>
      	<td>Email </td>
      	<td>${sessionScope.user.email}</td>
      </tr>
      <tr>
      	<td>First Name </td>
      	<td>${sessionScope.user.firstName}</td>
      </tr>
      <tr>
      	<td>Last Name </td>
      	<td>${sessionScope.user.lastName}</td>
      </tr>
      <tr>
      	<td>Gender </td>
      	<td>${sessionScope.user.gender}</td>
      </tr>
      <tr>
      	<td>DateOfBrith </td>
      	<td>${sessionScope.user.dateOfBirth}</td>
      </tr>
      <tr>
      	<td>Address </td>
      	<td>${sessionScope.user.address}</td>
      </tr>
      <tr>
      	<td>Mobile No.</td>
      	<td>${sessionScope.user.mobileNo}</td>
      </tr>
  </table>
  <br/><br/>
  <img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">
  </div>