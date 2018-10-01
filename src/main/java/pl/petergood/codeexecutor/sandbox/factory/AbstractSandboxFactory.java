package pl.petergood.codeexecutor.sandbox.factory;

import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.sandbox.factory.SandboxFactory;

public abstract class AbstractSandboxFactory implements SandboxFactory {
    private Interactor interactor;

    public AbstractSandboxFactory(Interactor interactor) {
        this.interactor = interactor;
    }

    public Interactor getInteractor() {
        return this.interactor;
    }
}
