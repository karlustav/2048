import org.w3c.dom.ls.LSOutput;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final BlockingQueue<Character> keyQueue = new ArrayBlockingQueue<>(1);

    public static int skoor = 0;
    static boolean abi = true;

    public static void main(String[] args) {
        String input = null;
        Valjak valjak = new Valjak();
        // Valjak.printColorPreview();
        //Scanner scanner = new Scanner(System.in);
        startKeyListener();
        valjak.generateNewTile();
        while(true) {
            System.out.println(skoor);
            valjak.kasOnVoimalikLiita();
            if (valjak.checkGameOver()) {
                System.out.println("Mäng on läbi");
                System.out.println("Lõppskoor: " + skoor);
                System.exit(0); // lõpeta programmi töö
            }

            abi = true;
            valjak.printValjak();
            while (abi) {
                input = String.valueOf(keyQueue.poll());
            }


            System.out.println(input);
            if (input.equals("q")) {
                break;
            }
            if (input.equals("w")) {
                input = "yles";
            }
            if (input.equals("a")) {
                input = "vasakule";
            }
            if (input.equals("s")) {
                input = "alla";
            }
            if (input.equals("d")) {
                input = "paremale";
            }
            if (input.equals("o")) {
                System.out.println("ooooooooooooooooooooooooooooooooo");
            }
            //System.out.println(keyQueue);

            valjak.update(input);
        }
    }
    private static void startKeyListener() {
        Frame frame = new Frame();
        frame.setUndecorated(true);
        frame.setSize(1, 1);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyQueue.offer(e.getKeyChar());
                abi = false;
            }
        });
    }
}
