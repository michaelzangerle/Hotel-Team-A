package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.leistungen.ILeistung;

public interface IAufenthaltLeistung extends IModel {
	
	public ILeistung getLeistung();

	public void setLeistung(ILeistung paket);

	public IAufenthalt getAufenthalt();

	public void setAufenthalt(IAufenthalt aufenthalt);

	public int getAnzahl();

	public void setAnzahl(int anzahl);

	public Date getDatum();

	public void setDatum(Date datum);

}
