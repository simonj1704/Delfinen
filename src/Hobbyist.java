package src;

import src.Member;

public class Hobbyist extends Member {

    public Hobbyist(String name, int age) {
        super(name, age, false, false, "Hobbyist");
    }

    @Override
    public String toString() {
        return "Hobbyist{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", typeOfMembership='" + getTypeOfMembership() + '\'' +
                ", typeOfSwimmer='" + getTypeOfSwimmer() + '\'' +
                ", isPassive=" + isPassive() +
                ", hasArrears=" + hasArrears() +
                '}';
    }
}
