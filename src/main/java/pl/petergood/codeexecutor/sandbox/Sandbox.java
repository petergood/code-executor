package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.command.Command;

import java.io.IOException;
import java.util.ArrayList;

public interface Sandbox {
    void execute(ArrayList<String> arguments, Command command) throws IOException, InterruptedException;
    void cleanup() throws IOException, InterruptedException;
    void copyToSandbox(ArrayList<Resource> resources) throws IOException, InterruptedException;

    Interactor getInteractor();
}
