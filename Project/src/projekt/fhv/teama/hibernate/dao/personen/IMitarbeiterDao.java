package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IMitarbeiter;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseException;

public interface IMitarbeiterDao extends IGenericDao<IMitarbeiter>  {
	
	public Set<IMitarbeiter> getMitarbeiterByName(String firstname, String lastname) throws DatabaseException;
	public Set<IMitarbeiter> getMitarbeiterByName(String name) throws DatabaseException;
	public Set<IMitarbeiter> getMitarbeiterByNummer(String mail) throws DatabaseException;
	
}
