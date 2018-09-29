package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.commandcreator.IsolateSandboxCommandCreator;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.command.Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class IsolateSandbox extends AbstractSandbox {
    private int boxId;

    public IsolateSandbox(Interactor interactor) {
        super(interactor);
    }

    @Override
    public void initialize() throws IOException, InterruptedException {
        this.boxId = new Random().nextInt();
        Command initializationCommand = IsolateSandboxCommandCreator.initializeSandboxCommand(boxId);

        getInteractor().executeSync(initializationCommand);
    }

    @Override
    public void execute(ArrayList<String> arguments, Command command) throws IOException, InterruptedException {
        Command executionCommand = IsolateSandboxCommandCreator.executeCommand(arguments, this.boxId, command);
        getInteractor().executeSync(executionCommand);
    }

    @Override
    public void cleanup() throws IOException, InterruptedException {
        Command cleanupCommand = IsolateSandboxCommandCreator.cleanupCommand(this.boxId);
        getInteractor().executeSync(cleanupCommand);
    }
}
