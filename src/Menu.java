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
        boolean isRunning = true;
        System.out.println("Welcome Coach");
        while (isRunning) {
            menuHeader = "Main Menu";
            leadText = "Please choose an option:";
            menuItems = new String[]{"1. Add a training result", "2. Add a tournament result", "3. View training results",
                    "4. View tournament results","5. View Elite Swimmers" , "6. Delete training result", "7. Delete tournament result",
            "8. Quit"};
            printMenu();
            int inputChoice = readChoiceInt();

            switch (inputChoice) {
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
                    //View Elite Swimmers
                    break;
                case 6:
                    //Delete Training Result
                    break;
                case 7:
                    //Delete tournament Result
                    break;
                case 8:
                    System.out.println("You've Chosen to Quit.");
                    isRunning = false;
                    break;
            }
        }
    }

    public void treasurerMenu(){
        boolean isRunning = true;
        System.out.println("Welcome Treasurer");
        while (isRunning) {
            menuHeader = "Main Menu";
            leadText = "Please choose an option:";
            menuItems = new String[]{"1. View Arrears/Passive", "2. Change Arrears/Passive", "3. Quit"};
            printMenu();
            int input = readChoiceInt();

            switch (input) {
                case 1:
                    memberHandler.printMembers();
                    break;
                case 2:
                    memberHandler.changeArrears();
                    break;
                case 3:
                    System.out.println("You've chosen to Quit.");
                    isRunning = false;
            }
        }
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

        //Usernames
        String usernamePresident = "President";
        String usernameCoach = "Coach";
        String usernameTreasurer = "Treasurer";

        //Passwords
        String passwordPresident = "president";
        String passwordCoach = "coach";
        String passwordTreasurer = "treasurer";


        System.out.print("Enter username: ");
        username = in.nextLine();
        System.out.print("Enter password: ");
        password = in.nextLine();

        if(username.equalsIgnoreCase(usernamePresident) && password.equals(passwordPresident)){
            presidentMenu();
        } else if (username.equalsIgnoreCase(usernameCoach) && password.equals(passwordCoach)) {
            coachMenu();
        } else if (username.equalsIgnoreCase(usernameTreasurer) && password.equals(passwordTreasurer)) {
            treasurerMenu();
        } else {
            System.out.println("Access denied.");
        }
    }
}
