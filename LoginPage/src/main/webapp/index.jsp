<html>
<head>
<title>Login</title>
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
        ThinkAndGrow
    </div>
</header>
<div class="container">
    <div class="login">
        <h2>Enter Login Details</h2>
        <div class="form">
            <form action = "Login" method="post">
                <table class="table">
                    <tr>
                        <td class="text">Enter Username :</td>
                        <td ><input class="input" type="text" name ="username" required></td>
                    </tr>
                    <tr>
                        <td class="text">Enter Password :</td>
                        <td ><input class="input" type="password" name ="password" required></td>
                    </tr>
                    <tr>
                        <td> <input class="log" id="loginbutton" type="submit" value="Login"></td>
                        <td><input class="log" id="signbutton" type="button" onclick="window.location.href='signUp.jsp';" value="SignUp"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
