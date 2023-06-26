FROM maven AS build

COPY . /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean install

FROM openjdk

WORKDIR /app

COPY --from=build /usr/src/app/target/Develcode-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "Develcode-0.0.1-SNAPSHOT.jar"]
