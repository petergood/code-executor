package pl.petergood.codeexecutor.interactor;

import pl.petergood.codeexecutor.interactor.command.Command;

import java.io.IOException;

public interface Interactor {
    ProcessResult executeSync(Command command) throws IOException, InterruptedException;
}
