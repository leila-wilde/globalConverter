package conversion;

public class TextConverter implements BaseConverter {
    @Override
    public String encode(int ascii) {
        return Character.toString((char) ascii);
    }
    @Override
    public int decode(String token) {
        if (token.length() != 1) {
            throw new IllegalArgumentException("Text token must be one character");
        }
        return token.charAt(0);
    }
}
