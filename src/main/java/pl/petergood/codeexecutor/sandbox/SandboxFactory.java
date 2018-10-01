package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.interactor.Interactor;

public interface SandboxFactory {
    Sandbox createSandbox(String instanceId) throws SandboxException;
}
