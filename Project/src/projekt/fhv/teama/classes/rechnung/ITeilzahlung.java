package projekt.fhv.teama.classes.rechnung;

import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface ITeilzahlung extends IDao {
	public void setZahlungsmethode(Set<IZahlungsmethode> zahlungsmethoden);
	public Set<IZahlungsmethode> getZahlungsmethoden();
	public void addZahlungsmethode(IZahlungsmethode zahlungsmethode);
	public void removeZahlungsmethode(IZahlungsmethode zahlungsmethode);
	public IZahlungsmethode getZahlungsmethode();
	public void setRechnung(IRechnung rechnung);
	public IRechnung getRechnung();
	public void setBetrag(float betrag);
	public float getBetrag();
}
