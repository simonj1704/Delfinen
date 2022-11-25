package src;

public class Member {
    private int age;
    private String name;
    private String typeOfMembership; // Senior / junior
    private String typeOfSwimmer; // Elite / hobbyist
    private boolean isPassive;
    private boolean hasArrears; // Restance

    // Constructors
    public Member(String name, int age, boolean isPassive, boolean hasArrears, String typeOfSwimmer) {
        setName(name);
        setAge(age);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
        setTypeOfSwimmer(typeOfSwimmer);
        setTypeOfMembership(age);
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
