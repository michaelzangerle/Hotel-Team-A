package projekt.fhv.teama.hibernate.dao.personen;

import java.util.List;

import projekt.fhv.teama.classes.personen.Kontodaten;
import projekt.fhv.teama.hibernate.dao.GenericDao;

public class KontodatenDao extends GenericDao<Kontodaten>{

	public KontodatenDao() {
		super("KONTODATEN");
	}
	
	public List<Kontodaten> getKontodatenByPersonName(String vorname, String nachname){
		
		//TODO Person: getKontodatenByPersonName(String vorname, String nachname)
		return null;
	}
	
	public List<Kontodaten> getKontodatenByVPName(String name){
		
		//TODO Vertragspartner: getKontodatenByVPName(String name)
		return null;
	}
	
	
}
