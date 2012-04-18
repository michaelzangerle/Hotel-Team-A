package projekt.fhv.teama.classes.personen;


import java.util.Set;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.classes.zimmer.IZimmer;

public interface IGast extends IPerson {
	public void setNummer(String nummer);
	public int getNummer();
	public void addRechnungposition(IRechnungsposition rePos);
	public void removeRechnungsposition(IRechnungsposition rePos);
	public Set<IRechnungsposition> getRechnungsposition();
	public void addReservierung(IReservierung res);
	public void removeReservierung(IReservierung res);
	public Set<IReservierung> getReservierungen();
	public IReservierung getReservierung();
	public void addAufenthalt(IAufenthalt aufenthalt);
	public IAufenthalt getAufenthalt();
	public void removeAufenthalt(IAufenthalt aufenthalt);
	public void setZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
}
