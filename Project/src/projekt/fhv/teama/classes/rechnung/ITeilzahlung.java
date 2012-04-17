package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface ITeilzahlung extends IDao {
	public void setZahlungsmethode(IZahlungsmethode zahlungsmethode);
	public IZahlungsmethode getZahlungsmethode();
	public void setRechnung(IRechnung rechnung);
	public IRechnung getRechnung();
	public void setBetrag(double Betrag);
	public double getBetrag();
}
