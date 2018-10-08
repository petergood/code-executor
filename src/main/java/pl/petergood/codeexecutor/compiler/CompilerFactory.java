package pl.petergood.codeexecutor.compiler;

import pl.petergood.codeexecutor.interactor.Interactor;

public class CompilerFactory {

    public static Compiler create(Language language, Interactor interactor) throws CompilationException {
        switch (language) {
            case CPP:
                return new CppCompiler(interactor);
            default:
                throw new CompilationException();
        }
    }
}
