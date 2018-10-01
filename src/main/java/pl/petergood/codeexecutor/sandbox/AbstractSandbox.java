package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.interactor.Interactor;

public abstract class AbstractSandbox implements Sandbox {
    private Interactor interactor;
    private SandboxConfiguration sandboxConfiguration;

    public AbstractSandbox(Interactor interactor, SandboxConfiguration sandboxConfiguration) {
        this.interactor = interactor;
        this.sandboxConfiguration = sandboxConfiguration;
    }

    public Interactor getInteractor() {
        return this.interactor;
    }

    public SandboxConfiguration getSandboxConfiguration() {
        return this.sandboxConfiguration;
    }
}
