package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.commandcreator.IsolateSandboxCommandCreator;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.command.Command;

import java.io.IOException;
import java.util.ArrayList;

public class IsolateSandbox extends AbstractSandbox {
    public IsolateSandbox(Interactor interactor, SandboxConfiguration sandboxConfiguration) {
        super(interactor, sandboxConfiguration);
    }

    @Override
    public void execute(ArrayList<String> arguments, Command command) throws IOException, InterruptedException {
        Command executionCommand = IsolateSandboxCommandCreator.executeCommand(arguments, getSandboxConfiguration().getSandboxId(), command);
        getInteractor().executeSync(executionCommand);
    }

    @Override
    public void cleanup() throws IOException, InterruptedException {
        Command cleanupCommand = IsolateSandboxCommandCreator.cleanupCommand(getSandboxConfiguration().getSandboxId());
        getInteractor().executeSync(cleanupCommand);
    }

    @Override
    public void copyToSandbox(ArrayList<Resource> resources) throws IOException, InterruptedException {
        for (Resource resource : resources) {
            Command copyCommand = new Command("cp");
            copyCommand.addArgument(resource.getPath());
            copyCommand.addArgument(getSandboxConfiguration().getSandboxPath());

            getInteractor().executeSync(copyCommand);
        }
    }
}
