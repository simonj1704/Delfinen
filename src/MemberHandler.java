package src;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {
    public ArrayList<Member> members = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public MemberHandler(){
    }



    public void addMember(int choice, String name, int age){

        switch (choice){
            case 1 -> createHobbyist(name, age);
            case 2 -> createElite(name, age);
            case 3 -> createMember();
        }
    }

    public void createMember(){

    }

    public void createElite(String name, int age){
        String coach;
        String discipline;

        coach = getCoach();
        discipline = getDiscipline();
        while (true){
            System.out.print("Do you want to add more disciplines(Y/N): ");
            if (in.nextLine().equalsIgnoreCase("y")){
                discipline = discipline + ", " + getDiscipline();
            } else {
                break;
            }
        }

        members.add(new EliteSwimmer(name, age, coach, discipline));

    }

    public void createHobbyist(String name, int age){
        members.add(new Hobbyist(name, age));
    }


    public String getCoach(){
        System.out.print("Who is the Coach: ");
        return in.nextLine();
    }

    public String getDiscipline(){
        System.out.print("What is the discipline: ");
        return in.nextLine();
    }
}
