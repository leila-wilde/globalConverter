package conversion;

public class HexConverter implements BaseConverter {
    private static final char[] DIGITS = "0123456789ABCDEF".toCharArray();

    @Override
    public String encode(int ascii) {
        // build two-digit hex
        int hi = ascii / 16, lo = ascii % 16;
        return "" + DIGITS[hi] + DIGITS[lo];
    }

    @Override
    public int decode(String token) throws NumberFormatException {
        if (token.length() != 2) {
            throw new NumberFormatException("Hex token must be 2 chars");
        }
        int hi = Character.digit(token.charAt(0), 16);
        int lo = Character.digit(token.charAt(1), 16);
        if (hi < 0 || lo < 0) throw new NumberFormatException("Invalid hex digit");
        return hi * 16 + lo;
    }
}
