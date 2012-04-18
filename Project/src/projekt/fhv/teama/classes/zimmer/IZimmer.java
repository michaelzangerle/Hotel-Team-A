package projekt.fhv.teama.classes.zimmer;

import java.util.List;
import java.util.Set;

import projekt.fhv.teama.classes.Aufenthalt;
import projekt.fhv.teama.classes.IAufenthalt;
import projekt.fhv.teama.classes.personen.Gast;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.rechnung.IRechnungsposition;
import projekt.fhv.teama.classes.rechnung.Rechnungsposition;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IZimmer extends IDao {
	
	public void setNummer(String nummer);
	public String getNummer();
	
	public void setKategorie(IKategorie kategorie);
	public IKategorie getKategorie();
	
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	
	public void setZimmerStatus(IZimmerStatus zimmerStatus);
	public IZimmerStatus getZimmerStatus();

	public Set<IStatusEntwicklung> getStatusEntwicklung();
	public void setStatusenticklung(Set<IStatusEntwicklung> statusenticklung);

	
	
	public void addReservierung(IReservierung res);
	public void removerReservierung(IReservierung res);
	public IReservierung getReservierung();
	public Set<IReservierung> getReservierungen();
	public void setReservierungen(Set<IReservierung> reservierungen);
	
	public void addAufenthalt(IAufenthalt aufenthalt);
	public void removeAufenthalt(IAufenthalt aufenthalt);
	public void setAufenthalte(List<Aufenthalt> aufenthalte);
	public IAufenthalt getAufenthalte();
	
	
	public List<IRechnungsposition> getRechnungspositionen();
	public void addRechungsposition(IRechnungsposition rechnungsposition);
	public void removeRechnungsposition(IRechnungsposition rechnungsposition);
	public void setRechnungspositionen(List<Rechnungsposition> rechnungspositionen);
	
	public void setGaeste(Set<Gast> gaeste);
	public Set<Gast> getGaeste();
	public void addGast(IGast gast);
	public void removeGast(IGast gast);
	
}
