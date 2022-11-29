package src;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {
    public ArrayList<Member> members = new ArrayList<>();
    public TimesHandler timesHandler = new TimesHandler();
    public Member member = new Member();
    Scanner in = new Scanner(System.in);
    private boolean isRunning;
    private String input;

    public MemberHandler() {
    }


    public void addMember(int choice, String name, int age) {
        switch (choice) {
            case 1 -> createHobbyist(name, age);
            case 2 -> createElite(name, age);
            case 3 -> createMember(name, age);
        }
    }

    public void createMember(String name, int age) {
        String typeOfSwimmer;
        boolean isPassive = isPassive();
        boolean hasArrears = hasArrears();

        typeOfSwimmer = getTypeOfSwimmer();


        members.add(new Member(name, age, isPassive, hasArrears, typeOfSwimmer));

    }

    public void createElite(String name, int age) {
        String coach;
        String discipline;

        coach = getCoach();
        discipline = getDiscipline();
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
        members.add(new EliteSwimmer(name, age, coach, discipline));
    }

    public void createHobbyist(String name, int age) {
        members.add(new Hobbyist(name, age));
    }

    public String getCoach() {
        System.out.print("Who is the Coach: ");
        return in.nextLine();
    }

    public String getDiscipline() {
        System.out.print("What is the discipline: ");
        return in.nextLine();
    }

    public String getTypeOfSwimmer() {
        String typeOfSwimmer = "";
        System.out.println("What type of swimmer is the member? (Hobbyist (1) / Elite Swimmer (2)");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> typeOfSwimmer = "Hobbyist";
            case 2 -> typeOfSwimmer = "Elite Swimmer";
            default -> System.out.println("Please enter a valid number.");
        }
        return typeOfSwimmer;
    }

    public void placeTimeOnSwimmer() {
        int searchId;
        System.out.printf("Input ID for Timeplacement on Swimmer: ");
        searchId = in.nextInt();
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == searchId) {
                Object eliteSwimmer = members.get(i);
            }
        }
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
        while (isRunning) {
            input = in.nextLine();
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
}