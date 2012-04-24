package projekt.fhv.teama.classes.zimmer;

import projekt.fhv.teama.hibernate.dao.IModel;

public interface IZimmerpreis extends IModel {
	public void setKategorie(IKategorie kategorie);

	public IKategorie getKategorie();

	public void setSaison(ISaison saison);

	public ISaison getSaison();

	public void setPreis(float preis);

	public float getPreis();
}
