public class TestValjak {
    public static void main(String[] args) {
        Valjak valjak = new Valjak();
        for (int i = 0; i < 10; i++) {
            valjak.generateNewTile();
        }
        valjak.printValjak();
    }
}
