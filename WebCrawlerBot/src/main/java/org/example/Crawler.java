package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

public class Crawler {

    public HashSet<String> urlHash;
    public int MAX_DEPTH = 2;

    public static Connection connection = null;

    public Crawler(){
        urlHash = new HashSet<>();
        connection = DatabaseConnection.getConnection();
    }

    public void getPageTextAndLinks(String url, int depth)
    {
        //if urlHash does not contain url

        if(!urlHash.contains(url)) {
            //Add url to url Hashset
            if (urlHash.add(url)) {
                System.out.println(url);
            }

            try {
                //Connecting to webPages & get webpage as document object
                Document document = Jsoup.connect(url).timeout(5000).get();

                //get text inside that document/webpages
                String text = document.text().length() > 1000 ? document.text().substring(0, 999) : document.text();

                //get title of webpage
                String title = document.title();

                //Prepare an insertion command
                PreparedStatement preparedStatement = connection.prepareStatement("Insert into pages values(?,?,?)");

                //At first ?
                preparedStatement.setString(1, title);

                //At second ?
                preparedStatement.setString(2, url);

                //At third ?
                preparedStatement.setString(3, text);

                //Execute the prepared command
                preparedStatement.executeUpdate();

                //increase depth
                depth++;

                //limit depth
                if (depth == 2) {
                    return;
                }

                //Get all links/anchor tags that are present in webpage
                Elements availableLinksOnPage = document.select("a[href]");

                //for every link, call the function recursively
                for (Element currentLink : availableLinksOnPage) {
                    getPageTextAndLinks(currentLink.attr("abs:href"), depth);
                }
            } catch (IOException | SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.getPageTextAndLinks("http://www.javatpoint.com/",0);

    }
}