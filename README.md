# Nana's Hand Crafts Backend

Quarkus API for the Nana's Hand Crafts crochet brand website.

## Tech stack

- Java 21
- Quarkus
- Quarkus REST + Jackson
- Hibernate Validator
- SmallRye Health

## Run locally

```bash
./mvnw quarkus:dev
```

The API runs on `http://localhost:8080` by default.

## Configuration

| Variable | Default | Description |
| --- | --- | --- |
| `PORT` | `8080` | HTTP port used by Quarkus |
| `CORS_ALLOWED_ORIGINS` | `http://localhost:5173,http://127.0.0.1:5173` | Comma-separated frontend origins |
| `STOREFRONT_ASSET_BASE_URL` | `http://localhost:5173` | Frontend domain used to turn `/products/...` image paths into absolute URLs |

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/api/brand` | Brand name, tagline, story, values, and contact channels |
| `GET` | `/api/products` | Starter product catalog; accepts optional `?category=` |
| `GET` | `/api/products/{id}` | Single product by id |
| `GET` | `/api/categories` | Product category list |
| `POST` | `/api/inquiries` | Capture custom order/product inquiry requests |
| `GET` | `/health` | Health endpoint |

Product data is currently seeded in `CatalogService` so it is easy to replace once product photos, prices, and descriptions are available.

Product images are served by the frontend from `public/products`. By default the API returns absolute local frontend URLs such as `http://localhost:5173/products/granny-square-shoulder-bag.svg`. Set `STOREFRONT_ASSET_BASE_URL` to the deployed React storefront domain in production.

## Verify

```bash
./mvnw test
```
