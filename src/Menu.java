package src;

import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;

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

    public void userLogin(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println("Enter username: ");

        if(input.equalsIgnoreCase("coach")){
            System.out.println("Enter password ");
            if (input.equalsIgnoreCase("Coach")){
                //TODO add coachMenu()
            } else {
                System.out.println("Invalid password");
                //TODO add while loop?
            }
        } else if (input.equalsIgnoreCase("president")) {
            System.out.println("Enter password: ");
            if(input.equalsIgnoreCase("president")){
                //TODO add presidentMenu()
            } else {
                System.out.println("Invalid password");
            }
            
        } else if (input.equalsIgnoreCase("treasurer")) {
            System.out.println("Enter password");
            if (input.equalsIgnoreCase("treasurer")){
                //TODO add treasurerMenu()
            } else {
                System.out.println("Invalid password");
            }
            
        }
    }
    public void coachMenu(){

    }
    public void treasurerMenu(){

    }
    public void presidentMenu(){

    }
}
