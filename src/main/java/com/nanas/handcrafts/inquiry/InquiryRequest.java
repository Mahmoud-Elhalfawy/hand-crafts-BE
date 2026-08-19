package com.nanas.handcrafts.inquiry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InquiryRequest(
    @NotBlank(message = "Name is required")
    @Size(max = 120, message = "Name must be 120 characters or fewer")
    String name,

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Size(max = 160, message = "Email must be 160 characters or fewer")
    String email,

    @Size(max = 120, message = "Phone must be 120 characters or fewer")
    String phone,

    @Size(max = 160, message = "Interested product must be 160 characters or fewer")
    String interestedProduct,

    @NotBlank(message = "Message is required")
    @Size(min = 10, max = 1200, message = "Message must be between 10 and 1200 characters")
    String message
) {
}
