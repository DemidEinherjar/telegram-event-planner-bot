package com.github.DemidEinherjar.tepb.command;

import com.github.DemidEinherjar.tepb.repository.entity.TelegramUser;
import com.github.DemidEinherjar.tepb.service.SendBotMessageService;
import com.github.DemidEinherjar.tepb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String START_MESSAGE = "Привет! Я Telegram Bot, который будет напомниать тебе о предстоящих "
            + "событиях. Меня еще разрабатывают, поэтому я мало что умею. Если хочешь подсказать как меня можно улучшить, "
            + "то напиши моему создателю tg: @demid88";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {
                    user.setActive(true);
                    telegramUserService.save(user);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setActive(true);
                    telegramUser.setChatId(chatId);
                    telegramUserService.save(telegramUser);
                });
        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}