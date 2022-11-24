package src.memberTypes;

import src.Member;

public class Hobbyist extends Member {

    public Hobbyist(String name, int age, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setTypeOfSwimmer("Hobbyist");
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
    }
}
