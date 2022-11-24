package src;

public class Member {
    private int age;
    private String name;
    private String typeOfMembership; // Senior / junior
    private String typeOfSwimmer; // Elite / hobbyist
    private boolean isPassive;
    private boolean hasArrears; // Restance

    // Constructors
    public Member(String name, int age, String typeOfMembership, String typeOfSwimmer, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setTypeOfMembership(typeOfMembership);
        setTypeOfSwimmer(typeOfSwimmer);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getTypeOfMembership() {
        return typeOfMembership;
    }
    public String getTypeOfSwimmer() {
        return typeOfSwimmer;
    }
    public boolean hasArrears() {
        return hasArrears;
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
}
