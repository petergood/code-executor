package pl.petergood.codeexecutor.program;

import pl.petergood.codeexecutor.Resource;
import pl.petergood.codeexecutor.compiler.Language;

public class ProgramSource {
    private Language language;
    private Resource sourceFile;

    public ProgramSource(Language language, Resource sourceFile) {
        this.language = language;
        this.sourceFile = sourceFile;
    }

    public Language getLanguage() {
        return language;
    }

    public Resource getSourceFile() {
        return sourceFile;
    }
}
