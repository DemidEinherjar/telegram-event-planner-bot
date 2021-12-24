package com.github.DemidEinherjar.tepb.service;

// Service fot sending messages via TelegramBot
public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
}
