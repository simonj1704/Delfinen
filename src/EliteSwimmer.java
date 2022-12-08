package src;

import java.time.LocalDate;
import java.util.ArrayList;

public class EliteSwimmer extends Member {
    private String coach;
    private String swimmingDiscipline; // Ryg, crawl, butterfly, breaststroke
    private ArrayList<TrainingTime> trainingTimes = new ArrayList<>();
    private ArrayList<TournamentBoard> tournamentTimes = new ArrayList<>();

    public EliteSwimmer(String name, int age, String coach, String swimmingDiscipline, boolean isPassive, boolean hasArrears) {
        super(name, age, isPassive, hasArrears, "Elite Swimmer");
        setCoach(coach);
        setSwimmingDiscipline(swimmingDiscipline);
    }

    public EliteSwimmer(int id, String name, int age, String coach, String swimmingDiscipline, boolean isPassive, boolean hasArrears, String tourney, String times) {
        super(id, name, age, "Elite Swimmer", isPassive, hasArrears);
        setCoach(coach);
        setSwimmingDiscipline(swimmingDiscipline);
        setIsPassive(isPassive);
        setHasArrears(hasArrears);
        setTrainingTimes(times);
        setTournamentTimes(tourney);


    }

    public void setTrainingTimes(String times){
        String[] trainingTime = times.split(",");
        String[] time = new String[0];
        for (int i = 0; i < trainingTime.length; i++) {
            time = splitTimes(trainingTime[i]);
            if (time[0].charAt(0) == ' '){
                time[0] = time[0].replace(" ", "");
            }
            if (time.length != 1) {
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
    }

    public void setTournamentTimes(String tourney){
        String[] tournaments = tourney.split(",");
        String[] tournament = new String[0];
        for (int i = 0; i < tournaments.length; i++) {
            tournament = splitTourney(tournaments[i]);
            if (tournament[0].charAt(0) == ' '){
                tournament[0] = tournament[0].replace(" ", "");
            }
            if (tournament.length != 1) {
                String[] date = getDate(tournament[5]);
                date[2] = date[2].replace("]", "");
                tournament[0] = tournament[0].replace("[","");
                tournamentTimes.add(new TournamentBoard(
                        LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])),
                        tournament[0], tournament[1], Integer.parseInt(tournament[2]),
                        Integer.parseInt(tournament[3]), tournament[4]
                ));
            }
        }
    }

    public String[] splitTimes(String input){
        return input.split(":");
    }

    public String[] getDate(String date){
        return date.split("-");
    }

    public String[] splitTourney(String input){
        return input.split(":");
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
                + member.tournamentTimes + ";" + member.trainingTimes;
        return out;
    }

    @Override
    public String printMember(Member member) {
        return super.printMember(member);
    }

    public void addTime(TrainingTime newTime) {
        trainingTimes.add(newTime);
    }
    public void addTourney(TournamentBoard newTournamentBoard){
        tournamentTimes.add(newTournamentBoard);

    }
    
    public void printTimes(){
        for (int i = 0; i < trainingTimes.size(); i++) {
            System.out.printf("Discipline: %s \t Time: %d:%d \t Date: %s\n",trainingTimes.get(i).getDiscipline(),
                    trainingTimes.get(i).getTrainingSeconds(), trainingTimes.get(i).getTrainingMilSeconds(),
                    trainingTimes.get(i).getDate());
        }
    }

    public void printTournaments(){
        for (int i = 0; i < tournamentTimes.size(); i++) {
            System.out.printf("Tourney Name: %s \t Placement: %s \t Discipline: %s \t Time: %d:%d\n",tournamentTimes.get(i).getTourneyName(),
                    tournamentTimes.get(i).getPlacement(), tournamentTimes.get(i).getDiscipline(),
                    tournamentTimes.get(i).getPlacementTimeSeconds(),
                    tournamentTimes.get(i).getPlacementTimeMilliseconds());
        }
    }

    public double getTrainingTime(String discipline){
        for (int i = 0; i < trainingTimes.size(); i++) {
            if (trainingTimes.get(i).getDiscipline().equalsIgnoreCase(discipline)){
                return trainingTimes.get(i).getTime();
            }
        }
        return 0;
    }

    public ArrayList<TrainingTime> getTrainingTimes(){
        return trainingTimes;
    }

    public ArrayList<TournamentBoard> getTournaments(){
        return tournamentTimes;
    }

    public String printTimeFor5Top(String discipline){
        String out;
        out = getId() + " " + getName() + " " + getTrainingTime(discipline);
        return out;
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