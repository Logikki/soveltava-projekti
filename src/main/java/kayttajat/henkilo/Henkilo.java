package kayttajat.henkilo;

public class Henkilo implements java.io.Serializable {
    protected String nimi;
    protected String salasana;
	protected String sposti;
	
	public Henkilo(String nimi, String salasana, String sposti) {
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
	public boolean onkoSalasana(String salasana) {
		if (salasana.equals(this.salasana)) {
			return true;
		}
		else {
			return false;
		}
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
	@Override
	public String toString() {
		return "[nimi=" + nimi + ", salasana=" + salasana + ", sposti=" + sposti + "]";
	}
}