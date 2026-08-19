package com.nanas.handcrafts.catalog;

import java.util.List;
import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class CatalogResource {

    private final CatalogService catalogService;

    public CatalogResource(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GET
    @Path("/products")
    public List<Product> getProducts(@QueryParam("category") String category) {
        return catalogService.findAll(Optional.ofNullable(category).filter(value -> !value.isBlank()));
    }

    @GET
    @Path("/products/{id}")
    public Product getProduct(@PathParam("id") String id) {
        return catalogService.findById(id)
            .orElseThrow(() -> new NotFoundException("Product not found: " + id));
    }

    @GET
    @Path("/categories")
    public List<String> getCategories() {
        return catalogService.categories();
    }
}
