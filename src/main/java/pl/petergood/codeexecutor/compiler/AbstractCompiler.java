package pl.petergood.codeexecutor.compiler;

import pl.petergood.codeexecutor.interactor.Interactor;

public abstract class AbstractCompiler implements Compiler {
    private Interactor interactor;

    public AbstractCompiler(Interactor interactor) {
        this.interactor = interactor;
    }

    public Interactor getInteractor() {
        return this.interactor;
    }
}
