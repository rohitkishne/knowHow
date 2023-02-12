package org.Loginpage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session =  request.getSession();

        try {
            Connection connection = usersDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from signUp where user=? and pass=?;");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next())
            {
                session.setAttribute("username",username);
                response.sendRedirect("home.jsp?name="+username);
            }

            else {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                out.println("<script>alert('Username or Password is incorrect!');</script>");
                rd.include(request,response);
            }
            out.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
