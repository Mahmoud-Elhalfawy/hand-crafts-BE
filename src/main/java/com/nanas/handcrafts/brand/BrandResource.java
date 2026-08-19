package com.nanas.handcrafts.brand;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/brand")
@Produces(MediaType.APPLICATION_JSON)
public class BrandResource {

    @GET
    public BrandInfo getBrand() {
        return new BrandInfo(
            "Nana's Hand Crafts",
            "Crocheted with love",
            "Handmade crochet pieces designed for cozy homes, thoughtful gifts, and everyday warmth.",
            "Nana's Hand Crafts celebrates slow-made crochet work: soft textures, gentle colors, and personal details in every stitch.",
            List.of("Handmade quality", "Custom keepsakes", "Soft, cozy design", "Made with care"),
            List.of("Custom orders", "Product inquiries", "Gift requests")
        );
    }
}
