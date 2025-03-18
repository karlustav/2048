import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Valjak valjak = new Valjak();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(Arrays.deepToString(valjak.getValjak())); // prindi väljak
            if (valjak.checkGameOver()) {
                System.out.println("Mäng on läbi");
                System.out.println("Lõppskoor: " + skoor);
                System.exit(0); // lõpeta programmi töö
            }
            else {
                System.out.println("");
                String suund = scanner.nextLine();
            }
        }
    }
}
