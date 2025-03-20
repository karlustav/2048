import java.util.Arrays;
import java.util.Scanner;

public class TestValjak {
    public static void main(String[] args) {
        Valjak valjak = new Valjak();
        Scanner scanner = new Scanner(System.in);
        int skoor = 0;
        valjak.generateNewTile();
        while(true) {
            // System.out.println(Arrays.deepToString(valjak.getValjak())); // prindi väljak, tuleb panna pärast sinna kus on suunainput valitud
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
            valjak.update(input);

        }
    }
}
