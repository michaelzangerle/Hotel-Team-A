package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IZimmerpreis extends IDao {
	public void setKategorie(IKategorie kategorie);
	public IKategorie getKategorie();
	public void setSaison(ISaison saison);
	public ISaison getSaison();
	public void setPreis(double preis);
	public double getPreis();
}
