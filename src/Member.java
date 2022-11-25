package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    ArrayList<Member> members = new ArrayList<>();
    private int age;
    private String name;
    private String typeOfMembership; // Senior / junior
    private String typeOfSwimmer; // Elite / hobbyist
    private boolean isPassive;
    private boolean hasArrears; // Restance
    private int id = 0;
    private static int nextId;

    // Constructors
    public Member(String name, int age, boolean isPassive, boolean hasArrears, String typeOfSwimmer) {
        setName(name);
        setAge(age);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
        setTypeOfSwimmer(typeOfSwimmer);
        setTypeOfMembership(age);
        id += nextId++;

    }

    public void setTypeOfMembership(int age) {
        if (age < 18) {
            typeOfMembership = "Junior";
        } else {
            typeOfMembership = "Senior";
        }
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getTypeOfSwimmer() {
        return typeOfSwimmer;
    }
    public boolean hasArrears() {
        return hasArrears;
    }
    public String getTypeOfMembership() {
        return typeOfMembership;
    }
    public boolean isPassive() {
        return isPassive;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHasArrears(boolean hasArrears) {
        this.hasArrears = hasArrears;
    }
    public void setIsPassive(boolean passive) {
        isPassive = passive;
    }
    public void setTypeOfMembership(String typeOfMembership) {
        this.typeOfMembership = typeOfMembership;
    }
    public void setTypeOfSwimmer(String typeOfSwimmer) {
        this.typeOfSwimmer = typeOfSwimmer;
    }

    public void addMember(){
        Scanner in = new Scanner(System.in);
        Member member;
        System.out.println("Type member name: ");
        name = in.nextLine();
        System.out.println("Type member age: ");
        age = in.nextInt();
        in.nextLine(); //Scanner bug
        System.out.println("Choose type of swimmer: ");
        typeOfSwimmer = in.nextLine();
        System.out.println("Passive or active subscription?");
        if (in.nextLine().equals("Passive".toLowerCase())){
            isPassive = true;
        } else {
            isPassive = false;
        }
        Member newMember = new Member(name,age,isPassive,false, typeOfSwimmer);

    }

    @Override
    public String toString() {
        return "Member{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", typeOfMembership='" + typeOfMembership + '\'' +
                ", typeOfSwimmer='" + typeOfSwimmer + '\'' +
                ", isPassive=" + isPassive +
                ", hasArrears=" + hasArrears +
                '}';
    }
}
