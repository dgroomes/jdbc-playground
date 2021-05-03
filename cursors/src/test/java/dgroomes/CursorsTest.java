package dgroomes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CursorsTest {

    private static DestinationVisitor app = new DestinationVisitor();

    @Test
    void test() throws Exception {
        var rows = app.visit();

        assertEquals(10, rows);
    }
}
