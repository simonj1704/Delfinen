package src;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {
    public FileHandler fileHandler = new FileHandler();
    public Member member = new Member();
    Scanner in = new Scanner(System.in);
    private boolean isRunning = true;
    private String input;
    LocalDate date = LocalDate.now();

    public MemberHandler() {
        member.setNextId(setNextId());
    }

    public int setNextId() {
        fileHandler.setReadMembers();
        int nextId;
        return nextId = fileHandler.readMembers.get(fileHandler.readMembers.size() - 1).getId() + 1;
    }

    public void deleteMember() {
        printMembers();
        fileHandler.deleteMember();
    }

    public void addMember() {
        int choice;
        int age;
        String name;
        System.out.print("1. Create Hobbyist. \n2. Create Elite Swimmer. \nEnter Input: ");
        choice = readChoiceInt();

        System.out.print("Enter Name: ");
        name = in.nextLine();

        System.out.print("Enter Age: ");
        age = readChoiceInt();

        switch (choice) {
            case 1 -> createHobbyist(name, age);
            case 2 -> createElite(name, age);
            default -> System.out.print("Error.");
        }
    }

    public void createElite(String name, int age) {
        String coach;
        String discipline;
        boolean isPassive = false;
        boolean hasArrears = false;
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Do you want to add Arrears or Passive to Member? (Yes) or (No): ");
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("Yes")) {
                isPassive = isPassive();
                hasArrears = hasArrears();
                isRunning = false;
            } else if (choice.equalsIgnoreCase("No")) {
                isRunning = false;
            } else {
                System.out.print("Unknown Input, Try again.");
            }
        }
        coach = getCoach();
        discipline = getDiscipline();
        EliteSwimmer eliteSwimmer = new EliteSwimmer(name, age, coach, discipline, isPassive, hasArrears);
        fileHandler.writeMember(eliteSwimmer.printMember(eliteSwimmer));
    }

    public void createHobbyist(String name, int age) {
        boolean isPassive = false;
        boolean hasArrears = false;
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Do you want to add Arrears or Passive to Member? (Yes) or (No): ");
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("Yes")) {
                isPassive = isPassive();
                hasArrears = hasArrears();
                isRunning = false;
            } else if (choice.equalsIgnoreCase("No")) {
                isRunning = false;
            } else {
                System.out.print("Unknown Input, Try again.");
            }
        }
        Hobbyist hobbyist = new Hobbyist(name, age, isPassive, hasArrears);
        fileHandler.writeMember(hobbyist.printMember(hobbyist));
    }

    public void printMembers() {
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Type: %-8s Member: %-15s Coach: %-10s Disciplines: %-20s Arrears: %-7s Passive Member: %-7s Subscription price: %-7d\n", fileHandler.readMembers.get(i).getId(),
                        fileHandler.readMembers.get(i).getName(), fileHandler.readMembers.get(i).getAge(),
                        fileHandler.readMembers.get(i).getTypeOfMembership(), fileHandler.readMembers.get(i).getTypeOfSwimmer(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getCoach(), ((EliteSwimmer) fileHandler.readMembers.get(i)).getSwimmingDiscipline(),
                        fileHandler.readMembers.get(i).hasArrears(), fileHandler.readMembers.get(i).isPassive(), fileHandler.readMembers.get(i).getSubscriptionPrice());
            } else {
                System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Type: %-8s Member: %-15s Arrears: %-7s Passive Member: %-8s Subscription price: %-10d\n",
                        fileHandler.readMembers.get(i).getId(), fileHandler.readMembers.get(i).getName(),
                        fileHandler.readMembers.get(i).getAge(), fileHandler.readMembers.get(i).getTypeOfMembership(),
                        fileHandler.readMembers.get(i).getTypeOfSwimmer(), fileHandler.readMembers.get(i).hasArrears(),
                        fileHandler.readMembers.get(i).isPassive(), fileHandler.readMembers.get(i).getSubscriptionPrice());
            }
        }
    }

    public void changeMember() {
        boolean isRunning = true;
        int choice;
        printMembers();
        System.out.print("What member do you want to change(ID): ");
        choice = readChoiceInt();
        int index = -1;
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i).getId() == choice) {
                index = i;
            }
        }
        System.out.println("------------------------------------------------");
        System.out.print("ID: " + fileHandler.readMembers.get(index).getId() + "     " +
                "Name: " + fileHandler.readMembers.get(index).getName() + "     " +
                "Age: " + fileHandler.readMembers.get(index).getAge() + "     " +
                "Type: " + fileHandler.readMembers.get(index).getTypeOfMembership() + "     " +
                "Arrears: " + fileHandler.readMembers.get(index).hasArrears() + "\n");
        System.out.println("------------------------------------------------");
        System.out.println("What do you want to Change: ");
        System.out.println("1. Name\n2. Age\n3. Member\n4. Passive\n5. Arrears");
        while (isRunning) {
            int change = readChoiceInt();
            switch (change) {
                case 1 -> {
                    System.out.print("What do you want to change the name to: ");
                    fileHandler.readMembers.get(index).setName(in.nextLine());
                    isRunning = false;
                }
                case 2 -> {
                    System.out.print("What do you want to change the age to: ");
                    int age = readChoiceInt();
                    fileHandler.readMembers.get(index).setAge(age);
                    fileHandler.readMembers.get(index).setTypeOfMembership(age);
                    isRunning = false;
                }
                case 3 -> {
                    System.out.print("What Member type do you want to set this Member as: ");
                    fileHandler.readMembers.get(index).setTypeOfSwimmer(in.nextLine());
                    isRunning = false;
                }
                case 4 -> {
                    System.out.print("Do you want to set this Member as Passive (yes): ");
                    String passive = in.nextLine();
                    fileHandler.readMembers.get(index).setIsPassive(passive.equalsIgnoreCase("yes"));
                    isRunning = false;
                }
                case 5 -> {
                    System.out.print("Do you want to give this Member Arrears (yes): ");
                    String arrears = in.nextLine();
                    fileHandler.readMembers.get(index).setHasArrears(arrears.equalsIgnoreCase("yes"));
                    isRunning = false;
                }
                default -> System.out.println("Unknown Input.");
            }
            fileHandler.changeMember();
        }
    }


    public void changeArrears() {
        boolean isRunning = true;
        int choice;
        printMembers();
        System.out.print("What member do you want to change(ID): ");
        choice = readChoiceInt();
        int index = -1;
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i).getId() == choice) {
                index = i;
            }
        }
        System.out.println("------------------------------------------------");
        System.out.print("ID: " + fileHandler.readMembers.get(index).getId() + "     " +
                "Name: " + fileHandler.readMembers.get(index).getName() + "     " +
                "Age: " + fileHandler.readMembers.get(index).getAge() + "     " +
                "Type: " + fileHandler.readMembers.get(index).getTypeOfMembership() + "     " +
                "Arrears: " + fileHandler.readMembers.get(index).hasArrears() + "     " +
                "Passive: " + fileHandler.readMembers.get(index).isPassive() + "\n");
        System.out.println("------------------------------------------------");
        System.out.println("What do you want to change: ");
        System.out.println("1. Passive\n 2. Arrears");
        while (isRunning) {
            int change = readChoiceInt();
            switch (change) {
                case 1 -> {
                    System.out.print("Do you want to set this member as passive (Yes) or register active (No): ");
                    String passive = in.nextLine();
                    fileHandler.readMembers.get(index).setIsPassive(passive.equalsIgnoreCase("yes"));
                    fileHandler.changeMember();
                    isRunning = false;
                }
                case 2 -> {
                    System.out.print("Do you want to give this member arrears (Yes) or remove arrears (No): ");
                    String arrears = in.nextLine();
                    fileHandler.readMembers.get(index).setHasArrears(arrears.equalsIgnoreCase("yes"));
                    fileHandler.changeMember();
                    isRunning = false;
                }
                default -> System.out.println("Unknown Input.");
            }
        }
    }

    public int readChoiceInt() {
        boolean validChoice = false;
        int choice = -1;

        while (!validChoice) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                in.nextLine();
                validChoice = true;
            } else {
                System.out.print("Please choose an option\n");
                in.nextLine();
            }
        }
        return choice;
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
            System.out.print("Do you want to add more disciplines(Yes) or (No): ");
            input = in.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                discipline = discipline + ", " + getDiscipline();
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("You chose to not enter another Discipline.");
                isRunning = false;
            } else {
                System.out.println("I don't understand what you mean. Enter Yes or No!");
                isRunning = true;
            }
        }
        return discipline;
    }

    public String getTypeOfSwimmer() {
        String typeOfSwimmer = "";
        System.out.println("What type of swimmer is the member? (Hobbyist (1) / Elite Swimmer (2)");
        int choice = readChoiceInt();
        switch (choice) {
            case 1 -> typeOfSwimmer = "Hobbyist";
            case 2 -> typeOfSwimmer = "Elite Swimmer";
            default -> System.out.println("Please enter a valid number.");
        }
        return typeOfSwimmer;
    }

    public boolean isPassive() {
        boolean isPassive = false;
        isRunning = true;
        while (isRunning) {
            System.out.print("Is the member passive (Yes) or active (No): ");
            input = in.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                isPassive = true;
                isRunning = false;
            } else if (input.equalsIgnoreCase("no")) {
                isRunning = false;
            } else {
                System.out.print("I don't understand what you mean. Enter Yes or No: ");
                isRunning = true;
            }
        }
        return isPassive;
    }

    public boolean hasArrears() {
        boolean hasArrears = false;
        isRunning = true;
        System.out.print("Does the member have arrears? (Yes) or (No): ");
        input = in.nextLine();
        while (isRunning) {
            if (input.equalsIgnoreCase("yes")) {
                hasArrears = true;
                isRunning = false;
            } else if (input.equalsIgnoreCase("no")) {
                isRunning = false;
            } else {
                System.out.print("I don't understand what you mean. Enter Yes or No: ");
                isRunning = true;
            }
        }
        return hasArrears;
    }

    public void createTrainingTime() {
        int searchId;
        System.out.print("Input Discipline ");
        String inputDiscipline = in.nextLine();
        System.out.print("Input Training Time in Seconds: ");
        int trainingTimeSeconds = readChoiceInt();
        System.out.print("Input Training Time in Milliseconds: ");
        int trainingTimeMilSeconds = readChoiceInt();
        TrainingTime newTime = new TrainingTime(date, trainingTimeSeconds, trainingTimeMilSeconds, inputDiscipline);
        System.out.print("Input ID for Time-placement on Swimmer: ");
        searchId = readChoiceInt();
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i).getId() == searchId) {
                EliteSwimmer eliteSwimmer = (EliteSwimmer) fileHandler.readMembers.get(i);
                eliteSwimmer.addTime(newTime);
                System.out.printf(eliteSwimmer.toString());
            }
        }
    }

    public void createTournamentResult() {
        int searchId;
        System.out.print("Input tourney name: ");
        String tourneyName = in.nextLine();
        System.out.print("Input tournament placement: ");
        String placement = in.nextLine().replace(" ", "_");
        System.out.print("Input swim time seconds: ");
        int placementTimeSeconds = readChoiceInt();
        System.out.print("Input swim time ms: ");
        int placementTimeMilliseconds = readChoiceInt();
        System.out.print("Input swim discipline: ");
        String discipline = in.nextLine();
        TournamentBoard newTournamentBoard = new TournamentBoard(date, tourneyName, placement, placementTimeSeconds
                , placementTimeMilliseconds, discipline);
        System.out.print("Input ID for Time-placement on Swimmer: ");
        searchId = readChoiceInt();
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i).getId() == searchId) {
                EliteSwimmer eliteSwimmer = (EliteSwimmer) fileHandler.readMembers.get(i);
                eliteSwimmer.addTourney(newTournamentBoard);
                System.out.println(eliteSwimmer);
            }
        }
    }

    public void trainingTimePrint() {
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Coach: %-10s Disciplines: %-20s\n",
                        fileHandler.readMembers.get(i).getId(),
                        fileHandler.readMembers.get(i).getName(), fileHandler.readMembers.get(i).getAge(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getCoach(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getSwimmingDiscipline());
                ((EliteSwimmer) fileHandler.readMembers.get(i)).printTimes();
                System.out.println();

            }

        }
    }

    public void tournamentTimePrint() {
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Coach: %-10s Disciplines: %-20s\n",
                        fileHandler.readMembers.get(i).getId(),
                        fileHandler.readMembers.get(i).getName(), fileHandler.readMembers.get(i).getAge(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getCoach(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getSwimmingDiscipline(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)));
                ((EliteSwimmer) fileHandler.readMembers.get(i)).printTournaments();
                System.out.println();
            }
        }
    }

    public void top5Print() {
        System.out.print("What Discipline do you want to print: ");
        String discipline = in.nextLine();
        ArrayList<EliteSwimmer> eliteSwimmers = new ArrayList<>();
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                eliteSwimmers.add((EliteSwimmer) fileHandler.readMembers.get(i));

            }
        }
        if (discipline.equalsIgnoreCase("ryg")) {
            RygTimeComparator rygSorter = new RygTimeComparator();
            eliteSwimmers.sort(rygSorter);
        } else if (discipline.equalsIgnoreCase("crawl")) {
            CrawlTimeComparator crawlSorter = new CrawlTimeComparator();
            eliteSwimmers.sort(crawlSorter);
        } else if (discipline.equalsIgnoreCase("bryst")) {
            BrystTimeComparator brystSorter = new BrystTimeComparator();
            eliteSwimmers.sort(brystSorter);
        } else if (discipline.equalsIgnoreCase("butterfly")) {
            ButterflyTimeComparator flySorter = new ButterflyTimeComparator();
            eliteSwimmers.sort(flySorter);
        }


        for (int i = 0; i < 5; i++) {
            System.out.println(eliteSwimmers.get(i).printTimeFor5Top(discipline));
        }
    }

    public void printEliteSwimmers() {
        ArrayList<EliteSwimmer> eliteSwimmers = new ArrayList<>();
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                eliteSwimmers.add((EliteSwimmer) fileHandler.readMembers.get(i));

            }
        }
        System.out.println("ELITE SWIMMERS");
        for (int i = 0; i < eliteSwimmers.size(); i++) {
            System.out.printf("ID: %-2d \t Name: %-20s \t Age: %-3d \t Type: %-6s \t Coach: %-10s \t Discipline: %-15s \t" +
                            "TrainingTimes: %s \t Tournaments: %s \t Passive %-5s\n",
                    eliteSwimmers.get(i).getId(), eliteSwimmers.get(i).getName(), eliteSwimmers.get(i).getAge(),
                    eliteSwimmers.get(i).getTypeOfMembership(), eliteSwimmers.get(i).getCoach(),
                    eliteSwimmers.get(i).getSwimmingDiscipline(), eliteSwimmers.get(i).getTrainingTimes(),
                    eliteSwimmers.get(i).getTournaments(), eliteSwimmers.get(i).isPassive());
        }
    }

    public void deleteTrainingResult() {
        int searchID;
        int input;
        ArrayList<EliteSwimmer> eliteSwimmers = new ArrayList<>();
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                eliteSwimmers.add((EliteSwimmer) fileHandler.readMembers.get(i));
            }
        }
        System.out.println("ELITE SWIMMERS");
        for (int i = 0; i < eliteSwimmers.size(); i++) {
            System.out.printf("ID: %-2d \t Name: %-20s \t Age: %-3d \t Type: %-6s \t Coach: %-10s \t Discipline: %-15s \t" +
                            "TrainingTimes: %s \t Tournaments: %s \t Passive %-5s\n",
                    eliteSwimmers.get(i).getId(), eliteSwimmers.get(i).getName(), eliteSwimmers.get(i).getAge(),
                    eliteSwimmers.get(i).getTypeOfMembership(), eliteSwimmers.get(i).getCoach(),
                    eliteSwimmers.get(i).getSwimmingDiscipline(), eliteSwimmers.get(i).getTrainingTimes(),
                    eliteSwimmers.get(i).getTournaments(), eliteSwimmers.get(i).isPassive());
        }
        System.out.println("Enter swimmer ID:");
        searchID = readChoiceInt();
        for (int i = 0; i < eliteSwimmers.size(); i++) {
            if (searchID == eliteSwimmers.get(i).getId()) {
                if (eliteSwimmers.get(i).getTrainingTimes().size() > 1) {
                    System.out.println(eliteSwimmers.get(i).getTrainingTimes().toString());
                    System.out.println("Which training time to you want to delete? 1/2/3/4.");
                    input = readChoiceInt();
                    if (input == 1) {
                        eliteSwimmers.get(i).getTrainingTimes().remove(0);
                    } else if (input == 2) {
                        eliteSwimmers.get(i).getTrainingTimes().remove(1);
                    } else if (input == 3) {
                        eliteSwimmers.get(i).getTrainingTimes().remove(2);
                    } else {
                        eliteSwimmers.get(i).getTrainingTimes().remove(3);
                    }
                } else {
                    eliteSwimmers.get(i).getTrainingTimes().remove(i);
                }
            }
            try {
                PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv"));
                for (i = 0; i < fileHandler.readMembers.size(); i++) {
                    if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                        fileWriter.println(new EliteSwimmer(fileHandler.readMembers.get(i).getId(),
                                fileHandler.readMembers.get(i).getName(), fileHandler.readMembers.get(i).getAge(),
                                ((EliteSwimmer) fileHandler.readMembers.get(i)).getCoach(),
                                ((EliteSwimmer) fileHandler.readMembers.get(i)).getSwimmingDiscipline(),
                                fileHandler.readMembers.get(i).isPassive(), fileHandler.readMembers.get(i).hasArrears(),
                                ((EliteSwimmer) fileHandler.readMembers.get(i)).getTournaments().toString(),
                                ((EliteSwimmer) fileHandler.readMembers.get(i)).getTrainingTimes().toString()).printMember((EliteSwimmer) fileHandler.readMembers.get(i)));
                    }
                }
                System.out.println("Training time deleted.");
                fileWriter.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteTournamentResult() {
        int searchID;
        int input;
        ArrayList<EliteSwimmer> eliteSwimmers = new ArrayList<>();
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                eliteSwimmers.add((EliteSwimmer) fileHandler.readMembers.get(i));
            }
        }
        System.out.println("ELITE SWIMMERS");
        for (int i = 0; i < eliteSwimmers.size(); i++) {
            System.out.printf("ID: %-2d \t Name: %-20s \t Age: %-3d \t Type: %-6s \t Coach: %-10s \t Discipline: %-15s \t" +
                            "TrainingTimes: %s \t Tournaments: %s \t Passive %-5s\n",
                    eliteSwimmers.get(i).getId(), eliteSwimmers.get(i).getName(), eliteSwimmers.get(i).getAge(),
                    eliteSwimmers.get(i).getTypeOfMembership(), eliteSwimmers.get(i).getCoach(),
                    eliteSwimmers.get(i).getSwimmingDiscipline(), eliteSwimmers.get(i).getTrainingTimes(),
                    eliteSwimmers.get(i).getTournaments(), eliteSwimmers.get(i).isPassive());
        }
        System.out.println("Enter swimmer ID:");
        searchID = readChoiceInt();
        for (int i = 0; i < eliteSwimmers.size(); i++) {
            if (searchID == eliteSwimmers.get(i).getId()) {
                System.out.println(eliteSwimmers.get(i).getTournaments().toString());
                System.out.println("Which tournament result to you want to delete?");
                input = readChoiceInt() - 1;
                eliteSwimmers.get(i).getTournaments().remove(input);
            }
        }
        try {
            PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv"));
            for (int i = 0; i < fileHandler.readMembers.size(); i++) {
                if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                    fileWriter.println(new EliteSwimmer(fileHandler.readMembers.get(i).getId(),
                            fileHandler.readMembers.get(i).getName(), fileHandler.readMembers.get(i).getAge(),
                            ((EliteSwimmer) fileHandler.readMembers.get(i)).getCoach(),
                            ((EliteSwimmer) fileHandler.readMembers.get(i)).getSwimmingDiscipline(),
                            fileHandler.readMembers.get(i).isPassive(), fileHandler.readMembers.get(i).hasArrears(),
                            ((EliteSwimmer) fileHandler.readMembers.get(i)).getTournaments().toString(),
                            ((EliteSwimmer) fileHandler.readMembers.get(i)).getTrainingTimes().toString()).printMember((EliteSwimmer) fileHandler.readMembers.get(i)));
                }
            }
            System.out.println("Tournament result deleted.");
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}