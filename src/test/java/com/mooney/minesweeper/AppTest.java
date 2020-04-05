package com.mooney.minesweeper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void sampleTest() {
        var version = new Version("a", "b");

        assertEquals("a", version.javaVersion());
        assertEquals("b", version.jfxVersion());
    }
}
