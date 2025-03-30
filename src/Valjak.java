import java.util.ArrayList;
import java.util.Arrays;

public class Valjak {
    private Ruut[][] valjak;
    private ArrayList<Ruut> ruudud;

    public Valjak() {
        valjak = new Ruut[4][4];
        ruudud = new ArrayList<Ruut>();
    }


    public Ruut[][] getValjak() {
        return valjak;
    }

    public void setValjak(Ruut[][] valjak) {
        this.valjak = valjak;
    }

    public void update(String suund) {
        if (suund.equals("yles")) {
            for (int i = 0; i < 3; i++) {
                for (int y = 0; y < 4; y++) {
                    for (int x = 0; x < 4; x++) {
                        Ruut ruut = valjak[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }
        else if (suund.equals("alla")) {
            for (int i = 0; i < 3; i++) {
                for (int y = 3; y >= 0; y--) {
                    for (int x = 0; x < 4; x++) {
                        Ruut ruut = valjak[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }
        else if (suund.equals("vasakule")) {
            for (int i = 0; i < 3; i++) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        Ruut ruut = valjak[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }
        else if (suund.equals("paremale")) {
            for (int i = 0; i < 3; i++) {
                for (int x = 3; x >= 0; x--) {
                    for (int y = 0; y < 4; y++) {
                        Ruut ruut = valjak[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }

        generateNewTile();
    }

    public void generateNewTile() {

        int newTileValue = 2;
        if (Math.random() <= 0.1) {
            newTileValue = 4;
        }

        ArrayList<Integer[]> nullPositions = new ArrayList<Integer[]>();
        for (int i = 0; i < valjak.length; i++) {
            for (int j = 0; j < valjak[i].length; j++) {
                if (valjak[i][j] == null) {
                    nullPositions.add(new Integer[]{i, j});
                }
            }
        }

        int mitmes = (int) (Math.random() * nullPositions.size());
        Ruut uusRuut = new Ruut(newTileValue, nullPositions.get(mitmes)[0], nullPositions.get(mitmes)[1], this);
        addRuut(uusRuut);
    }

    public void updateTest(Valjak testValjak, String suund) {
        if (suund.equals("yles")) {
            for (int i = 0; i < 3; i++) {
                for (int y = 0; y < 4; y++) {
                    for (int x = 0; x < 4; x++) {
                        Ruut ruut = testValjak.getValjak()[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }
        else if (suund.equals("alla")) {
            for (int i = 0; i < 3; i++) {
                for (int y = 3; y >= 0; y--) {
                    for (int x = 0; x < 4; x++) {
                        Ruut ruut = testValjak.getValjak()[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }
        else if (suund.equals("vasakule")) {
            for (int i = 0; i < 3; i++) {
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        Ruut ruut = testValjak.getValjak()[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }
        else if (suund.equals("paremale")) {
            for (int i = 0; i < 3; i++) {
                for (int x = 3; x >= 0; x--) {
                    for (int y = 0; y < 4; y++) {
                        Ruut ruut = testValjak.getValjak()[y][x];
                        if (ruut != null) {
                            ruut.liigu(suund);
                        }
                    }
                }
            }
        }
    }

    public boolean checkGameOver() {
        String vana = Arrays.deepToString(valjak);
//        for (int i = valjak.length - 1; i >= 0; i--) {
//            System.out.println(Arrays.toString(valjak[i]));
//        }
        String[] suunad = {"yles", "alla", "paremale", "vasakule"};
        for (String suund : suunad) {
            Valjak testValjak = new Valjak();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (this.valjak[i][j] != null) {
                        Ruut vanaRuut = this.valjak[i][j];
                        Ruut copy = new Ruut(vanaRuut.getVaartus(), i, j, testValjak);
                        testValjak.addRuut(copy);
                    }
                }
            }

            updateTest(testValjak, suund); // proovi iga suunaga liikumist
            // System.out.println(Arrays.deepToString(testValjak.getValjak()));

            if (!Arrays.deepToString(testValjak.valjak).equals(vana)) {
                return false;
            }
        }
        return true; // kui ei muutunud midagi ühegi suuna korral, siis on mäng läbi
    }

    // meetod, et vaadata kas kuskil on kõrvuti olevaid samu numbreid, mida saab kokku liita.
    public boolean kasOnVoimalikLiita(){
        for (int rida = 0; rida < valjak.length; rida++) {
            for (int veerg = 0; veerg < valjak[0].length; veerg++) {

            }
        }
        return false;
    }

    // See on AI-generated funktsioon
    public void generateGameOverBoard() {
        // Clear current board
        valjak = new Ruut[4][4];
        ruudud.clear();

        // Pattern of alternating values with no possible merges
        int[][] values = {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2}
        };

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                Ruut ruut = new Ruut(values[y][x], y, x, this);
                addRuut(ruut);
            }
        }
    }

    public void addRuut(Ruut ruut) {
        valjak[ruut.getY()][ruut.getX()] = ruut;
        ruudud.add(ruut);
    }

    String value;
    // Getter
    public ArrayList<Ruut> getRuudud() {
        return ruudud;
    }

    // Värvide osa on AI generated.
    private static final String RESET = "\u001B[0m";

    public static String getColor(int value) {
        return switch (value) {
            case 2 -> "\u001B[38;5;34m";     // Green
            case 4 -> "\u001B[38;5;120m";    // Light Green
            case 8 -> "\u001B[38;5;43m";    // Pale Lime Green
            case 16 -> "\u001B[38;5;51m";    // Cyan
            case 32 -> "\u001B[38;5;27m";    // Blue
            case 64 -> "\u001B[38;5;63m";    // Indigo
            case 128 -> "\u001B[38;5;165m";  // Magenta-Violet
            case 256 -> "\u001B[38;5;196m";  // Red
            case 512 -> "\u001B[38;5;208m";  // Orange
            case 1024 -> "\u001B[38;5;220m"; // Dark Yellow
            case 2048 -> "\u001B[38;5;226m";// Yellow
            default -> "\u001B[0m";          // Reset
        };
    }

    // See ka AI generated
    public static void printColorPreview() {
        int[] tiles = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};

        for (int tile : tiles) {
            String color = getColor(tile);
            System.out.printf("%s%5s\u001B[0m ", color, tile); // 5-width padding for alignment
        }
        System.out.println(); // Newline at end
    }

    public void printValjak() {
        System.out.println("+" + ("-".repeat(6) + "+").repeat(4));
        for (int i = 0; i < valjak.length; i++) {
            for (int j = 0; j < valjak[i].length; j++) {
                Ruut muudetav = valjak[i][j];
                String color;
                if (muudetav != null) {
                    color = getColor(muudetav.getVaartus());
                }
                else {
                    color = RESET;
                }
                System.out.printf("| %s%4s%s ", color, (muudetav == null ? " " : muudetav.getVaartus()), RESET);
                if (j == 3) {
                    System.out.print("|");
                }
            }
            System.out.println();
            System.out.println("+" + ("-".repeat(6) + "+").repeat(4));
        }
    }

}
