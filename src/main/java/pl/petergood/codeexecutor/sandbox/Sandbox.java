package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.command.Command;

import java.io.IOException;
import java.util.ArrayList;

public interface Sandbox {
    void initialize() throws IOException, InterruptedException;
    void execute(ArrayList<String> arguments, Command command) throws IOException, InterruptedException;
    void cleanup() throws IOException, InterruptedException;

    Interactor getInteractor();
}
