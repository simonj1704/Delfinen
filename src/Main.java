package src;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String menuHeader = "Delfinen";
        String leadText = "Please choose an option\n";
        String[] menuItems = {"1. Create Hobbyist", "2. Create Elite Swimmer", "3. Create Member"};
        Menu menu = new Menu(menuHeader, leadText, menuItems);
        MemberHandler memberHandler = new MemberHandler();

        /*memberHandler.addMember(2,"Michael", 36);
        memberHandler.addMember(2,"sad", 26);
        memberHandler.addMember(2,"hgdf", 336);*/
        System.out.println(memberHandler.members);
        //memberHandler.placeTimeOnSwimmer();

        int choice;

        System.out.print("What name: ");
        String name = memberHandler.in.nextLine();
        System.out.print("age: ");
        int age = memberHandler.in.nextInt();
        memberHandler.in.nextLine();
        menu.printMenu();
        
        memberHandler.addMember(menu.readChoice(), name, age);

        System.out.println(memberHandler.members);


        // User login

        // Menu tekst med et valg


    }
}
