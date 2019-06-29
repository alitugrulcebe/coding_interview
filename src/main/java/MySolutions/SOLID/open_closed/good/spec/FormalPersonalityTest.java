package MySolutions.SOLID.open_closed.good.spec;

import MySolutions.SOLID.open_closed.good.src.FormalPersonality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/7/14.
 */
public class FormalPersonalityTest {
    @Test
    public void testGreetsSomeoneFormally() {
        FormalPersonality fp = new FormalPersonality();
        assertEquals("Good evening, sir.", fp.greet());
    }
}
