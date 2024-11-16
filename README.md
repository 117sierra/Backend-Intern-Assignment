# Project Setup and API Design Documentation

## Steps to Setup

1. **Clone the Repository:**
   - Clone the repository and open it in IntelliJ IDEA.

2. **Build the Project:**
   - The code editor will automatically build the project and get it ready to run.

3. **MongoDB Configuration:**
   - In the `resources` folder, the `application.properties` file has the Mongo URI set to the localhost server.
   - You need to install MongoDB on your local machine or provide a suitable Mongo URI for the connection.

---

## API Design

### General Information
- The overall API design is available on **Swagger**.
- **Swagger URL**: `http://localhost:8080/swagger-ui/index.html` (accessible after running the application).

### Endpoints
1. **Unprotected Endpoints:**
   - `admin/v1/register`: Used for admin registration.
   - `user/v1/register`: Used for user registration.

2. **Protected Endpoints:**
   - Endpoints under `user/v1` can only be accessed by users with the **user role**.
   - Endpoints under `admin/v1` can only be accessed by users with the **admin role**.

---

## Notes

1. **Session Management:**
   - To switch between accessing user and admin endpoints, you must end the current session.
   - Use the `http://localhost:8080/logout` endpoint to log out before attempting to access endpoints of a different role.
   - Failing to log out will result in a **403 Forbidden Error** when using tools like Postman.

2. **Authentication:**
   - Use **Basic Auth** in Postman for authentication while accessing protected endpoints.
   - Login/Logout endpoint is automatically handled by springboot so there are no such endpoints in controller class of the application.
