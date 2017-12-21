import java.sql.Date;

public class Train {
    private int train_id;

    public Train(int train_id, String start_station, String end_station, Date travel_date, String time_of_day, int seat_free, int chosen) {
        this.train_id = train_id;
        this.start_station = start_station;
        this.end_station = end_station;
        this.travel_date = travel_date;
        this.time_of_day = time_of_day;
        this.seat_free = seat_free;
        this.chosen = chosen;
    }

    private String start_station;

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public Date getTravel_date() {
        return travel_date;
    }

    public void setTravel_date(Date travel_date) {
        this.travel_date = travel_date;
    }

    public String getTime_of_day() {
        return time_of_day;
    }

    public void setTime_of_day(String time_of_day) {
        this.time_of_day = time_of_day;
    }

    public int getSeat_free() {
        return seat_free;
    }

    public void setSeat_free(int seat_free) {
        this.seat_free = seat_free;
    }

    public int getChosen() {
        return chosen;
    }

    public void setChosen(int chosen) {
        this.chosen = chosen;
    }

    private String end_station;
    private Date travel_date;
    private String time_of_day;
    private int seat_free;
    private int chosen;



}
