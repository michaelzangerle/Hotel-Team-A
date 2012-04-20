package projekt.fhv.teama.hibernate.dao.zimmer;

import java.sql.Date;
import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IReservierungsOptionDao extends IGenericDao<IReservierungsOption> {
	public Set<IReservierungsOption> getOptionen(Date zeitpunkt)throws DatabaseEntryNotFoundException;
}
