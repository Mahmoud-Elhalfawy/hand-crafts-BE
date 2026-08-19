package com.nanas.handcrafts.brand;

import java.util.List;

public record BrandInfo(
    String name,
    String tagline,
    String description,
    String story,
    List<String> values,
    List<String> contactChannels
) {
}
