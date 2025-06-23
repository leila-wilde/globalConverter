import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class OutputFormatter {
    private Properties messages;

    public OutputFormatter(String language) {
        messages = new Properties();
        String resourceName = "messages_" + language + ".properties";
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + resourceName);
                return;
            }
            messages.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getMessage(String key, Object... args) {
        String message = messages.getProperty(key);
        if (args.length > 0) {
            message = String.format(message, args);
        }
        return message;
    }
}
