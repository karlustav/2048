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

    public boolean checkGameOver() {
        return false;
    }

    public void addRuut(Ruut ruut) {
        valjak[ruut.getY()][ruut.getX()] = ruut;
        ruudud.add(ruut);
    }

    private String kollane = "\u001B[33m";
    private String valge = "\u001B[0m";

    String value;
    // Getter
    public ArrayList<Ruut> getRuudud() {
        return ruudud;
    }
    public void printValjak() {
        for (int i = 0; i < valjak.length; i++) {
            for (int j = 0; j < valjak[i].length; j++) {
                Ruut muudetav = valjak[i][j];
                if (muudetav != null) {
                    value = muudetav.toString();
                } else {
                    value = " ";
                }
                System.out.print(value);
                if (j < valjak[i].length - 1) {
                    System.out.print(kollane + "  |  " + valge);
                }
            }
            System.out.println();

            if (i < valjak.length -1 ) {
                for (int j = 0; j < valjak[i].length; j++) {
                    System.out.print(kollane + "----");
                    if(j < valjak[i].length-1){
                        System.out.print("+");
                    }
                }
            }
            System.out.println();
          //  System.out.println(Arrays.toString(valjak[i]));
        }
    }


}
