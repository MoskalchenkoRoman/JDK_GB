package dz6;

import java.util.Random;

public class MontyHall {
    public static void main(String[] args) {

        Random random = new Random();
        int trial = 1000;

        System.out.println("Оставляем выбранную дверь.");
        int win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            if (contestantDoor == prizeDoor) {
                win++;
            }
        }

        System.out.println("Количество побед из " + trial + " попыток: " + win);
        System.out.println("Процент побед: " + (double) win / trial*100 + "%");
        System.out.println();

        System.out.println("Меняем дверь.");
        win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            int wrongDoor = prizeDoor;
            while (wrongDoor == prizeDoor ||
                    wrongDoor == contestantDoor) {
                wrongDoor = random.nextInt(3);
            }

            int alternateDoor = 3 - (contestantDoor + wrongDoor);

            if (alternateDoor == prizeDoor) {
                win++;
            }
        }

        System.out.println("Количество побед из " + trial + " попыток: " + win);
        System.out.println("Процент побед: " + (double) win / trial*100 + "%");
    }
}
