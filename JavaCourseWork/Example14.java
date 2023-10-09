public class Example14 {
    public static void main(String[] args) {
        System.out.println("Euro to Malta Liri Conversion Table");

        for (int eur  = 1; eur < 101; eur++) {
            System.out.println(eur + " Euro : " + (eur * 0.43) + " Lm");
        }
    }
}
