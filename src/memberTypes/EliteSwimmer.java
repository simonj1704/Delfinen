package src.memberTypes;

import src.Member;

public class EliteSwimmer extends Member {
    private String coach;

    public EliteSwimmer(String name, int age, String coach, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setTypeOfSwimmer("Elite Swimmer");
        setCoach(coach);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
    }

    public void setCoach(String coach){
        this.coach = coach;
    }

    public String getCoach() {
        return coach;
    }
}
