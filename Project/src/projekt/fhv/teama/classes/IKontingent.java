package projekt.fhv.teama.classes;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IKontingent extends IDao{
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
	public void setKontingent(short kontingent);
	public short getKontingent();
	public void setUeberbuchngsgrenze(short ueberbuGrenz);
	public short getUeberbuchungsgrenze();
	public void setVertragspartner(IVertragspartner partner);
	public IVertragspartner getVertragspartner();
}
