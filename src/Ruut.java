public class Ruut {
    private int vaartus;
    private int x;
    private int y;

    public Ruut(int vaartus, int y, int x) {
        this.vaartus = vaartus;
        this.x = x;
        this.y = y;
    }

    public void liigu(String suund) {
        if (suund.equals("yles")) {
            y--;
        }
        else if (suund.equals("alla")) {
            y++;
        }
        else if (suund.equals("paremale")) {
            x++;
        }
        else if (suund.equals("vasakule")) {
            x--;
        }
    }

    public boolean checkCollision(String suund, Ruut teineRuut) {
        if (suund.equals("yles")) {
            return teineRuut.getY() == this.y - 1;
        }
        else if (suund.equals("alla")) {
            return teineRuut.getY() == this.y + 1;
        }
        else if (suund.equals("paremale")) {
            return teineRuut.getX() == this.x + 1;
        }

        return teineRuut.getX() == this.x - 1;

    }

    public int getVaartus() {
        return vaartus;
    }

    public void setVaartus(int vaartus) {
        this.vaartus = vaartus;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return vaartus + "";
    }
}
