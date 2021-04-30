import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class WordWrapServiceTest {
    private static WordWrapService wordWrapService;

    @BeforeAll
    public static void setup() {
        wordWrapService = new WordWrapService();
    }


    @Test
    public void returnHelloWorld() {
        String helloMessage = wordWrapService.helloWorld();
        Assertions.assertEquals(helloMessage, "Hello world - Word wrap");
    }

    @Test
    public void returnWrapTextInTenCharacters() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String result = wordWrapService.getWrapText(text);

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
}
