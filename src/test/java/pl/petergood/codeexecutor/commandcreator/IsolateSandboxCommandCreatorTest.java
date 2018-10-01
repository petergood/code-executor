package pl.petergood.codeexecutor.commandcreator;

import org.junit.Test;
import static org.junit.Assert.*;

import pl.petergood.codeexecutor.interactor.command.Command;

import java.util.ArrayList;

public class IsolateSandboxCommandCreatorTest {

    @Test
    public void Should_CreateCommandToInitializeSandbox() {
        Command command = IsolateSandboxCommandCreator.initializeSandboxCommand("1");
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--init");
        arguments.add("--box-id=1");

        assertEquals(arguments, command.getArguments());
    }

    @Test
    public void Should_CreateCommandToRunSandboxedCommand() {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--wall-time=1");
        Command sandboxedCommand = new Command("ls");
        sandboxedCommand.addArgument("-a");
        Command executionCommand = IsolateSandboxCommandCreator.executeCommand(arguments, "1", sandboxedCommand);

        ArrayList<String> expectedArguments = new ArrayList<>();
        expectedArguments.add("--run");
        expectedArguments.add("--box-id=1");
        expectedArguments.add("--wall-time=1");
        expectedArguments.add("--");
        expectedArguments.add("ls");
        expectedArguments.add("-a");

        assertEquals(expectedArguments, executionCommand.getArguments());
    }

    @Test
    public void Should_CreateCommandToCleanupSandbox() {
        Command cleanupCommand = IsolateSandboxCommandCreator.cleanupCommand("1");

        ArrayList<String> expectedArguments = new ArrayList<>();
        expectedArguments.add("--box-id=1");
        expectedArguments.add("--cleanup");

        assertEquals(expectedArguments, cleanupCommand.getArguments());
    }
}
