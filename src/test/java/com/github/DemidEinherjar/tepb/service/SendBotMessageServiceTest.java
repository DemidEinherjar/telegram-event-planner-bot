package com.github.DemidEinherjar.tepb.service;

import com.github.DemidEinherjar.tepb.bot.EventPlannerTelegramBot;
import com.github.DemidEinherjar.tepb.service.SendBotMessageService;
import com.github.DemidEinherjar.tepb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private EventPlannerTelegramBot eventPlannerTelegramBot;

    @BeforeEach
    public void init() {
        eventPlannerTelegramBot = Mockito.mock(EventPlannerTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(eventPlannerTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(eventPlannerTelegramBot).execute(sendMessage);
    }
}
