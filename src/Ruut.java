public class Ruut {
    private int vaartus;
    private int x;
    private int y;
    private Valjak valjak;

    public Ruut(int vaartus, int y, int x, Valjak valjak) {
        this.vaartus = vaartus;
        this.x = x;
        this.y = y;
        this.valjak = valjak;
    }

    public void liigu(String suund) {
        if (suund.equals("yles")) {
            int oldX = x;
            int oldY = y;
            if (y != 0 && !checkCollision("yles")) {
                y--;
                valjak.getValjak()[y][x] = this;
                valjak.getValjak()[oldY][oldX] = null;
                return;
            }
            else if (checkCollision(suund) && ruutAsukohaJargi(this.x, this.y - 1).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x, this.y - 1).setVaartus(this.vaartus * 2);
                valjak.getValjak()[this.y][this.x] = null;
                return;
            }
        }
        else if (suund.equals("alla")) {
            if (y != 3 && !checkCollision("alla")) {
                y++;
            }
            else if (ruutAsukohaJargi(this.x, this.y + 1).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x, this.y + 1).setVaartus(this.vaartus * 2);
            }
            valjak.getValjak()[this.y][this.x] = null;
        }
        else if (suund.equals("paremale")) {
            if (x != 3 && !checkCollision("paremale")) {
                x++;
            }
            else if (ruutAsukohaJargi(this.x + 1, this.y).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x + 1, this.y).setVaartus(this.vaartus * 2);
            }
            valjak.getValjak()[this.y][this.x] = null;
        }
        else if (suund.equals("vasakule")) {
            if (x != 0 && !checkCollision("vasakule")) {
                x--;
            }
            else if (ruutAsukohaJargi(this.x - 1, this.y).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x - 1, this.y).setVaartus(this.vaartus * 2);
            }
            valjak.getValjak()[this.y][this.x] = null;

        }
    }

    public Ruut ruutAsukohaJargi(int x, int y) {
        for (Ruut ruut: valjak.getRuudud()) {
            if (ruut.getX() == x && ruut.getY() == y) {
                return ruut;
            }
        }
        return null;
    }

    public boolean checkCollision(String suund) {
        boolean onCollision = false;
        for (Ruut teineRuut: valjak.getRuudud()) {
            if (onCollision) {
                return true;
            }
            if (suund.equals("yles")) {
                onCollision = teineRuut.getY() == this.y - 1 && teineRuut.getX() == this.x;
            }
            else if (suund.equals("alla")) {
                onCollision = teineRuut.getY() == this.y + 1 && teineRuut.getX() == this.x;
            }
            else if (suund.equals("paremale")) {
                onCollision = teineRuut.getX() == this.x + 1 && teineRuut.getY() == this.y;
            }
            else if (suund.equals("vasakule")) {
                onCollision =  teineRuut.getX() == this.x - 1 && teineRuut.getY() == this.y;
            }
        }
        return false;

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
