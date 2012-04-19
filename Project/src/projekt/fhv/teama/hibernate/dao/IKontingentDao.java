package projekt.fhv.teama.hibernate.dao;



import java.util.Set;

import projekt.fhv.teama.classes.IKontingent;

public interface IKontingentDao extends IGenericDao<IKontingent> {
	public Set<IKontingent> getKontingentByVPID(int iid);
	public Set<IKontingent> getKontingentByName(String name);
}
