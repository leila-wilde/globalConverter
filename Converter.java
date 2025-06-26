public class Converter {

    public String convert(String base, String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            int ascii = (int) c;
            String converted = switch (base.toLowerCase()) {
                case "hexadecimal", "-h" -> toBase(ascii, 16).toUpperCase();
                case "binary", "-b"      -> toBase(ascii, 2);
                case "octal", "-o"       -> toBase(ascii, 8);
                case "decimal", "-d"     -> Integer.toString(ascii);
                case "text", "-t"        -> Character.toString(c);
                default -> "Erreur";
            };
            result.append(converted).append(" ");
        }

        return result.toString().trim();
    }

    private String toBase(int number, int base) {
        String digits = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.insert(0, digits.charAt(number % base));
            number = number / base;
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}