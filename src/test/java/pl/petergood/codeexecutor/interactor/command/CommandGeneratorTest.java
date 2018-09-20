package pl.petergood.codeexecutor.interactor.command;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CommandGeneratorTest {

    @Test
    public void Should_ReturnCommandAsString_When_GivenCommand() {
        Command command = new Command("ls");
        command.addArgument("-a");
        command.addArgument("/etc");
        CommandGenerator commandGenerator = new CommandGenerator(command);

        assertEquals("ls -a /etc", commandGenerator.createCommandAsString());
    }

    @Test
    public void Should_ReturnCommandAsArray_When_GivenCommand() {
        Command command = new Command("ls");
        command.addArgument("-a");
        command.addArgument("/etc");
        CommandGenerator commandGenerator = new CommandGenerator(command);

        ArrayList<String> expectedArray = new ArrayList<>();
        expectedArray.add("ls");
        expectedArray.add("-a");
        expectedArray.add("/etc");

        assertEquals(expectedArray, commandGenerator.createCommandAsArray());
    }
}
