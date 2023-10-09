public class logicalOperators {
    public static void main(String args[]) {
        int a = 10;
        int b = 2;

        if (a != 0) {
            System.out.println("a is not equal to 0");
        }
        if ((a != 0) & (b % a == 0) ) {
            System.out.println("b is a factor of a");
        }
        boolean P,Q;
        P = true;Q = false;
        System.out.println("P\tQ\tPANDQ\tPORQ\tPSANDQ\tPSORQ\tPXORQ\tPNOTQ\n");
        System.out.println("True\tFalse\t" + (P&Q) + "\t" + (P|Q) + "\t" + (P&&Q) + "\t" + (P||Q) + "\t" + (P^Q) + "\t" + (P!=Q) + "\n");
        P = false;Q = true;
        System.out.println("False\tTrue\t" + (P&Q) + "\t" + (P|Q) + "\t" + (P&&Q) + "\t" + (P||Q) + "\t"+ (P^Q) + "\t" + (P!=Q) + "\n");
        P = false;Q = false;
        System.out.println("False\tFalse\t" + (P&Q) + "\t" + (P|Q) + "\t" + (P&&Q) + "\t" + (P||Q) + "\t"+ (P^Q) + "\t" + (P!=Q) + "\n");
        P = true;Q = true;
        System.out.println("True\tTrue\t" + (P&Q) + "\t" + (P|Q) + "\t" + (P&&Q) + "\t" + (P||Q) + "\t"+  (P^Q) + "\t"+ (P!=Q) + "\n");
   
        
    }
}
