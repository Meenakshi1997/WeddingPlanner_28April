<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-image:url(images\\bg-body.jpg); height:135%; width:100%"></div>
<jsp:include page="Navbar.jsp"/>

<br/><br/><br/>

<!-- Content -->
<div class="container" style="margin-top:-810px">
<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%">
<br/><br/>
<c:if test="${not empty msg}">
<div class="alert alert-warning">
	 ${msg} 
	
</div>
</c:if>	<br/>
<img src="images/separator.png" alt="Main_Image" style="width:100%">
<br/>
  <div align="center"><h2 style="font-family:Monotype Corsiva; color:brown; font-size:30px; font-weight:bold">User Login Form</h2></div>
  
  <br/><form class="form-horizontal" action="validateUser" method="post" style=" margin-left:25%;">
    <div class="form-group">
      <label class="control-label col-sm-2"  for="email">Email:</label>
      <div class="col-sm-4">
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-4">
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div> 
    </div>
    <button type="submit" class="btn btn-default" style=" margin-left:30%;">Login</button>
    <br/><br/>
    <a href="UserRegister.jsp" style=" font-size:20px ;margin-left:20%;" class="btn btn-link btn-md" role="button" >Click here for Registration</a>
    
  </form>
<br/>

<img src="images/separator.png" alt="Main_Image" style="width:100%">
</div>