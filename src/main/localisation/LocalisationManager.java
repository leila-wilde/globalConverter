package localisation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class LocalisationManager {
    private ResourceBundle messages;

    public LocalisationManager() {
        // Get the default system locale
        Locale locale = Locale.getDefault();
        loadMessages(locale);
    }

    public LocalisationManager(Locale locale) {
        loadMessages(locale);
    }

    private void loadMessages(Locale locale) {
        try {
            messages = ResourceBundle.getBundle("messages", locale);
        } catch (MissingResourceException e) {
            // Fallback to English if the specific locale resource is not found
            messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
        }
    }

    public String getMessage(String key) {
        try {
            return messages.getString(key);
        } catch (MissingResourceException e) {
            // Handle the case where the key is not found
            System.err.println("Missing resource for key: " + key);
            return "Missing resource for key: " + key;
        }
    }
}