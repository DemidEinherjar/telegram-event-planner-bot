package com.github.DemidEinherjar.tepb.command;

import com.github.DemidEinherjar.tepb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String START_MESSAGE = "Привет! Я Telegram Bot, который будет напомниать тебе о предстоящих "
            + "событиях. Меня еще разрабатывают, поэтому я мало что умею. Если хочешь подсказать с идеей развития, "
            + "то напиши моему создателю tg: @demid88";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}