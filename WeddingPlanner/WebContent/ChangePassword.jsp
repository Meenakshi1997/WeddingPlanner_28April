<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-image:url(images\\bg-body.jpg); height:115%; width:100%"></div>
<jsp:include page="UserHeader.jsp"/>

<br/><br/><br/>
<div class="container" style="margin-top:-700px">
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

  <div align="center"><h2 style="font-family:Monotype Corsiva; color:brown; font-size:30px; font-weight:bold">Change Password Form</h2></div>
  <br/>
  <form class="form-horizontal" action="changePassword" method="post" style=" margin-left:25%;">
    <div class="form-group">
      <label class="control-label col-sm-2" for="newpassword">New Password:</label>
      <div class="col-sm-4">
      <input type="password" class="form-control" id="newpassword" placeholder="Enter password" name="newpassword">
    </div> 
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="comfirmpassword">Comfirm Password:</label>
      <div class="col-sm-4">
      <input type="password" class="form-control" id="comfirmpassword" placeholder="Enter password" name="confirmpassword">
    </div> 
    </div>
    <button type="submit" class="btn btn-default" style="margin-left:25%">Change Password</button>
  </form>

<br/>
<img src="images/separator.png" class="img-rounded" alt="Main_Image" style="width:100%">	
<br/>
</div>