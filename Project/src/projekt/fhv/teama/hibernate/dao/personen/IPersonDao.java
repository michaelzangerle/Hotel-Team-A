package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IPerson;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IPersonDao extends IGenericDao<IPerson> {
	public Set<IPerson> getPerson(String name);
	public Set<IPerson> getPerson(String vorname, String nachname);
}
