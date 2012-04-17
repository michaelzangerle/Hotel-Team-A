package projekt.fhv.teama.classes.rechnung;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IKontodaten extends IDao {

	public void setIban(String iaban);
	public String getIban();
	public void setBic(String bic);
	public String getBic();
	public void setKontonummer(String ktoNr);
	public String getKontonummer();
	public void setBlz(String blz);
	public String getBlz();

}
