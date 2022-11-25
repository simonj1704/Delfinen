package src;

import java.util.Scanner;
import java.time.LocalDate;

public class TimesHandler {
    Scanner in = new Scanner(System.in);
    LocalDate date = LocalDate.now();

    //Testing
    EliteSwimmer eliteSwimmer = new EliteSwimmer("Michael", 42, "Maria", "Butterfly");
    //

    private String inputDiscipline;
    private int trainingTimeSeconds;
    private int trainingTimeMilSeconds;

    public void createTrainingTime() {
        System.out.print("Input Discipline ");
        inputDiscipline = in.nextLine();
        System.out.print("Input Training Time in Seconds: ");
        trainingTimeSeconds = in.nextInt();
        in.nextLine();
        System.out.print("Input Training Time in Milliseconds: ");
        trainingTimeMilSeconds = in.nextInt();
        in.nextLine();

        TrainingTime newTime = new TrainingTime(eliteSwimmer, date, trainingTimeSeconds, trainingTimeMilSeconds, inputDiscipline);
    }
}
