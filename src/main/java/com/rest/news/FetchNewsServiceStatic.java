package com.rest.news;


import com.rest.helper.URLFetch;

public class FetchNewsServiceStatic {

    public String getResponseFromStaticFunction(){
        //apikey = 1e1541fe894d423ea58d74b9d519704c

        String response = URLFetch.getResponse("https://newsapi.org/v2/top-headlines?country=in&apiKey=1e1541fe894d423ea58d74b9d519704c");
        return response;

    }

}
