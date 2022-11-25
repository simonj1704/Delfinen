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
        int choice;

        System.out.print("What name: ");
        String name = memberHandler.in.nextLine();
        System.out.print("age: ");
        int age = memberHandler.in.nextInt();
        memberHandler.in.nextLine();
        menu.printMenu();
        
        memberHandler.addMember(menu.readChoice(), name, age);

        System.out.println(memberHandler.members);
    }
}
