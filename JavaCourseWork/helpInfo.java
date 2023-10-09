import java.io.IOException;

public class helpInfo {
    public static void main(String[] args) throws IOException {
        int x;

        x = System.in.read();

        switch (x) {
            case '1':
                System.out.println("The if:\n");
                System.out.println("if(condition) statement;");
                System.out.println("else statement;");
                break;
            case '2':
                System.out.println("The switch:\n");
                System.out.println("switch(expression) {");
                System.out.println(" case constant:");
                System.out.println(" statement sequence");
                System.out.println(" break;");
                System.out.println(" // ...");
                System.out.println("}");

            default:
                break;
        }
    }
}
