package pl.petergood.codeexecutor.interactor;

public class ProcessResult {
    private int exitCode;
    private String stdOut;

    public ProcessResult(int exitCode, String stdOut) {
        this.exitCode = exitCode;
        this.stdOut = stdOut;
    }

    public int getExitCode() {
        return exitCode;
    }

    public String getStdOut() {
        return stdOut;
    }
}
