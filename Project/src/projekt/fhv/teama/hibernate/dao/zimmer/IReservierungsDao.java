package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IReservierungsDao extends IGenericDao<IReservierung> {
	
	public Set<IReservierung>getReservierungByPerson(String vorname,String nachname);
	public Set<IReservierung>getReservierungByVertragspartner(String name);

}
