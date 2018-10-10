package pl.petergood.codeexecutor.strategy;

import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.program.ProgramSource;
import pl.petergood.codeexecutor.sandbox.Sandbox;

public class ExecutionStrategy extends AbstractStrategy {
    public ExecutionStrategy(Interactor interactor, Sandbox sandbox, ProgramSource programSource) {
        super(interactor, sandbox, programSource);
    }

    @Override
    public void execute() {
        
    }
}
