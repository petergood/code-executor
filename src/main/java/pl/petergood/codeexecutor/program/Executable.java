package pl.petergood.codeexecutor.program;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.interactor.command.Command;

public class Executable {
    private Resource executableResource;
    private Command executionCommand;

    public Executable(Resource executableResource, Command executionCommand) {
        this.executableResource = executableResource;
        this.executionCommand = executionCommand;
    }

    public Resource getExecutableResource() {
        return executableResource;
    }

    public Command getExecutionCommand() {
        return executionCommand;
    }
}
