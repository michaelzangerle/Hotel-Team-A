package projekt.fhv.teama.controller.interfaces.interfacesmodel;

public interface ITeilzahlung {
	public void setZahlungsmethode(IZahlungsmethode zahlungsmethode);
	public IZahlungsmethode getZahlungsmethode();
	public void setRechnung(IRechnung rechnung);
	public IRechnung getRechnung();
	public void setBetrag(double Betrag);
	public double getBetrag();
}
