package encryption;

// A simple cipher algorithm interface.
public interface CipherAlgorithm {
    // Encrypt the given plain text using the key
    String encrypt(String plain, int key);

    // Decrypt the given cipher text using the key
    String decrypt(String cipher, int key);
}
