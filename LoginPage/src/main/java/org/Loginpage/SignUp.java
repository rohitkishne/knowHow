package org.Loginpage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");
        String age = request.getParameter("age");



        try{
            Connection connection = usersDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into signUp(name,email,user, pass,contact,age) values(?,?,?,?,?,?);");
            preparedStatement.setString(1, name);
            if(!isValid(email))
            {
                RequestDispatcher rd = request.getRequestDispatcher("signUp.jsp");
                out.println("<script>alert('Email is not correct. Please enter valid Email-Id');</script>");
                rd.include(request,response);
            }
            else {
                preparedStatement.setString(2, email);
            }
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, contact);
            preparedStatement.setString(6, age);

            int result = preparedStatement.executeUpdate();
            if(result>0)
            {
                RequestDispatcher rd = request.getRequestDispatcher("signUp.jsp");
                out.println("<script>alert('You are Successfully Registered.');</script>");
                rd.include(request,response);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
    protected boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if(email==null)
        {
            return false;
        }
        return pat.matcher(email).matches();
    }
}
