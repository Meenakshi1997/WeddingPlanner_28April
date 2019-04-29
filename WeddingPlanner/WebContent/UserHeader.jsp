<!DOCTYPE html>
<html lang="en">
<head>
  <title>Wedding Planner</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="font-family:Monotype Corsiva; color:brown; font-size:40px; font-weight:bold">Wedding Planner</a>
    </div>
    <ul class="nav navbar-nav" style="margin-left:25%">
      <li class="active"><a href="HomePage.jsp" style="font-family:Monotype Corsiva; color:brown; font-size:25px;">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-family:Monotype Corsiva; color:brown; font-size:25px;" >Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
        	<li><a href="viewAllVenues" style="font-family:Monotype Corsiva; color:brown; font-size:20px;">View All Venues</a></li>
			<li><a href="viewAllCaterings" style="font-family:Monotype Corsiva; color:brown; font-size:20px;">View All Caterings</a></li>
			<li><a href="viewAllVendors" style="font-family:Monotype Corsiva; color:brown; font-size:20px;">View All Vendors</a></li>
	
        </ul>
     </li>
      <li><a href="#" style="font-family:Monotype Corsiva; color:brown; font-size:25px;">Add Event</a></li>
      <li><a href="#" style="font-family:Monotype Corsiva; color:brown; font-size:25px;">Payment</a></li>

    </ul>
  </div>

 <ul class="nav navbar-nav navbar-right" style="margin-right:80px; margin-top:-4%">
    <li class="dropdown" ><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-family:Monotype Corsiva; color:brown; font-size:25px;">Welcome : ${sessionScope.user.firstName} ${sessionScope.user.lastName}<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="ViewProfile.jsp" style="font-family:Monotype Corsiva; color:brown; font-size:15px;">View Profile</a></li>
          <li><a href="UpdateProfile.jsp" style="font-family:Monotype Corsiva; color:brown; font-size:15px;">Update Profile</a></li>
          <li><a href="ChangePassword.jsp" style="font-family:Monotype Corsiva; color:brown; font-size:15px;">Change Password</a></li>
          <li><a href="#" style="font-family:Monotype Corsiva; color:brown; font-size:15px;"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
        </ul>
      </li>

    </ul>
    </nav>
</body>
</html>