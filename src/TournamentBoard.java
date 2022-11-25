package src;

public class TournamentBoard {
    private int month;
    private int date;
    private int hour;
    private int minutes;
    private int seconds;


    // Constructors
    public TournamentBoard(int month, int date, int hour, int minutes) {
        setMonth(month);
        setDate(date);
        setHour(hour);
        setMinutes(minutes);
    }


    // Getters
    public int getMonth() {
        return month;
    }
    public int getDate() {
        return date;
    }
    public int getHour() {
        return hour;
    }
    public int getMinutes() {
        return minutes;
    }

    // Setters
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}
