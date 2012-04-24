package projekt.fhv.teama.classes.rechnung;

import java.sql.Date;

import projekt.fhv.teama.classes.leistungen.ILeistung;
import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.zimmer.IZimmer;
import projekt.fhv.teama.hibernate.dao.IModel;

public interface IRechnungsposition extends IModel {
	public void setLeistung(ILeistung leistung);
	public ILeistung getLeistung();
	public void setEinzelpreis(float einzelpreis);
	public float getEinzelpreis();
	public void setAnzahl(int anzahl);
	public int getAnzahl();
	public void setSteuersatz(short steuersatz);
	public short getSteuersatz();
	public float getSumme();
	public void setSumme(float summe);
	public void setErstellung(Date erstellung);
	public Date getErstellung();
	public void setZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
	public void setBeglichen(boolean beglichen);
	public boolean getBeglichen();
	public void setGast(IGast gast);
	public IGast getGast();
	public void setRechnung(IRechnung rechnung);
	public IRechnung getRechnung();
	public ILeistung getLeistungID();
	public void setLeistungID(ILeistung leistung);
}
