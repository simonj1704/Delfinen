package src;

import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;
    MemberHandler memberHandler = new MemberHandler();
    Scanner in = new Scanner(System.in);

    public Menu(String menuHeader, String leadText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }

    public void printMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuItems.length; i++)
            printString += menuItems[i] + "\n";
        System.out.print("\n" + printString);
    }

    public int readChoiceInt() {
        boolean validChoice = false;
        int choice = -1;

        while (!validChoice) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                validChoice = true;
            } else {
                in.nextLine();
                System.out.print(leadText);
            }
        }
        return choice;
    }

    public void coachMenu(){
        menuHeader = "Welcome Coach";
        leadText = "Please choose an option:";
        menuItems = new String[]{"1. Add a training result", "2. Add a tournament result", "3. View training results",
                "4. View tournament results"};
        printMenu();
        int inputChoice = readChoiceInt();
        in.nextLine();

        switch (inputChoice){
            case 1:
                memberHandler.createTrainingTime();
                break;
            case 2:
                memberHandler.createTournamentResult();
                break;
            case 3:
                //TODO add trainingTimePrint
                break;
            case 4:
                //TODO add tournamentResultPrint
                break;
            case 5:
        }
    }

    public void treasurerMenu(){
        menuHeader = "Welcome treasurer";
        leadText = "Please choose an option:";
        menuItems = new String[]{"1. view arrears"};
        printMenu();
        //TODO add print arrears

    }

    public void presidentMenu(){
        boolean isRunning = true;
        System.out.print("\nWelcome President.");
        while (isRunning) {
            menuHeader = "Main Menu:";
            leadText = "Please choose an option:";
            menuItems = new String[]{"1. Add member", "2. Delete members", "3. View members", "4. Change Member", "5. Quit" };
            printMenu();
            System.out.print("Enter input: ");
            int inputChoice = readChoiceInt();

            switch (inputChoice) {
                case 1:
                    memberHandler.addMember();
                    break;
                case 2:
                    memberHandler.fileHandler.deleteMember();
                    break;
                case 3:
                    memberHandler.printMembers();
                    break;
                case 4:
                    memberHandler.changeMember();
                    break;
                case 5:
                    System.out.println("You've chosen to Quit.");
                    isRunning = false;
                    break;
            }
        }
    }

    public void userLogin(){
        String username;
        String password;
        System.out.print("Enter username: ");
        username = in.nextLine();
        System.out.print("Enter password: ");
        password = in.nextLine();

        if(username.equalsIgnoreCase("President") && password.equalsIgnoreCase("president")){
            presidentMenu();
        } else if (username.equalsIgnoreCase("coach") && password.equalsIgnoreCase("coach")) {
            coachMenu();
        } else if (username.equalsIgnoreCase("treasurer") && password.equalsIgnoreCase("treasurer")) {
            treasurerMenu();
        } else {
            System.out.println("Access denied.");
        }
    }
}
