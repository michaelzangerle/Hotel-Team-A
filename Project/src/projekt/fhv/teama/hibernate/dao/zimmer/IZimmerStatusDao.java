package projekt.fhv.teama.hibernate.dao.zimmer;

import projekt.fhv.teama.classes.zimmer.IZimmerstatus;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IZimmerStatusDao extends IGenericDao<IZimmerstatus> {
	public IZimmerstatus getZimmerStatus(String statusname);
}
