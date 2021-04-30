import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WrapperTest {

    private static Wrapper wrapper;

    @BeforeAll
    public static void setup() {
        wrapper = new Wrapper();
    }


    @Test
    public void returnHelloWorld() {
        String helloMessage = wrapper.helloWorld();
        Assertions.assertEquals(helloMessage, "Hello world - Word wrap");
    }

    @Test
    public void returnWrapTextInTenCharacters() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String result = wrapper.getWrapText(text, 10);

        String expected = "Lorem ipsu\n" +
                "m dolor si\n" +
                "t amet, c\n" +
                "onsectetur\n" +
                "adipiscing\n" +
                "elit, sed d\n" +
                "o eiusmod\n" +
                "tempor inc\n" +
                "ididunt ut\n" +
                "labore et \n" +
                "dolore mag \n" +
                "na aliqua.";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void returnWrapTextInSevenCharacters() {
        String text = "Lorem ipsum dolor sit";
        String result = wrapper.getWrapText(text, 7);

        String expected = "Lorem i\n" +
                "psum do\n" +
                "lor sit";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void returnExceptionWhenWrapHasNegativeNumber() {
        String text = "Lorem ipsum dolor sit";

        Exception result = Assertions.assertThrows(
                Exception.class,
                () -> wrapper.getWrapText(text, -2)
        );

        Assertions.assertEquals("Invalid wrap number", result.getMessage());
    }
}
