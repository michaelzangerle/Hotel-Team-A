package projekt.fhv.teama.classes;

import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IKategoriekontigent extends IDao {
	
	public IKategorie getKategorie();

	public void setKategorie(IKategorie kategorie);

	public IKontingent getKontingent();

	public void setKontingent(IKontingent kontingent);

	public int getAnzahl();

	public void setAnzahl(int anzahl);

	public int getVerfuegbar();

	public void setVerfuegbar(int verfuegbar);

}
