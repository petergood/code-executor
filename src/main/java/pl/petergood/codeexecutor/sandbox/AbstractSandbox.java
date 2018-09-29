package pl.petergood.codeexecutor.sandbox;

import pl.petergood.codeexecutor.interactor.Interactor;

public abstract class AbstractSandbox implements Sandbox {
    private Interactor interactor;

    public AbstractSandbox(Interactor interactor) {
        this.interactor = interactor;
    }

    public Interactor getInteractor() {
        return this.interactor;
    }
}
