package validation;

import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

public enum Base {
    HEX("hexadecimal", "-h"),
    OCT("octal", "-o"),
    DEC("decimal", "-d"),
    BIN("binary",  "-b"),
    TXT("text", "-t");

    private final String fullName;
    private final String flag;

    Base(String fullName, String flag) {
        this.fullName = fullName;
        this.flag     = flag;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFlag() {
        return flag;
    }

    // Accept either full name or short flag (case-insensitive)
    public static Base from(String raw) {
        if (StringUtils.isNullOrEmpty(raw)) {
            throw new IllegalArgumentException("Base cannot be empty");
        }
        String norm = raw.trim().toLowerCase(Locale.ROOT);

        Optional<Base> found = Arrays.stream(values())
            .filter(b -> b.flag.equals(norm) || b.fullName.equals(norm))
            .findFirst();

        return found.orElseThrow(() ->
            new IllegalArgumentException("Unknown base: " + raw));
    }
}
