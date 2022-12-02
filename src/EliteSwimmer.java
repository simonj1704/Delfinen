package src;

import java.util.ArrayList;

public class EliteSwimmer extends Member {
    private String coach;
    private String swimmingDiscipline; // Ryg, crawl, butterfly, breaststroke
    private ArrayList<TrainingTime> trainingTimes = new ArrayList<>();
    private ArrayList<TournamentBoard> tournamentTimes = new ArrayList<>();

    public EliteSwimmer(String name, int age, String coach, String swimmingDiscipline) {
        super(name, age, false, false, "Elite Swimmer");
        setCoach(coach);
        setSwimmingDiscipline(swimmingDiscipline);
    }

    public EliteSwimmer(int id, String name, int age, String coach, String swimmingDiscipline, boolean isPassive, boolean hasArrears) {
        super(id, name, age, "Elite Swimmer", false, false);
        setCoach(coach);
        setSwimmingDiscipline(swimmingDiscipline);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
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


    public String printMember(EliteSwimmer member){
        String out;
        out = member.getId() + ";" + member.getName() + ";" + member.getAge() + ";" + member.getTypeOfMembership() + ";" +
                member.getTypeOfSwimmer() + ";" + member.getCoach() + ";" + member.getSwimmingDiscipline()
                + ";" + member.isPassive() + ";" + member.hasArrears();
        return out;
    }

    public void addTime(TrainingTime newTime) {
        trainingTimes.add(newTime);
    }
    public void addTourney(TournamentBoard newTournamentBoard){
        tournamentTimes.add(newTournamentBoard);

    }

    @Override
    public String toString() {
        return "EliteSwimmer{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", id=" + getId() +
                ", coach='" + coach + '\'' +
                ", swimmingDiscipline='" + swimmingDiscipline + '\'' +
                ", typeOfMembership='" + getTypeOfMembership() + '\'' +
                ", typeOfSwimmer='" + getTypeOfSwimmer() + '\'' +
                ", isPassive=" + isPassive() +
                ", hasArrears=" + hasArrears() +
                ", subscriptionPrice" + getSubscriptionPrice() +
                ", Tournament-results= " + tournamentTimes +
                ", trainingTimes=" + trainingTimes.toString() +
                '}';
    }
}