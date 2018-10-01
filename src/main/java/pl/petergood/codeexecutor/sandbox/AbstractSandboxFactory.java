package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.interactor.Interactor;

public abstract class AbstractSandboxFactory implements SandboxFactory {
    private Interactor interactor;

    public AbstractSandboxFactory(Interactor interactor) {
        this.interactor = interactor;
    }

    public Interactor getInteractor() {
        return this.interactor;
    }
}
