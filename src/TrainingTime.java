package src;


import java.time.LocalDate;

public class TrainingTime {
    private int trainingSeconds = 0;
    private int trainingMilSeconds = 0;
    private double trainingTime = 0;
    private String discipline = "Unknown";
    private LocalDate date = LocalDate.now();

    // Constructors
    public TrainingTime(LocalDate date, int trainingSeconds, int trainingMilSeconds, String discipline) {
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
    public double getTime(){
        return Double.parseDouble(trainingSeconds+"."+trainingMilSeconds);
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

    public LocalDate getDate(){
        return date;
    }

    @Override
    public String toString() {
        return discipline +
                ":" + trainingSeconds + ":" + trainingMilSeconds
                + ":" + date;
    }
}
