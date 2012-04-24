
package projekt.fhv.teama.classes.rechnung;

import java.util.Set;

import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.ILand;
import projekt.fhv.teama.classes.personen.IMitarbeiter;

public interface IRechnung extends IModel {
	public String getNummer();
	public void setNummer(String nummer);
	public void addRechnungsposition(IRechnungsposition rePos);
	public void removeRechnungsposition(IRechnungsposition rePos);
	public Set<IRechnungsposition> getRechnungspositionen();
	public void setSumme(float summe);
	public float getSumme();
	public void addTeilzahlung(ITeilzahlung teilzahl);
	public void removeTeilzahlung(ITeilzahlung teilzahl);
	public Set<ITeilzahlung> getTeilzahlungen();
	public void setMitarbeiter(IMitarbeiter mitarbeiter);
	public IMitarbeiter getMitarbeiter();
	public void setBezahlerVorname(String bezahlerVorname);
	public String getBezahlerVorname();
	public void setBezahlerNachname(String bezahlerNachname);
	public String getBezahlerNachname();
	public void setBezahlerStrasse(String bezahlerStrasse);
	public String getBezahlerStrasse();
	public void setBezahlerOrt(String bezahlerOrt);
	public String getBezahlerOrt();
	public void setBezahlerPLZ(String bezahlerPLZ);
	public String getBezahlerPLZ();
	public ILand getBezahlerLand();
	public void setBezahlerLand(ILand bezahlerLand);
}
