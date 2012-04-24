package projekt.fhv.teama.classes;

import projekt.fhv.teama.classes.zimmer.IKategorie;

public interface IKategoriekontingent extends IModel {
	
	public IKategorie getKategorie();

	public void setKategorie(IKategorie kategorie);

	public IKontingent getKontingent();

	public void setKontingent(IKontingent kontingent);

	public int getAnzahl();

	public void setAnzahl(int anzahl);

	public int getVerfuegbar();

	public void setVerfuegbar(int verfuegbar);

}
