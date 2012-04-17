package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import projekt.fhv.teama.classes.IAufenthalt;

public interface IAufenthaltDao extends IGenericDao<IAufenthalt> {
	
	public List<IAufenthalt> getAufenthaltByGastName(String vorname, String nachname);
	public List<IAufenthalt> getAufenthaltByZimmerNummer(String nr);

}
