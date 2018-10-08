package pl.petergood.codeexecutor.compiler;

public class CompilationException extends Exception {
    private String errorMessage;

    public CompilationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
