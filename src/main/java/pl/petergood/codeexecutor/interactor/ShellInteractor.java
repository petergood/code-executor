package pl.petergood.codeexecutor.interactor;

import pl.petergood.codeexecutor.interactor.command.Command;
import pl.petergood.codeexecutor.interactor.command.CommandGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellInteractor implements Interactor {
    private ProcessResult createProcessResult(Process process) throws IOException {
        BufferedReader bufferedOutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader bufferedErrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        StringBuilder stdOutBuilder = new StringBuilder();
        StringBuilder stdErrBuilder = new StringBuilder();

        while (bufferedOutReader.ready()) {
            stdOutBuilder.append((char) bufferedOutReader.read());
        }

        while (bufferedErrReader.ready()) {
            stdErrBuilder.append((char) bufferedErrReader.read());
        }

        return new ProcessResult(process.exitValue(),
                new ProcessOutputStreams(stdOutBuilder.toString(), stdErrBuilder.toString()));
    }

    @Override
    public ProcessResult executeSync(Command command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        CommandGenerator commandGenerator = new CommandGenerator(command);

        processBuilder.command(commandGenerator.createCommandAsArray());
        Process process = processBuilder.start();
        process.waitFor();

        return createProcessResult(process);
    }
}
