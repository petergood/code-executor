package pl.petergood.codeexecutor.commandcreator;

import org.junit.Test;
import pl.petergood.codeexecutor.interactor.command.Command;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CppCommandCreatorTest {
    @Test
    public void Should_ReturnCommandToCompileSource() {
        Command compilationCommand = CppCompilerCommandCreator.compilationCommand("test.cpp", "test");

        ArrayList<String> expectedArguments = new ArrayList<>();
        expectedArguments.add("test.cpp");
        expectedArguments.add("-o");
        expectedArguments.add("test");

        assertEquals("g++", compilationCommand.getExecutableName());
        assertEquals(expectedArguments, compilationCommand.getArguments());
    }
}
