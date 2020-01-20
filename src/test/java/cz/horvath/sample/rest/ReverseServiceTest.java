package cz.horvath.sample.rest;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 */
public class ReverseServiceTest {

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Ahoj, jak se máš?", "?šÁm es kaj ,jOha"},
            {"Je     mi   fajn.", ".NjaF iM ej"},
            {"", ""}
        });
    }

    /**
     * Test of reverseString method, of class ReverseService.
     *
     * @param input
     * @param expected
     */
    @ParameterizedTest
    @MethodSource("data")
    public void testReverseString(String input, String expected) {
        ReverseService instance = new ReverseService();
        String result = instance.reverseString(input);
        assertEquals(expected, result);
    }

}
