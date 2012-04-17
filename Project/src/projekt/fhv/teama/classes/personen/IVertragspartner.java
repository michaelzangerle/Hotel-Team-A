package projekt.fhv.teama.classes.personen;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IVertragspartner extends IDao {
	public void setName(String name);
	public String getNamer();
	public void setStrasse(String strasse);
	public String getStrasse();
	public void setOrt(String ort);
	public String getOrt();
	public void setPlz(String plz);
	public String getPlz();
	public void setTelefonNummer(String telNr);
	public String getTelefonNummer();
	public void setEmail(String email);
	public String getEmail();
	public void setIban(String iaban);
	public String getIban();
	public void setBic(String bic);
	public String getBic();
	public void setKontonummer(String ktoNr);
	public String getKontonummer();
	public void setBlz(String blz);
	public String getBlz();
	public void setLand(ILand land);
	public ILand getLand();
}
