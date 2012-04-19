package projekt.fhv.teama.hibernate.dao;



import java.util.Set;

import projekt.fhv.teama.classes.IKontingent;
import projekt.fhv.teama.hibernate.exceptions.NoDatabaseEntryFoundException;

public interface IKontingentDao extends IGenericDao<IKontingent> {
	public Set<IKontingent> getKontingentByVPID(int iid)throws NoDatabaseEntryFoundException ;
	public Set<IKontingent> getKontingentByVPName(String name)throws NoDatabaseEntryFoundException ;
}
