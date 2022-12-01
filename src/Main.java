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
        menu.userLogin();
    }
}
