package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.ISaison;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface ISaisonDao extends IGenericDao<ISaison> {
	public ISaison getSaison(String saison)throws DatabaseEntryNotFoundException;
}
