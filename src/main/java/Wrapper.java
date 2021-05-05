import java.util.Arrays;
import java.util.List;

public class Wrapper {

    private static final String BLANK = " ";

    Wrapper() {
        // An useless constructor
    }

    public String helloWorld() {
        return "Hello world - Word wrap";
    }

    public String getWrapText(String text, int wrap) {
        validateDelimiter(wrap);
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

    public String getWrapTextSoftLimit(String text, int delimiter) {
        validateDelimiter(delimiter);
        return wrapTextWithWordSoftLimit(text, delimiter);
    }

    private String wrapTextWithWordSoftLimit(String text, int delimiter) {
        List<String> listWords = Arrays.asList(text.split(BLANK));
        var builder = new StringBuilder();

        var aux = new StringBuilder();
        listWords.forEach(word -> softLimitWords(word, aux, delimiter, builder));
        if (aux.length() > 0) {
            builder.append(aux).append("\n");
        }
        return builder.toString();
    }

    private void softLimitWords(String word, StringBuilder aux, int delimiter, StringBuilder builder) {
        aux.append(word);
        if (aux.length() < delimiter) {
            aux.append(BLANK);
        }
        if (aux.length() >= delimiter) {
            builder.append(aux).append("\n");
            aux.delete(0, aux.length());
        }
    }

    public String getWrapTextHardLimit(String text, int delimiter) {
        validateDelimiter(delimiter);
        return wrapTextWithWordHardLimit(text, delimiter);
    }

    private String wrapTextWithWordHardLimit(String text, int delimiter) {
        List<String> listWords = Arrays.asList(text.split(BLANK));
        var builder = new StringBuilder();

        var aux = new StringBuilder();
        listWords.forEach(word -> hardLimitWords(word, aux, delimiter, builder));
        if (aux.length() > 0) {
            builder.append(aux).append("\n");
        }
        return builder.toString();
    }

    private void hardLimitWords(String word, StringBuilder aux, int delimiter, StringBuilder builder) {
        int sumWords = aux.length() + word.length();
        if (sumWords > delimiter) {
            builder.append(aux).append("\n");
            aux.delete(0, aux.length());
        }
        aux.append(word);
        if(aux.length() < delimiter) {
            aux.append(BLANK);
        }
        if (aux.length() >= delimiter) {
            builder.append(aux).append("\n");
            aux.delete(0, aux.length());
        }
    }

    private void validateDelimiter(int delimiter) {
        if (delimiter < 0) {
            throw new RuntimeException("Invalid wrap number");
        }
    }
}