package kayttajat;
import java.util.HashMap;

class Opiskelija {
    private String nimi;
    private String opNumero;
    private HashMap<String, Integer> kurssiSuoritukset;
    private String salasana;
    
    public Opiskelija(String nimi, String opNumero, HashMap<String, Integer> kurssiSuoritukset, String salasana) {
        this.nimi = nimi;
        this.opNumero = opNumero;
        this.kurssiSuoritukset = kurssiSuoritukset;
        this.salasana = salasana;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOpNumero() {
        return opNumero;
    }

    public void setOpNumero(String opNumero) {
        this.opNumero = opNumero;
    }

    public HashMap<String, Integer> getKurssiSuoritukset() {
        return kurssiSuoritukset;
    }

    public void setKurssiSuoritukset(HashMap<String, Integer> kurssiSuoritukset) {
        this.kurssiSuoritukset = kurssiSuoritukset;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

}