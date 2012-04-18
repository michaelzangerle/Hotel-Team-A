package projekt.fhv.teama.classes;



import java.util.Set;

import projekt.fhv.teama.hibernate.dao.IDao;

public interface IPfandTyp extends IDao {
	public void setBezeichnung(String bezeichnung);
	public String getBezeichnung();
	public void setBeschreibung(String beschreibung);
	public String getBeschreibung();
	public Set<IAufenthalt> getAufenthalte();
	public void setAufenthalte(Set<IAufenthalt> aufenthalte);
	
}
