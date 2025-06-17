import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



@ParameterizedTest
@CsvSource({
        "2, 3, 5",
        "0, 0, 0",
        "-1, -2, -3",
        "10, -5, 5"
})
void testAddMultipleInputs(int a, int b, int expected) {
        CalculatorService service = new CalculatorService(new MathHelper());
        assertEquals(expected, service.add(a, b));
        }
