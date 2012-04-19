package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IVertragspartner;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IVertragspartnerDao extends IGenericDao<IVertragspartner> {
	public Set<IVertragspartner> getVertragspartnerByName(String name);
}
