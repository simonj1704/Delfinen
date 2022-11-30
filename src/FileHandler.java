package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {



    ArrayList<Member> readMembers = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void setReadMembers(){
        try {
            Scanner fileReader = new Scanner(new File("Members.csv"));
            while(fileReader.hasNextLine()){
                ArrayList<String> tokens = new ArrayList<>();
                Scanner tokenReader = new Scanner(fileReader.nextLine());
                tokenReader.useDelimiter(";");
                while(tokenReader.hasNext()){
                    tokens.add(tokenReader.next());
                }
                if (tokens.size() == 9){
                    readMembers.add(new EliteSwimmer(Integer.parseInt(tokens.get(0)), tokens.get(1),
                            Integer.parseInt(tokens.get(2)),
                            tokens.get(5), tokens.get(6),
                            Boolean.parseBoolean(tokens.get(7)), Boolean.parseBoolean(tokens.get(8))));
                } else {
                    readMembers.add(new Member(Integer.parseInt(tokens.get(0)), tokens.get(1),
                            Integer.parseInt(tokens.get(2)), tokens.get(4),
                            Boolean.parseBoolean(tokens.get(5)), Boolean.parseBoolean(tokens.get(6))));
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteMember(){
        int delete;
        System.out.println(readMembers);
        System.out.print("What member do you want to delete(ID): ");
        delete = in.nextInt();
        readMembers.remove(delete-1);
        try {
            PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv"));
            for (int i = 0; i < readMembers.size(); i++) {
                fileWriter.println(new Member().printMember(readMembers.get(i)));
            }
            System.out.println("Member succesfully deleted");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeMember(){
        int choice;
        System.out.println(readMembers);
        System.out.print("What member do you want to change(ID): ");
        choice = in.nextInt();
        Member member = readMembers.get(choice);
        System.out.println(readMembers.get(choice-1));
        System.out.print("What do you want to change: ");
        String change = in.nextLine();
        switch (change){
            case "name" -> {
                System.out.print("What do you want to change it to: ");
                readMembers.get(choice).setName(in.nextLine());
            }
            case "age" -> {
                System.out.print("What do you want to change the age to: ");
                readMembers.get(choice).setAge(in.nextInt());
            }
            case "swimmer" -> {
                System.out.print("What do you want to set this member as: ");
                readMembers.get(choice).setTypeOfSwimmer(in.nextLine());
            }
            case "passive" -> {
                System.out.print("Do you want to set this member as passive: ");
                String passive = in.nextLine();
                readMembers.get(choice).setHasArrears(passive.equals("yes"));
            }
            case "arrears" -> {
                System.out.print("Do you want to give this member arrears: ");
                String arrears = in.nextLine();
                readMembers.get(choice).setHasArrears(arrears.equals("yes"));
            }
        }
    }

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setReadMembers();
        System.out.println(fileHandler.readMembers);
        fileHandler.deleteMember();
    }
}
