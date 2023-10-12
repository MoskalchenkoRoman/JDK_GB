package dz2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        List<Developer> developers = new ArrayList<>();

        int tempInt = 10;
        for (int i = 0; i < tempInt; i++) {
            if (rand.nextBoolean()) {
                developers.add(new Frontend());
            } else {
                developers.add(new Backend());
            }

        }

        for (Developer developer : developers) {
            creatingShell(developer);
        }
    }
    static void creatingShell(Developer developer) {
        if (developer instanceof Frontend) {
            ((Frontend) developer).developGUI();
        } else {
            System.out.println("Я " + developer.getClass() + " и этому не обучен");
        }
    }
}
