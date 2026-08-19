package com.nanas.handcrafts.catalog;

import java.util.List;

public record Product(
    String id,
    String name,
    String category,
    String description,
    String startingPrice,
    String imageAlt,
    boolean customisable,
    List<String> tags
) {
}
