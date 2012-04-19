package projekt.fhv.teama.hibernate.dao;

import java.util.Set;

import projekt.fhv.teama.classes.IAufenthalt;

public interface IAufenthaltDao extends IGenericDao<IAufenthalt> {
	
	public Set<IAufenthalt> getAufenthaltByGastName(String vorname, String nachname);
	public Set<IAufenthalt> getAufenthaltByZimmerNummer(String nr);
}
