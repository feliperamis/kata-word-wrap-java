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
}
