package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.example.service.CacheService;

@Path("/hello")
public class HelloWorldEndpoint {

   @javax.inject.Inject
   CacheService cacheService;

   @GET
   @Path("cache")
   public Response doGet() {
      return Response.ok(cacheService.getContent()).build();
   }

   @POST
   @Path("cache")
   public Response addSomethingToTheCache(String text) {
      cacheService.addToCache(text);
      return Response.created(null).build();
   }
}