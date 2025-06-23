package java.converter;

public class TextConverter {

    // Convert a string to its ASCII values in hexadecimal
    public String textToHex(String text) {
        StringBuilder hex = new StringBuilder();
        for (char ch : text.toCharArray()) {
            hex.append(String.format("%02X", (int) ch));
        }
        return hex.toString();
    }

    // Convert hexadecimal ASCII values back to a string
    public String hexToText(String hex) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            text.append((char) Integer.parseInt(str, 16));
        }
        return text.toString();
    }
}