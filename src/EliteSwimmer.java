package src;

import src.Member;

public class EliteSwimmer extends Member {
    private String coach;
    private String swimmingDiscipline; // Ryg, crawl, butterfly, breaststroke

    public EliteSwimmer(String name, int age, String coach, String swimmingDiscipline) {
        super(name, age, false, false, "Elite Swimmer");
        setCoach(coach);
        setSwimmingDiscipline(swimmingDiscipline);
    }

    public void setCoach(String coach) {
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
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", coach='" + coach + '\'' +
                ", swimmingDiscipline='" + swimmingDiscipline + '\'' +
                ", typeOfMembership='" + getTypeOfMembership() + '\'' +
                ", typeOfSwimmer='" + getTypeOfSwimmer() + '\'' +
                ", isPassive=" + isPassive() +
                ", hasArrears=" + hasArrears() +
                '}';
    }
}