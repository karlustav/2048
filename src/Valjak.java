import java.util.ArrayList;
import java.util.Arrays;

public class Valjak {
    private Ruut[][] valjak;

    public Valjak() {
        valjak = new Ruut[4][4];
    }

    public Ruut[][] getValjak() {
        return valjak;
    }

    public void setValjak(Ruut[][] valjak) {
        this.valjak = valjak;
    }

    public Ruut[][] initialize() {
        return null;
    }

    public Ruut[][] update(String suund) {
        return null;
    }

    public Ruut[][] generateNewTile() {

        int newTileValue = 2;
        if (Math.random() <= 0.1) {
            newTileValue = 4;
        }

        int nullcount = 0;
        ArrayList<Integer[]> nullPositions = new ArrayList<Integer[]>();
        for (int i = 0; i < valjak.length; i++) {
            for (int j = 0; j < valjak[i].length; j++) {
                if (valjak[i][j] == null) {
                    nullcount++;
                    nullPositions.add(new Integer[]{i, j});
                }
            }
        }

        System.out.println("nullcount: " + nullcount);
        for (int i = 0; i < nullPositions.size(); i++) {
            System.out.println(Arrays.toString(nullPositions.get(i)));
        }

        return null;
    }

    public boolean checkGameOver() {

        return false;
    }


}
