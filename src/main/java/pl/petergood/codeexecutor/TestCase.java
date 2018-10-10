package pl.petergood.codeexecutor;

public class TestCase {
    private Resource input;
    private Resource output;

    public TestCase(Resource input) {
        this.input = input;
    }

    public void setExpectedOutput(Resource output) {
        this.output = output;
    }

    public Resource getInput() {
        return input;
    }

    public Resource getOutput() {
        return output;
    }
}
