package pl.petergood.codeexecutor;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResourceTest {

    @Test
    public void Should_ReturnFullPath() {
        Resource resource = new Resource("/this/is/a/test", "test.txt");

        assertEquals("/this/is/a/test/test.txt", resource.getFullPath());
    }

    @Test
    public void Should_ReturnFullPath_When_TrailingSlashIsPresent() {
        Resource resource = new Resource("/this/is/a/test/", "test.txt");

        assertEquals("/this/is/a/test/test.txt", resource.getFullPath());
    }
}
