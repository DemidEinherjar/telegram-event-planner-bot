package com.github.DemidEinherjar.tepb.service;

import com.github.DemidEinherjar.tepb.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

// {@link Service} for handling {@link TelegramUser} entity.
public interface TelegramUserService {

    // Save new tgUser
    void save(TelegramUser telegramUser);

    // List of active users
    List<TelegramUser> retrieveAllActiveUsers();

    // Find user by chatId
    Optional<TelegramUser> findByChatId(String chatId);
}