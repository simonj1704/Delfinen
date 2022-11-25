package src;

import src.memberTypes.EliteSwimmer;
import src.memberTypes.Hobbyist;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    private void run() {
        Member mem1 = new EliteSwimmer("Michael Phelps", 36, "Rikke Nyborg", "Freestyle");
        System.out.println(mem1.toString());
        Member mem2 = new Hobbyist("Søren Banjamus", 12);
        System.out.println(mem2.toString());


    }
}
