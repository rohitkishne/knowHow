package org.Loginpage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        System.out.println("Session before invalidate: "+ request.getSession(false));

        request.getSession(false).invalidate();

        System.out.println("Session after invalidate: "+ request.getSession(false));


        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
        out.close();


    }
}
