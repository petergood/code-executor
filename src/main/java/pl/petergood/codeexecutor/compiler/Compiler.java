package pl.petergood.codeexecutor.compiler;

import pl.petergood.codeexecutor.interactor.command.Command;
import pl.petergood.codeexecutor.program.Executable;
import pl.petergood.codeexecutor.program.ProgramSource;

import java.io.IOException;

public interface Compiler {
    String getCompilerExecutableName();
    Executable compile(ProgramSource programSource) throws IOException, InterruptedException, CompilationException;
    Command getProgramExecutionCommand();
}
