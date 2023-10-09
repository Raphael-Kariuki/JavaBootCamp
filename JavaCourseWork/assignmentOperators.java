public class assignmentOperators {
    public static void main(String[] args) {
        int a = 12;

        for (int count = 0; count < 1; count++) {
            System.out.println("a++\t" + (a++));
            System.out.println("a--\t" + (a--));
            System.out.println("a+=\t" + (a += 2));
            System.out.println("a-=\t" + (a -= 1));
            System.out.println("a*=\t" + (a *= 2));
            
        }

    }
}
