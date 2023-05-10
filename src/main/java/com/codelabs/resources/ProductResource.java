package com.codelabs.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    /**
     * POST API to add new products
     * @param product
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        if(products.add(product)) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/{productId}")
    public Response updateProduct(@PathParam("productId") String productId, Product updatedProduct) {
        products = products.stream().map(product -> {
            if(product.getId().equals(productId)) {
                return updatedProduct;
            } else {
                return product;
            }
        }).collect(Collectors.toList());

        return Response.ok(products).build();
    }

    
}
