package projekt.fhv.teama.classes.rechnung;

public interface ITeilzahlung {
	public void setZahlungsmethode(IZahlungsmethode zahlungsmethode);
	public IZahlungsmethode getZahlungsmethode();
	public void setRechnung(IRechnung rechnung);
	public IRechnung getRechnung();
	public void setBetrag(double Betrag);
	public double getBetrag();
}
