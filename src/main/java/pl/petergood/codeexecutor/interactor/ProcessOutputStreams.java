package pl.petergood.codeexecutor.interactor;

public class ProcessOutputStreams {
    private String stdOut;
    private String stdErr;

    public ProcessOutputStreams(String stdOut, String stdErr) {
        this.stdOut = stdOut;
        this.stdErr = stdErr;
    }

    public String getStdOut() {
        return stdOut;
    }

    public String getStdErr() {
        return stdErr;
    }
}
