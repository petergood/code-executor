package pl.petergood.codeexecutor.sandbox.factory;

import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.sandbox.Sandbox;
import pl.petergood.codeexecutor.sandbox.SandboxException;

public interface SandboxFactory {
    Sandbox createSandbox(String instanceId) throws SandboxException;
}
