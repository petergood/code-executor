package pl.petergood.codeexecutor.interactor.command;

import java.util.ArrayList;

public class Command {
    private String executableName;
    private ArrayList<String> arguments = new ArrayList<>();

    public Command(String executableName) {
        this.executableName = executableName;
    }

    public void addArgument(String argument) {
        arguments.add(argument);
    }

    public String getExecutableName() {
        return executableName;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }
}
