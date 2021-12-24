package com.github.DemidEinherjar.tepb.command;

import org.telegram.telegrambots.meta.api.objects.Update;

//Command interface for handling telegram-bot commands.
public interface Command {
    void execute(Update update);
}
