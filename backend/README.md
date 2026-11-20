# SimpleShop Spring Boot API
Java 21 / Spring Boot 3.3.6 / Spring Data JPA / H2. From this directory run `mvnw.cmd spring-boot:run` on Windows or `./mvnw spring-boot:run` on Unix. Requires internet on first run to download Maven and dependencies. You may instead run `mvn spring-boot:run` with Maven installed.

Admin seed credentials: `admin@simpleshop.local` / `Admin@12345` (demo only). Use environment variables `SIMPLESHOP_ADMIN_EMAIL` and `SIMPLESHOP_ADMIN_PASSWORD` to change them before first startup. Frontend Vite proxies `/api` to port 8080.

`application.properties` defaults to an in-memory H2 database. The `database/ecommerce.sql` file is optional MySQL DDL. For MySQL you also need a JDBC driver dependency.

Note: This module uses classroom-level in-memory bearer sessions, not a production authentication system.
