package com.github.DemidEinherjar.tepb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.DemidEinherjar.tepb.command.CommandName.STOP;
import static com.github.DemidEinherjar.tepb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
