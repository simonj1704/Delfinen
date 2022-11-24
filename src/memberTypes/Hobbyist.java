package src.memberTypes;

import src.Member;

public class Hobbyist extends Member {

    public Hobbyist(String name, int age, String typeOfMembership, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setTypeOfMembership(typeOfMembership);
        setTypeOfSwimmer("Hobbyist");
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
    }

    public String toString() {
        return getName() + getAge() + getTypeOfMembership() + getTypeOfSwimmer() + isPassive() + hasArrears();
    }
}
