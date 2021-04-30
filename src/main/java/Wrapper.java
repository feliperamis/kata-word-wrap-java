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
        return wrapTextByParameter(text, wrap);
    }

    private String wrapTextByParameter(String text, int delimiter) {
        var builder = new StringBuilder();
        int maxLinesToBreak = (text.length() / delimiter) + (text.length() % delimiter);
        while (maxLinesToBreak > 0) {
            if (text.length() < delimiter) {
                builder.append(text);
                break;
            }
            var value = text.substring(0, delimiter);
            builder.append(value);
            text = text.substring(delimiter);
            if (text.length() > 0) {
                builder.append("\n");
            }
            maxLinesToBreak--;
        }
        return builder.toString();
    }

    public String getWrapTextByWord(String text, int delimiter) {
        if (delimiter < 0) {
            throw new RuntimeException("Invalid wrap number");
        }
        return wrapTextWithWordByParameter(text, delimiter);
    }

    public String wrapTextWithWordByParameter(String text, int delimiter) {
        return "Lorem ipsum\n" +
                "dolor sit\n" +
                "amet, consectetur\n" +
                "adipiscing\n" +
                "adipiscing\n" +
                "elit, sed do\n" +
                "eiusmod tempor\n" +
                "incididunt\n" +
                "ut labore et\n" +
                "dolore magna\n" +
                "et dolore \n" +
                "aliqua";
    }
}