package projekt.fhv.teama.classes.zimmer;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.personen.IGast;
import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.dao.IModel;

public interface IReservierung extends IModel {
	
	public void addZimmer(IZimmer zimmer);
	public void removeZimmer(IZimmer zimmer);
	public Set<IZimmer> getZimmer();
	
	public void setPerson(IPerson person);
	public IPerson getPerson();
	
	public void addGast(IGast gast);
	public void removeGast(IGast gast);
	public Set<IGast> getGaeste();
	public void setGaeste(Set<IGast> gaeste);
	
	public void addOption(IReservierungsOption option);
	public void removeOption(IReservierungsOption option);
	public Set<IReservierungsOption> getOptionen();
	
	public void setVertragspartner(IVertragspartner partner);
	public IVertragspartner getVertragspartner();
	
	public Set<ITeilreservierung> getTeilreservierungen();
	public void setTeilreservierungen(Set<ITeilreservierung> teilreservierungen);
	public void addTeilreservierung(ITeilreservierung teilreservierung);
	public void removeTeilreservierung(ITeilreservierung teilreservierung);
	
	public void setVon(Date von);
	public Date getVon();
	public void setBis(Date bis);
	public Date getBis();
}
