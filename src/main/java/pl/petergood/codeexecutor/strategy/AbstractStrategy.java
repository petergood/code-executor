package pl.petergood.codeexecutor.strategy;

import pl.petergood.codeexecutor.TestCase;
import pl.petergood.codeexecutor.interactor.Interactor;
import pl.petergood.codeexecutor.program.ProgramSource;
import pl.petergood.codeexecutor.sandbox.Sandbox;

import java.util.ArrayList;

public abstract class AbstractStrategy implements Strategy {
    private ArrayList<TestCase> testCases = new ArrayList<>();
    private ProgramSource programSource;

    private Interactor interactor;
    private Sandbox sandbox;

    public AbstractStrategy(Interactor interactor, Sandbox sandbox, ProgramSource programSource) {
        this.programSource = programSource;
        this.interactor = interactor;
        this.sandbox = sandbox;
    }

    @Override
    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }

    @Override
    public void addTestCases(ArrayList<TestCase> testCases) {
        for (TestCase testCase : testCases) {
            addTestCase(testCase);
        }
    }

    public ArrayList<TestCase> getTestCases() {
        return testCases;
    }

    public ProgramSource getProgramSource() {
        return programSource;
    }

    public Interactor getInteractor() {
        return interactor;
    }

    public Sandbox getSandbox() {
        return sandbox;
    }
}
