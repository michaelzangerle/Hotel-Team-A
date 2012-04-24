package projekt.fhv.teama.classes.rechnung;

import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface ITeilzahlung extends IModel {

	public void setZahlungsmethoden(Set<IZahlungsmethode> zahlungsmethoden);

	public Set<IZahlungsmethode> getZahlungsmethoden();

	public void addZahlungsmethode(IZahlungsmethode zahlungsmethode);

	public void removeZahlungsmethode(IZahlungsmethode zahlungsmethode);

	public void setRechnung(IRechnung rechnung);

	public IRechnung getRechnung();

	public void setBetrag(float betrag);

	public float getBetrag();
}
