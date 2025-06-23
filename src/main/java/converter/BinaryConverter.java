package java.converter;

public class BinaryConverter {

    // Convert a decimal number to binary
    public String decimalToBinary(int decimal) {
        // implement conversion logic
        return Integer.toBinaryString(decimal); // Placeholder
    }

    // Convert an binary number to decimal
    public int binaryToDecimal(String binary) {
        // implement conversion logic
        return Integer.parseInt(binary, 2); // Placeholder
    }
}
