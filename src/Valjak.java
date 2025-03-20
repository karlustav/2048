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

    public boolean checkGameOver() {
        return false;
    }

    public void addRuut(Ruut ruut) {
        valjak[ruut.getY()][ruut.getX()] = ruut;
        ruudud.add(ruut);
    }

    // Getter
    public ArrayList<Ruut> getRuudud() {
        return ruudud;
    }

    public void printValjak() {
        for (int i = 0; i < valjak.length; i++) {
            System.out.println(Arrays.toString(valjak[i]));
        }
    }

}
