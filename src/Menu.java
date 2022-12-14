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

    public void coachMenu() {
        boolean isRunning = true;
        System.out.println("Welcome Coach");
        while (isRunning) {
            menuHeader = "Main Menu";
            leadText = "Please choose an option:";
            menuItems = new String[]{"1. Add a training result", "2. Add a tournament result", "3. View training results",
                    "4. View tournament results", "5. View Elite Swimmers", "6. View Top 5 Swimmers",
                    "7. Delete training result", "8. Delete tournament result",
                    "9. Quit"};
            printMenu();
            int inputChoice = memberHandler.readChoiceInt();

            switch (inputChoice) {
                case 1 -> memberHandler.createTrainingTime();
                case 2 -> memberHandler.createTournamentResult();
                case 3 -> memberHandler.trainingTimePrint();
                case 4 -> memberHandler.tournamentTimePrint();
                case 5 -> memberHandler.printEliteSwimmers();
                case 6 -> memberHandler.top5Print();
                case 7 -> memberHandler.deleteTrainingResult();
                case 8 -> memberHandler.deleteTournamentResult();
                case 9 -> {
                    System.out.println("You've Chosen to Quit.");
                    isRunning = false;
                }
            }
        }
    }

    public void treasurerMenu() {
        boolean isRunning = true;
        System.out.println("Welcome Treasurer");
        while (isRunning) {
            menuHeader = "Main Menu";
            leadText = "Please choose an option:";
            menuItems = new String[]{"1. View Arrears/Passive", "2. Change Arrears/Passive", "3. Quit"};
            printMenu();
            int input = memberHandler.readChoiceInt();

            switch (input) {
                case 1 -> memberHandler.printMembers();
                case 2 -> memberHandler.changeArrears();
                case 3 -> {
                    System.out.println("You've chosen to Quit.");
                    isRunning = false;
                }
            }
        }
    }

    public void presidentMenu() {
        boolean isRunning = true;
        System.out.print("\nWelcome President.");
        while (isRunning) {
            menuHeader = "Main Menu:";
            leadText = "Please choose an option:";
            menuItems = new String[]{"1. Add member", "2. Delete members", "3. View members", "4. Change Member", "5. Quit"};
            printMenu();
            System.out.print("Enter input: ");
            int inputChoice = memberHandler.readChoiceInt();

            switch (inputChoice) {
                case 1 -> memberHandler.addMember();
                case 2 -> memberHandler.deleteMember();
                case 3 -> memberHandler.printMembers();
                case 4 -> memberHandler.changeMember();
                case 5 -> {
                    System.out.println("You've chosen to Quit.");
                    isRunning = false;
                }
            }
        }
    }

    public void userLogin() {
        String username;
        String password;

        String usernamePresident = "President";
        String usernameCoach = "Coach";
        String usernameTreasurer = "Treasurer";
        String passwordPresident = "president";
        String passwordCoach = "coach";
        String passwordTreasurer = "treasurer";

        System.out.print("Enter username: ");
        username = in.nextLine();
        System.out.print("Enter password: ");
        password = in.nextLine();

        if (username.equalsIgnoreCase(usernamePresident) && password.equals(passwordPresident)) {
            presidentMenu();
        } else if (username.equalsIgnoreCase(usernameCoach) && password.equals(passwordCoach)) {
            coachMenu();
        } else if (username.equalsIgnoreCase(usernameTreasurer) && password.equals(passwordTreasurer)) {
            treasurerMenu();
        } else {
            System.out.println("Access denied. Try again!");
            userLogin();
        }
    }
}
