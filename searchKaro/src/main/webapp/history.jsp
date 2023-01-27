<%@ page import="com.Techknow.HistoryResult" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<header class="menu">
    <div class="left">
        <a href="index.jsp" class="active">
        <img src="https://online.ben.edu/sites/default/files/bdt_davinci-brain-200x200.jpg" alt="">
        </a>    </div>
    <div class="mid">
        <ul class="navbar">
            <li><a href="index.jsp" class="active">Home</a></li>
            <li><a href="about.jsp">About Us</a></li>
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
  <div class="title">History</div>
</form>
    <div class="results">
      <table border="2">
        <tr class="table">
          <td>keyword</td>
          <td>link</td>
        </tr>

        <%
          ArrayList<HistoryResult> results = (ArrayList<HistoryResult>) request.getAttribute("results");
          for(HistoryResult result : results) {
        %>
          <tr class="table">
            <td style="column-width: 250px"><%out.println(result.getKeyword());%></td>
            <td><a href="<%out.println(result.getLink());%>"><%out.println(result.getLink());%></a> </td>
          </tr>
        <%
          }
        %>
      </table>
    </div>
</body>
</html>
