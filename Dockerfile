FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=pet_tepb_bot
ENV BOT_TOKEN=5084701414:AAFnSLV8W7q9GR5JXOOq3FwQpYlMYgVrbG4
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]
