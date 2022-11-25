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
    private String tourneyName;
    private String placement;
    private int placementTimeSeconds;
    private int placementTimeMiliseconds;

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

    public void createTournamentResult(){
        System.out.println("Input tourney name");
        tourneyName = in.nextLine();
        System.out.println("Input tournament placement");
        placement = in.nextLine();
        System.out.println("Input swimtime seconds");
        placementTimeSeconds = in.nextInt();
        in.nextLine();
        System.out.println("Input swimtime ms");
        placementTimeMiliseconds = in.nextInt();
        in.nextLine();

        TournamentBoard tournamentBoard = new TournamentBoard(date,tourneyName,placement,placementTimeSeconds,
                placementTimeMiliseconds);

    }
}
