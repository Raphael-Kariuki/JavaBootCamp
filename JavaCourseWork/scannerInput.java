import java.util.Scanner;

public class scannerInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value for a: ");
        int a = scanner.nextInt();
        System.out.println("Enter value for b: ");
        int b = scanner.nextInt();
        scanner.close();
        
        System.out.println("a * b: " + (a*b));

    }
}
