/**
 * 
 */
package projekt.fhv.teama.hibernate.dao;

import java.util.List;

import projekt.fhv.teama.classes.Kontingent;

/**
 * @author mike
 *
 */
public class KontingentDao extends GenericDao<Kontingent>{

	public KontingentDao() {
		super("Kontingent");
		
	}
	
	public List<Kontingent> getKontingentByVPID(int id) {
		
		// TODO Kontingent: getKontingentByVPID(int id)
		return null;
	}
	
	public List<Kontingent> getKontingentByVPName(String name) {
		
		// TODO Kontingent: getKontingentByVPName(int id)
		return null;
	}
	
	

}
