package pl.petergood.codeexecutor.compiler;

import org.junit.Test;
import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.ProcessOutputStreams;
import pl.petergood.codeexecutor.interactor.ProcessResult;
import pl.petergood.codeexecutor.interactor.command.Command;
import pl.petergood.codeexecutor.program.Executable;
import pl.petergood.codeexecutor.program.ProgramSource;

import java.io.IOException;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class CppCompilerTest {

    @Test
    public void Should_CreateExecutableResource_When_GivenSource() throws IOException, InterruptedException, CompilationException {
        Interactor mockedInteractor = mock(Interactor.class);
        when(mockedInteractor.executeSync(any(Command.class))).thenReturn(new ProcessResult(0,
                new ProcessOutputStreams("", "")));

        ProgramSource source = new ProgramSource(Language.CPP, new Resource("/var", "test.cpp"));
        Compiler compiler = CompilerFactory.create(Language.CPP, mockedInteractor);

        Executable executable = compiler.compile(source);

        assertEquals("/var/out", executable.getExecutableResource().getFullPath());
    }

    @Test(expected = CompilationException.class)
    public void Should_ThrowException_When_CompilationErrorOccurs() throws IOException, InterruptedException, CompilationException {
        Interactor mockedInteractor = mock(Interactor.class);
        when(mockedInteractor.executeSync(any(Command.class))).thenReturn(new ProcessResult(0,
                new ProcessOutputStreams("", "Compilation error.")));

        ProgramSource source = new ProgramSource(Language.CPP, new Resource("/var", "test.cpp"));
        Compiler compiler = CompilerFactory.create(Language.CPP, mockedInteractor);

        Executable executable = compiler.compile(source);
    }
}
