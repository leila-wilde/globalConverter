import java.ui.OutputFormatter;

public class Main {
    static void main(String[] args) {
        OutputFormatter formatter = new OutputFormatter("en");
        System.out.println(formatter.getMessage("welcome.message"));
    }
}