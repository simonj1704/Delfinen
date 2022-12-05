package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {
    public ArrayList<Member> members = new ArrayList<>();
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

    public void addMember() {
        int choice;
        int age;
        String name;
        System.out.print("1. Create Hobbyist. \n2. Create Elite Swimmer. \n3. Create Member. \nEnter Input: ");
        choice = readChoiceInt();

        System.out.print("Enter Name: ");
        name = in.nextLine();

        System.out.print("Enter Age: ");
        age = readChoiceInt();

        switch (choice) {
            case 1 -> createHobbyist(name, age);
            case 2 -> createElite(name, age);
            case 3 -> createMember(name, age);
            default -> System.out.print("Error.");
        }
    }

    public void createMember(String name, int age) {
        boolean isPassive = isPassive();
        boolean hasArrears = hasArrears();
        String typeOfSwimmer = getTypeOfSwimmer();

        members.add(new Member(name, age, isPassive, hasArrears, typeOfSwimmer));
        fileHandler.writeMember(member.printMember(new Member(name, age, isPassive, hasArrears, typeOfSwimmer)));
    }

    public void createElite(String name, int age) {
        String coach;
        String discipline;

        coach = getCoach();
        discipline = getDiscipline();
        EliteSwimmer eliteSwimmer = new EliteSwimmer(name, age, coach, discipline);
        members.add(eliteSwimmer);
        fileHandler.writeMember(eliteSwimmer.printMember(eliteSwimmer));
    }

    public void createHobbyist(String name, int age) {
        Hobbyist hobbyist = new Hobbyist(name, age);
        members.add(hobbyist);
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

    public void changeMember(){
        boolean isRunning = true;
        int choice;
        printMembers();
        System.out.print("What member do you want to change(ID): ");
        choice = readChoiceInt();
        int index = -1;
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i).getId() == choice){
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
        System.out.println("What do you want to change: ");
        System.out.println("Name\nAge\nType\nPassive\nArrears");
        while (isRunning) {
            String change = in.nextLine();
            switch (change.toLowerCase()) {
                case "name" -> {
                    System.out.print("What do you want to change the name to: ");
                    fileHandler.readMembers.get(index).setName(in.nextLine());
                    isRunning = false;
                }
                case "age" -> {
                    System.out.print("What do you want to change the age to: ");
                    int age = readChoiceInt();
                    fileHandler.readMembers.get(index).setAge(age);
                    fileHandler.readMembers.get(index).setTypeOfMembership(age);
                    isRunning = false;
                }
                case "type" -> {
                    System.out.print("What type do you want to set this member as: ");
                    fileHandler.readMembers.get(index).setTypeOfSwimmer(in.nextLine());
                    isRunning = false;
                }
                case "passive" -> {
                    System.out.print("Do you want to set this member as passive(yes): ");
                    String passive = in.nextLine();
                    fileHandler.readMembers.get(index).setHasArrears(passive.equals("yes"));
                    isRunning = false;
                }
                case "arrears" -> {
                    System.out.print("Do you want to give this member arrears(yes): ");
                    String arrears = in.nextLine();
                    fileHandler.readMembers.get(index).setHasArrears(arrears.equals("yes"));
                    isRunning = false;
                }
                default -> System.out.println("Unknown Input.");
            }
            fileHandler.changeMember();
        }
    }


    public void changeArrears(){
        boolean isRunning = true;
        int choice;
        printMembers();
        System.out.print("What member do you want to change(ID): ");
        choice = readChoiceInt();
        int index = -1;
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i).getId() == choice){
                index = i;
            }
        }
        System.out.println("------------------------------------------------");
        System.out.print("ID: " + fileHandler.readMembers.get(index).getId() + "     " +
                "Name: " + fileHandler.readMembers.get(index).getName() + "     " +
                "Age: " + fileHandler.readMembers.get(index).getAge() + "     " +
                "Type: " + fileHandler.readMembers.get(index).getTypeOfMembership() + "     " +
                "Arrears: " + fileHandler.readMembers.get(index).hasArrears() + "     " +
                "Passive" + fileHandler.readMembers.get(index).isPassive() + "\n");
        System.out.println("------------------------------------------------");
        System.out.println("What do you want to change: ");
        System.out.println("Passive\nArrears");
        while (isRunning) {
            String change = in.nextLine();
            switch (change.toLowerCase()) {
                case "passive" -> {
                    System.out.print("Do you want to set this member as passive(yes) or register active(no): ");
                    String passive = in.nextLine();
                    fileHandler.readMembers.get(index).setHasArrears(passive.equals("yes"));
                    isRunning = false;
                }
                case "arrears" -> {
                    System.out.print("Do you want to give this member arrears(yes) or remove arrears(no): ");
                    String arrears = in.nextLine();
                    fileHandler.readMembers.get(index).setHasArrears(arrears.equals("yes"));
                    isRunning = false;
                }
                default -> System.out.println("Unknown Input.");
            }
            fileHandler.changeMember();
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
            System.out.print("Do you want to add more disciplines(Y/N): ");
            input = in.nextLine();
            if (input.equalsIgnoreCase("y")) {
                discipline = discipline + ", " + getDiscipline();
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
        while (isRunning) {
            System.out.println("Is the member passive (Y) or active (N)");
            input = in.nextLine();
            if (input.equalsIgnoreCase("y")) {
                isPassive = true;
                isRunning = false;
            } else if (input.equalsIgnoreCase("n")) {
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
        System.out.println("Input tourney name");
        String tourneyName = in.nextLine();
        System.out.println("Input tournament placement");
        String placement = in.nextLine();
        System.out.println("Input swim time seconds");
        int placementTimeSeconds = readChoiceInt();
        System.out.println("Input swim time ms");
        int placementTimeMilliseconds = readChoiceInt();
        TournamentBoard newTournamentBoard = new TournamentBoard(date, tourneyName, placement, placementTimeSeconds
                , placementTimeMilliseconds);
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
    public void trainingTimePrint(){
        for (int i = 0; i < fileHandler.readMembers.size(); i++){
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Coach: %-10s Disciplines: %-20s\n",
                        fileHandler.readMembers.get(i).getId(),
                        fileHandler.readMembers.get(i).getName(), fileHandler.readMembers.get(i).getAge(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getCoach(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getSwimmingDiscipline());
                ((EliteSwimmer) fileHandler.readMembers.get(i)).printTimes();
            }

        }
    }
    public void tournamentTimePrint(){
        for (int i = 0; i < fileHandler.readMembers.size();i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Coach: %-10s Disciplines: %-20s\n",
                        fileHandler.readMembers.get(i).getId(),
                        fileHandler.readMembers.get(i).getName(), fileHandler.readMembers.get(i).getAge(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getCoach(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)).getSwimmingDiscipline(),
                        ((EliteSwimmer) fileHandler.readMembers.get(i)));
                ((EliteSwimmer) fileHandler.readMembers.get(i)).printTournaments();
            }
        }
    }

    public void top5Print(){
        System.out.print("What Discipline do you want to print: ");
        String discipline = in.nextLine();
        ArrayList<EliteSwimmer> eliteSwimmers = new ArrayList<>();
        for (int i = 0; i < fileHandler.readMembers.size(); i++) {
            if (fileHandler.readMembers.get(i) instanceof EliteSwimmer) {
                eliteSwimmers.add((EliteSwimmer) fileHandler.readMembers.get(i));

            }
        }
        if (discipline.equalsIgnoreCase("ryg")){
            RygTimeComparator rygSorter = new RygTimeComparator();
            eliteSwimmers.sort(rygSorter);
        } else if (discipline.equalsIgnoreCase("crawl")){
            CrawlTimeComparator crawlSorter = new CrawlTimeComparator();
            eliteSwimmers.sort(crawlSorter);
        } else if (discipline.equalsIgnoreCase("bryst")){
            BrystTimeComparator brystSorter = new BrystTimeComparator();
            eliteSwimmers.sort(brystSorter);
        } else if (discipline.equalsIgnoreCase("butterfly")){
            ButterflyTimeComparator flySorter = new ButterflyTimeComparator();
            eliteSwimmers.sort(flySorter);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(eliteSwimmers.get(i).printTimeFor5Top(discipline));
        }
    }
}