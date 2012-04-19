package projekt.fhv.teama.hibernate.dao.zimmer;

import java.util.Date;
import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IOptionDao extends IGenericDao<IOption> {
	public Set<IOption> getOption(Date zeitpunkt);
}
