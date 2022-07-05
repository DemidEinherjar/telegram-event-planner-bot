FROM openjdk:oraclelinux8
EXPOSE 8080

ENV BOT_NAME=bot_name
ENV BOT_TOKEN=bot_token
ENV BOT_DB_USERNAME=tepb_db_user
ENV BOT_DB_PASSWORD=tepb_db_password

COPY target/telegram-event-planner-bot.jar app/telegram-event-planner-bot.jar

ENTRYPOINT ["java","-Dspring.datasource.username=${BOT_DB_USERNAME}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "telegram-event-planner-bot.jar"]
