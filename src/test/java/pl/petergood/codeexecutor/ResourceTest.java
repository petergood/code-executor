package pl.petergood.codeexecutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResourceTest {

    @Test
    public void Should_ReturnResourceDirectory_When_GivenRelativePath() {
        Resource resource = new Resource("this/is/a/test/test.txt");

        assertEquals("this/is/a/test/", resource.getDirectoryPath());
    }

    @Test
    public void Should_ReturnResourceDirectory_When_GivenAbsolutePath() {
        Resource resource = new Resource("/this/is/a/test/test.txt");

        assertEquals("/this/is/a/test/", resource.getDirectoryPath());
    }
}
