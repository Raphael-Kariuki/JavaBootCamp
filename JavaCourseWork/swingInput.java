import javax.swing.*;

public class swingInput {
    public static void main(String[] args) {
        String temp;

        temp = JOptionPane.showInputDialog(null, "Enter first value");
        int a = Integer.parseInt(temp);

        JOptionPane.showMessageDialog(null, a, "Entered value ", a);
    }
}
