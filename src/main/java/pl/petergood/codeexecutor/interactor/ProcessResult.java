package pl.petergood.codeexecutor.interactor;

public class ProcessResult {
    private int exitCode;
    private ProcessOutputStreams processOutputStreams;

    public ProcessResult(int exitCode, ProcessOutputStreams processOutputStreams) {
        this.exitCode = exitCode;
        this.processOutputStreams = processOutputStreams;
    }

    public int getExitCode() {
        return exitCode;
    }

    public ProcessOutputStreams getOutput() {
        return this.processOutputStreams;
    }
}
