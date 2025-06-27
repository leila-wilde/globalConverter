package encryption;

import java.util.Locale;

/*
Chooses and implements cipher algorithm.
Currently only supports "caesar"; in future can add others.
*/
public class EncryptionManager {
    private final CipherAlgorithm algo;

    // Constructs an EncryptionManager for the named algorithm.
    public EncryptionManager(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Algorithm name cannot be null");
        }
        switch (name.toLowerCase(Locale.ROOT)) {
            case "caesar":
                this.algo = new CaesarCipher();
                break;
            // future cases:
            // case "algorithm": this.algo = new algorithm()); break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + name);
        }
    }

    // Encrypts the given text with the key
    public String encrypt(String text, int key) {
        return algo.encrypt(text, key);
    }

    // Decrypts the given text with the key
    public String decrypt(String text, int key) {
        return algo.decrypt(text, key);
    }
}
