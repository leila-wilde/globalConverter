package java.converter;

public class OctalConverter {

    // Convert a decimal number to octal
    public String decimalToOctal(int decimal) {
        // implement conversion logic
        return Integer.toOctalString(decimal); // Placeholder
    }

    // Convert an octal number to decimal
    public int octalToDecimal(String octal) {
        // implement conversion logic
        return Integer.parseInt(octal, 8); // Placeholder
    }
}
