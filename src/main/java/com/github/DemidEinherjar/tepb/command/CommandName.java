package com.github.DemidEinherjar.tepb.command;

// Enumerate of commands
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("NoCommand");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
