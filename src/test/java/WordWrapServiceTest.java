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
}
