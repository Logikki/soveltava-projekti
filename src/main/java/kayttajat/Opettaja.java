package kayttajat;
class Opettaja{
    private String nimi;
    private String salasana;
    private String sposti;

    public Opettaja(String nimi, String salasana, String sposti) {
        this.nimi = nimi;
        this.salasana = salasana;
        this.sposti = sposti;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    public String getSposti() {
        return sposti;
    }

    public void setSposti(String sposti) {
        this.sposti = sposti;
    }
}