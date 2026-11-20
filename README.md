# SimpleShop · 7-member team project

## Merge the modules
Each member's ZIP preserves paths relative to the repository root. Extract **all seven** ZIP files into the same empty `SimpleShop/` repository folder (not seven nested folders). Each ZIP owns unique files. The root should contain `frontend/`, `backend/`, `database/`, `.gitignore`, and this README.

## Run
1. Install Java 21, Node.js 20+, npm. Internet is required on first install.
2. Backend: `cd backend` then Windows `mvnw.cmd spring-boot:run` or macOS/Linux `./mvnw spring-boot:run` (alternatively `mvn spring-boot:run` if Maven is installed). API runs on http://localhost:8080.
3. Frontend: `cd frontend` then `npm install` and `npm run dev`. Visit http://localhost:5173.
4. M1 should commit the updated `frontend/package-lock.json` after `npm install` (starter lockfile is incomplete until dependency resolution).

## Demo account
On first startup, seeded administrator: `admin@simpleshop.local` / `Admin@12345`. **Change these before any real deployment.** Customer accounts register in the UI.

## Database
Default: H2 in-memory demo database, auto-created by JPA. Restart resets demo data. Optional MySQL schema: `database/ecommerce.sql`. To use MySQL, configure `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`, `SPRING_JPA_HIBERNATE_DDL_AUTO=validate` (and add the MySQL JDBC dependency if needed). The provided SQL is an optional MySQL reference, not required for the H2 demo.

## API overview
GET `/api/products`, GET `/api/categories`, POST `/api/users/register`, POST `/api/users/login`, POST `/api/orders` (Bearer token), GET `/api/orders/my`, GET `/api/dashboard` (admin). Admin endpoints require a bearer token for product/category writes, dashboard, users and order management.

## Security scope
This is a **classroom demo**, not production-ready. Sessions are stored in memory (lost on restart), there is no rate limiting, CSRF strategy, payment integration, token expiry, or production-grade concurrent stock locking. Do not deploy publicly or use real customer data without a security review.

## Ownership
M1 frontend setup/shared components; M2 shopping; M3 customer accounts; M4 admin UI; M5 product/category APIs; M6 user/order APIs; M7 backend foundation/database/integration. Each member should work in their own Git branch, push that branch, and open a pull request. The team leader merges after review.
