package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Date;
import java.util.Set;

import projekt.fhv.teama.classes.zimmer.IReservierungsOption;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IReservierungsOptionDao extends IGenericDao<IReservierungsOption> {
	public Set<IReservierungsOption> getOption(Date zeitpunkt);
}
