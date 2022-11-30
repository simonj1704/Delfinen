package src;

import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;

    public Menu(){

    }

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

    public int readChoice() {
        Scanner in = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1;

        while (!validChoice) {
            System.out.print(leadText);
            if (in.hasNextInt()) {
                choice = in.nextInt();
                validChoice = true;
            } else {
                in.nextLine();
            }
        }
        return choice;
    }

    public void coachMenu(){
        menuHeader = "Welcome Coach";
        leadText = "Please choose an option:";
        menuItems = new String[]{"1. add a training result", "2. add a tournament result", "3. view training results",
                "4. view tournament results"};
        Menu menu = new Menu(menuHeader,leadText,menuItems);
        MemberHandler memberHandler = new MemberHandler();
        Scanner in = new Scanner(System.in);
        menu.printMenu();
        int inputChoice = in.nextInt();
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
                new FileHandler().printMember();
        }
    }
    public void treasurerMenu(){
        menuHeader = "Welcome treasurer";
        leadText = "Please choose an option:";
        menuItems = new String[]{"1. view arrears"};
        Menu menu = new Menu(menuHeader,leadText,menuItems);
        menu.printMenu();
        //TODO add print arrears

    }
    public void presidentMenu(){
        menuHeader = "Welcome president";
        leadText = "Please choose an option:";
        menuItems = new String[]{"1. Add member", "2. Delete members", "3. View members"};
        Menu menu = new Menu(menuHeader,leadText,menuItems);
        Scanner in = new Scanner(System.in);
        menu.printMenu();
        int inputChoice = in.nextInt();
        in.nextLine();

        switch (inputChoice){
            case 1:
                int choice = 0;
                String name = "";
                int age = 0;
                new MemberHandler().addMember(choice, name , age);
                break;
            case 2:
                new FileHandler().deleteMember();
                break;
            case 3:
                new FileHandler().printMember();
        }

    }
    public void userLogin(){
        Scanner in = new Scanner(System.in);
        String username;
        String password;
        System.out.println("Enter username: ");
        username = in.nextLine();
        System.out.println("Enter password ");
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

       /* if(input.equalsIgnoreCase("coach")){
            System.out.println("Enter password ");
            if (input.equalsIgnoreCase("Coach")){
                coachMenu();
            } else {
                System.out.println("Invalid password");
                //TODO add while loop?
            }
        } else if (input.equalsIgnoreCase("president")) {
            System.out.println("Enter password: ");
            if(input.equalsIgnoreCase("president")){
                presidentMenu();
            } else {
                System.out.println("Invalid password");
            }

        } else if (input.equalsIgnoreCase("treasurer")) {
            System.out.println("Enter password");
            if (input.equalsIgnoreCase("treasurer")){
                treasurerMenu();
            } else {
                System.out.println("Invalid password");
            }

        }*/
    }
}
