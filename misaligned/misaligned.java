import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Misaligned {

    static String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
    static String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};

    static int printColorMap() {
        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.printf("%d | %s | %s\n", i * 5 + j, majorColors[i], minorColors[i]);
            }
        }
        return i * j;
    }


    static void printexpectedColorMap() {

        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                System.out.printf("%d | %10s | %10s\n", (i * 5 + j)+1, majorColors[i], minorColors[i]);
            }
        }
    }

    public static void main(String[] args) {
        int result = printColorMap();
        assert(result == 25);

        // Create a stream to hold the actual output
        ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        PrintStream actualPrintStream = new PrintStream(actualOutputStream);

        // Create a stream to hold the expected output
        ByteArrayOutputStream expectedOutputStream = new ByteArrayOutputStream();
        PrintStream expectedPrintStream = new PrintStream(expectedOutputStream);

        PrintStream oldPrintStream  = System.out;
        System.setOut(actualPrintStream);
        printColorMap();

        System.out.flush();
        System.setOut(expectedPrintStream);
        printexpectedColorMap();

        System.out.flush();
        System.setOut(oldPrintStream);

        System.out.println("actual: \n" + actualOutputStream.toString());
        System.out.println("expected: \n" + expectedOutputStream.toString());

        assert(actualOutputStream.toString()==expectedOutputStream.toString());

        System.out.println("All is well (maybe!)");
    }


}