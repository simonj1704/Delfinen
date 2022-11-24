package src.memberTypes;

import src.Member;

public class EliteSwimmer extends Member {
    private String coach;
    private String swimmingDiscipline; // Ryg, crawl, butterfly, breaststroke

    public EliteSwimmer(String name, int age, String coach, String swimmingDiscipline, boolean isPassive, boolean hasArrears) {
        setName(name);
        setAge(age);
        setTypeOfSwimmer("Elite Swimmer");
        setCoach(coach);
        setSwimmingDiscipline(swimmingDiscipline);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
    }

    public void setCoach(String coach){
        this.coach = coach;
    }

    public String getCoach() {
        return coach;
    }

    public void setSwimmingDiscipline(String swimmingDiscipline) {
        this.swimmingDiscipline = swimmingDiscipline;
    }

    public String getSwimmingDiscipline() {
        return swimmingDiscipline;
    }

    @Override
    public String toString() {
        return "EliteSwimmer{" +
                "coach='" + coach + '\'' +
                ", swimmingDiscipline='" + swimmingDiscipline + '\'' +
                '}';
    }
}