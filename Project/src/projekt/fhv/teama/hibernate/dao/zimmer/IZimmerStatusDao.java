package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IZimmerStatusDao extends IGenericDao<IZimmerstatus> {
	public IZimmerstatus getZimmerstatus(String statusname) throws DatabaseEntryNotFoundException;
}
