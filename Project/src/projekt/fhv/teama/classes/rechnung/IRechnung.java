
package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IRechnung extends IDao {
	public String getNummer();
	public void addRechnungsposition(IRechnungsposition rePos);
	public void removeRechnungsposition(IRechnungsposition rePos);
	public IRechnungsposition getRechnungspositionen();
	public void setSumme(double summe);
	public double getSumme();
	public void addTeilzahlung(ITeilzahlung teilzahl);
	public void removeTeilzahlung(ITeilzahlung teilzahl);
	public ITeilzahlung getTeilzahlungen();
	public void setMitarbeiter(IMitarbeiter mitarbeiter);
	public IMitarbeiter getMitarbeiter();
	public void setBezahlerVorname(String vorname);
	public String getBezahlerVorname();
	public void setBezahlerNachname(String nachname);
	public String getBezahlerNachname();
	public void setBezahlerStrasse(String strasse);
	public String getBezahlerStrasser();
	public void setBezahlerOrt(String ort);
	public String getBezahlerOrt();
	public void setBezahlerPlz(String plz);
	public String getBezahlerPlz();
}
