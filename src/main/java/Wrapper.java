

public class Wrapper {
    Wrapper() {
      // An useless constructor
    }

    public String helloWorld() {
        return "Hello world - Word wrap";
    }

    public String getWrapText(String text, int wrap) {

        if (wrap < 0) {
            throw new RuntimeException("Invalid wrap number");
        }

        return "Lorem ipsu\n" +
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
    }

}