package kayttajat.opiskelija;
import java.util.HashMap;
import kayttajat.henkilo.Henkilo;

public class Opiskelija extends Henkilo {
    /**
	 *
	 */
	private static final long serialVersionUID = 4329592575951960482L;
	protected String opNumero;
    protected HashMap<String, String> kurssiSuoritukset;

    public Opiskelija(String nimi, String salasana, String opNumero, String sposti) {
		super(nimi, salasana, sposti);
		this.opNumero = opNumero;
		kurssiSuoritukset = new HashMap<>();
	}
	public String getOpNumero() {
		return opNumero;
	}
	public void setOpNumero(String opNumero) {
		this.opNumero = opNumero;
	}
	public HashMap<String, String> getKurssiSuoritukset() {
		return kurssiSuoritukset;
	}
	public void lisaaKurssiSuoritus(String kurssi, String arvosana) {
		this.kurssiSuoritukset.put(kurssi, arvosana);
	}
	@Override
	public String toString() {
		return "Opiskelija [kurssiSuoritukset=" + kurssiSuoritukset + ", opNumero=" + opNumero + "]";
	}
}
