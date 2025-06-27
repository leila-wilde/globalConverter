package validation;

import java.util.regex.Pattern;

public final class StringUtils {
  private StringUtils() { /* no-op */ }

  public static boolean isNullOrEmpty(String str) {
    return str == null || str.trim().isEmpty();
  }

  public static String trim(String str) {
    return str == null ? null : str.trim();
  }

  private static final Pattern ALPHANUMERIC_SPACE =
    Pattern.compile("^[A-Za-z0-9 ]+$");

  // return true if str is non-null and only letters, digits or space
  public static boolean isAlphanumericSpace(String str) {
    return str != null && ALPHANUMERIC_SPACE.matcher(str).matches();
  }
}
