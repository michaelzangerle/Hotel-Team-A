package projekt.fhv.teama.hibernate.dao.personen;

import java.util.Set;

import projekt.fhv.teama.classes.personen.IKontodaten;
import projekt.fhv.teama.hibernate.dao.IGenericDao;

public interface IKontodatenDao extends IGenericDao<IKontodaten> {
	public Set<IKontodaten> getKontodatenByPersonName(String vorname, String nachname);
	public Set<IKontodaten> getKontodatenByVPName(String name);
}
