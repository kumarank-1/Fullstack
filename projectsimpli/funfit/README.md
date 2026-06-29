# Funfit

Funfit is a Java Enterprise web application for managing Zumba batches and participants. It uses Servlets, JSP, JDBC, MySQL, Maven, and a DAO/repository structure.

## Project Structure

- `src/main/java/com/funfit/model` - `Batch` and `Participant` model classes
- `src/main/java/com/funfit/dao` - DAO contracts
- `src/main/java/com/funfit/dao/impl` - JDBC DAO implementations
- `src/main/java/com/funfit/repository` - repository classes used by servlets
- `src/main/java/com/funfit/servlet` - participant and batch servlets
- `src/main/resources/schema.sql` - MySQL database and table script
- `src/main/resources/db.properties` - local JDBC configuration
- `src/main/webapp` - HTML, JSP, CSS, and web deployment files

## Database Setup

1. Open MySQL.
2. Run `src/main/resources/schema.sql`.
3. Update `src/main/resources/db.properties` if your MySQL username or password is different.

Default configuration:

```properties
db.url=jdbc:mysql://localhost:3306/funfit?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
db.username=root
db.password=root
```

## Build

```bash
mvn clean package
```

The web archive is created at:

```text
target/funfit.war
```

Deploy `target/funfit.war` to Apache Tomcat 9 or another servlet container that supports `javax.servlet`.

## Eclipse

Import the folder as an existing Maven project. The Eclipse WTP metadata is included so it can be used as a Dynamic Web Project with the context root `funfit`.

## Main URLs

- `/funfit/` - welcome/navigation page
- `/funfit/batches` - list batches
- `/funfit/participants` - list participants
- `/funfit/participants?batchId=1` - list participants in one batch
- `/funfit/add-batch.html` - add batch
- `/funfit/add-participant.html` - add participant
- `/funfit/update-batch.html` - update batch
- `/funfit/update-participant.html` - update participant
