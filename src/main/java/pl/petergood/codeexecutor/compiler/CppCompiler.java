package pl.petergood.codeexecutor.compiler;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.commandcreator.CppCompilerCommandCreator;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.ProcessResult;
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
    public Executable compile(ProgramSource programSource) throws IOException, InterruptedException, CompilationException {
        Command compilationCommand = CppCompilerCommandCreator.compilationCommand(
                programSource.getSourceFile().getPath(),
                programSource.getSourceFile().getDirectoryPath() + "out"
        );

        ProcessResult compilationResult = getInteractor().executeSync(compilationCommand);
        String compilationErrorMessage = compilationResult.getOutput().getStdErr();

        if (compilationErrorMessage.length() > 0)
            throw new CompilationException(compilationErrorMessage);

        return new Executable(new Resource(programSource.getSourceFile().getDirectoryPath() + "out"), getProgramExecutionCommand());
    }
}
