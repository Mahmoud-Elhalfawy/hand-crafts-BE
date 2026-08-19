package com.nanas.handcrafts.inquiry;

import java.time.Instant;

public record InquiryResponse(
    String id,
    String status,
    String message,
    Instant receivedAt
) {
}
