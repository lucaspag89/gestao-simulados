FROM adoptopenjdk/openjdk11

WORKDIR /app

ADD /exams.jar /app/exams.jar

ENTRYPOINT ["java", "-jar", "exams.jar"]