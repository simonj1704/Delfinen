package src;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {
    public ArrayList<Member> members = new ArrayList<>();
    Scanner in = new Scanner(System.in);


    public void addMember(int choice, String name, int age){

        switch (choice){
            case 1 -> createHobbyist();
            case 2 -> createElite(name, age);
            case 3 -> createMember();
        }
    }

    public void createMember(){

    }

    public void createElite(String name, int age){
        String coach;
        String discipline;

        coach = in.nextLine();
        discipline = in.nextLine();

        members.add(new EliteSwimmer(name, age, coach, discipline));

    }

    public void createHobbyist(){

    }
}
