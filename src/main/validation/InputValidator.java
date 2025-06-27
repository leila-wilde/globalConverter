package validation;

// Top-level validation for command-line parameters
public final class InputValidator {
  private InputValidator() { /* no-op */ }
  // Normalise a base (either full word or short flag).
  // return the short-flag form (e.g. "-h")
  public static String normalizeBase(String raw) {
    Base base = Base.from(raw);
    return base.getFlag();
  }

  // Validate that text is non-empty and only A–Z, a–z, 0–9 or space
  public static void validateText(String text) {
    if (StringUtils.isNullOrEmpty(text)) {
      throw new IllegalArgumentException("Input cannot be empty");
    }
    if (!StringUtils.isAlphanumericSpace(text)) {
      throw new IllegalArgumentException(
        "Only alphanumeric characters and spaces are allowed");
    }
  }

  // Normalise encrypt/decrypt flag - return -e or -d
  public static String normalizeEncryptFlag(String raw) {
    if (StringUtils.isNullOrEmpty(raw)) {
      throw new IllegalArgumentException("Encrypt flag cannot be empty");
    }
    switch(raw.trim().toLowerCase()) {
      case "-e":
      case "--encrypt":
        return "-e";
      case "-d":
      case "--decrypt":
        return "-d";
      default:
        throw new IllegalArgumentException("Unknown flag: " + raw);
    }
  }

  // Validate & parse a numeric key (must be integer ≥ 0)
  public static int validateKey(String raw) {
    if (StringUtils.isNullOrEmpty(raw)) {
      throw new IllegalArgumentException("Key cannot be empty");
    }
    try {
      int k = Integer.parseInt(raw.trim());
      if (k < 0) {
        throw new IllegalArgumentException("Key must be non‐negative");
      }
      return k;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Key must be an integer: " + raw);
    }
  }
}
