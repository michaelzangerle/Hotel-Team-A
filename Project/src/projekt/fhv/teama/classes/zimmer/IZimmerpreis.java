package projekt.fhv.teama.classes.zimmer;

public interface IZimmerpreis {
	public void setKategorie(IKategorie kategorie);
	public IKategorie getKategorie();
	public void setSaison(ISaison saison);
	public ISaison getSaison();
	public void setPreis(double preis);
	public double getPreis();
}
