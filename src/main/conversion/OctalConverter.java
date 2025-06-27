// OctalConverter.java
package conversion;
public class OctalConverter implements BaseConverter {
    @Override
    public String encode(int ascii) {
        // produce up to 3 octal digits
        int a = ascii;
        char c2 = (char)('0' + (a % 8)); a /= 8;
        char c1 = (char)('0' + (a % 8)); a /= 8;
        char c0 = (char)('0' + (a % 8));
        return "" + c0 + c1 + c2;
    }
    @Override
    public int decode(String token) {
        if (token.length() != 3) 
            throw new NumberFormatException("Octal token must be 3 chars");
        int val = 0;
        for (char c : token.toCharArray()) {
            int d = c - '0';
            if (d < 0 || d > 7) throw new NumberFormatException("Bad octal digit");
            val = val * 8 + d;
        }
        return val;
    }
}
