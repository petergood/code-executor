package pl.petergood.codeexecutor.program;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.interactor.command.Command;

public class CppExecutable extends AbstractExecutable {
    public CppExecutable(Resource executableResource) {
        super(executableResource);
    }

    @Override
    public Command getExecutionCommand() {
        return new Command(String.format("./%s", getExecutableResource().getPath()));
    }
}
