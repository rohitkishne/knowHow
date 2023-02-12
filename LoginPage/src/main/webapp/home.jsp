
<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="loginpage.css">
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
<header class="menu">
    <div class="left">
        <a href="index.jsp" class="active">
         <img src="https://online.ben.edu/sites/default/files/bdt_davinci-brain-200x200.jpg" alt="">
        </a>
    </div>
    <div class="mid">
        <ul class="navbar">
            <li><a href="index.jsp" class="active">Home</a></li>
            <li><a href="about.jsp">About Us</a></li>
            <li><a href="https://acciojob.com/" target="_blank">CodeWithAccioJob</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
        </ul>
    </div>
    <div class="right">
        <form action="Logout" method="get">
            <div>
                <input class="log" type="submit" value="Logout">
            </div>
        </form>
    </div>
</header>
<div align="Center">
        <h2>
            Hello, <%=request.getParameter("name")%>!
        </h2>
        <h3>Welcome to Home page...</h3>

</div>

</body>
</html>
