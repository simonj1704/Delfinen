package src.memberTypes;

import src.Member;

public class EliteSwimmer extends Member {

    public EliteSwimmer(String name, int age, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setTypeOfSwimmer("Elite Swimmer");
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
    }
}
