package projekt.fhv.teama.classes.leistungen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IArtikel extends IDao {
	
	public void setBezeichnung(String bezeichnung);

	public String getBezeichnung();

	public void setBeschreibung(String beschreibung);

	public String getBeschreibung();

	public void setPreis(float preis);

	public float getPreis();

	public void setWarengruppe(IWarengruppe warengruppe);

	public IWarengruppe getWarengruppe();
}
