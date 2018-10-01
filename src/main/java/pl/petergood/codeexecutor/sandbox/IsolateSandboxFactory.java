package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.commandcreator.IsolateSandboxCommandCreator;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.interactor.ProcessResult;

import java.io.IOException;

public class IsolateSandboxFactory extends AbstractSandboxFactory {

    public IsolateSandboxFactory(Interactor interactor) {
        super(interactor);
    }

    private String parseIsolateInitializationResult(ProcessResult processResult) throws SandboxException {
        if (processResult.getStdOut().charAt(0) != '/')
            throw new SandboxException(processResult.getStdOut());

        return processResult.getStdOut();
    }

    @Override
    public Sandbox createSandbox(String instanceId) throws SandboxException {
        try {
            ProcessResult initializationResult = getInteractor().executeSync(IsolateSandboxCommandCreator.initializeSandboxCommand(instanceId));
            String sandboxPath = parseIsolateInitializationResult(initializationResult);

            SandboxConfiguration sandboxConfiguration = new SandboxConfiguration();
            sandboxConfiguration.setSandboxId(instanceId);
            sandboxConfiguration.setSandboxPath(sandboxPath);

            return new IsolateSandbox(getInteractor(), sandboxConfiguration);
        } catch (IOException | InterruptedException e) {
            throw new SandboxException("Initialization error");
        }
    }
}
