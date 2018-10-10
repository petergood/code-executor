package pl.petergood.codeexecutor.strategy;

import pl.petergood.codeexecutor.TestCase;

import java.util.ArrayList;

public interface Strategy {
    void addTestCase(TestCase testCase);
    void addTestCases(ArrayList<TestCase> testCases);

    void execute();
}
