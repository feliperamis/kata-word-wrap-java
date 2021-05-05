import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WrapperTest {

    private static Wrapper wrapper;

    @BeforeAll
    static void setup() {
        wrapper = new Wrapper();
    }

    @Test
    void returnHelloWorld() {
        String helloMessage = wrapper.helloWorld();
        Assertions.assertEquals(helloMessage, "Hello world - Word wrap");
    }

    @Test
    void returnWrapTextInTenCharacters() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String expected = "Lorem ipsu\n" +
                "m dolor si\n" +
                "t amet, co\n" +
                "nsectetur \n" +
                "adipiscing\n" +
                " elit, sed\n" +
                " do eiusmo\n" +
                "d tempor i\n" +
                "ncididunt \n" +
                "ut labore \n" +
                "et dolore \n" +
                "magna aliq\n" +
                "ua.";

        String result = wrapper.getWrapText(text, 10);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void returnWrapTextInSevenCharacters() {
        String text = "Lorem ipsum dolor sit";
        String expected = "Lorem i\n" +
                "psum do\n" +
                "lor sit";

        String result = wrapper.getWrapText(text, 7);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void returnWrapTextInSevenCharactersWithSmallText() {
        String text = "Lorem";
        String expected = "Lorem";

        String result = wrapper.getWrapText(text, 7);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void returnExceptionWhenWrapHasNegativeNumber() {
        String text = "Lorem ipsum dolor sit";

        Exception result = Assertions.assertThrows(
                Exception.class,
                () -> wrapper.getWrapText(text, -2)
        );

        Assertions.assertEquals("Invalid wrap number", result.getMessage());
    }

    @Test
    void returnWrapTextInTenCharactersWithSoftLimit() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String expected = "Lorem ipsum\n" +
                "dolor sit \n" +
                "amet, consectetur\n" +
                "adipiscing\n" +
                "elit, sed \n" +
                "do eiusmod\n" +
                "tempor incididunt\n" +
                "ut labore \n" +
                "et dolore \n" +
                "magna aliqua.\n";

        String result = wrapper.getWrapTextByWord(text, 10);
        System.out.println("Result ->\n" + result);
        Assertions.assertEquals(expected, result);
    }
}