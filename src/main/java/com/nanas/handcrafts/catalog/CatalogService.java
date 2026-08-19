package com.nanas.handcrafts.catalog;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatalogService {

    private final List<Product> products = List.of(
        new Product(
            "cozy-baby-blanket",
            "Cozy Baby Blanket",
            "Baby Gifts",
            "A soft crochet blanket made for newborn gifts, stroller walks, and nursery keepsakes.",
            "Custom quote",
            "Folded handmade crochet baby blanket in soft neutral yarn",
            true,
            List.of("blanket", "baby", "gift")
        ),
        new Product(
            "amigurumi-keepsake",
            "Amigurumi Keepsake Toy",
            "Amigurumi",
            "A made-to-order crochet character or animal designed as a playful handmade keepsake.",
            "Custom quote",
            "Small crochet amigurumi toy with stitched details",
            true,
            List.of("toy", "custom", "keepsake")
        ),
        new Product(
            "textured-throw-pillow",
            "Textured Throw Pillow",
            "Home Decor",
            "A decorative crochet pillow cover that adds texture and warmth to a favorite room.",
            "Custom quote",
            "Square crochet pillow with raised stitch texture",
            true,
            List.of("home", "decor", "pillow")
        ),
        new Product(
            "market-tote",
            "Market Tote",
            "Accessories",
            "A sturdy crochet tote for errands, yarn shopping, beach days, or everyday use.",
            "Custom quote",
            "Reusable crochet tote bag with long handles",
            true,
            List.of("bag", "accessory", "reusable")
        ),
        new Product(
            "flower-coasters",
            "Flower Coaster Set",
            "Home Decor",
            "A sweet set of crochet coasters inspired by petals, tea time, and handmade hosting.",
            "Custom quote",
            "Set of floral crochet coasters arranged on a table",
            true,
            List.of("coasters", "floral", "table")
        ),
        new Product(
            "crochet-headband",
            "Crochet Headband",
            "Accessories",
            "A soft everyday headband that can be customized by color, width, and yarn texture.",
            "Custom quote",
            "Crochet headband in a soft blush yarn",
            true,
            List.of("wearable", "accessory", "custom")
        )
    );

    public List<Product> findAll(Optional<String> category) {
        return category
            .map(this::normalise)
            .map(selectedCategory -> products.stream()
                .filter(product -> normalise(product.category()).equals(selectedCategory))
                .toList())
            .orElse(products);
    }

    public Optional<Product> findById(String id) {
        String selectedId = normalise(id);
        return products.stream()
            .filter(product -> normalise(product.id()).equals(selectedId))
            .findFirst();
    }

    public List<String> categories() {
        return products.stream()
            .map(Product::category)
            .distinct()
            .sorted(Comparator.naturalOrder())
            .toList();
    }

    private String normalise(String value) {
        return value.toLowerCase(Locale.ROOT).trim();
    }
}
