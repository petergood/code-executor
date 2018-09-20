package pl.petergood.codeexecutor.interactor;

import pl.petergood.codeexecutor.interactor.command.Command;
import pl.petergood.codeexecutor.interactor.command.CommandGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellInteractor implements Interactor {
    private ProcessResult createProcessResult(Process process) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder stdOutBuilder = new StringBuilder();

        while (bufferedReader.ready()) {
            stdOutBuilder.append((char) bufferedReader.read());
        }

        return new ProcessResult(process.exitValue(), stdOutBuilder.toString());
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
