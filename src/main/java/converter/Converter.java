package java.converter;

public class Converter {

    private HexConverter hexConverter;
    private DecimalConverter decimalConverter;
    private BinaryConverter binaryConverter;
    private TextConverter textConverter;
    private OctalConverter octalConverter;

    public Converter() {
        hexConverter = new HexConverter();
        decimalConverter = new DecimalConverter();
        binaryConverter = new BinaryConverter();
        textConverter = new TextConverter();
        octalConverter = new OctalConverter();
    }

    // Convert decimal to hexadecimal
    public String convertDecimalToHex(int decimal) {
        return hexConverter.decimalToHex(decimal);
    }

    // Convert hexadecimal to decimal
    public int convertHexToDecimal(String hex) {
        return hexConverter.hexToDecimal(hex);
    }

    // Convert binary to decimal
    public int convertBinaryToDecimal(String binary) {
        return binaryConverter.binaryToDecimal(binary);
    }

    // Convert decimal to binary
    public String convertDecimalToBinary(int decimal) {
        return binaryConverter.decimalToBinary(decimal);
    }

    // Convert decimal to octal
    public String convertDecimalToOctal(int decimal) {
        return octalConverter.decimalToOctal(decimal);
    }

    // Convert octal to decimal
    public int convertOctalToDecimal(String octal) {
        return octalConverter.octalToDecimal(octal);
    }

    // Convert text to hexadecimal
    public String convertTextToHex(String text) {
        return textConverter.textToHex(text);
    }

    // Convert hexadecimal to text
    public String convertHexToText(String hex) {
        return textConverter.hexToText(hex);
    }
}
