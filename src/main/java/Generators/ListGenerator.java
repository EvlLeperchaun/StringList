package Generators;


import java.io.*;
import java.util.Random;

public class ListGenerator {
    private int size;

    public ListGenerator() {
        this.size = 100;
        BufferedWriter bw = null;
        Random rand = new Random();
        try {
            FileWriter fw = new FileWriter(new File("src/main/resources/random_list.txt"), false);
            bw = new BufferedWriter(fw);
            for (int i = 1; i < this.size + 1; i++) {
                int r = (rand.nextInt(25) + 65);
                char c = (char) r;
                bw.write(c);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.printf("IO exception\n");
        } finally {
            if (!(bw == null)) {
                try {
                    bw.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public ListGenerator(int size) {
        this.size = size;
        BufferedWriter bw = null;
        Random rand = new Random();
        try {
            FileWriter fw = new FileWriter(new File("src/main/resources/random_list.txt"), false);
            bw = new BufferedWriter(fw);
            for (int i = 1; i < this.size + 1; i++) {
                int r = rand.nextInt(25) + 65;
                char c = (char) r;
                bw.write(c);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.printf("IO exception\n");
        } finally {
            if (!(bw == null)) {
                try {
                    bw.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
