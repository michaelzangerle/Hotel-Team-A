package projekt.fhv.teama.classes.zimmer;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.dao.IDao;

public interface IReservierung extends IDao {
	
	public void addKategorie(IKategorie kategorie);
	public void removeKategorie(IKategorie kategorie);
	public Set<IKategorie> getKategorie();
	public void setKategorie(Set<IKategorie> kategorie);
	
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public IZimmer getZimmer();
	
	public void setPerson(IPerson person);
	public IPerson getPerson();
	
	public void addGast(IGast gast);
	public void removeGast(IGast gast);
	public Set<IGast> getGast();
	
	public void addOption(IOption option);
	public void removeOption(IOption option);
	public Set<IOption> getOption();
	
	public void setVertragspartner(IVertragspartner partner);
	public IVertragspartner getVertragspartner();
	
	public void setVon(Timestamp von);
	public Timestamp getVon();
	public void setBis(Timestamp bis);
	public Timestamp getBis();
}
