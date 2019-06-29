package MySolutions.SOLID.dependency_inversion.bad.spec;

import MySolutions.SOLID.dependency_inversion.bad.src.Phone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/8/14.
 */
public class PhoneTest {
    @Test
    public void testGeneratesAlertString() {
        Phone phone = new Phone();
        assertEquals("It is rainy", phone.generateWeatherAlert("rainy"));
    }
}
