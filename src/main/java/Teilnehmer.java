public class Teilnehmer {
    private String startNr;
    private String kategorie;
    private String name;

    public Teilnehmer(String startNr, String kategorie, String name) {
        this.startNr = startNr;
        this.kategorie = kategorie;
        this.name = name;
    }

    public String getStartNr() {
        return startNr;
    }

    public void setStartNr(String startNr) {
        this.startNr = startNr;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
