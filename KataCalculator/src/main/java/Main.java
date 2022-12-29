import service.ConverterService;
import utils.CreateScanner;

import java.util.Locale;

public class Main {

    static ConverterService converter = new ConverterService();
    static int actionIndex = -1;

    public static void main(String[] args) {
        CreateScanner createScanner = new CreateScanner();

        String[] actions = {"\\+", "-", "/", "\\*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        int a, b;
        String[] data;
        boolean isRoman;

        System.out.print("Введите выражение: ");
        String expression = createScanner.getScanner().nextLine().toUpperCase(Locale.ROOT);

        for (int i = 0; i < actions.length; i++) {
            if (expression.contains(actions[i])) {
                actionIndex = i;
            }
        }

        try {
            data = expression.split(regexActions[actionIndex].trim());
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].trim();
            }

            if (data.length > 2) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("invalid input");
                }
            } else {
                isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }

                calculated(actions, a, b, isRoman);
            }
        } catch (Exception e) {
            System.out.println("BIG TRY - invalid input");
        }
    }

    static void calculated(String[] massAction, int a, int b, boolean isRoman) {
        int result = 0;

        if (a > 0 && a < 11 && b > 0 && b < 11) {
            switch (massAction[actionIndex]) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> result = a / b;
            }

            if (isRoman) {
                if (result != 0) {
                    System.out.println(converter.intToRoman(result));
                } else {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("no such roman number exists");
                    }
                }
            } else {
                System.out.println(result);
            }
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("range should be between [1-10] or [I-X]");
            }
        }
    }
}
