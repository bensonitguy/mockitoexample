package com.rest.news;

import java.io.*;
import java.net.*;

public class FetchNewsService {

    public static String getTodaysNews(String api_key){
        return getResponse("https://newsapi.org/v2/top-headlines?country=in&apiKey="+api_key);
    }

    public String whoIsMyFriend(){
        return "Jarvis";
    }

    public String getQuote(){
        return "This is a quote by "+whoIsMyFriend();
    }

    public static String getResponse(String urlToRead) {

        StringBuilder result = new StringBuilder();
        try{

            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            System.out.println(result.toString());
        }catch(Exception e){
            e.printStackTrace();
        }

        return result.toString();
    }
}
