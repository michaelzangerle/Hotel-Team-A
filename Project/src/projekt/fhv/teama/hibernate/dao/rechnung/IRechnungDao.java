package projekt.fhv.teama.hibernate.dao.rechnung;

import java.util.Set;

import projekt.fhv.teama.classes.rechnung.IRechnung;
import projekt.fhv.teama.hibernate.dao.IGenericDao;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

public interface IRechnungDao extends IGenericDao<IRechnung> {
	public Set<IRechnung> getRechnungByMitarbeiter(String vorname, String nachname)throws DatabaseEntryNotFoundException;
	public Set<IRechnung> getRechnungByBezahler(String vorname, String nachname) throws DatabaseEntryNotFoundException;
}
