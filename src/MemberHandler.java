package src;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {
    public ArrayList<Member> members = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    private boolean isRunning = true;

    public MemberHandler(){
    }


    public void addMember(int choice, String name, int age) {
        switch (choice) {
            case 1 -> createHobbyist(name, age);
            case 2 -> createElite(name, age);
            case 3 -> createMember(name, age);
        }
    }

    public void createMember(String name, int age) {
        boolean isPassive = isPassive();
        boolean hasArrears = hasArrears();
        String typeOfSwimmer = in.nextLine();

        members.add(new Member(name, age, isPassive, hasArrears, typeOfSwimmer));

    }

    public void createElite(String name, int age) {
        String coach;
        String discipline;
        String input;

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

    public boolean isPassive() {
        boolean isPassive = false;
        System.out.println("Is the member passive (y) or active (n)");
        while (isRunning) {
            if (in.nextLine().equalsIgnoreCase("y")) {
                isPassive = true;
                isRunning = false;
            } else if (in.nextLine().equalsIgnoreCase("n")) {
                isPassive = false;
                isRunning = false;
            } else {
                System.out.println("I don't understand what you mean. Enter y or n!");
            }
        }
        return isPassive;
    }

    public boolean hasArrears() {
        boolean hasArrears = false;
        System.out.println("Does the member have arrears? yes (y) or no (n)");
        while (isRunning) {
            if (in.nextLine().equalsIgnoreCase("y")) {
                hasArrears = true;
                isRunning = false;
            } else if (in.nextLine().equalsIgnoreCase("n")) {
                hasArrears = false;
                isRunning = false;
            } else {
                System.out.println("I don't understand what you mean. Enter y or n!");
            }
        }
        return hasArrears;
    }
}