package com.codelabs.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/v1/product")
public class ProductResource {

    List<Product> products = new ArrayList<>();

    /**
     * GET API to return list of products
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response.ok(products).build();
    }

    
}
