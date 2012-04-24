package projekt.fhv.teama.hibernate.dao;

import java.util.Set;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.hibernate.exceptions.DatabaseEntryNotFoundException;

/**
 * Interface f�r die KontingentDao-Klasse 
 * @author Team A
 * @version 1.2
 */
public interface IKontingentDao extends IGenericDao<IKontingent> {
	
	/**
	 * Liefert die Kontingente von dem Vertragspartner mit der �bergebenen ID
	 * @param id int
	 * @return Set<IKontingent>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IKontingent> getKontingentByVPID(int id) throws DatabaseEntryNotFoundException;

	/**
	 * Liefert die Kontingente von dem Vertragspartner mit dem �bergebenen Namen
	 * @param name String
	 * @return Set<IKontingent>
	 * @throws DatabaseEntryNotFoundException
	 */
	public Set<IKontingent> getKontingentByVPName(String name) throws DatabaseEntryNotFoundException;
}
