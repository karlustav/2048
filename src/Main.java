import org.w3c.dom.ls.LSOutput;



import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int skoor = 0;

    public static void main(String[] args) {
        Valjak valjak = new Valjak();
        // Valjak.printColorPreview();
        Scanner scanner = new Scanner(System.in);
        valjak.generateNewTile();
        while(true) {
            System.out.println(skoor);
            valjak.kasOnVoimalikLiita();
            if (valjak.checkGameOver()) {
                System.out.println("Mäng on läbi");
                System.out.println("Lõppskoor: " + skoor);
                System.exit(0); // lõpeta programmi töö
            }
            valjak.printValjak();
            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            }
            if (input.equals("w")) {
                input = "yles";
            }
            if (input.equals("a")) {
                input = "vasakule";
            }
            if (input.equals("s")) {
                input = "alla";
            }
            if (input.equals("d")) {
                input = "paremale";
            }


            valjak.update(input);
        }
    }
}
