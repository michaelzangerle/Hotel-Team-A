package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IReservierung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IReservierungDao extends IGenericDao<IReservierung> {
	
	public Set<IReservierung>getReservierungByPerson(String vorname,String nachname) throws DatabaseEntryNotFoundException ;
	public Set<IReservierung>getReservierungByVP(String name) throws DatabaseEntryNotFoundException;

}
