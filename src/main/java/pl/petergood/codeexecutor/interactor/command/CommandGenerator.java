package pl.petergood.codeexecutor.interactor.command;

import java.util.ArrayList;

public class CommandGenerator {
    private Command command;

    public CommandGenerator(Command command) {
        this.command = command;
    }

    public String createCommandAsString() {
        StringBuilder commandStringBuilder = new StringBuilder();
        commandStringBuilder.append(this.command.getExecutableName()).append(" ");

        for (String argument : this.command.getArguments()) {
            commandStringBuilder.append(argument).append(" ");
        }

        commandStringBuilder.deleteCharAt(commandStringBuilder.length() - 1);

        return commandStringBuilder.toString();
    }

    public ArrayList<String> createCommandAsArray() {
        ArrayList<String> commandArray = new ArrayList<>();
        commandArray.add(this.command.getExecutableName());

        for (String argument : this.command.getArguments()) {
            commandArray.add(argument);
        }

        return commandArray;
    }
}
