package pl.petergood.codeexecutor.program;

import pl.petergood.codeexecutor.Resource;

public abstract class AbstractExecutable implements Executable {
    private Resource executableResource;

    public AbstractExecutable(Resource executableResource) {
        this.executableResource = executableResource;
    }

    public Resource getExecutableResource() {
        return executableResource;
    }
}
