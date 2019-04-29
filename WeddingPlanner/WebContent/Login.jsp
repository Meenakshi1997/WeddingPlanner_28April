<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-image:url(images\\bg-body.jpg); height:115%; width:100%"></div>
<jsp:include page="Navbar.jsp"/>

<br/><br/><br/>
<div class="container" style="margin-top:-650px">
<%--
 <%
	Object msg=request.getAttribute("errorMsg");
   if(msg!=null){
	   %>
	   		<div class="alert alert-danger">
	   			Email or Password is incorrect...
	   		</div>
	   <%
   }
 %>	
  --%>

<c:if test="${not empty errorMsg}">
	<div class="alert alert-danger">
		${errorMsg}
	</div>
</c:if>  
<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%">
<br/><br/>
<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">	

  <div align="center"><h2 style="font-family:Monotype Corsiva; color:brown; font-size:30px; font-weight:bold">Login Form</h2></div>
  <br/>
  <form class="form-horizontal" action="login" method="post" style=" margin-left:25%;">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
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
    <button type="submit" class="btn btn-default" style="margin-left:30%">Login</button>
  </form>

<br/>
<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">	
<br/>
</div>