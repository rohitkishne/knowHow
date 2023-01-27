package com.Techknow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String keyword = request.getParameter("keyword");
        System.out.println(keyword);

        try
        {
            //Establish/get connection to database
            Connection connection = DatabaseConnection.getConnection();

            //save keyword and link associated into history table
            PreparedStatement preparedStatement = connection.prepareStatement("insert into history values (?,?);");
            preparedStatement.setString(1, keyword);
            preparedStatement.setString(2, "http://localhost:8080/searchKaro/Search?keyword="+keyword);
            preparedStatement.executeUpdate();

            //Executing a query related to keyword and get the results
            ResultSet resultSet = connection.createStatement().executeQuery("select pageTitle, pageLink, (length(lower(pagetext))-length(replace(lower(pagetext),'"+keyword+"','')))/length('"+keyword+"') as countOccurrence from pages order by countOccurrence desc limit 30;");

            ArrayList<SearchResult> results = new ArrayList<>();

            //Iterate through resultSet and save all elements in results arraylist
            while(resultSet.next())
            {
                SearchResult searchResult = new SearchResult();

                //get PageTitle
                searchResult.setPageTitle(resultSet.getString("pageTitle"));

                //get PageLink
                searchResult.setPageLink(resultSet.getString("pageLink"));

                results.add(searchResult);
            }
            //Display results in console
            for(SearchResult searchResult : results)
            {
                System.out.println(searchResult.getPageTitle()+" "+searchResult.getPageLink());
            }

            //set Attribute of request with results arraylist
            request.setAttribute("results", results);

            //forward request to search.jsp
            request.getRequestDispatcher("/search.jsp").forward(request,response);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

        }catch (SQLException | IOException | ServletException exception)
        {
            exception.printStackTrace();
        }
    }
}
