package pl.petergood.codeexecutor.commandcreator;

import pl.petergood.codeexecutor.interactor.command.Command;

public class CppCompilerCommandCreator {
    public static Command compilationCommand(String inputFile, String outputFile) {
        Command command = new Command("g++");
        command.addArgument(inputFile);
        command.addArgument("-o");
        command.addArgument(outputFile);

        return command;
    }
}
