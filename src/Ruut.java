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
        int oldX = x;
        int oldY = y;
        if (suund.equals("yles")) {
            // Kui üleval on vaba koht
            if (y != 0 && !checkCollision("yles")) {
                y--;
                valjak.getValjak()[y][x] = this;
                valjak.getValjak()[oldY][oldX] = null;
                valjak.getRuudud().remove(ruutAsukohaJargi(oldX, oldY));
                return;
            }
            // Kui üleval on ruut sama väärtusega.
            else if (checkCollision(suund) && ruutAsukohaJargi(this.x, this.y - 1).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x, this.y - 1).setVaartus(this.vaartus * 2);
                Main.skoor += this.vaartus * 2;
                valjak.getValjak()[this.y][this.x] = null;
                valjak.getRuudud().remove(this);
                return;
            }
        }

        else if (suund.equals("alla")) {
            if (y != 3 && !checkCollision("alla")) {
                y++;
                valjak.getValjak()[y][x] = this;
                valjak.getValjak()[oldY][oldX] = null;
                valjak.getRuudud().remove(ruutAsukohaJargi(oldX, oldY));
                return;
            } else if (checkCollision(suund) && ruutAsukohaJargi(this.x, this.y + 1).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x, this.y + 1).setVaartus(this.vaartus * 2);
                Main.skoor += this.vaartus * 2;
                valjak.getValjak()[this.y][this.x] = null;
                valjak.getRuudud().remove(this);
                return;
            }
        }

        else if (suund.equals("paremale")) {
            if (x != 3 && !checkCollision("paremale")) {
                x++;
                valjak.getValjak()[y][x] = this;
                valjak.getValjak()[oldY][oldX] = null;
                valjak.getRuudud().remove(ruutAsukohaJargi(oldX, oldY));
                return;
            } else if (checkCollision(suund) && ruutAsukohaJargi(this.x + 1, this.y).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x + 1, this.y).setVaartus(this.vaartus * 2);
                Main.skoor += this.vaartus * 2;
                valjak.getValjak()[this.y][this.x] = null;
                valjak.getRuudud().remove(this);
                return;
            }
        }

        else if (suund.equals("vasakule")) {
            if (x != 0 && !checkCollision("vasakule")) {
                x--;
                valjak.getValjak()[y][x] = this;
                valjak.getValjak()[oldY][oldX] = null;
                valjak.getRuudud().remove(ruutAsukohaJargi(oldX, oldY));
                return;
            } else if (checkCollision(suund) && ruutAsukohaJargi(this.x - 1, this.y).getVaartus() == this.vaartus) {
                ruutAsukohaJargi(this.x - 1, this.y).setVaartus(this.vaartus * 2);
                Main.skoor += this.vaartus * 2;
                valjak.getValjak()[this.y][this.x] = null;
                valjak.getRuudud().remove(this);
                return;
            }
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
            if (onCollision) {
                return true;
            }
        }
        return false;

    }

    public Valjak getValjak() {
        return valjak;
    }

    public void setValjak(Valjak valjak) {
        this.valjak = valjak;
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
