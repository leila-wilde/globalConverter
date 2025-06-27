import conversion.*;
import encryption.EncryptionManager;
import validation.InputValidator;
import validation.StringUtils;
import localisation.LocalisationManager;

import java.util.Map;
import java.util.Scanner;

public class GlobalConverter {
    // Map short flags to converter instances
    private static final Map<String, BaseConverter> CONVERTERS = Map.of(
        "-h", new HexConverter(),
        "-o", new OctalConverter(),
        "-d", new DecimalConverter(),
        "-b", new BinaryConverter(),
        "-t", new TextConverter()
    );

    public static void main(String[] args) {
        LocalisationManager lm = new LocalisationManager();
        Scanner scanner = new Scanner(System.in);

        String baseFlag    = null;   // -h, -o, -d, -b, -t
        String text        = null;   // user input
        boolean doEncrypt  = false;
        boolean doDecrypt  = false;
        String algoName    = "caesar"; // encryption algorithm name
        int key            = 0;

        // 1) Parse arguments
        for (int i = 0; i < args.length; i++) {
            String a = args[i].trim();
            switch (a.toLowerCase()) {
                // Base flags or full names
                case "-h": case "-o": case "-d":
                case "-b": case "-t":
                case "hexadecimal": case "octal":
                case "decimal": case "binary":
                case "text":
                    baseFlag = InputValidator.normalizeBase(a);
                    break;

                // Encryption / Decryption flags
                case "-e": case "--encrypt":
                    doEncrypt = true;
                    break;
                case "-x": case "--decrypt":
                    doDecrypt = true;
                    break;

                // Encryption algorithm
                case "-a":
                case "--algorithm":
                    if (i + 1 < args.length) {
                        algoName = args[++i];
                    }
                    break;

                // Key
                case "-k":
                case "--key":
                    if (i + 1 < args.length) {
                        key = InputValidator.validateKey(args[++i]);
                    }
                    break;

                // Otherwise assume it's the quoted text
                default:
                    // strip surrounding quotes if present
                    text = a.replaceAll("^\"|\"$", "");
                    break;
            }
        }

        // 2) Prompt for missing base
        while (StringUtils.isNullOrEmpty(baseFlag)) {
            System.out.print(lm.getMessage("prompt.base"));
            try {
                baseFlag = InputValidator.normalizeBase(scanner.nextLine());
            } catch (IllegalArgumentException ex) {
                System.out.println(lm.getMessage("error.invalidBase")
                                   .replace("{0}", ex.getMessage()));
            }
        }

        // 3) Prompt for missing text
        while (StringUtils.isNullOrEmpty(text)) {
            System.out.print(lm.getMessage("prompt.string"));
            String line = scanner.nextLine();
            try {
                InputValidator.validateText(line);
                text = line;
            } catch (IllegalArgumentException ex) {
                System.out.println(lm.getMessage("error.invalidString")
                                   .replace("{0}", ex.getMessage()));
            }
        }

        // 4) Prompt for key if encryption/decryption requested but no key was given
        if ((doEncrypt || doDecrypt) && key == 0) {
            while (true) {
                System.out.print(lm.getMessage("prompt.key"));
                String kLine = scanner.nextLine();
                try {
                    key = InputValidator.validateKey(kLine);
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println(lm.getMessage("error.invalidKey")
                                       .replace("{0}", ex.getMessage()));
                }
            }
        }

        // 5) Perform encryption/decryption first in TEXT domain
        String working = text;
        if (doEncrypt || doDecrypt) {
            EncryptionManager em = new EncryptionManager(algoName);
            working = doEncrypt
                ? em.encrypt(working, key)
                : em.decrypt(working, key);
        }

        // 6) Convert to/from base
        BaseConverter converter = CONVERTERS.get(baseFlag);
        StringBuilder output = new StringBuilder();

        if ("-t".equals(baseFlag)) {
            // We're converting *from* a base *to* text
            // assume tokens are space-separated
            for (String token : working.split("\\s+")) {
                int ascii = converter.decode(token);
                output.append((char) ascii);
            }
        } else {
            // We're converting *to* the selected base
            for (char c : working.toCharArray()) {
                output.append(converter.encode((int) c))
                      .append(' ');
            }
        }

        // 7) Print result
        System.out.println(lm.getMessage("output.result")
                           .replace("{0}", output.toString().trim()));

        scanner.close();
    }
}