package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IReservierung extends IDao {
	public void addKategorie(IKategorie kat);
	public void removeKategorie(IKategorie kat);
	public IKategorie getKategorie();
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
	public void setPerson(IPerson person);
	public IPerson getPerson();
	public void addGast(IGast gast);
	public void removeGast(IGast gast);
	public IGast getGast();
	public void addOption(IOption option);
	public void removeOption(IOption option);
	public IOption getOption();
	public void setVertragspartner(IVertragspartner partner);
	public IVertragspartner getVertragspartner();
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
}
