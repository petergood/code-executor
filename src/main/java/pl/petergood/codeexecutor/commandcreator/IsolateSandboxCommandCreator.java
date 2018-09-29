package pl.petergood.codeexecutor.commandcreator;

import pl.petergood.codeexecutor.interactor.command.Command;

import java.util.ArrayList;

public class IsolateSandboxCommandCreator {
    public static Command initializeSandboxCommand(int boxId) {
        Command command = new Command("isolate");
        command
                .addArgument("--init")
                .addArgument(String.format("--box-id=%d", boxId));

        return command;
    }

    public static Command executeCommand(ArrayList<String> arguments, int boxId, Command commandToSandbox) {
        Command command = new Command("isolate");
        command.addArgument("--run");
        command.addArgument(String.format("--box-id=%d", boxId));

        for (String argument : arguments) {
            command.addArgument(argument);
        }

        command.addArgument("--");
        command.addArgument(commandToSandbox.getExecutableName());

        for (String argument : commandToSandbox.getArguments()) {
            command.addArgument(argument);
        }

        return command;
    }

    public static Command cleanupCommand(int boxId) {
        Command command = new Command("isolate");
        command.addArgument(String.format("--box-id=%d", boxId));
        command.addArgument("--cleanup");

        return command;
    }
}
