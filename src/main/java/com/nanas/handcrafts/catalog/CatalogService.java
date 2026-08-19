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
            "granny-square-shoulder-bag",
            "Granny Square Shoulder Bag",
            "Bags",
            "A compact crochet shoulder bag with floral granny squares, a long strap, and button detail.",
            "Custom quote",
            "/products/granny-square-shoulder-bag.svg",
            "Model wearing a cream, dusty rose, and navy granny square crochet shoulder bag",
            true,
            List.of("bag", "granny square", "floral", "shoulder bag")
        ),
        new Product(
            "granny-square-sundress",
            "Granny Square Sundress",
            "Dresses",
            "A white sundress finished with a black and blue crochet granny square bodice.",
            "Custom quote",
            "/products/granny-square-sundress.svg",
            "White dress with black straps and a blue, white, and black granny square crochet bodice",
            true,
            List.of("dress", "granny square", "summer", "wearable")
        ),
        new Product(
            "open-stitch-bandana",
            "Open Stitch Crochet Bandana",
            "Bandanas",
            "A lightweight tie-back crochet bandana with an airy open stitch pattern and scalloped edge.",
            "Custom quote",
            "/products/open-stitch-bandana.svg",
            "Red open stitch crochet bandana worn as a hair scarf",
            true,
            List.of("bandana", "hair scarf", "red", "open stitch")
        ),
        new Product(
            "flower-granny-bandana",
            "Flower Granny Square Bandana",
            "Accessories",
            "A floral granny square bandana available in bright and neutral color combinations.",
            "Custom quote",
            "/products/flower-granny-bandana.svg",
            "Blue and white floral granny square crochet bandana worn over loose hair",
            true,
            List.of("bandana", "hair scarf", "granny square", "floral")
        ),
        new Product(
            "multi-color-granny-bandana",
            "Multi-Color Granny Bandana",
            "Bandanas",
            "A customizable granny square bandana made in colorways like blue, pink, green, yellow, purple, brown, black, orange, and teal.",
            "Custom quote",
            "/products/multi-color-granny-bandana.svg",
            "Grid of granny square crochet bandanas in multiple color options",
            true,
            List.of("bandana", "custom colors", "granny square", "floral")
        ),
        new Product(
            "tie-on-hip-scarf",
            "Tie-On Crochet Hip Scarf",
            "Wearables",
            "A triangular crochet hip scarf that ties at the waist for styling over jeans, skirts, or beachwear.",
            "Custom quote",
            "/products/tie-on-hip-scarf.svg",
            "Red triangular crochet hip scarf tied over black jeans",
            true,
            List.of("hip scarf", "belt", "red", "festival")
        ),
        new Product(
            "granny-square-crop-top",
            "Granny Square Crop Top",
            "Tops",
            "A fitted crochet crop top made from granny square panels with bold contrast straps and edging.",
            "Custom quote",
            "/products/granny-square-crop-top.svg",
            "Black, blue, and white granny square crochet crop top worn with a white skirt",
            true,
            List.of("top", "granny square", "wearable", "summer")
        ),
        new Product(
            "granny-square-pouch",
            "Granny Square Drawstring Pouch",
            "Bags",
            "A soft drawstring crochet pouch with floral granny square panels and scalloped edging.",
            "Custom quote",
            "/products/granny-square-pouch.svg",
            "Stack of cream granny square crochet pouches with brown, black, pink, and blue flowers",
            true,
            List.of("pouch", "bag", "drawstring", "granny square")
        ),
        new Product(
            "lace-triangle-scarf",
            "Lace Triangle Crochet Scarf",
            "Accessories",
            "A delicate open lace triangle scarf for layering around the neck or styling as a head covering.",
            "Custom quote",
            "/products/lace-triangle-scarf.svg",
            "Taupe lace triangle crochet scarf styled around the neck",
            true,
            List.of("scarf", "lace", "triangle scarf", "neutral")
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
