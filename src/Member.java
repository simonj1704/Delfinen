package src;


public class Member {
    private int age;
    private String name;
    private String typeOfMembership; // Senior / junior
    private String typeOfSwimmer; // Elite / hobbyist
    private boolean isPassive;
    private boolean hasArrears; // Restance
    private int subscriptionPrice;
    private int id;
    private static int nextId;

    public void setNextId(int nextId) {
        Member.nextId = nextId;
    }

    // Constructors
    public Member(String name, int age, boolean isPassive, boolean hasArrears, String typeOfSwimmer) {
        setName(name);
        setAge(age);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
        setTypeOfSwimmer(typeOfSwimmer);
        setTypeOfMembership(age);
        setSubscriptionPrice();
        id = nextId++;

    }

    public Member(int id, String name, int age, String typeOfSwimmer, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
        setTypeOfSwimmer(typeOfSwimmer);
        setTypeOfMembership(age);
        setSubscriptionPrice();
        this.id = id;

    }

    public Member() {
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

    public int getId() {
        return id;
    }

    public void setSubscriptionPrice() {
        if (this.age < 18) {
            this.subscriptionPrice = 1000;
        } else if (this.age > 60) {
            this.subscriptionPrice = 1200;
        } else if (isPassive) {
            this.subscriptionPrice = 500;
        } else {
            this.subscriptionPrice = 1600;
        }
    }

    public int getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public String printMember(Member member) {
        String out;
        out = member.getId() + ";" + member.getName() + ";" + member.getAge() + ";" + member.getTypeOfMembership() + ";" +
                member.getTypeOfSwimmer() + ";" + member.isPassive() + ";" + member.hasArrears() + ";"
                + member.getSubscriptionPrice();
        return out;
    }

    public void viewMember(Member member) {
        System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Type: %-8s Subscription Price: %-7d Member: %-15s Arrears: %-7s Passive Member: %-7s\n",
                member.getId(), member.getName(), member.getAge(), member.getTypeOfMembership(),
                member.getSubscriptionPrice(), member.getTypeOfSwimmer(), member.hasArrears(), member.isPassive());
    }


    @Override
    public String toString() {
        return "Member{" +
                "ID = " + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", typeOfMembership='" + typeOfMembership + '\'' +
                ", typeOfSwimmer='" + typeOfSwimmer + '\'' +
                ", isPassive=" + isPassive +
                ", hasArrears=" + hasArrears +
                ", subscriptionPrice=" + subscriptionPrice +
                '}';
    }
}