package encryption;

/*
Implements the Caesar cipher:
 - shifts A–Z or a–z by the given key (mod 26)
 - leaves all other characters (spaces, digits, punctuation) unchanged
*/
public class CaesarCipher implements CipherAlgorithm {
    @Override
    public String encrypt(String plain, int key) {
        // Normalize key to range [0..25]
        int shift = key % 26;
        StringBuilder out = new StringBuilder(plain.length());

        for (char c : plain.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // Uppercase letter: shift within 'A'..'Z'
                int orig = c - 'A';
                int shifted = (orig + shift + 26) % 26; // +26 ensures non-negative
                out.append((char)('A' + shifted));
            }
            else if (c >= 'a' && c <= 'z') {
                // Lowercase letter: shift within 'a'..'z'
                int orig = c - 'a';
                int shifted = (orig + shift + 26) % 26;
                out.append((char)('a' + shifted));
            }
            else {
                // Non-alphabetic: leave unchanged
                out.append(c);
            }
        }
        return out.toString();
    }

    @Override
    public String decrypt(String cipher, int key) {
        // Decryption is just encryption with the negative shift
        return encrypt(cipher, -key);
    }
}
