public class GlobalConverter {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java GlobalConverter <base> <message> [-k key] [-a algorithm]");
            return;
        }

        String base = args[0];
        String message = args[1];
        String key = null;
        String algorithm = null;

        for (int i = 2; i < args.length; i++) {
            if (args[i].equals("key") || args[i].equals("-k")) {
                if (i + 1 < args.length) key = args[i + 1];
            } else if (args[i].equals("-a")) {
                if (i + 1 < args.length) algorithm = args[i + 1];
            }
        }

        if (!Validator.isValidBase(base)) {
            System.out.println("Base invalide. Bases possibles : hexadecimal, decimal, binary, octal, text.");
            return;
        }

        if (!Validator.isValidString(message)) {
            System.out.println("Chaîne invalide. Utilisez uniquement des lettres et/ou chiffres.");
            return;
        }

        if (key != null && algorithm != null && algorithm.equalsIgnoreCase("cesar")) {
            try {
                int shift = Integer.parseInt(key);
                message = CesarCipher.encrypt(message, shift);
            } catch (NumberFormatException e) {
                System.out.println("Clé de chiffrement invalide. Utilisez un nombre entier.");
                return;
            }
        }

        Converter converter = new Converter();
        String output = converter.convert(base, message);
        System.out.println(output);
    }
}