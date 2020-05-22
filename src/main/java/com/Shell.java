package com;

import java.util.ArrayList;
import java.util.List;

public class Shell {
    private List<Command> commands = new ArrayList<>();

    public Command getCommand(String commandName) {
        for (Command command : commands) {
            if (command.getCommand().equals(commandName)) {
                return command;
            }
        }
        return null;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

}