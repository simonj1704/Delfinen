package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {



    ArrayList<Member> readMembers = new ArrayList<>();

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

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setReadMembers();
        System.out.println(fileHandler.readMembers);
    }
}
