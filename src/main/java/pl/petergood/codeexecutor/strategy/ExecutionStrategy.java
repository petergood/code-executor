package pl.petergood.codeexecutor.strategy;

import pl.petergood.codeexecutor.TestCase;
import pl.petergood.codeexecutor.compiler.CompilationException;
import pl.petergood.codeexecutor.compiler.Compiler;
import pl.petergood.codeexecutor.compiler.CompilerFactory;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.command.Command;
import pl.petergood.codeexecutor.program.Executable;
import pl.petergood.codeexecutor.program.ProgramSource;
import pl.petergood.codeexecutor.sandbox.Sandbox;

import java.io.IOException;
import java.util.ArrayList;

public class ExecutionStrategy extends AbstractStrategy {
    public ExecutionStrategy(Interactor interactor, Sandbox sandbox, ProgramSource programSource) {
        super(interactor, sandbox, programSource);
    }

    @Override
    public void execute() throws IOException, InterruptedException, CompilationException {
        for (TestCase testCase : getTestCases()) {
            getSandbox().copyToSandbox(testCase.getInputResource());
        }

        Compiler compiler = CompilerFactory.create(getProgramSource().getLanguage(), getInteractor());
        Executable executable = compiler.compile(getProgramSource());
        getSandbox().copyToSandbox(executable.getExecutableResource());

        for (TestCase testCase : getTestCases()) {
            ArrayList<String> args = new ArrayList<>();
            getSandbox().execute(new ArrayList<>(), executable.getExecutionCommand());
        }
    }
}
