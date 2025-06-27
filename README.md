# Global Converter

![Java](https://img.shields.io/badge/Java-17-blue)
![Console](https://img.shields.io/badge/Platform-Console-brightgreen)
![License](https://img.shields.io/badge/License-GPLv3-blue.svg)

A Java console application that allows users to convert text strings into various bases (hexadecimal, octal, decimal, binary, or text) and optionally encrypt or decrypt them.

## ✨ Key Features
- **Convert strings**: Convert to and from five different bases: hexadecimal, octal, decimal, binary, and text.
- **Encryption**: Support for encryption and decryption using Caesar cipher with a user-defined key.
- **Language Support**: English or French depending on user system locale.
- **User-friendly**: Command-line interface that accepts both full words and shorthand flags.
- **Input validation**: Ensures only valid bases, commands, and characters are processed.
- **Software Design**: Extensible architecture for future enhancements, including additional encryption algorithms and localization support.
 

## 🛠️ Technical Implementation
- **Core Java**: The application is built using Java, following object-oriented principles.
- **Modular Design**: The code is organized into packages for conversion, encryption, validation and localization functions.
- **Custom Conversion Logic**: Manual conversion routines are implemented for each base without relying on built-in Java methods.
- **Caesar Cipher**: A simple encryption algorithm is implemented for reversible data transformation.

## 🚀 How to Compile & Use
1. Clone the repository
2. Ensure you have Java installed and properly configured in your environment to run the application.
3. Create an output directory
From globalConverter/ run:
```bash
mkdir -p out
```
4. Compile all `.java`files: 
From globalConverter/ run:
``` bash
javac -d out $(find src/main -name "*.java")
```
4. Copy the resource bundles
``` bash
cp src/resources/messages_*.properties out/

```
5. Run GlobalConverter application
``` bash
java -cp out GlobalConverter -h "Hello world"
```
3. Optionally, encryption using caesar cipher by specifying a key using `-k` or `key` followed an valid integer. 

4. The application will validate the input and display the converted output.

All together in one line:
``` bash
mkdir -p out \
  && javac -d out $(find src/main -name "*.java") \
  && cp src/resources/messages_*.properties out/ \
  && java -cp out GlobalConverter -h "Hello world"
```

### Future upgrades
- **additional encryption algorithms**: possibility to specify an encryption action `-a` and choice of cipher such as `"caesar"` before the key
- **additional languages**

## 📋 Sample Conversions
- Convert to hexadecimal:
``` bash
java GlobalConverter -h "Hello world"
48 65 6C 6C 6F 20 57 6F 72 6C 64
```
- Convert to binary:
``` bash
java -cp out GlobalConverter -b "Hello World"
Result: 01001000 01100101 01101100 01101100 01101111 00100000 01010111 01101111 01110010 01101100 01100100
```
- - Convert to decimal:
``` bash
java -cp out GlobalConverter octal "Hello World"
Result: 110 145 154 154 157 040 127 157 162 154 144
```

## 📬 Contact
**Developers**: Leila.Wilde & Djacem Mmadani

**Email**: [leila.wilde@laplateforme.com](mailto:leila.wilde@laplateforme.com) | [djacem.madani@laplateforme.com](mailto:djacem.madani@laplateforme.io)

**LinkedIn**: [Leila Wilde](https://www.linkedin.com/in/leila-wilde/) | [Djacem Madani](https://www.linkedin.com/in/djacem-madani-18913733b/)

## License
GNU GPL License - See [LICENSE](LICENSE) for details

Developed to practice Java fundamentals