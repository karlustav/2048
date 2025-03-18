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

    public void update(String suund) {
        return;
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

        valjak[nullPositions.get(mitmes)[0]][nullPositions.get(mitmes)[1]] = new Ruut(newTileValue);
    }

    public boolean checkGameOver() {

        return false;
    }

    public void printValjak() {
        for (int i = 0; i < valjak.length; i++) {
            System.out.println(Arrays.toString(valjak[i]));
        }
    }


}
