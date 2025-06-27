// DecimalConverter.java
package conversion;
public class DecimalConverter implements BaseConverter {
    @Override
    public String encode(int ascii) {
        // build digits in reverse
        if (ascii == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int n = ascii;
        while (n > 0) {
            sb.append((char)('0' + (n % 10)));
            n /= 10;
        }
        return sb.reverse().toString();
    }
    @Override
    public int decode(String token) {
        if (token.isEmpty()) 
            throw new NumberFormatException("Empty decimal token");
        int val = 0;
        for (char c : token.toCharArray()) {
            if (c < '0' || c > '9')
                throw new NumberFormatException("Bad decimal digit: " + c);
            val = val * 10 + (c - '0');
        }
        return val;
    }
}
