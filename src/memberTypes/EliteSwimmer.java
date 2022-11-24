package src.memberTypes;

import src.Member;

public class EliteSwimmer extends Member {

    public EliteSwimmer(String name, int age, String typeOfMembership, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setTypeOfMembership(typeOfMembership);
        setTypeOfSwimmer("Elite Swimmer");
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
    }

    @Override
    public String toString() {
        return getName() + getAge() + getTypeOfMembership() + getTypeOfSwimmer() + isPassive() + hasArrears();
    }
}
