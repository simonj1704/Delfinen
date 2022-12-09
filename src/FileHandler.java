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
            readMembers.clear();
            Scanner fileReader = new Scanner(new File("Members.csv"));
            while(fileReader.hasNextLine()){
                ArrayList<String> tokens = new ArrayList<>();
                Scanner tokenReader = new Scanner(fileReader.nextLine());
                tokenReader.useDelimiter(";");
                while(tokenReader.hasNext()){
                    tokens.add(tokenReader.next());
                }
                if (tokens.size() > 8){
                    readMembers.add(new EliteSwimmer(Integer.parseInt(tokens.get(0)), tokens.get(1),
                            Integer.parseInt(tokens.get(2)),
                            tokens.get(5), tokens.get(6),
                            Boolean.parseBoolean(tokens.get(7)), Boolean.parseBoolean(tokens.get(8)),
                            tokens.get(10),tokens.get(11)));
                } else {
                    readMembers.add(new Member(Integer.parseInt(tokens.get(0)), tokens.get(1),
                            Integer.parseInt(tokens.get(2)), tokens.get(4),
                            Boolean.parseBoolean(tokens.get(5)), Boolean.parseBoolean(tokens.get(6))));
                }
                tokenReader.close();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeMember(String member) {
        try {
            PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv", true));
            fileWriter.println(member);
            fileWriter.close();
            readMembers.clear();
            setReadMembers();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void changeMember() {
        try {
            PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv"));
            for (int i = 0; i < readMembers.size(); i++) {
                if (readMembers.get(i) instanceof EliteSwimmer){
                    fileWriter.println(new EliteSwimmer(readMembers.get(i).getId(),
                            readMembers.get(i).getName(), readMembers.get(i).getAge(),
                            ((EliteSwimmer) readMembers.get(i)).getCoach(), ((EliteSwimmer) readMembers.get(i)).getSwimmingDiscipline(),
                            readMembers.get(i).isPassive(), readMembers.get(i).hasArrears(),
                            ((EliteSwimmer) readMembers.get(i)).getTournaments().toString(),
                            ((EliteSwimmer) readMembers.get(i)).getTrainingTimes().toString()).printMember((EliteSwimmer) readMembers.get(i)));
                } else {
                fileWriter.println(new Member().printMember(readMembers.get(i)));
                }
            }
            System.out.println("Member successfully Changed");
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteMember(){
        boolean deleted = false;
        int delete;
        System.out.print("What member do you want to delete(ID): ");
        delete = new MemberHandler().readChoiceInt();
        int index;
        for (int i = 0; i < readMembers.size(); i++) {
            if (readMembers.get(i).getId() == delete){
                index = i;
                readMembers.remove(index);
                try {
                    PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv"));
                    for (i = 0; i < readMembers.size(); i++) {
                        if (readMembers.get(i) instanceof EliteSwimmer){
                            fileWriter.println(new EliteSwimmer(readMembers.get(i).getId(),
                                    readMembers.get(i).getName(), readMembers.get(i).getAge(),
                                    ((EliteSwimmer) readMembers.get(i)).getCoach(), ((EliteSwimmer) readMembers.get(i)).getSwimmingDiscipline(),
                                    readMembers.get(i).isPassive(), readMembers.get(i).hasArrears(),
                                    ((EliteSwimmer) readMembers.get(i)).getTournaments().toString(),
                                    ((EliteSwimmer) readMembers.get(i)).getTrainingTimes().toString()).printMember((EliteSwimmer) readMembers.get(i)));
                        } else {
                            fileWriter.println(new Member().printMember(readMembers.get(i)));
                        }
                    }
                    System.out.println("Member successfully deleted");
                    deleted = true;
                    fileWriter.close();
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if (!deleted) {
            System.out.println("Member not Found.");
        }
    }
    public void deleteResults(String message){
        try {
            PrintStream fileWriter = new PrintStream(new FileOutputStream("Members.csv"));
            for (int i = 0; i < readMembers.size(); i++) {
                if (readMembers.get(i) instanceof EliteSwimmer) {
                    fileWriter.println(new EliteSwimmer(readMembers.get(i).getId(),
                            readMembers.get(i).getName(), readMembers.get(i).getAge(),
                            ((EliteSwimmer) readMembers.get(i)).getCoach(),
                            ((EliteSwimmer) readMembers.get(i)).getSwimmingDiscipline(),
                            readMembers.get(i).isPassive(), readMembers.get(i).hasArrears(),
                            ((EliteSwimmer) readMembers.get(i)).getTournaments().toString(),
                            ((EliteSwimmer) readMembers.get(i)).getTrainingTimes().toString()).printMember((EliteSwimmer) readMembers.get(i)));
                }
            }
            System.out.println(message);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
