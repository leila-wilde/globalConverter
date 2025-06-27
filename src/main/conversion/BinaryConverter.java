// BinaryConverter.java
package conversion;
public class BinaryConverter implements BaseConverter {
    @Override
    public String encode(int ascii) {
        char[] bits = new char[8];
        for (int i = 7; i >= 0; i--) {
            bits[i] = (ascii % 2 == 0 ? '0' : '1');
            ascii /= 2;
        }
        return new String(bits);
    }
    @Override
    public int decode(String token) {
        if (token.length() != 8)
            throw new NumberFormatException("Binary token must be 8 bits");
        int val = 0;
        for (char c : token.toCharArray()) {
            val <<= 1;
            if (c == '1') val |= 1;
            else if (c != '0') throw new NumberFormatException("Bad bit: " + c);
        }
        return val;
    }
}
