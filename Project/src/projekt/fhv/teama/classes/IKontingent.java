package projekt.fhv.teama.classes;

import java.util.Set;
import java.sql.Date;

import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.classes.zimmer.IKategorie;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IKontingent extends IDao {
	
	public void setVon(Date von);

	public Date getVon();

	public void setBis(Date bis);

	public Date getBis();

	public void setKondition(short kondition);

	public short getKondition();

	public void setUeberbuchungsgrenze(short ueberbuchungsgrenze);

	public short getUeberbuchungsgrenze();

	public void setVertragspartner(IVertragspartner vertragspartner);

	public IVertragspartner getVertragspartner();

	public Set<IKategorie> getKategorien();

	public void setKategorien(Set<IKategorie> kategorien);
}
