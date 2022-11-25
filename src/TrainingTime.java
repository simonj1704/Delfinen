package src;


import src.memberTypes.EliteSwimmer;

import java.time.LocalDate;

public class TrainingTime {
    private int resultMonth;
    private int resultDate;
    private int year;
    private int trainingSeconds;
    private int trainingMilSeconds;
    private String discipline;
    private LocalDate date;

    // Constructors
    public TrainingTime(EliteSwimmer eliteSwimmer, LocalDate date, int trainingSeconds, int trainingMilSeconds, String discipline) {
        setTrainingSeconds(trainingSeconds);
        setTrainingMilSeconds(trainingMilSeconds);
        setDiscipline(discipline);
        this.date = date;
    }


    // Getters
    public int getTrainingMilSeconds() {
        return trainingMilSeconds;
    }
    public int getTrainingSeconds() {
        return trainingSeconds;
    }
    public String getDiscipline() {
        return discipline;
    }

    // Setters
    public void setTrainingMilSeconds(int trainingMilSeconds) {
        this.trainingMilSeconds = trainingMilSeconds;
    }
    public void setTrainingSeconds(int trainingSeconds) {
        this.trainingSeconds = trainingSeconds;
    }
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
