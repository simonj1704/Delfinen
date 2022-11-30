package src;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {
    public ArrayList<Member> members = new ArrayList<>();
    public Member member = new Member();
    Scanner in = new Scanner(System.in);
    private boolean isRunning = true;
    private String input;
    private String inputDiscipline;
    private int trainingTimeSeconds;
    private int trainingTimeMilSeconds;
    private String tourneyName;
    private String placement;
    private int placementTimeSeconds;
    private int placementTimeMiliseconds;
    LocalDate date = LocalDate.now();
    ArrayList<TrainingTime> trainingTimes = new ArrayList<>();

    public MemberHandler() {
        member.setNextId();
    }

    public void writeMember(String member){
        try {
            PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv",true));
            fileWriter.println(member);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addMember(int choice, String name, int age) {
        switch (choice) {
            case 1 -> createHobbyist(name, age);
            case 2 -> createElite(name, age);
            case 3 -> createMember(name, age);
        }
    }

    public void deleteMember(){

    }

    public void createMember(String name, int age) {
        boolean isPassive = isPassive();
        boolean hasArrears = hasArrears();
        String typeOfSwimmer = getTypeOfSwimmer();


        members.add(new Member(name, age, isPassive, hasArrears, typeOfSwimmer));
        writeMember(member.printMember(new Member(name, age, isPassive, hasArrears, typeOfSwimmer)));
    }

    public void createElite(String name, int age) {
        String coach;
        String discipline;


        coach = getCoach();
        discipline = getDiscipline();
        EliteSwimmer eliteSwimmer = new EliteSwimmer(name, age, coach, discipline);
        members.add(eliteSwimmer);
        writeMember(eliteSwimmer.printMember(eliteSwimmer));
    }

    public void createHobbyist(String name, int age) {
        Hobbyist hobbyist = new Hobbyist(name, age);
        members.add(hobbyist);
        writeMember(hobbyist.printMember(hobbyist));
    }

    public String getCoach() {
        System.out.print("Who is the Coach: ");
        return in.nextLine();
    }

    public String getDiscipline() {
        String discipline;
        System.out.print("What is the discipline: ");
        discipline = in.nextLine();
        while (isRunning) {
            System.out.print("Do you want to add more disciplines(Y/N): ");
            input = in.nextLine();
            if (input.equalsIgnoreCase("y")) {
                discipline = discipline + ", " + getDiscipline();
                isRunning = true;
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("You chose to not enter another discipline.");
                isRunning = false;
            } else {
                System.out.println("I don't understand what you mean. Enter y or n!");
                isRunning = true;
            }
        }
        return discipline;
    }

    public String getTypeOfSwimmer() {
        String typeOfSwimmer = "";
        System.out.println("What type of swimmer is the member? (Hobbyist (1) / Elite Swimmer (2)");
        int choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1 -> typeOfSwimmer = "Hobbyist";
            case 2 -> typeOfSwimmer = "Elite Swimmer";
            default -> System.out.println("Please enter a valid number.");
        }
        return typeOfSwimmer;
    }

    public boolean isPassive() {
        boolean isPassive = false;
        while (isRunning) {
            System.out.println("Is the member passive (Y) or active (N)");
            input = in.nextLine();
            if (input.equalsIgnoreCase("y")) {
                isPassive = true;
                isRunning = false;
            } else if (input.equalsIgnoreCase("n")) {
                isPassive = false;
                isRunning = false;
            } else {
                System.out.println("I don't understand what you mean. Enter y or n!");
                isRunning = true;
            }
        }
        return isPassive;
    }

    public boolean hasArrears() {
        boolean hasArrears = false;
        System.out.println("Does the member have arrears? (Y/N)");
        input = in.nextLine();
        while (isRunning) {
            if (input.equalsIgnoreCase("y")) {
                hasArrears = true;
                isRunning = false;
            } else if (input.equalsIgnoreCase("n")) {
                hasArrears = false;
                isRunning = false;
            } else {
                System.out.println("I don't understand what you mean. Enter y or n!");
                isRunning = true;
            }
        }
        return hasArrears;
    }

    public void createTrainingTime() {
        int searchId;
        System.out.print("Input Discipline ");
        inputDiscipline = in.nextLine();
        System.out.print("Input Training Time in Seconds: ");
        trainingTimeSeconds = in.nextInt();
        in.nextLine();
        System.out.print("Input Training Time in Milliseconds: ");
        trainingTimeMilSeconds = in.nextInt();
        in.nextLine();
        TrainingTime newTime = new TrainingTime(date, trainingTimeSeconds, trainingTimeMilSeconds, inputDiscipline);
        System.out.printf("Input ID for Timeplacement on Swimmer: ");
        searchId = in.nextInt();
        in.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == searchId) {
                EliteSwimmer eliteSwimmer = (EliteSwimmer) members.get(i);
                eliteSwimmer.addTime(newTime);
                System.out.printf(eliteSwimmer.toString());
            }
        }
    }

    public void createTournamentResult(){
        int searchId;
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
        TournamentBoard newtournamentBoard = new TournamentBoard(date,tourneyName,placement,placementTimeSeconds
                ,placementTimeMiliseconds);
        System.out.printf("Input ID for Timeplacement on Swimmer: ");
        searchId = in.nextInt();
        in.nextLine();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == searchId) {
                EliteSwimmer eliteSwimmer = (EliteSwimmer) members.get(i);
                eliteSwimmer.addTourney(newtournamentBoard);
            }
        }
    }

}