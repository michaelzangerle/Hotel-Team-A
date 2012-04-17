package projekt.fhv.teama.classes.rechnung;

import java.sql.Date;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IRechnungsposition extends IDao {
	public void setLeistung(ILeistung leistung);
	public ILeistung getLeistung();
	public void setEinzelpreis(double einzPreis);
	public double getEinzelpreis();
	public void setAnzahl(int Anzahl);
	public int getAnzahl();
	public void setSteuersatz(short steuersatz);
	public short getSteuersatz();
	public double getSumme();
	public void setErstellungsDatum(Date erstellDatum);
	public Date getErstellungsDatum();
	public void setZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
	public void setBeglichen(boolean beglichen);
	public boolean getBeglichen();
	public void setGast(IGast gast);
	public IGast getGast();
	public void setRechnung(IRechnung rechnung);
	public IRechnung getRechnung();
}
