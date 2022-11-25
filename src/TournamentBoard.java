package src;

import java.time.LocalDate;

public class TournamentBoard {
    LocalDate date;

    private String tourneyName;
    private String placement;
    private int placementTimeSeconds;
    private int placementTimeMiliseconds;
    private String discipline;


    // Constructors
    public TournamentBoard(EliteSwimmer eliteSwimmer, LocalDate date, String tourneyName,String placement, int placementTimeSeconds,
                           int placementTimeMiliseconds) {
        setPlacement(placement);
        setDiscipline(discipline);
        setPlacementTimeSeconds(placementTimeSeconds);
        setPlacementTimeMiliseconds(placementTimeMiliseconds);
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
    public int getPlacementTimeMiliseconds(){
        return placementTimeMiliseconds;
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

    public void setPlacementTimeMiliseconds(int placementTimeMiliseconds) {
        this.placementTimeMiliseconds = placementTimeMiliseconds;
    }

    public void setPlacement(String placement){
        this.placement = placement;
    }
    public void setTourneyName(String tourneyName){
        this.tourneyName = tourneyName;
    }
}

