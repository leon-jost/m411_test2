public class Messresultat {
    private String startNr;
    private String einlaufzeit;

    public Messresultat(String startNr, String einlaufzeit) {
        this.startNr = startNr;
        this.einlaufzeit = einlaufzeit;
    }

    public String getStartNr() {
        return startNr;
    }

    public void setStartNr(String startNr) {
        this.startNr = startNr;
    }

    public String getEinlaufzeit() {
        return einlaufzeit;
    }

    public void setEinlaufzeit(String einlaufzeit) {
        this.einlaufzeit = einlaufzeit;
    }
}
