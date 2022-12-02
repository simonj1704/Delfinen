package src;

import java.time.LocalDate;

public class TournamentBoard {
    LocalDate date;

    private String tourneyName;
    private String placement;
    private int placementTimeSeconds;
    private int placementTimeMilliseconds;
    private String discipline;


    // Constructors
    public TournamentBoard(LocalDate date, String tourneyName,String placement, int placementTimeSeconds,
                           int placementTimeMilliseconds) {
        setPlacement(placement);
        setDiscipline(discipline);
        setPlacementTimeSeconds(placementTimeSeconds);
        setPlacementTimeMilliseconds(placementTimeMilliseconds);
        setTourneyName(tourneyName);
        this.date = date;
    }


    // Getters
    public String getDiscipline(){
        return discipline;
    }


    public int getPlacementTimeSeconds(){
        return placementTimeSeconds;
    }
    public int getPlacementTimeMilliseconds(){
        return placementTimeMilliseconds;
    }
    public String getPlacement(){
        return tourneyName;
    }
    public String getTourneyName(){
        return tourneyName;
    }

    // Setters


    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setPlacementTimeSeconds(int placementTimeSeconds) {
        this.placementTimeSeconds = placementTimeSeconds;
    }

    public void setPlacementTimeMilliseconds(int placementTimeMilliseconds) {
        this.placementTimeMilliseconds = placementTimeMilliseconds;
    }

    public void setPlacement(String placement){
        this.placement = placement;
    }
    public void setTourneyName(String tourneyName){
        this.tourneyName = tourneyName;
    }

    @Override
    public String toString() {
        return "Tournament: " + tourneyName +
                "\tPlacement : " + placement +
                "\tTime: " + placementTimeSeconds + ":" + placementTimeMilliseconds+
                "\tDiscipline" + discipline;
    }
}

