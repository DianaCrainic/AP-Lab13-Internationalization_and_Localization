package com;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Command {
    private String command;
    private String arg;

    public Command(String command){
        this.command = command;
    }

    public abstract String execute(Object ... args);

    public String toString(){
        return command + " " + arg;
    }

}
