public class Station {
    private int station_id;

    public int getStation_id() {
        return station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public String getStation_symbol() {
        return station_symbol;
    }

    private String station_name;
    private String station_symbol;

    public Station(int station_id, String station_name, String station_symbol)
    {
        this.station_id = station_id;
        this.station_name = station_name;
        this.station_symbol = station_symbol;
    }

}
