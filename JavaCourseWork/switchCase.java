import java.io.IOException;

public class switchCase {
    public static void main(String[] args) throws IOException {
        char input = (char) System.in.read();

        switch (input) {
            case 'K':
                System.out.println("Yes");
                break;
            case 'L':
                System.out.println("Yeah");
                break;
            
            default:
                System.out.println("Meeh " + input);
                break;
        }
    }
}
