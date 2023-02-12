<html>
<head>
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="signup.css">
<link rel="stylesheet" type="text/css" href="login.css">
<link rel="stylesheet" type="text/css" href="loginpage.css">
</head>
<body>
<header class="menu">
    <div class="left">
        <a href="index.jsp" class="active">
         <img src="https://online.ben.edu/sites/default/files/bdt_davinci-brain-200x200.jpg" alt="">
        </a>
    </div>
    <div id="mid">
        Registration
    </div>
</header>
<div class="container">
    <div class="signform">
        <form class="signupform" action = "SignUp" method="post">
            <table class="signtable">
                <tr>
                    <td class="entries">Enter Name :</td>
                    <td><input class="filldata" type="text" name ="name" required></td>
                </tr>
                <tr>
                   <td class="entries">Enter Email-ID :</td>
                   <td><input class="filldata" type="text" name ="email" required></td>
                </tr>
                <tr>
                    <td class="entries">Enter Username :</td>
                    <td><input class="filldata" type="text" name ="username" required></td>
                </tr>
                <tr>
                    <td class="entries">Enter Password :</td>
                    <td><input class="filldata" type="password" name ="password" required></td>
                </tr>
                 <tr>
                     <td class="entries">Enter Contact No. :</td>
                     <td><input class="filldata" type="password" name ="contact" required></td>
                 </tr>
                 <tr>
                     <td class="entries">Enter Age :</td>
                     <td><input class="filldata" type="password" name ="age" required></td>
                 </tr>
                <tr>
                    <td><input class="log" id="rightbutton" type="button" onClick="window.location.href='index.jsp';" value="Login"></td>
                    <td><input class="log" id="leftbutton" type="submit" value="SignUp"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
