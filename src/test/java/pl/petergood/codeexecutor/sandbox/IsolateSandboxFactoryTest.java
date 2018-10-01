package pl.petergood.codeexecutor.sandbox;

import org.junit.Test;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.ProcessResult;
import pl.petergood.codeexecutor.interactor.command.Command;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class IsolateSandboxFactoryTest {

    @Test(expected = SandboxException.class)
    public void Should_ThrowException_When_PathIsNotReturned() throws IOException, InterruptedException, SandboxException {
        Interactor mockedInteractor = mock(Interactor.class);
        when(mockedInteractor.executeSync(any(Command.class))).thenReturn(new ProcessResult(0, "Box already exists."));

        IsolateSandboxFactory isolateSandboxFactory = new IsolateSandboxFactory(mockedInteractor);
        Sandbox sandbox = isolateSandboxFactory.createSandbox("1");
    }

    public void Should_CreateSandboxInstance() throws IOException, InterruptedException, SandboxException {
        Interactor mockedInteractor = mock(Interactor.class);
        when(mockedInteractor.executeSync(any(Command.class))).thenReturn(new ProcessResult(0, "/"));

        IsolateSandboxFactory isolateSandboxFactory = new IsolateSandboxFactory(mockedInteractor);
        Sandbox sandbox = isolateSandboxFactory.createSandbox("1");
    }
}
