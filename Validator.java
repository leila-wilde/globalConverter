public class Validator {
    public static boolean isValidString(String str) {
        return str.matches("[a-zA-Z0-9 ]+");
    }

    public static boolean isValidBase(String base) {
        return base.equalsIgnoreCase("hexadecimal") || base.equalsIgnoreCase("-h") ||
               base.equalsIgnoreCase("binary")      || base.equalsIgnoreCase("-b") ||
               base.equalsIgnoreCase("octal")       || base.equalsIgnoreCase("-o") ||
               base.equalsIgnoreCase("decimal")     || base.equalsIgnoreCase("-d") ||
               base.equalsIgnoreCase("text")        || base.equalsIgnoreCase("-t");
    }
}