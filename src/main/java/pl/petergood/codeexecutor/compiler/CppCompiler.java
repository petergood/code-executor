package pl.petergood.codeexecutor.compiler;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.command.Command;
import pl.petergood.codeexecutor.program.Executable;
import pl.petergood.codeexecutor.program.ProgramSource;

import java.io.IOException;

public class CppCompiler extends AbstractCompiler {
    private final String compilerExecutableName = "g++";

    public CppCompiler(Interactor interactor) {
        super(interactor);
    }

    @Override
    public String getCompilerExecutableName() {
        return this.compilerExecutableName;
    }

    @Override
    public Command getProgramExecutionCommand() {
        return new Command("./");
    }

    @Override
    public Executable compile(ProgramSource programSource) throws IOException, InterruptedException {
        Command compilationCommand = new Command(compilerExecutableName);
        compilationCommand.addArgument(programSource.getSourceFile().getPath());
        compilationCommand.addArgument("-o");
        compilationCommand.addArgument(programSource.getSourceFile().getDirectoryPath() + "out");

        getInteractor().executeSync(compilationCommand);

        return new Executable(new Resource(programSource.getSourceFile().getPath() + "out"), getProgramExecutionCommand());
    }
}
