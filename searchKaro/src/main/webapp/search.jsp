<%@ page import="com.Techknow.SearchResult" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>KnowHow</title>
    <link rel="stylesheet" type="text/css" href="style.css">
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
            <li><a href="about.jsp" >About Us</a></li>
            <li><a href="https://acciojob.com/" target="_blank">CodeWithAccioJob</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
        </ul>
    </div>
    <div class="right">
        <form action="History">
            <div class="history">
                <button type="submit">History</button>
            </div>
        </form>
    </div>
</header>
<form action = "Search">
    <div class="title">KnowHow</div>
    <input type="text" name = "keyword" >
    <button type="submit">Search</button>
</form>
<div class="results">
    <table border="2">
        <tr class="table">
            <td >Title</td>
            <td>Link</td>
        </tr>

        <%
            //Get results form search servlet
            ArrayList<SearchResult> results = (ArrayList<SearchResult>)request.getAttribute("results");

            //iterate for every data present in result array
            for(SearchResult result : results)
            {
        %>
        <tr class="table">
            <td><%out.println(result.getPageTitle());%></td>
            <td><a href="<%out.println(result.getPageLink());%>"><%out.println(result.getPageLink());%></a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
