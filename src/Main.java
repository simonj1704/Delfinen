package src;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String menuHeader = "Delfinen";
        String leadText = "Choices";
        String[] menuItems = {"1. Create Hobbyist", "2. Create Elite Swimmer", "3. Create Member"};
        Menu menu = new Menu(menuHeader, leadText, menuItems);
        MemberHandler memberHandler = new MemberHandler();
        int choice;

        menu.printMenu();
        choice = menu.readChoice();

        System.out.println("What name: ");
        String name = memberHandler.in.nextLine();
        System.out.println("age: ");
        int age = memberHandler.in.nextInt();
        memberHandler.in.nextLine();
        memberHandler.addMember(choice, name, age);

        System.out.println(memberHandler.members);
    }
}
