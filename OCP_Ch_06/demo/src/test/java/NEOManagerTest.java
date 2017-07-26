import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NEOManagerTest {
    @Test
    public void simpleEquals() {
        String a = "a";
        String b = "a";

        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertEquals(a.hashCode(), b.hashCode());
    }
}