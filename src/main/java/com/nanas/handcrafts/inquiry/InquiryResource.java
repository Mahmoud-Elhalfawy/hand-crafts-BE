package com.nanas.handcrafts.inquiry;

import java.time.Instant;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/inquiries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InquiryResource {

    @POST
    public Response createInquiry(@Valid InquiryRequest request) {
        InquiryResponse response = new InquiryResponse(
            UUID.randomUUID().toString(),
            "received",
            "Thank you, " + request.name() + ". Nana's Hand Crafts will follow up about your request soon.",
            Instant.now()
        );

        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
