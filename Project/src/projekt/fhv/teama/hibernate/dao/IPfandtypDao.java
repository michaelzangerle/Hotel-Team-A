package projekt.fhv.teama.hibernate.dao;

import projekt.fhv.teama.classes.IPfandtyp;

public interface IPfandtypDao extends IGenericDao<IPfandtyp> {
	public IPfandtyp getPfandTypByBe(String bez);
}
