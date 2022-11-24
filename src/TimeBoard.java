package src;


public class TimeBoard {
    private int month;
    private int date;
    private int hour;
    private int minutes;
    private int seconds;


    // Constructors
    public TimeBoard(int month, int date, int hour, int minutes, int seconds) {
        setMonth(month);
        setDate(date);
        setHour(hour);
        setMinutes(minutes);
        setSeconds(seconds);
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
    public int getSeconds() {
        return seconds;
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
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
