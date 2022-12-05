package src;

import java.time.LocalDate;

public class TournamentBoard {
    LocalDate date = LocalDate.now();

    private String tourneyName = "Unknown";
    private String placement = "Unknown";
    private int placementTimeSeconds = 0;
    private int placementTimeMilliseconds = 0;
    private double placementTime = 0;
    private String discipline = "Unknown";


    // Constructors
    public TournamentBoard(LocalDate date, String tourneyName,String placement, int placementTimeSeconds,
                           int placementTimeMilliseconds) {
        setPlacement(placement);
        setDiscipline(discipline);
        setPlacementTime(placementTimeSeconds,placementTimeMilliseconds);
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
    public double getPlacementTime(){
        return placementTime;
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
    public void setPlacementTime(int placementSeconds, int placementMilliSeconds){
        placementTime = Double.parseDouble(placementSeconds + "." + placementMilliSeconds);
    }

    public void setPlacement(String placement){
        this.placement = placement;
    }
    public void setTourneyName(String tourneyName){
        this.tourneyName = tourneyName;
    }

    @Override
    public String toString() {
        return tourneyName +
                ":" + placement +
                ":" + placementTimeSeconds + ":" + placementTimeMilliseconds+
                ":" + discipline + ":" + date;
    }
}

