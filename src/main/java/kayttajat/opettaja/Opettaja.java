package kayttajat.opettaja;
import kayttajat.henkilo.Henkilo;

public class Opettaja extends Henkilo {
	/**
	 *
	 */
	private static final long serialVersionUID = 2895440032784389096L;
	public Opettaja(String nimi, String salasana, String sposti) {
		super(nimi, salasana, sposti);
	}
    
	public String getSposti() {
		return sposti;
	}
	public void setSposti(String sposti) {
		this.sposti = sposti;
	}
}