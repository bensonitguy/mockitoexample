package com.mockito;

import com.rest.news.FetchNewsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.rest.news.FetchNewsService;



@Path("/message")
public class MessageRestService {

    FetchNewsService fetchService = new FetchNewsService();

    @GET
    @Path("/news/{param}")
    public Response printMessage(@PathParam("param") String apiKey) {

        String result = fetchService.getTodaysNews(apiKey);

        return Response.status(200).entity(result).build();

    }

    @GET
    @Path("/test/{param}")

    public Response printMessage1(@PathParam("param") String message) {

        String result = "hello "+message+ ".This is "+fetchService.whoIsMyFriend();

        return Response.status(200).entity(result).build();

    }

}
