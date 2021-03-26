package kayttajat.henkilo;

public class Henkilo implements java.io.Serializable {
    protected String nimi;
    protected String salasana;
<<<<<<< HEAD
	protected String sposti;
	public Henkilo(String nimi, String salasana, String sposti) {
=======
    
	public Henkilo(String nimi, String salasana) {
>>>>>>> master
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
}