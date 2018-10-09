package pl.petergood.codeexecutor.program;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.interactor.command.Command;

public interface Executable {
    Resource getExecutableResource();
    Command getExecutionCommand();
}
