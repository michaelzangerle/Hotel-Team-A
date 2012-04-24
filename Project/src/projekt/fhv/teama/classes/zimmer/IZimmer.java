package projekt.fhv.teama.classes.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.IModel;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;

public interface IZimmer extends IModel {

	public void setNummer(String nummer);

	public String getNummer();

	public void setKategorie(IKategorie kategorie);

	public IKategorie getKategorie();

	public void setBeschreibung(String beschreibung);

	public String getBeschreibung();

	public void setZimmerstatus(IZimmerstatus zimmerStatus);

	public IZimmerstatus getZimmerstatus();

	public Set<IStatusentwicklung> getStatusentwicklungen();

	public void setStatusentwicklungen(Set<IStatusentwicklung> statusenticklung);

	public void addReservierung(IReservierung res);

	public void removeReservierung(IReservierung res);

	public Set<IReservierung> getReservierungen();

	public void setReservierungen(Set<IReservierung> reservierungen);

	public Set<IRechnungsposition> getRechnungspositionen();

	public void addRechungsposition(IRechnungsposition rechnungsposition);

	public void removeRechnungsposition(IRechnungsposition rechnungsposition);

	public void setRechnungspositionen(Set<IRechnungsposition> rechnungspositionen);

	public void setGaeste(Set<IGast> gaeste);

	public Set<IGast> getGaeste();

	public void addGast(IGast gast);

	public void removeGast(IGast gast);
	
	public void addAufenthalt(IAufenthalt aufenthalt);
	
	public Set<IAufenthalt> getAufenthalte();
	
	public void setAufenthalte(Set<IAufenthalt> aufenthalte);
	
	public void removeAufenthalt(IAufenthalt aufenthalt);

}
