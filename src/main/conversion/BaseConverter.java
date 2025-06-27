package conversion;

public interface BaseConverter {
    // Convert a single ASCII code (0–127) to the target base
    String encode(int ascii);

    // Parse a single token in this base back to its ASCII code
    int decode(String token) throws NumberFormatException;
}
