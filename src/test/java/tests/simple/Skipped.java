package tests.simple;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Tag("empty")
public class Skipped {
    @Test
    @Disabled
    void test0() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test01() {
        assertTrue(true);
    }

    @Test
    @Disabled("With some reason")
    void test2() {
        assertTrue(true);
    }
}
