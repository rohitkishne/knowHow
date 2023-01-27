package com.Techknow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/History")
public class History extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            //making a connection with database
            Connection connection = DatabaseConnection.getConnection();
            //getting a result from a history db
            ResultSet resultSet = connection.createStatement().executeQuery("Select * from history;");

            ArrayList<HistoryResult> results = new ArrayList<HistoryResult>();

            while (resultSet.next())
            {
                String keyword = resultSet.getString("keyword");
                String link = resultSet.getString("link");
                HistoryResult historyResult = new HistoryResult(keyword, link);
                results.add(historyResult);
            }
            //display result in console
            for(HistoryResult searchResult : results)
            {
                System.out.println(searchResult.getKeyword()+" "+searchResult.getLink());
            }
            //set the attribute of request with result arraylist
            request.setAttribute("results",results);

            //forward request to history.jsp
            request.getRequestDispatcher("/history.jsp").forward(request,response);
            response.setContentType("text/html");

            //writer created for displaying to history.jsp
            PrintWriter out = response.getWriter();

        }catch (SQLException | IOException | ServletException exception)
        {
            exception.printStackTrace();
        }
    }
}
