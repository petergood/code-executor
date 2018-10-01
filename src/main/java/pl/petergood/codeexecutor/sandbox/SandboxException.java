package pl.petergood.codeexecutor.sandbox;

public class SandboxException extends Exception {
    private String errorMessage;

    public SandboxException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
