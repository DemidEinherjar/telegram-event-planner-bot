package com.github.DemidEinherjar.tepb.service;


import com.github.DemidEinherjar.tepb.bot.EventPlannerTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

// Implementation of SendBotMessageService interface
@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final EventPlannerTelegramBot eventPlannerTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(EventPlannerTelegramBot eventPlannerTelegramBot) {
        this.eventPlannerTelegramBot = eventPlannerTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            eventPlannerTelegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
