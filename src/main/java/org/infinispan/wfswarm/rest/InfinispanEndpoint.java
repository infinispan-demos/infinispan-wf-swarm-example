package org.infinispan.wfswarm.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.infinispan.Cache;

@Path("/infinispan")
@ApplicationScoped
public class InfinispanEndpoint {

   @Inject
   Cache<String, String> cache;

   @GET
   @Path("cache")
   public Response printContent() {
      return Response.ok(cache.keySet().toString()).build();
   }

   @POST
   @Path("cache")
   public Response addSomethingToTheCache(String text) {
      cache.put(text, text);
      return Response.created(null).build();
   }
}