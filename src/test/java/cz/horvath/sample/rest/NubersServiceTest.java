package cz.horvath.sample.rest;

import cz.horvath.sample.rest.service.NumberService;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class NubersServiceTest {

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {43256791, 11331545},
            {56, 56},
            {8, 16},
            {0, 0},
            {4, 4},
            {5379, 5318},
            {2753698, 6407954}
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testSomeMethod(long input, long expected) {
        NumberService ns = new NumberService();
        long result = ns.scramble(input);
        assertEquals(expected, result);
    }

}
