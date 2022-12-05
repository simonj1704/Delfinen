package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

    public EliteSwimmer(int id, String name, int age, String coach, String swimmingDiscipline, boolean isPassive, boolean hasArrears, String tourney, String times) {
        super(id, name, age, "Elite Swimmer", false, false);
        setCoach(coach);
        setSwimmingDiscipline(swimmingDiscipline);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
        String[] time = splitTimes(times);
        String[] tournament = splitTourney(tourney);
        if (tournament.length != 0) {
            String[] date = getDate(tournament[5]);
            date[2] = date[2].replace("]", "");
            tournament[0] = tournament[0].replace("[","");
            tournamentTimes.add(new TournamentBoard(
                    LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                    tournament[0],
                    tournament[1],
                    Integer.parseInt(tournament[2]),
                    Integer.parseInt(tournament[3])
            ));
        }
        if (time.length != 0) {
            String[] date = getDate(time[3]);
            date[2] = date[2].replace("]", "");
            time[0] = time[0].replace("[","");
            trainingTimes.add(new TrainingTime(
                    LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                    Integer.parseInt(time[1]),
                    Integer.parseInt(time[2]),
                    time[0]
            ));
        }

    }

    public String[] splitTimes(String input){
        String[] out = input.split(":");
        return out;
    }

    public String[] getDate(String date){
        return date.split("-");
    }

    public String[] splitTourney(String input){
        String[] out = input.split(":");
        return out;
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
                + ";" + member.isPassive() + ";" + member.hasArrears() + ";" + member.getSubscriptionPrice() + ";"
                + member.trainingTimes + ";" + member.tournamentTimes;
        return out;
    }

    @Override
    public String printMember(Member member) {
        return super.printMember(member);
    }

    public void viewMember(EliteSwimmer member){
        System.out.printf("ID: %-4d \t Name: %-30s Age: %-4d Type: %-8s Subscription Price: %-7d Member: %-15s Arrears: %-7s Passive Member: %-7s\n",
                member.getId(), member.getName(), member.getAge(), member.getTypeOfMembership(),
                member.getSubscriptionPrice(), member.getTypeOfSwimmer(), member.hasArrears(), member.isPassive());
    }

    public void addTime(TrainingTime newTime) {
        trainingTimes.add(newTime);
    }
    public void addTourney(TournamentBoard newTournamentBoard){
        tournamentTimes.add(newTournamentBoard);

    }
    
    public void printTimes(){
        for (int i = 0; i < trainingTimes.size(); i++) {
            System.out.printf("%s %d %d %s",trainingTimes.get(i).getDate(),
                    trainingTimes.get(i).getTrainingSeconds(), trainingTimes.get(i).getTrainingMilSeconds(),
                    trainingTimes.get(i).getDiscipline());
        }
    }

    public double getTrainingTimes(){
        System.out.println(trainingTimes);
        return Double.parseDouble(trainingTimes.get(1) + "." + trainingTimes.get(2));
    }
    public void printTournaments(){
        for (int i = 0; i < tournamentTimes.size(); i++) {
            System.out.printf("%s %s %s %d %d",tournamentTimes.get(i).getTourneyName(),
                    tournamentTimes.get(i).getPlacement(), tournamentTimes.get(i).getDiscipline(),
                    tournamentTimes.get(i).getPlacementTimeSeconds(),
                    tournamentTimes.get(i).getPlacementTimeMilliseconds());
        }
    }


    @Override
    public String toString() {
        return "EliteSwimmer{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", id=" + getId() +
                ", coach='" + getCoach() + '\'' +
                ", swimmingDiscipline='" + getSwimmingDiscipline() + '\'' +
                ", typeOfMembership='" + getTypeOfMembership() + '\'' +
                ", typeOfSwimmer='" + getTypeOfSwimmer() + '\'' +
                ", isPassive=" + isPassive() +
                ", hasArrears=" + hasArrears() +
                ", subscriptionPrice" + getSubscriptionPrice() +
                ", Tournament-results= " + tournamentTimes.toString() +
                ", trainingTimes=" + trainingTimes.toString() +
                '}';
    }
}