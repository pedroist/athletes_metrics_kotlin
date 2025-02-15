# Athletes Metrics API

This is a Kotlin Spring Boot application that manages athlete metrics and performance data. The API provides endpoints to track, analyze, and manage athletic performance metrics.

## Technologies Used

- Kotlin
- Spring Boot
- Gradle
- JDK 17 or later
- Spring Data JPA
- PostgreSQL (as the database)

## Prerequisites

Before running the application, make sure you have the following installed:

- JDK 17 or later
- Gradle
- PostgreSQL

## Getting Started

1. Clone the repository:
```bash
git clone <repository-url>
cd athletes_metrics_kotlin
```

2. Configure the database:
   - Create a PostgreSQL database
   - Update the `application.properties` or `application.yml` file with your database credentials

3. Build the project:
```bash
./gradlew build
```

4. Run the application:
```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access the API documentation at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Development

To run tests:
```bash
./gradlew test
```

To build the project without running tests:
```bash
./gradlew build -x test
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 