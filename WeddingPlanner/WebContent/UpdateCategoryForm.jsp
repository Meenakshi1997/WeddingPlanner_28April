<div style="background-image:url(images\\bg-body.jpg); height:110%; width:100%"></div>
<jsp:include page="AdminHeader.jsp"/>

<br/>
<!-- Content -->
<div class="container" style="margin-top:-630px">
	<img src="images/m10.jpg" class="img-rounded" alt="Main_Image" style="width:100%">
	<br/><br/>
	<img src="images/separator.png" alt="Main_Image" style="width:100%">
	
	<div align="center"><h2 style="font-family:Monotype Corsiva; color:brown; font-size:30px; font-weight:bold">Update Category Form</h2></div>


<form class="form-horizontal" action="updateCategoryProcess" method="post">

 <div class="form-group">
    <label class="control-label col-sm-2" for="categoryId">Category Id :</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="categoryId" name="categoryId" value="${requestScope.categoryObj.categoryId}" readonly="readonly">
    </div>
</div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="categoryName">Category Name :</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="categoryName" name="categoryName" value="${requestScope.categoryObj.categoryName}">
    </div>
  </div>
   <div class="form-group">
    <label class="control-label col-sm-2" for="desc">Category Description:</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="desc" name="desc" value="${requestScope.categoryObj.categoryDesc}">
    </div>
  </div>
    <button type="submit" class="btn btn-default" style=" margin-left:45%;">Update Category</button>
</form>

 </div>

