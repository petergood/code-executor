package pl.petergood.codeexecutor.strategy;

import pl.petergood.codeexecutor.TestCase;
import pl.petergood.codeexecutor.compiler.CompilationException;

import java.io.IOException;
import java.util.ArrayList;

public interface Strategy {
    void addTestCase(TestCase testCase);
    void addTestCases(ArrayList<TestCase> testCases);

    void execute() throws IOException, InterruptedException, CompilationException;
}
