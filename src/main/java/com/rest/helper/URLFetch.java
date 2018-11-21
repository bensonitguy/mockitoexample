package com.rest.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLFetch {

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

    private boolean isRainingToday(){
        return true;
    }
}
